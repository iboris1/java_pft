package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Boris on 16.01.2017.
 */
public class Collections {

  public static void main(String args[]) {
    String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

//    for ( int i = 0; i < languages.size(); i++){
//      System.out.println("Я хочу выучить " + languages.get(i));
//    }

    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }

  }
}
