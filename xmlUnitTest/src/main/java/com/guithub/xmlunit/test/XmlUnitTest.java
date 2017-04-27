package com.guithub.xmlunit.test;

import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.Difference;

import javax.xml.transform.Source;

public class XmlUnitTest {

  public static void main(String[] args) {

    //не всегда работает, причину пока не нашел

    Source source1 = Input.fromFile("first.xml").build();
    Source source2 = Input.fromFile("second.xml").build();

    Diff myDiff = DiffBuilder.compare(source1).withTest(source2).build();
    Iterable<Difference> differences = myDiff.getDifferences();
    for (Difference difference : differences) {
      System.out.println(difference);
    }
    System.out.println("*******************");
    System.out.println(myDiff.toString());
  }
}
