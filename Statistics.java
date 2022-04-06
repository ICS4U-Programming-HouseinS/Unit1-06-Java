// import necessary packages
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**

* This program finds the mean and median using input from a text file.

*

* @author Housein Shaib
* @version 1.0

* @since   2022-04-06

*/

 
class Statistics {
 
  // method to calculate the mean
  public static double CalcMean(Integer[] array) {
    int tempNum = 0;
    double sum = 0;
    for (int i = 0; i < array.length; i++) {
      tempNum = (array[i]);
      sum = sum + tempNum;
    }
    double mean = sum / array.length;
    return mean;
  }
 
  // method to calculate the median
  public static List<Integer> CalcMedian(Integer[] array) {
    List<Integer> listOfMedian
            = new ArrayList<Integer>();
    if (array.length % 2 == 0) {
      int indexOfMedian1 = array.length / 2 - 1;
      int indexOfMedian2 = array.length / 2;
      listOfMedian.add(indexOfMedian1);
      listOfMedian.add(indexOfMedian2);
    } else {
      double indexOfMedianDou = array.length / 2 + 0.5;
      int indexOfMedian = (int) indexOfMedianDou;
      listOfMedian.add(indexOfMedian);
    }
    return listOfMedian;
  }
  
  // main method
  public static void main(String[] args) throws IOException {
     
    //declares variable
    int tempInt = 0;
    
    // creates lists for file input
    List<String> listOfStrings
        = new ArrayList<String>();
    List<Integer> listOfInt
        = new ArrayList<Integer>();
       
    // Enter data using BufferReader
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));

    while (true) {
      //asks user which file the would like to read from
      System.out.println("Which set of numbers would you like to pick? 1, 2 or 3?");
      // Reading data using readLine
      String userInput = reader.readLine();
          
      // declares myObj
      File myObj = new File("");
          
      // checks which file the user picked
      if (userInput.equals("1")) {
        myObj = new File("set1.txt");
      } else if (userInput.equals("2")) {
        myObj = new File("set2.txt");
      } else if (userInput.equals("3")) {
        myObj = new File("set3.txt");
      } else {
        System.out.println("error");
      }
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        listOfStrings.add(data);
      }

      // storing the data in list to array
      String[] array
          = listOfStrings.toArray(new String[0]);
            
      for (String str : listOfStrings) {
        tempInt = Integer.parseInt(str);
        listOfInt.add(tempInt);
      }
        
      // convert list to array
      Integer[] arrayOfIntegers
      = listOfInt.toArray(new Integer[listOfInt.size()]);
      
      // sorts array
      Arrays.sort(arrayOfIntegers);
      
      // calls method for mean and median while passing arrayOfIntegers
      System.out.println("The mean is " + CalcMean(arrayOfIntegers));
      List<Integer> listOfIndex
          = CalcMedian(arrayOfIntegers);
      Integer[] arrayOfIndex
            = listOfIndex.toArray(new Integer[0]);
      for (Integer index : listOfIndex) {
        System.out.println("The median is: " + arrayOfIntegers[index]);
      }
      break;
    }
  }
}