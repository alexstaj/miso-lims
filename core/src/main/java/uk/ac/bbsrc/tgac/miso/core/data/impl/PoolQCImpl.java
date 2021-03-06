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

package uk.ac.bbsrc.tgac.miso.core.data.impl;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eaglegenomics.simlims.core.User;

import uk.ac.bbsrc.tgac.miso.core.data.AbstractPoolQC;
import uk.ac.bbsrc.tgac.miso.core.data.Pool;
import uk.ac.bbsrc.tgac.miso.core.exception.MalformedPoolException;


/**
 * Concrete implementation of a PoolQC
 * 
 * @author Rob Davey
 * @since 0.1.9
 */
public class PoolQCImpl extends AbstractPoolQC implements Serializable {
  protected static final Logger log = LoggerFactory.getLogger(PoolQCImpl.class);
  /**
   * Construct a new PoolQC
   */
  public PoolQCImpl() {
  }

  /**
   * Construct a new PoolQC from a parent Pool, checking that the given User can read that Pool
   * 
   * @param pool
   *          of type Pool
   * @param user
   *          of type User
   */
  public PoolQCImpl(Pool pool, User user) {
    if (pool.userCanRead(user)) {
      try {
        setPool(pool);
      } catch (MalformedPoolException e) {
        log.error("constructor", e);
      }
    }
  }

  @Override
  public boolean userCanRead(User user) {
    return true;
  }

  @Override
  public boolean userCanWrite(User user) {
    return true;
  }
}
