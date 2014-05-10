import java.io.*;
import java.util.*;

/**
 * This program compute the number of inversions in the file given,
 * where the <i>i</i><sup>th</sup> row of the file indicates the
 * <i>i</i><sup>th</sup> entry of an array.
 * 
 * @author Calvin Cheng
 */
public class SplitInversions {
	
	private static int countInversions(int[] intArray) {
		return 0;
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("IntegerArray.txt"));
		int[] intArray = new int[100000];
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = input.nextInt();
		}
		
		int splitInversions = countInversions(intArray);
		
		System.out.println(splitInversions);
		
		input.close();
		
		return;
	}

}
