import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.*;

public class MyDate {

  Date date = new Date();
  String format = removeTime(date);
  int month;
  int day;
  int year;

  public MyDate() {
    getMonthNum();
  }


  public String removeTime(Date date) {
    String justDate = date.toString();
    String day = justDate.substring(0, 10);
    String year = justDate.substring(justDate.length() - 4, justDate.length());
    String formatted = day + ", " + year;
    return formatted;
  }

  public String getDayName() {
    String day = format.substring(0, 3);
    return day;
  }

  public int getDayNum() {
    int daynum = Integer.valueOf(format.substring(8, 10));
    return daynum;
  }

  public String getWeekName() {
    StringBuilder build = new StringBuilder();
    LocalDate today = LocalDate.now();

    LocalDate monday = today;
    while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
      monday = monday.minusDays(1);
    }
    build.append(monday);

    build.append(".");
    LocalDate saturday = today;
    while (saturday.getDayOfWeek() != DayOfWeek.SATURDAY) {
      saturday = saturday.plusDays(1);
    }
    build.append(saturday);
    return build.toString();
  }

  public void getMonthNum() {
    String monthname = format.substring(4, 7);
    switch(monthname) {
      case "Jan":
        month = 1;
      break;

      case "Feb":
        month = 2;
      break;

      case "Mar":
        month = 3;
      break;

      case "Apr":
        month = 4;
      break;

      case "May":
        month = 5;
      break;

      case "Jun":
        month = 6;
      break;

      case "Jul":
        month = 7;
      break;

      case "Aug":
        month = 8;
      break;

      case "Sep":
        month = 9;
      break;

      case "Oct":
        month = 10;
      break;

      case "Nov":
        month = 11;
      break;

      case "Dec":
        month = 12;
      break;
    }
  }

}
