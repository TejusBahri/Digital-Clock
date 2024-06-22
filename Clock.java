import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

public class Clock extends JFrame
{

    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dateLabel;
    String time;
    String date;

    Clock()
    {
        this.setTitle("Digital Clock");        // Frame Title
        this.setSize(350, 200);
        super.setLocation(0,0);
        this.setBackground(Color.BLACK);// Window coordinates
        this.setLayout(new FlowLayout());
        this.setResizable(true);          // cannot minimize or maximize

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
        timeLabel.setForeground(new Color(0xFFFFFF));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);

        dateFormat = new SimpleDateFormat("MMMM dd, Y");
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free",Font.PLAIN,50));

        this.add(timeLabel);  // adding the explicit labels in the GUI window
        this.add(dateLabel);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTime();  // calling the function
    }

    public void setTime()
    {
        while(true)                                                         // till I don't stop it
        {
            time = timeFormat.format(Calendar.getInstance().getTime());    // extracting info from base calendar
            timeLabel.setText(time);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try                                                   // reassuring that time will increase only by 1 second by making the operation goto sleep
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();

            }
        }
    }

}

