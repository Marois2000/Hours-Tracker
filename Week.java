import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Week {

  MyDate date = new MyDate();

  public Week() {

  }

  public void addDay(String hours) throws FileNotFoundException {
    String weekpath = "Weekly/" + date.getWeekName() + ".txt";
    try(PrintWriter out = new PrintWriter(new FileOutputStream(weekpath, true))){
      out.println(date.format + ":");
      out.println(hours);
    } catch (FileNotFoundException f){
      System.out.println("Didn't work");
    }
  }





}
