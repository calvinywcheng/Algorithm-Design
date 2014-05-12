import java.io.*;
import java.util.*;

/**
 * This program compute the number of inversions in the file given,
 * where the <i>i</i><sup>th</sup> row of the file indicates the
 * <i>i</i><sup>th</sup> entry of an array.
 * 
 * @author Calvin Cheng
 */
public class CountInversions {
	
	/**
	 * Counts the number of inversions in the given list of integers.
	 * 
	 * @param intArray the list of integers to be processed.
	 * @return the number of inversions in the given list of integers.
	 */
	public static long countInversions(List<Integer> intArray) {
		
		return sortAndCount(intArray);
	}
	
	private static long sortAndCount(List<Integer> intArray) {
		
		if (intArray.size() <= 1) {
			return 0;
		}
		else {
			List<Integer> left = intArray.subList(0, intArray.size()/2);
			List<Integer> right = intArray.subList(intArray.size()/2, intArray.size());
			
			return sortAndCount(left) + sortAndCount(right) + mergeAndCount(left, right);
		}
	}
	
	private static long mergeAndCount(List<Integer> left, List<Integer> right) {
		
		int[] sorted = new int[left.size() + right.size()];
		long count = 0;
		
		int i = 0;
		int j = 0;
		
		for(int k = 0; k < (left.size() + right.size()); k++) {
			
			if (i == left.size()) {
				sorted[k] = right.get(j);
				j++;
			}
			else if (j == right.size()) {
				sorted[k] = left.get(i);
				i++;
			}
			else if (left.get(i) <= right.get(j)) {
				sorted[k] = left.get(i);
				i++;
			}
			else if (left.get(i) > right.get(j)) {
				sorted[k] = right.get(j);
				count += (left.size() - i);
				j++;
			}
		}
		
		for (i = 0; i < left.size(); i++) {
			left.set(i, sorted[i]);
		}
		for (i = 0; i < right.size(); i++) {
			right.set(i, sorted[i + left.size()]);
		}
		
		return count;
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("IntegerArray.txt"));
		ArrayList<Integer> intArray = new ArrayList<Integer>(100000);
		
		while(input.hasNextInt()) {
			intArray.add(input.nextInt());
		}
		
		long splitInversions = countInversions(intArray);
		
		System.out.println(splitInversions);
		
		input.close();
		
		return;
	}

}
