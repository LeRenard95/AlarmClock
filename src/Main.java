import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.lang.Thread.sleep;

public class Main extends JFrame implements ActionListener {
    private JButton set;
    private JButton secondsButton;
    private JButton minutesButton;

    private int minutes;
    private int seconds;

    public Main() {

        minutes = 0;
        seconds = 0;

        Font font = new Font("Times", Font.PLAIN, 36);
        JLabel label = new JLabel("Alarmclock", JLabel.CENTER);
        label.setFont(font);

        JPanel p = new JPanel();
        p.add(label);
        p.setBackground(Color.YELLOW);
        p.setOpaque(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        JPanel buttonsPanel = new JPanel();

        set = new JButton("Set");
        secondsButton = new JButton("0");
        minutesButton = new JButton("0");


        set.addActionListener(this);
        secondsButton.addActionListener(this);
        minutesButton.addActionListener(this);

        set.setFont(font);
        minutesButton.setFont(font);
        secondsButton.setFont(font);

        buttonsPanel.add(secondsButton);
        buttonsPanel.add(minutesButton);
        buttonsPanel.add(set);

        add(p);
        add(buttonsPanel);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object temp = e.getSource();
        if (temp == minutesButton) {
            minutes++;

            if (minutes == 60) {
                minutes = 0;

            }
        } else if (temp == secondsButton) {

            seconds += 10;
            if (seconds == 60) {
                seconds = 0;
                minutes++;
            }


        } else if (temp == set) {
            System.out.println("HIER");


            while (0 < seconds) {
                System.out.println(seconds);
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                seconds--;
            }
            while (0 < minutes) {
                System.out.println(minutes);
                try {
                    sleep(60000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                minutes--;
            }

            System.out.println("AAAAALAAAAARM");


        } else {
            System.out.println("Time left " + minutes + ":" + seconds);
        }
        minutesButton.setText(minutes + "");
        secondsButton.setText(seconds + "");
    }

    public static void main(String[] args) {

        new Main();


    }
}