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
	
	private static int countInversions(List<Integer> intArray) {
		return sortAndCount(intArray, 0);
	}
	
	private static int sortAndCount(List<Integer> intArray, int inversions) {
		if (intArray.size() == 1) {
			return 0;
		}
		else {
			return mergeAndCount(intArray.subList(0, intArray.size()/2),
					intArray.subList(intArray.size()/2, intArray.size()));
		}
	}
	
	private static int mergeAndCount(List<Integer> left, List<Integer> right) {
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("IntegerArray.txt"));
		ArrayList<Integer> intArray = new ArrayList<Integer>(100000);
		
		while(input.hasNextInt()) {
			intArray.add(input.nextInt());
		}
		
		int splitInversions = countInversions(intArray);
		
		System.out.println(splitInversions);
		
		input.close();
		
		return;
	}

}
