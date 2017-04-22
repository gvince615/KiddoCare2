package com.vintek.gvincent.kiddocare2.home;

import com.vintek.gvincent.kiddocare2.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: gvincent on 4/22/17.
 */

public enum EventType {
  CHILD_SCHEDULED("Child Scheduled", 0, R.drawable.ic_human_child_grey600_48dp),
  TRIP_SCHEDULED("Trip Scheduled", 1, R.drawable.ic_calendar_clock_grey600_48dp),
  TODO_ITEM("ToDo Item", 1, R.drawable.ic_format_list_checks_grey600_48dp),
  GENERIC_REMINDER("Reminder", 2, R.drawable.ic_clock_alert_grey600_48dp);

  private static List<?> eventTypes;
  private String title;
  private int type;
  private int image;

  EventType(String title, int type, int image) {
    this.title = title;
    this.type = type;
    this.image = image;
  }

  public static List<String> getEventTypes() {
    List<String> eventTypes = new ArrayList();
    eventTypes.add(EventType.CHILD_SCHEDULED.getTitle());
    eventTypes.add(EventType.TRIP_SCHEDULED.getTitle());
    eventTypes.add(EventType.TODO_ITEM.getTitle());
    eventTypes.add(EventType.GENERIC_REMINDER.getTitle());
    return eventTypes;
  }

  public static EventType getEventType(int event) {
    EventType eventType;
    switch (event) {
      case 0:
        eventType = EventType.CHILD_SCHEDULED;
        break;
      case 1:
        eventType = EventType.TRIP_SCHEDULED;
        break;
      case 2:
        eventType = EventType.TODO_ITEM;
        break;
      case 3:
        eventType = EventType.GENERIC_REMINDER;
        break;
      default:
        eventType = EventType.CHILD_SCHEDULED;
        break;
    }
    return eventType;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public int getImage() {
    return image;
  }

  public void setImage(int image) {
    this.image = image;
  }
}
