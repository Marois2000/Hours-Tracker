import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class LogDisplay implements ActionListener {

  Toolkit tk = Toolkit.getDefaultToolkit();
  Dimension screenSize = tk.getScreenSize();
  MyDate date = new MyDate();
  FileList files = new FileList();


  private JFrame logs = new JFrame();

  private JPanel header = new JPanel();
  private JComboBox days = new JComboBox(files.getLogDays());

  private JPanel hours = new JPanel();
  private JLabel hoursmessage = new JLabel("Trend Moving and Storage LLC.");
  private JTextField input = new JTextField();

  private JPanel dailylog = new JPanel();
  private JLabel title = new JLabel("The Log:");
  private JTextArea logarea = new JTextArea();

  private JPanel right = new JPanel();
  private JButton menu = new JButton("Menu");
  private JLabel empty = new JLabel();

  private JPanel motivate = new JPanel();
  private JTextArea message = new JTextArea();

  public LogDisplay() {
    menu.setFocusPainted(false);
    menu.addActionListener(this);
    menu.setPreferredSize(new Dimension(100, 100));
    menu.setForeground(Color.white);
    menu.setFont(new Font("impact", Font.PLAIN, 20));
    menu.setBackground(Color.blue);
    empty.setPreferredSize(new Dimension(300, screenSize.height - 300));
    right.add(empty);
    right.add(menu);
    right.setBackground(Color.gray);
    right.setPreferredSize(new Dimension(screenSize.width / 8, screenSize.height - 40));

    message.setBackground(Color.gray);
    message.setForeground(Color.blue);
    message.setPreferredSize(new Dimension(screenSize.width / 8, screenSize.height - 40));
    message.setEditable(false);
    message.setLineWrap(true);
    message.setFont(new Font("impact", Font.PLAIN, 20));
    motivate.add(message);
    motivate.setBackground(Color.gray);
    motivate.setPreferredSize(new Dimension(screenSize.width / 8, screenSize.height - 40));

    title.setFont(new Font("Impact", Font.PLAIN, 30));
    title.setForeground(Color.black);
    logarea.setForeground(Color.black);
    logarea.setBackground(Color.white);
    logarea.setPreferredSize(new Dimension(screenSize.width / 2, screenSize.height - 300));
    logarea.setLineWrap(true);
    logarea.setFont(new Font("impact", Font.PLAIN, 30));
    logarea.setEditable(false);
    dailylog.setBackground(Color.lightGray);
    dailylog.setLayout(new BoxLayout(dailylog, BoxLayout.Y_AXIS));
    dailylog.add(title);
    dailylog.add(logarea);

    hoursmessage.setFont(new Font("Impact", Font.PLAIN, 30));
    hoursmessage.setPreferredSize(new Dimension(500, 40));
    hoursmessage.setForeground(Color.blue);
    hours.setBackground(Color.gray);
    hours.add(hoursmessage);

    days.setForeground(Color.blue);
    days.addActionListener(this);
    header.setBackground(Color.BLUE);
    header.add(days);

    logs.setLayout(new BorderLayout());
    logs.add(header, BorderLayout.PAGE_START);
    logs.add(hours, BorderLayout.PAGE_END);
    logs.add(dailylog, BorderLayout.CENTER);
    logs.add(motivate, BorderLayout.LINE_START);
    logs.add(right, BorderLayout.LINE_END);
    logs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    logs.pack();
    logs.setVisible(true);
    logs.setSize(screenSize.width, screenSize.height - 40);
  }

@Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == menu) {
      new Menu();
      logs.dispose();
    } else {
      try{
        logarea.setText(null);
        String path = "Logs/" + days.getSelectedItem();
        FileReader read = new FileReader(path);
        Scanner scan = new Scanner(read);
        scan.useDelimiter("(?<=.)");
        while(scan.hasNext()) {
          logarea.append(scan.next());
       }
      } catch(FileNotFoundException f){}
    }
  }


}
