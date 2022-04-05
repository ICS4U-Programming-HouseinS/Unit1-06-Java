// import necessary packages
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
 
class Statistics {
 
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
 
  public static List<Integer> CalcMedian(Integer[] array) {
    List<Integer> listOfMedian
            = new ArrayList<Integer>();
    if (array.length % 2 == 0) {
      int indexOfMedian1 = array.length/2 -1;
      int indexOfMedian2 = array.length/2;
      System.out.println("index1: " + indexOfMedian1);
      System.out.println("index2: " + indexOfMedian2);
      listOfMedian.add(indexOfMedian1);
      listOfMedian.add(indexOfMedian2);
    } else {
      int indexOfMedian = array.length / 2 + 0.5;
      listOfMedian.add(indexOfMedian);
      System.out.println(indexOfMedian);
    }
    return listOfMedian;
  }
  
  public static void main(String[] args) throws IOException {
     
     int tempInt = 0;
    
     // list that holds strings of a file
        List<String> listOfStrings
            = new ArrayList<String>();
        List<Integer> listOfInt
            = new ArrayList<Integer>();
       
        File myObj = new File("set1.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          listOfStrings.add(data);
        }

        // storing the data in arraylist to array
        String[] array
            = listOfStrings.toArray(new String[0]);
            
        for (String str : listOfStrings) {
          tempInt = Integer.parseInt(str);
          listOfInt.add(tempInt);
        }
        
      System.out.println(listOfInt);
        
        Integer[] arrayOfIntegers
      = listOfInt.toArray(new Integer[listOfInt.size()]);
      
      Arrays.sort(arrayOfIntegers);
      
      System.out.println("The mean is " + CalcMean(arrayOfIntegers));
      System.out.println("The median(s) is " + CalcMedian(arrayOfIntegers));
    }
}