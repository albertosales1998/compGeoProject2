package assignment2;

import javax.swing.*;

/**
 * Project 2 code skeleton; shows how to add a background image.
 * 
 * @author Antonio Hernandez
 */
public class Project2Framework
{
    public static void main(String[] args)
    {
        new Project2Framework();
    }
    
    public Project2Framework()
    {        
        //Defining the geometric objects that represent the problem data
        Rectangle[] g = new Rectangle[]{
                new Rectangle(new Point(167, 482), new Point(302, 711), "South America"),
                new Rectangle(new Point(180, 726), new Point(582, 737), "Antarctica"),
                new Rectangle(new Point(305, 407), new Point(465, 624), "Africa/Middle-East"),
                new Rectangle(new Point(561, 550), new Point(705, 680), "Australia"),
                new Rectangle(new Point(305, 250), new Point(428, 400), "Europe"),
                new Rectangle(new Point(10, 36), new Point(297, 474), "North America")

        };
        
        //graphing
        FrameDisplay frame = new FrameDisplay(g);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
