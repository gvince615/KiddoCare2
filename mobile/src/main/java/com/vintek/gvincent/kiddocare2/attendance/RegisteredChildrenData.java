package com.vintek.gvincent.kiddocare2.attendance;

import android.os.Parcel;
import android.os.Parcelable;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

/**
 * Created by: gvincent on 5/3/17
 */

class RegisteredChildrenData implements Parcelable {
  private int childImage;
  private String childFirstName;
  private String childLastName;
  private String childAgeBracket;
  private LocalDate childBirthDate;
  private LocalDateTime childClockIn;
  private LocalDateTime childClockOut;

  public RegisteredChildrenData(int childImage, String childFirstName, String childLastName,
      String childAgeBracket, LocalDate childBirthDate, LocalDateTime childClockIn,
      LocalDateTime childClockOut) {

    this.childImage = childImage;
    this.childFirstName = childFirstName;
    this.childLastName = childLastName;
    this.childAgeBracket = childAgeBracket;
    this.childBirthDate = childBirthDate;
    this.childClockIn = childClockIn;
    this.childClockOut = childClockOut;
  }

  public int getChildImage() {
    return childImage;
  }

  public void setChildImage(int childImage) {
    this.childImage = childImage;
  }

  public String getChildFirstName() {
    return childFirstName;
  }

  public void setChildFirstName(String childFirstName) {
    this.childFirstName = childFirstName;
  }

  public String getChildLastName() {
    return childLastName;
  }

  public void setChildLastName(String childLastName) {
    this.childLastName = childLastName;
  }

  public String getChildAgeBracket() {
    return childAgeBracket;
  }

  public void setChildAgeBracket(String childAgeBracket) {
    this.childAgeBracket = childAgeBracket;
  }

  public LocalDate getChildBirthDate() {
    return childBirthDate;
  }

  public void setChildBirthDate(LocalDate childBirthDate) {
    this.childBirthDate = childBirthDate;
  }

  public LocalDateTime getChildClockIn() {
    return childClockIn;
  }

  public void setChildClockIn(LocalDateTime childClockIn) {
    this.childClockIn = childClockIn;
  }

  public LocalDateTime getChildClockOut() {
    return childClockOut;
  }

  public void setChildClockOut(LocalDateTime childClockOut) {
    this.childClockOut = childClockOut;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {

  }
}
