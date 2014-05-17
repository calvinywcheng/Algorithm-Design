import java.io.*;
import java.util.*;

public class Quicksort {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(new File("Quicksort.txt"));
		
		List<Short> sortArray = new ArrayList<Short>(10000);
		
		while(input.hasNextShort()) {
			sortArray.add(input.nextShort());
		}
		
		System.out.println(sortArray.size());
		
		input.close();
		return;
	}

}
