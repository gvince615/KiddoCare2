package com.vintek.gvincent.kiddocare2.home;

import java.io.Serializable;
import java.util.List;
import org.joda.time.LocalDateTime;

/**
 * Created by gvincent on 4/14/17.
 */

public class CalendarEventsData implements Serializable {

  private int eventType;
  private int eventImage;
  private String eventTitle;
  private String eventDescription;
  private LocalDateTime eventStartDateTime;
  private LocalDateTime eventEndDateTime;

  private List<CalendarEventsData> calendarEvents;

  public CalendarEventsData(int eventType, int eventImage, String eventTitle,
      String eventDescription, LocalDateTime eventStartDateTime, LocalDateTime eventEndDateTime) {

    this.eventType = eventType;
    this.eventImage = eventImage;
    this.eventTitle = eventTitle;
    this.eventDescription = eventDescription;
    this.eventStartDateTime = eventStartDateTime;
    this.eventEndDateTime = eventEndDateTime;
  }

  public int getEventType() {
    return eventType;
  }

  public void setEventType(int eventType) {
    this.eventType = eventType;
  }

  public List<CalendarEventsData> getCalendarEvents() {
    return calendarEvents;
  }

  public void setCalendarEvents(List<CalendarEventsData> calendarEvents) {
    this.calendarEvents = calendarEvents;
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

  public LocalDateTime getEventStartDateTime() {
    return eventStartDateTime;
  }

  public void setEventStartDateTime(LocalDateTime eventStartDateTime) {
    this.eventStartDateTime = eventStartDateTime;
  }

  public LocalDateTime getEventEndDateTime() {
    return eventEndDateTime;
  }

  public void setEventEndDateTime(LocalDateTime eventEndDateTime) {
    this.eventEndDateTime = eventEndDateTime;
  }
}
