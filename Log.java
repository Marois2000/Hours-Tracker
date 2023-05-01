import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Log implements ActionListener {

  Toolkit tk = Toolkit.getDefaultToolkit();
  Dimension screenSize = tk.getScreenSize();
  MyDate date = new MyDate();


  private JFrame log = new JFrame();

  private JPanel header = new JPanel();
  private JLabel time = new JLabel(date.format);

  private JPanel hours = new JPanel();
  private JLabel hoursmessage = new JLabel("Record your hours:");
  private JTextField input = new JTextField();

  private JPanel dailylog = new JPanel();
  private JLabel title = new JLabel("Daily Log:");
  private JTextArea logarea = new JTextArea();

  private JPanel right = new JPanel();
  private JButton submit = new JButton("Submit");
  private JLabel empty = new JLabel();

  private JPanel motivate = new JPanel();
  private JTextArea message = new JTextArea();

  public Log() {
    submit.setFocusPainted(false);
    submit.addActionListener(this);
    submit.setPreferredSize(new Dimension(100, 100));
    submit.setForeground(Color.white);
    submit.setFont(new Font("impact", Font.PLAIN, 20));
    submit.setBackground(Color.blue);
    empty.setPreferredSize(new Dimension(300, screenSize.height - 300));
    right.add(empty);
    right.add(submit);
    right.setBackground(Color.gray);
    right.setPreferredSize(new Dimension(screenSize.width / 8, screenSize.height - 40));

    message.setBackground(Color.gray);
    message.setForeground(Color.blue);
    message.setPreferredSize(new Dimension(screenSize.width / 8, screenSize.height - 40));
    message.setEditable(false);
    message.setLineWrap(true);
    message.setFont(new Font("impact", Font.PLAIN, 20));
    getMotivational();
    motivate.add(message);
    motivate.setBackground(Color.gray);
    motivate.setPreferredSize(new Dimension(screenSize.width / 8, screenSize.height - 40));

    title.setFont(new Font("Impact", Font.PLAIN, 20));
    title.setForeground(Color.black);
    logarea.setForeground(Color.black);
    logarea.setBackground(Color.white);
    logarea.setPreferredSize(new Dimension(screenSize.width / 2, screenSize.height - 300));
    logarea.setLineWrap(true);
    logarea.setFont(new Font("impact", Font.PLAIN, 20));
    dailylog.setBackground(Color.lightGray);
    dailylog.setLayout(new BoxLayout(dailylog, BoxLayout.Y_AXIS));
    dailylog.add(title);
    dailylog.add(logarea);

    input.setBackground(Color.lightGray);
    input.setForeground(Color.black);
    input.setPreferredSize(new Dimension(100, 40));
    input.setFont(new Font("Impact", Font.PLAIN, 20));
    hoursmessage.setFont(new Font("Impact", Font.PLAIN, 20));
    hours.setBackground(Color.gray);
    hours.add(hoursmessage);
    hours.add(input);

    time.setFont(new Font("Impact", Font.PLAIN, 30));
    time.setForeground(Color.black);
    header.setBackground(Color.BLUE);
    header.add(time);

    log.setLayout(new BorderLayout());
    log.add(header, BorderLayout.PAGE_START);
    log.add(hours, BorderLayout.PAGE_END);
    log.add(dailylog, BorderLayout.CENTER);
    log.add(motivate, BorderLayout.LINE_START);
    log.add(right, BorderLayout.LINE_END);
    log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    log.pack();
    log.setVisible(true);
    log.setSize(screenSize.width, screenSize.height - 40);
  }



@Override
  public void actionPerformed(ActionEvent e) {
    Week week = new Week();
    if(e.getSource() == submit) {
      String hour = input.getText();
      String logged = logarea.getText();
      if(input.getText() != null) {
        String name = date.format.substring(4, 7) + "-" + date.format.substring(8, 10) + "-" + date.format.substring(11, 16);
        String hourpath = "Hours/" + name + ".txt";
        try(PrintWriter out = new PrintWriter(hourpath)){
          out.println(hour);
        } catch (FileNotFoundException f){
          System.out.println("Didn't work");
        }
        try {
          week.addDay(hour);
        } catch (FileNotFoundException r) {}
      }
      if(logarea.getText() != null) {
        String named = date.format.substring(4, 7) + "-" + date.format.substring(8, 10) + "-" + date.format.substring(11, 16);
        String logpath = "Logs/" + named + ".txt";
        try(PrintWriter out = new PrintWriter(logpath)){
          out.println(logged);
        } catch (FileNotFoundException g){
          System.out.println("Didn't work");
        }
      }
    }
    new Menu();
    log.dispose();
  }

  public void getMotivational() {
    ArrayList<String> quotes = new ArrayList<String>();
    try{
      FileReader read = new FileReader("Motivation.txt");
      Scanner scan = new Scanner(read);
      while(scan.hasNextLine()) {
        quotes.add(scan.nextLine());
      }
    } catch(FileNotFoundException f){}
    int rand = (int)(Math.floor(Math.random() * quotes.size()));
    message.append(quotes.get(rand));
  }

  public static void main(String[] args) {
    new Log();
  }
}
