package ru.stqa.pft.sandbox;

/**
 * Created by Boris on 19.12.2016.
 */
public class Distance {

  public static void main (String[] args){

    Point p1 = new Point(1,4);
    Point p2 = new Point(5,6);
//    System.out.println("Distance between point 1 and point 2 is "+calcDistance(p1,p2));
    System.out.println("Distance between point 1 and point 2 is "+p1.calcDistance(p2));

  }

//  public static double calcDistance(Point p1, Point p2){
//    return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
//
//  }

}
