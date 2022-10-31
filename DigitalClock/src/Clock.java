import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Clock extends JFrame{

    //Declare the variables we will be using to build the clock.
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;

    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    //Main method starts the clock
    public static void main(String[] args){
        //Make a new clock
        new Clock();
    }//end main

    //Declare the Clock class constructor.
    //Inside this constructor we will create the clock
    //so it displays as soon as the constructor method is called.
    Clock() {
        //Set the clock to close when the use clicks the X on the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set the title of the Clock
        this.setTitle("Alayna's Clock");

        //Set the layout for the frame where the clock is displayed
        this.setLayout(new FlowLayout());

        //Set the size of the clock
        this.setSize(350,220);

        //Make it a fixed width and height - so that user can't resize window
        this.setResizable(false);

        //Initialize the time, day and date formats
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd MMMM, yyyy");

        //Create a new label to how the time and set the font and colors
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("SERIF", Font.PLAIN, 59));
        timeLabel.setBackground(Color.PINK);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setOpaque(true);

        //Create a labels to hold the day and date and set their fonts
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Bell MT", Font.ITALIC, 34));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Bell MT", Font.ITALIC, 30));

        //Add the labels to the clock
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);

        //Most important step!
        //Set the clock to be visible so that we can see the jframe
        this.setVisible(true);

        //Start the clock to the time is updated
        startClock();

    }//end constructor method

    //This method starts the clock
    public void startClock() {

        //This is an infinite loop! We want to keep updating the time
        //constantly on our clock
        while(true){
            //Update time label with current time
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            //Update the day label with the current day
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            //Update the date label with the current date
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            //Puts the app to sleep for a short time (1000 milliseconds)
            // before updating the clock again
            try{
                Thread.sleep(1000);

            } catch(Exception e) {
                e.getStackTrace();
            }//end try catch

        }//end while loop

    }//end startClock method

}//end class
