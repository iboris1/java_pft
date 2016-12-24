package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Boris on 24.12.2016.
 */
public class PointTests {

  @Test
  public void testDistance(){
    Point p1 = new Point (2,3);
    Point p2 = new Point (-2,3);

    Point p3 = new Point (3,0);
    Point p4 = new Point (0,4);

    Assert.assertEquals(p1.calcDistance(p2),4.0);
    Assert.assertEquals(p3.calcDistance(p4),5.0);

  }

}
