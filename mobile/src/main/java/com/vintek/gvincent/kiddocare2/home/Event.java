package com.vintek.gvincent.kiddocare2.home;

import com.github.gfranks.collapsible.calendar.model.CollapsibleCalendarEvent;
import net.danlew.android.joda.JodaTimeAndroid;
import org.joda.time.LocalDate;

public class Event extends CollapsibleCalendarEvent {

  private long mDate;

  public Event(long date) {
    mDate = date;
  }

  @Override public org.joda.time.LocalDate getCollapsibleEventLocalDate() {

    return new LocalDate(mDate);
  }
}