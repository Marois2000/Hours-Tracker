import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class WeekDisplay implements ActionListener {

  Toolkit tk = Toolkit.getDefaultToolkit();
  Dimension screenSize = tk.getScreenSize();
  MyDate date = new MyDate();
  FileList files = new FileList();
  WeekBreakdown filler = new WeekBreakdown();

  private JFrame week = new JFrame();
  private JPanel header = new JPanel();
  private JComboBox weeks = new JComboBox(files.getFileNames());
  private JPanel disp = new JPanel();
  private JLabel mon = new JLabel();
  private JLabel tue = new JLabel();
  private JLabel wed = new JLabel();
  private JLabel thu = new JLabel();
  private JLabel fri = new JLabel();
  private JLabel sat = new JLabel();
  private JLabel total = new JLabel();

  private JPanel left = new JPanel();
  private JLabel leftlabel = new JLabel();

  private JPanel right = new JPanel();
  private JLabel rightlabel = new JLabel();

  private JPanel bottom = new JPanel();
  private JButton menu = new JButton("Menu");


  public WeekDisplay() {

    weeks.addActionListener(this);

    mon.setBackground(Color.blue);
    mon.setForeground(Color.white);
    mon.setFont(new Font("Impact", Font.PLAIN, 30));
    mon.setPreferredSize(new Dimension(200, 200));
    mon.setOpaque(true);

    tue.setBackground(Color.blue);
    tue.setForeground(Color.white);
    tue.setFont(new Font("Impact", Font.PLAIN, 30));
    tue.setOpaque(true);
    tue.setPreferredSize(new Dimension(200, 200));

    wed.setBackground(Color.blue);
    wed.setForeground(Color.white);
    wed.setFont(new Font("Impact", Font.PLAIN, 30));
    wed.setOpaque(true);
    wed.setPreferredSize(new Dimension(200, 200));

    thu.setBackground(Color.blue);
    thu.setForeground(Color.white);
    thu.setFont(new Font("Impact", Font.PLAIN, 30));
    thu.setOpaque(true);
    thu.setPreferredSize(new Dimension(200, 200));

    fri.setBackground(Color.blue);
    fri.setForeground(Color.white);
    fri.setFont(new Font("Impact", Font.PLAIN, 30));
    fri.setOpaque(true);
    fri.setPreferredSize(new Dimension(200, 200));

    sat.setBackground(Color.blue);
    sat.setForeground(Color.white);
    sat.setFont(new Font("Impact", Font.PLAIN, 30));
    sat.setOpaque(true);
    sat.setPreferredSize(new Dimension(200, 200));

    total.setBackground(Color.blue);
    total.setForeground(Color.white);
    total.setFont(new Font("Impact", Font.PLAIN, 30));
    total.setPreferredSize(new Dimension(200, 200));
    total.setOpaque(true);

    disp.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.weightx = 0.5;
    c.weighty = 0.5;
    c.gridx = 1;
    c.gridy = 1;
    c.gridwidth = 1;
    disp.add(mon, c);

    c.gridx = 2;
    c.gridy = 1;
    c.gridwidth = 1;
    disp.add(tue, c);

    c.gridx = 3;
    c.gridy = 1;
    c.gridwidth = 1;
    disp.add(wed, c);

    c.gridx = 1;
    c.gridy = 2;
    c.gridwidth = 1;
    disp.add(thu, c);

    c.gridx = 2;
    c.gridy = 2;
    c.gridwidth = 1;
    disp.add(fri, c);

    c.gridx = 3;
    c.gridy = 2;
    c.gridwidth = 1;
    disp.add(sat, c);

    c.gridx = 2;
    c.gridy = 3;
    c.gridwidth = 1;
    disp.add(total, c);
    disp.setBackground(Color.lightGray);

    weeks.setPreferredSize(new Dimension(250, 50));
    weeks.setForeground(Color.black);
    header.setBackground(Color.blue);
    header.add(weeks);

    leftlabel.setPreferredSize(new Dimension(screenSize.width / 8, screenSize.height - 150));
    left.setBackground(Color.gray);
    left.add(leftlabel);

    rightlabel.setPreferredSize(new Dimension(screenSize.width / 8, screenSize.height - 150));
    right.setBackground(Color.gray);
    right.add(rightlabel);

    menu.setFocusPainted(false);
    menu.addActionListener(this);
    menu.setFont(new Font("Impact", Font.PLAIN, 20));
    menu.setForeground(Color.blue);
    menu.setPreferredSize(new Dimension(400, 100));
    menu.setBackground(Color.lightGray);
    bottom.setBackground(Color.gray);
    bottom.add(menu);

    week.setLayout(new BorderLayout());
    week.add(header, BorderLayout.PAGE_START);
    week.add(disp, BorderLayout.CENTER);
    week.add(left, BorderLayout.LINE_START);
    week.add(right, BorderLayout.LINE_END);
    week.add(bottom, BorderLayout.PAGE_END);
    week.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    week.pack();
    week.setVisible(true);
    week.setSize(screenSize.width, screenSize.height - 40);
  }


@Override
  public void actionPerformed(ActionEvent e) {
    String filename = "Weekly/" + weeks.getSelectedItem().toString();
    try {
      filler.getHours(filename);
    } catch (FileNotFoundException f) {}
    mon.setText("Monday: " + filler.monday);
    mon.setHorizontalAlignment(JLabel.CENTER);
    tue.setText("Tuesday: " + filler.tuesday);
    mon.setHorizontalAlignment(JLabel.CENTER);
    wed.setText("Wednesday: " + filler.wednesday);
    wed.setHorizontalAlignment(JLabel.CENTER);
    thu.setText("Thursday: " + filler.thursday);
    thu.setHorizontalAlignment(JLabel.CENTER);
    fri.setText("Friday: " + filler.friday);
    fri.setHorizontalAlignment(JLabel.CENTER);
    sat.setText("Saturday: " + filler.saturday);
    sat.setHorizontalAlignment(JLabel.CENTER);
    total.setText("Total: " + filler.total);
    total.setHorizontalAlignment(JLabel.CENTER);

    if(e.getSource() == menu) {
      new Menu();
      week.dispose();
    }

  }


}
