package assignment2;

public class Algorithms {
    public static int isPointInSet(GeometricObject[] pArray, Point p){
        for (int i = 0; i < pArray.length; i++) {
            Polygon poly = (Polygon) pArray[i];
            if (poly.getBoundingRectangle().isPointInRectangle(p)) return i;
        }
        return -1;
    }
}