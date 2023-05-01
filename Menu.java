import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Menu implements ActionListener {

  Toolkit tk = Toolkit.getDefaultToolkit();
  Dimension screenSize = tk.getScreenSize();
  MyDate date = new MyDate();
  String dayname = date.format.substring(0, 3);
  WeekBreakdown filler = new WeekBreakdown();

  private JFrame frame = new JFrame();
  private JPanel main = new JPanel();
  private JButton log = new JButton("Log");
  private JButton weeks = new JButton("Past Weeks");
  private JPanel sidebar = new JPanel();
  private JPanel header = new JPanel();
  private JLabel title = new JLabel("Trend Moving and Storage LLC.");
  private JPanel currenthours = new JPanel();
  private JLabel hourtitle = new JLabel("Hours this Week:");
  private JLabel hoursnum = new JLabel();
  private JPanel dates = new JPanel();
  private JLabel day = new JLabel(date.format);
  private JLabel week = new JLabel(date.getWeekName());
  private JPanel logo = new JPanel();
  private JLabel pic = new JLabel();
  private JButton pastlogs = new JButton("Past Logs");
  private JButton quit = new JButton("Quit");



  public Menu() {

    ImageIcon iconlogo = new ImageIcon("CompanyLogos/TrendLogo.png");
    pic.setIcon(iconlogo);
    logo.add(pic);
    logo.setBackground(Color.lightGray);

    day.setFont(new Font("impact", Font.PLAIN, 20));
    day.setForeground(Color.blue);
    day.setHorizontalAlignment(JLabel.CENTER);
    week.setFont(new Font("impact", Font.PLAIN, 20));
    week.setForeground(Color.blue);
    week.setHorizontalAlignment(JLabel.CENTER);
    dates.setLayout(new GridLayout(2, 1));
    dates.setBackground(Color.gray);
    dates.add(day);
    dates.add(week);

    hourtitle.setFont(new Font("impact", Font.PLAIN, 30));
    hourtitle.setForeground(Color.blue);
    hourtitle.setHorizontalAlignment(JLabel.CENTER);
    String file = "Weekly/" + date.getWeekName() + ".txt";
    try {
      filler.getHours(file);
    } catch (FileNotFoundException f) {}
    hoursnum.setForeground(Color.blue);
    hoursnum.setFont(new Font("impact", Font.PLAIN, 30));
    hoursnum.setText(filler.total.toString());
    hoursnum.setHorizontalAlignment(JLabel.CENTER);
    currenthours.add(hourtitle);
    currenthours.add(hoursnum);
    currenthours.setBackground(Color.gray);

    title.setFont(new Font("impact", Font.PLAIN, 40));
    title.setForeground(Color.white);
    header.setBackground(Color.blue);
    header.add(title);

    quit.addActionListener(this);
    quit.setFocusPainted(false);
    quit.setForeground(Color.white);
    quit.setBackground(Color.blue);
    quit.setFont(new Font("impact", Font.PLAIN, 20));

    pastlogs.addActionListener(this);
    pastlogs.setFocusPainted(false);
    pastlogs.setForeground(Color.white);
    pastlogs.setBackground(Color.blue);
    pastlogs.setFont(new Font("impact", Font.PLAIN, 20));

    weeks.addActionListener(this);
    weeks.setFocusPainted(false);
    weeks.setForeground(Color.white);
    weeks.setBackground(Color.blue);
    weeks.setFont(new Font("impact", Font.PLAIN, 20));

    log.addActionListener(this);
    log.setFocusPainted(false);
    if(dayname.equals("Sun")) {
      log.setEnabled(false);
    }
    log.setForeground(Color.white);
    log.setBackground(Color.blue);
    log.setFont(new Font("impact", Font.PLAIN, 20));

    sidebar.add(log);
    sidebar.add(weeks);
    sidebar.add(pastlogs);
    sidebar.add(quit);
    sidebar.setBackground(Color.gray);
    sidebar.setLayout(new GridLayout(4, 1, 0, 50));

    main.setSize(screenSize.width, screenSize.height - 40);
    main.setLayout(new BorderLayout());
    main.add(sidebar, BorderLayout.LINE_START);
    main.add(header, BorderLayout.PAGE_START);
    main.add(currenthours, BorderLayout.PAGE_END);
    main.add(dates, BorderLayout.LINE_END);
    main.add(logo, BorderLayout.CENTER);
    main.setBackground(Color.lightGray);


    frame.add(main);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    frame.setSize(screenSize.width, screenSize.height - 40);
  }





@Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == log) {
      new Log();
      frame.dispose();
    } else if (e.getSource() == weeks) {
      new WeekDisplay();
      frame.dispose();
    } else if (e.getSource() == pastlogs) {
      new LogDisplay();
      frame.dispose();
    } else if (e.getSource() == quit) {
      frame.dispose();
    }
  }

  public static void main(String[] args) {
    new Menu();

  }
}
