/*
 * This program is part of the OpenLMIS logistics management information system platform software.
 * Copyright © 2013 VillageReach
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *  
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License along with this program.  If not, see http://www.gnu.org/licenses.  For additional information contact info@OpenLMIS.org. 
 */

package org.openlmis.core.domain;


import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.session.RowBounds;

public class Pagination extends RowBounds {

  @Getter
  @Setter
  private Integer page;

  @Getter
  private Integer numberOfPages;

  @Getter
  private Integer totalRecords;

  public Pagination(Integer page, int limit) {
    super((page - 1) * limit, limit);
    this.page = page;
  }

  public void setTotalRecords(Integer totalRecords) {
    this.totalRecords = totalRecords;
    setNumberOfPages();
  }

  private void setNumberOfPages() {
    numberOfPages = totalRecords / getLimit();
    if (totalRecords % getLimit() > 0) {
      numberOfPages++;
    }

    if (numberOfPages == 0) {
      numberOfPages++;
    }
  }
}