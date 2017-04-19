package com.vintek.gvincent.kiddocare2.home;

import android.graphics.drawable.Drawable;
import com.vintek.gvincent.kiddocare2.R;

/**
 * Created by gvincent on 4/14/17.
 */

public enum EventType {
  CHILD_SCHEDULED("Child Scheduled", 0, R.drawable.ic_human_child_grey600_48dp),
  TRIP_SCHEDULED("Trip Scheduled", 1, R.drawable.ic_calendar_clock_grey600_48dp),
  TODO_ITEM("ToDo Item", 1, R.drawable.ic_format_list_checks_grey600_48dp),
  GENERIC_REMINDER("Reminder", 2, R.drawable.ic_clock_alert_grey600_48dp);

  private final String typeStr;
  private final int typeInt;

  public int image() {
    return image;
  }

  private final int image;

  EventType(String typeStr, int typeInt, int image) {
    this.typeStr = typeStr;
    this.typeInt = typeInt;
    this.image = image;
  }

  public String typeStr() {
    return typeStr;
  }

  public int typeInt() {
    return typeInt;
  }

}

