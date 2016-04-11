/**
 * Copyright 2015 Michael Leahy / TyphonRT, Inc.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.typhonrt.android.java6.data.option.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * OptionModel
 */
public class OptionModel implements IOptionModel
{
   private String          title;
   private AtomicInteger   intValue;
   private OptionType      optionType;

   private float           minValue, maxValue;

   public OptionModel(String title, boolean value)
   {
      this.title = title;
      intValue = new AtomicInteger();
      optionType = OptionType.BOOLEAN;

      minValue = 0;
      maxValue = 1;

      setRangePercent(value ? 1f : 0f);
   }

   public OptionModel(String title, float percent)
   {
      this(title, percent, 0, 1);
   }

   public OptionModel(String title, float percent, float minValue, float maxValue)
   {
      this.title = title;
      this.minValue = minValue;
      this.maxValue = maxValue;

      intValue = new AtomicInteger();
      optionType = OptionType.FLOAT;

      setRangePercent(percent);
   }

   @Override
   public float getFloatValue()
   {
      return minValue + (getRangePercent() * (maxValue - minValue));
   }

   @Override
   public OptionType getOptionType()
   {
      return optionType;
   }

   @Override
   public boolean getBooleanValue()
   {
      return getRangePercent() >= 0.5f;
   }

   @Override
   public float getRangePercent()
   {
      return Float.intBitsToFloat(intValue.get());
   }

   @Override
   public String getTitle()
   {
      return title;
   }

   @Override
   public void setRangePercent(float value)
   {
      intValue.lazySet(Float.floatToIntBits(Math.max(0, Math.min(value, 1))));
   }
}
