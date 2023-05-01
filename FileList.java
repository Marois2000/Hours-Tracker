import java.util.*;
import java.io.*;

public class FileList {

  public FileList() {

  }

  public String[] getFileNames() {
    String[] names;
    File f = new File("Weekly");
    names = f.list();
    return names;
  }

  public String[] getLogDays() {
    String[] names;
    File f = new File("Logs");
    names = f.list();
    return names;
  }





}
