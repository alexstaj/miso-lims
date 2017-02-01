/*
 * Copyright (c) 2012. The Genome Analysis Centre, Norwich, UK
 * MISO project contacts: Robert Davey @ TGAC
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

package uk.ac.bbsrc.tgac.miso.core.util;

import java.util.Comparator;
import java.util.Date;

import uk.ac.bbsrc.tgac.miso.core.data.QC;

/**
 * uk.ac.bbsrc.tgac.miso.core.util
 * <p/>
 * Info
 * 
 * @author Rob Davey
 * @date 01/12/11
 * @since 0.1.3
 */
public class QcDateComparator<T extends QC> implements Comparator<T> {

  @Override
  public int compare(QC object1, QC object2) {
    Date date1 = object1.getQcDate();
    Date date2 = object2.getQcDate();

    // Handle sorting of null values
    if (date1 == null && date2 == null) return 0;
    if (date1 == null) return 1;
    if (date2 == null) return -1;

    if (date1.before(date2)) {
      return -1;
    } else if (date1.after(date2)) {
      return 1;
    } else {
      return Long.compare(object1.getId(), object2.getId());
    }
  }
}
