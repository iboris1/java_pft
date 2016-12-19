package ru.stqa.pft.sandbox;

/**
 * Created by Boris on 19.12.2016.
 */
public class Point {

  public int x;
  public int y;

  public Point(int x, int y){
    this.x = x;
    this.y = y;

  }

  public double calcDistance(Point p2){
    return Math.sqrt(Math.pow((this.x - p2.x), 2) + Math.pow((this.y - p2.y), 2));

  }

}
