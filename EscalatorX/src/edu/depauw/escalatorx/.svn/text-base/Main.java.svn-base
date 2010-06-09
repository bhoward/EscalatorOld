package edu.depauw.escalatorx;

import java.util.*;

/**
 * Only used as the starting point for the runnable jar.
 * 
 * Source: http://garyboone.com/2009/06/creating-single-file-runnable-jars-in-scala-and-eclipse/
 */
public class Main {
  public static void main(String[] args) {
    List<String> argList = new ArrayList<String>();
    argList.add("edu.depauw.escalatorx.Escalator");
    for (String s : args)
      argList.add(s);
    scala.tools.nsc.MainGenericRunner.main(argList.toArray(new String[0]));
  }
}
