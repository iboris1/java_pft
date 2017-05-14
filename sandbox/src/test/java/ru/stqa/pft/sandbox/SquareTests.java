package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Boris on 24.12.2016.
 */
public class SquareTests {

  @Test
  public void testArea(){
    Square s = new Square(5);
    Assert.assertEquals(s.area(), 30.0);
  }

}
