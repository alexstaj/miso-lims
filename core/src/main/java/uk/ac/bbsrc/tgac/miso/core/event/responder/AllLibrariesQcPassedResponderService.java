/*
 * Copyright (c) 2012. The Genome Analysis Centre, Norwich, UK
 * MISO project contacts: Robert Davey, Mario Caccamo @ TGAC
 * *********************************************************************
 *
 * This file is part of MISO.
 *
 * MISO is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MISO is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MISO.  If not, see <http://www.gnu.org/licenses/>.
 *
 * *********************************************************************
 */

package uk.ac.bbsrc.tgac.miso.core.event.responder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eaglegenomics.simlims.core.User;

import uk.ac.bbsrc.tgac.miso.core.data.impl.ProjectOverview;
import uk.ac.bbsrc.tgac.miso.core.event.Alert;
import uk.ac.bbsrc.tgac.miso.core.event.AlerterService;
import uk.ac.bbsrc.tgac.miso.core.event.Event;
import uk.ac.bbsrc.tgac.miso.core.event.impl.AbstractResponderService;
import uk.ac.bbsrc.tgac.miso.core.event.impl.DefaultAlert;
import uk.ac.bbsrc.tgac.miso.core.event.model.ProjectOverviewEvent;
import uk.ac.bbsrc.tgac.miso.core.event.type.MisoEventType;
import uk.ac.bbsrc.tgac.miso.core.exception.AlertingException;

/**
 * uk.ac.bbsrc.tgac.miso.core.event.responder
 * <p/>
 * Info
 * 
 * @author Rob Davey
 * @date 20/10/11
 * @since 0.1.2
 */
public class AllLibrariesQcPassedResponderService extends AbstractResponderService {
  protected static final Logger log = LoggerFactory.getLogger(AllLibrariesQcPassedResponderService.class);

  private String baseURL = "";

  public void setBaseURL(String baseURL) {
    this.baseURL = baseURL;
  }

  public AllLibrariesQcPassedResponderService() {
  }

  @Override
  public boolean respondsTo(Event event) {
    if (event instanceof ProjectOverviewEvent) {
      ProjectOverviewEvent poe = (ProjectOverviewEvent) event;
      ProjectOverview po = poe.getEventObject();
      if (poe.getEventType().equals(MisoEventType.ALL_LIBRARIES_QC_PASSED) && po.getAllLibrariesQcPassed()) {
        log.debug("Project " + poe.getEventObject().getProject().getAlias() + ": " + poe.getEventMessage());
        return true;
      }
    }
    return false;
  }

  @Override
  public void generateResponse(Event event) {
    if (event instanceof ProjectOverviewEvent) {
      ProjectOverviewEvent re = (ProjectOverviewEvent) event;
      ProjectOverview po = re.getEventObject();

      for (User user : po.getWatchers()) {
        Alert a = new DefaultAlert(user);
        a.setAlertTitle("All Library QCs passed for project " + po.getProject().getAlias() + "(" + po.getProject().getName() + ")");

        StringBuilder at = new StringBuilder();
        at.append("The following Project's Libraries have been QC'ed successfully: " + po.getProject().getAlias() + " ("
            + event.getEventMessage() + "). Please view Project " + po.getProject().getId() + " in MISO for more information");
        if (event.getEventContext().has("baseURL")) {
          at.append(":\n\n" + event.getEventContext().getString("baseURL") + "/project/" + po.getProject().getId());
        }
        a.setAlertText(at.toString());

        for (AlerterService as : getAlerterServices()) {
          try {
            as.raiseAlert(a);
          } catch (AlertingException e) {
            log.error("Cannot raise user-level alert", e);
          }
        }
      }

      if (getSaveSystemAlert()) {
        raiseSystemAlert(event);
      }
    }
  }
}
