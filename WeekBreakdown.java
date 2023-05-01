import java.util.*;
import java.io.*;

public class WeekBreakdown {

  int monday = 0;
  int tuesday = 0;
  int wednesday = 0;
  int thursday = 0;
  int friday = 0;
  int saturday = 0;
  Integer total = 0;

  public WeekBreakdown() {

  }

  public void getHours(String file) throws FileNotFoundException {
    FileReader read = new FileReader(file);
    Scanner scan = new Scanner(read);
    scan.useDelimiter("(?<=.)");
    StringBuilder build = new StringBuilder();
    while(scan.hasNextLine()) {
      String day = scan.nextLine();
      String dayname = " ";
      if(day.length() > 2) {
        dayname = day.substring(0, 3);
      }
        switch(dayname) {
          case "Mon":
          monday = Integer.valueOf(scan.nextLine());
          break;

          case "Tue":
          tuesday = Integer.valueOf(scan.nextLine());
          break;

          case "Wed":
          wednesday = Integer.valueOf(scan.nextLine());
          break;

          case "Thu":
          thursday = Integer.valueOf(scan.nextLine());
          break;

          case "Fri":
          friday = Integer.valueOf(scan.nextLine());
          break;

          case "Sat":
          saturday = Integer.valueOf(scan.nextLine());
          break;
      }
    }
    getTotal();
  }

  public void getTotal() throws FileNotFoundException {
    total = monday + tuesday + wednesday + thursday + friday + saturday;
  }

}
