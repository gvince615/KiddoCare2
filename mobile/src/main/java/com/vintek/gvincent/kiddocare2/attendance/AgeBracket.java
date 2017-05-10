package com.vintek.gvincent.kiddocare2.attendance;

/**
 * Created by: gvincent on 5/3/17
 */

enum AgeBracket {
  INFANT("Infant"), TODDLER("Toddler"), SCHOOL_AGE("School Age");

  private String title;

  AgeBracket(String title) {
    this.title = title;
  }
}
