package assignment2;

import java.awt.Graphics;
import java.util.Arrays;

/**
 * This class represents a simple polygon; polygon is given by its vertices
 * listed in counterclockwise order.
 */
public class Polygon extends GeometricObject
{

    private Point[] vertexList; //list of vertices in counterclockwise order
    private int size;   //capacity of array vertexList
    private int vertNumber; //number of vertices of this polygon
    private String mapElement;
    private Rectangle boundingRectangle;

    /**
     * Instantiates a Polygon object. The polygon vertices are given in an array
     * of Point type. All points in the array will become vertices of the polygon.
     *
     * @param pointList array of points that will form the polygon vertices;
     *                  must have at least 3 vertices.
     */
    Polygon(Point[] pointList, String mapElement) throws IllegalArgumentException
    {
        //less that 3 vertices do not define a polygon
        if (pointList.length < 3) throw new IllegalArgumentException(
                "Attempt to define a polygon with less than 3 vertices");
        else
        {
            vertNumber = size = pointList.length;
            vertexList =  new Point[size];

            for (int i=0; i<vertNumber; i++)
            {
                vertexList[i] = pointList[i];
            }
        }

        this.mapElement = mapElement;
        this.boundingRectangle = new Rectangle(new Point(smallestX(), smallestY()), new Point(greatestX(), greatestY()));
    }

    /**
     * Adds a vertex as the last one in the sequence of vertices. Vertex array
     * will be expanded to double its size if vertex cannot be added because
     * array is full.
     *
     * @param v the new vertex
     */
    public void addVertex(Point v)
    {
        if (vertNumber == size)
        {
            size = 2*size;
            vertexList = Arrays.copyOf(vertexList, size);
        }

        vertexList[vertNumber] = v;
        vertNumber++;
    }

    public Rectangle getBoundingRectangle(){
        return boundingRectangle;
    }

    public String getMapElement(){
        return mapElement;
    }

    /**
     * Draws this polygon.
     *
     * @param g graphics context
     */
    @Override
    public void draw(Graphics g)
    {
        int[] x = new int[vertNumber];
        int[] y = new int[vertNumber];

        for(int i=0; i<vertNumber; i++)
        {
            x[i] = (int)vertexList[i].getX();
            y[i] = (int)vertexList[i].getY();
        }

        g.setColor(getInteriorColor());
        g.fillPolygon(x, y, vertNumber);
        g.setColor(getBoundaryColor());
        g.drawPolygon(x, y, vertNumber);
    }

    /**
     * Returns the number of vertices in this polygon
     *
     * @return number of vertices in this polygon
     */
    public int getNumberOfVertices()
    {
        return vertNumber;
    }

    /**
     * Obtains the vertices of the boundary of this polygon.
     *
     * @return array of vertices in the boundary of this polygon, counterclockwise
     */
    public Point[] getVertices()
    {
        Point[] vertices = new Point[vertNumber];
        for(int i=0; i<vertNumber; i++)
        {
            vertices[i] = vertexList[i];
        }

        return vertices;
    }

    /**
     * Determines the greatest x.
     *
     * @return the greatest x
     */
    public double greatestX()
    {
        double maxX = vertexList[0].getX();
        for (int i = 1; i < vertNumber; i++)
        {
            double xVal = vertexList[i].getX();

            if (xVal > maxX)
                maxX = xVal;
        }

        return maxX;
    }

    /**
     * Determines the greatest y.
     *
     * @return the greatest y
     */
    public double greatestY()
    {
        double maxY = vertexList[0].getY();
        for (int i = 1; i < vertNumber; i++)
        {
            double yVal = vertexList[i].getY();

            if (yVal > maxY)
                maxY = yVal;
        }

        return maxY;
    }

    /**
     * Determines the smallest x.
     *
     * @return the smallest x
     */
    public double smallestX()
    {
        double minX = vertexList[0].getX();
        for (int i = 1; i < vertNumber; i++)
        {
            double xVal = vertexList[i].getX();

            if (xVal < minX)
                minX = xVal;
        }

        return minX;
    }

    /**
     * Determines the smallest y.
     *
     * @return the smallest y
     */
    public double smallestY()
    {
        double minY = vertexList[0].getY();
        for (int i = 1; i < vertNumber; i++)
        {
            double yVal = vertexList[i].getY();

            if (yVal < minY)
                minY = yVal;
        }

        return minY;
    }

    /**
     * @return the area of a polygon
     */
    public double area(){
        double sum1 = 0.0, sum2 = 0.0;
        Point v1, v2;

        for (int i = 0; i < vertNumber; i++){
            v1 = vertexList[i];
            v2 = vertexList[(i + 1)% vertNumber];

            sum1 += v1.getX() * v2.getY();
            sum2 += v2.getX() * v1.getY();
        }

        double area = 0.5 * Math.abs(sum1 - sum2);
        return area;
    }

    /**
     * Constructs a String description of this polygon.
     *
     * @return String containing description of this polygon.
     */
    @Override
    public String toString()
    {
        String str = "POLYGON " + vertNumber + " " + super.toString() + "\n";

        for (int i = 0; i<vertNumber-1; i++)
        {
            str += vertexList[i] + "\n";
        }

        str += vertexList[vertNumber-1];
        str += "\n" + boundingRectangle.toString();

        return str;
    }

    /**
     * Translates this simple polygon by given vector.
     *
     * @param v given vector
     */
    public void translate(Vector v)
    {
        for (int i=0; i<vertNumber; i++)
        {
            vertexList[i].translate(v);
        }
    }
}