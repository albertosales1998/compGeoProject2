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
        GeometricObject[] mapElements = new GeometricObject[]{
                new Polygon(
                        new Point[]{
                                new Point(34, 339),
                                new Point(294, 45),
                                new Point(310, 151),
                                new Point(192, 477)},
                        "North America"),
                new Polygon(
                        new Point[]{
                                new Point(216, 483),
                                new Point(287, 535),
                                new Point(224, 701),
                                new Point(183, 516)},
                        "South America"),
                new Polygon(
                        new Point[]{
                                new Point(385, 398),
                                new Point(334, 344),
                                new Point(391, 110),
                                new Point(430, 357)},
                        "Europe"),
                new Polygon(
                        new Point[]{
                                new Point(364, 408),
                                new Point(451, 484),
                                new Point(399, 619),
                                new Point(323, 467)},
                        "Africa/Middle-East"),
                new Polygon(
                        new Point[]{
                                new Point(608, 547),
                                new Point(696, 564),
                                new Point(674, 668),
                                new Point(569, 596)},
                        "Australia"),
        };
        
        //graphing
        FrameDisplay frame = new FrameDisplay(mapElements);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
