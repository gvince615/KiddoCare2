package com.vintek.gvincent.kiddocare2.home;

import java.util.List;
import org.joda.time.LocalDate;

/**
 * Created by gvincent on 4/14/17.
 */

class CalendarEventsData {

  private EventType eventType;
  private int eventImage;
  private String eventTitle;
  private String eventDescription;
  private LocalDate eventStartDateTime;
  private LocalDate eventEndDateTime;

  private List<CalendarEventsData> calendarEvents;

  CalendarEventsData(EventType eventType, String eventDescription, LocalDate eventStartDateTime, LocalDate eventEndDateTime) {

    this.eventType = eventType;
    this.eventImage = eventType.image();
    this.eventTitle = eventType.typeStr();
    this.eventDescription = eventDescription;
    this.eventStartDateTime = eventStartDateTime;
    this.eventEndDateTime = eventEndDateTime;
  }

  public EventType getEventType() {
    return eventType;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }

  public int getEventImage() {
    return eventImage;
  }

  public void setEventImage(int eventImage) {
    this.eventImage = eventImage;
  }

  public String getEventTitle() {
    return eventTitle;
  }

  public void setEventTitle(String eventTitle) {
    this.eventTitle = eventTitle;
  }

  public String getEventDescription() {
    return eventDescription;
  }

  public void setEventDescription(String eventDescription) {
    this.eventDescription = eventDescription;
  }

  public LocalDate getEventStartDateTime() {
    return eventStartDateTime;
  }

  public void setEventStartDateTime(LocalDate eventStartDateTime) {
    this.eventStartDateTime = eventStartDateTime;
  }

  public LocalDate getEventEndDateTime() {
    return eventEndDateTime;
  }

  public void setEventEndDateTime(LocalDate eventEndDateTime) {
    this.eventEndDateTime = eventEndDateTime;
  }
}
