package assignment2;

import java.awt.Graphics;
import java.util.ArrayList;

public class Rectangle extends GeometricObject{
    private Point begin;
    private Point end;
    private String continent;
    public ArrayList<Point> points;

    public Rectangle() {
        begin = new Point(0, 0);
        end = new Point(1, 1);
    }

    public Rectangle(Point b, Point e) {
        begin = new Point(b.getX(), b.getY());
        end = new Point(e.getX(), e.getY());
    }

    public Rectangle(Point b, Point e, String continent) {
        begin = new Point(b.getX(), b.getY());
        end = new Point(e.getX(), e.getY());
        this.continent = continent;
    }

    public void draw(Graphics g) {
        int x = (int)smallestX();
        int y = (int)smallestY();
        int w = (int)width();
        int h = (int)height();

        g.setColor(getInteriorColor());
        g.fillRect(x, y, w, h);

        g.setColor(getBoundaryColor());
        g.drawRect(x, y, w, h);
    }

    public Point getBegin() {
        return begin;
    }

    public void setBegin(Point begin) {
        this.begin = new Point(begin.getX(), begin.getY());
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = new Point(end.getX(), end.getY());
    }

    public double greatestX() {
        return begin.getX() > end.getX() ? begin.getX():end.getX();
    }

    public double greatestY() {
        return begin.getY() > end.getY() ? begin.getY():end.getY();
    }

    public double height() {
        return Math.abs(begin.getY() - end.getY());
    }

    public double smallestX() {
        return begin.getX() < end.getX() ? begin.getX():end.getX();
    }

    public double smallestY() {
        return begin.getY() < end.getY() ? begin.getY():end.getY();
    }

    public String toString() {
        String str = "Rectangle " + super.toString() + "\n";
        str += begin + "\n" + end  + "\n" + continent;
        return str;
    }

    public void translate(Vector v) {
        begin.translate(v);
        end.translate(v);
    }

    public double width() {
        return Math.abs(begin.getX() - end.getX());
    }

    /**
     * @param p given point
     * @return true iff p is in the boundaries of the rectangle
     */
    public boolean isPointInRectangle(Point p){
        double x = p.getX();
        double y = p.getY();
        if ((smallestX() <= x && x <= greatestX()) && (smallestY() <= y && y <= greatestY())) return true;
        else return false;
    }

    public String getContinent() {
        return continent;
    }
}
