/**
 * Copyright 2015 Michael Leahy / TyphonRT, Inc.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.typhonrt.android.java6.data.option.model;

/**
 * IOptionModel
 */
public interface IOptionModel
{
   /**
    * OptionType
    */
   enum OptionType
   {
      BOOLEAN, FLOAT
   }

   boolean getBooleanValue();

   float getFloatValue();

   OptionType getOptionType();

   float getRangePercent();

   String getTitle();

   void setRangePercent(float value);
}
