package com.guithub.xmlunit.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.SAXException;
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.Difference;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ComparisonTest {

  public static void main(String[] args) {

    FileReader fr1 = null;
    FileReader fr2 = null;
    try {
      fr1 = new FileReader("Binchois.xml");
      fr2 = new FileReader("Binchois2.xml");
    } catch (FileNotFoundException exception) {
      exception.printStackTrace();
    }

    // don't validate dtd
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setValidating(false);
    try {
      dbf.setFeature("http://xml.org/sax/features/namespaces", false);
      dbf.setFeature("http://xml.org/sax/features/validation", false);
      dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar",
          false);
      dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd",
          false);
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }

    XMLUnit.setTestDocumentBuilderFactory(dbf);
    XMLUnit.setControlDocumentBuilderFactory(dbf);

    try {
      Diff diff = new Diff(fr1, fr2);
      System.out.println("Similar? " + diff.similar());
      System.out.println("Identical? " + diff.identical());

      DetailedDiff detDiff = new DetailedDiff(diff);
      List differences = detDiff.getAllDifferences();
      for (Object object : differences) {
        Difference difference = (Difference) object;
        System.out.println("***********************");
        System.out.println(difference);
        System.out.println("***********************");
      }

    } catch (SAXException exception) {
      exception.printStackTrace();
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

}
