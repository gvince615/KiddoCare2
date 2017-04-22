package com.vintek.gvincent.kiddocare2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.vintek.gvincent.kiddocare2.home.CalendarEventsData;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDateTime;

/**
 * Created by: gvincent on 4/20/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

  // All Static variables
  // Database Version
  private static final int DATABASE_VERSION = 1;

  // Database Name
  private static final String DATABASE_NAME = "kiddocareDB";

  // calendar events table name
  private static final String TABLE_CALENDAR_EVENTS = "calendarEvents";

  // calendar events Table Columns names
  private static final String KEY_ID = "id";
  private static final String KEY_EVENT_TYPE = "event_type";
  private static final String KEY_EVENT_IMAGE = "event_image";
  private static final String KEY_EVENT_TITLE = "event_title";
  private static final String KEY_EVENT_DESCRIPTION = "event_description";
  private static final String KEY_EVENT_START = "event_start";
  private static final String KEY_EVENT_STOP = "event_stop";

  public DatabaseHandler(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override public void onCreate(SQLiteDatabase db) {
    String CREATE_CALENDAR_EVENTS_TABLE = "CREATE TABLE "
        + TABLE_CALENDAR_EVENTS
        + "("
        + KEY_ID
        + " INTEGER PRIMARY KEY,"
        + KEY_EVENT_TYPE
        + " INTEGER,"
        + KEY_EVENT_IMAGE
        + " INTEGER,"
        + KEY_EVENT_TITLE
        + " TEXT,"
        + KEY_EVENT_DESCRIPTION
        + " TEXT,"
        + KEY_EVENT_START
        + " TEXT,"
        + KEY_EVENT_STOP
        + " TEXT"
        + ")";
    db.execSQL(CREATE_CALENDAR_EVENTS_TABLE);
  }

  @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // Drop older table if existed
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_CALENDAR_EVENTS);

    // Create tables again
    onCreate(db);
  }

  // Adding new contact
  public void addCalendarEvent(CalendarEventsData calendarEventsData) {
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(KEY_EVENT_TYPE, calendarEventsData.getEventType());
    values.put(KEY_EVENT_IMAGE, calendarEventsData.getEventImage());
    values.put(KEY_EVENT_TITLE, calendarEventsData.getEventTitle());
    values.put(KEY_EVENT_DESCRIPTION, calendarEventsData.getEventDescription());
    values.put(KEY_EVENT_START, String.valueOf(calendarEventsData.getEventStartDateTime()));
    values.put(KEY_EVENT_STOP, String.valueOf(calendarEventsData.getEventEndDateTime()));

    // Inserting Row
    db.insert(TABLE_CALENDAR_EVENTS, null, values);
    db.close(); // Closing database connection
  }

  // Getting single contact
  public CalendarEventsData getCalendarEvent(int id) {
    SQLiteDatabase db = this.getReadableDatabase();

    Cursor cursor = db.query(TABLE_CALENDAR_EVENTS, new String[] {
        KEY_ID, KEY_EVENT_TYPE, KEY_EVENT_TITLE, KEY_EVENT_DESCRIPTION, KEY_EVENT_START,
        KEY_EVENT_STOP
    }, KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);

    if (cursor != null) cursor.moveToFirst();

    LocalDateTime start =
        LocalDateTime.parse(cursor.getString(cursor.getColumnIndex(KEY_EVENT_START)));
    LocalDateTime stop =
        LocalDateTime.parse(cursor.getString(cursor.getColumnIndex(KEY_EVENT_STOP)));

    CalendarEventsData calendarEventsData =
        new CalendarEventsData(cursor.getInt(cursor.getColumnIndex(KEY_EVENT_TYPE)),
            cursor.getInt(cursor.getColumnIndex(KEY_EVENT_IMAGE)),
            cursor.getString(cursor.getColumnIndex(KEY_EVENT_TITLE)),
            cursor.getString(cursor.getColumnIndex(KEY_EVENT_DESCRIPTION)), start, stop);
    // return calendarEvent
    return calendarEventsData;
  }

  // Getting All Contacts
  public List<CalendarEventsData> getAllCalendarEvents() {
    List<CalendarEventsData> calendarEventsDatas = new ArrayList<CalendarEventsData>();
    // Select All Query
    String selectQuery = "SELECT  * FROM " + TABLE_CALENDAR_EVENTS;

    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);

    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
      do {
        LocalDateTime start =
            LocalDateTime.parse(cursor.getString(cursor.getColumnIndex(KEY_EVENT_START)));
        LocalDateTime stop =
            LocalDateTime.parse(cursor.getString(cursor.getColumnIndex(KEY_EVENT_STOP)));

        CalendarEventsData calendarEventsData =
            new CalendarEventsData(cursor.getInt(cursor.getColumnIndex(KEY_EVENT_TYPE)),
                cursor.getInt(cursor.getColumnIndex(KEY_EVENT_IMAGE)),
                cursor.getString(cursor.getColumnIndex(KEY_EVENT_TITLE)),
                cursor.getString(cursor.getColumnIndex(KEY_EVENT_DESCRIPTION)), start, stop);

        calendarEventsDatas.add(calendarEventsData);
      } while (cursor.moveToNext());
    }

    // return contact list
    return calendarEventsDatas;
  }

  // Getting contacts Count
  //public int getCalendarEventsCount() {
  //
  //}
  // Updating single contact
  //public int updateCalendarEvent(CalendarEventsData calendarEventsData) {
  //
  //}

  // Deleting single contact
  //public void deleteCalendarEvent(CalendarEventsData calendarEventsData) {}
}
