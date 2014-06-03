import java.util.*;
import java.io.*;

public class GraphMinCuts {

	public static void main(String[] args) throws FileNotFoundException {
		
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>(200, 1.0f);
		
		Scanner input = new Scanner(new File("kargerMinCut.txt"));
		
		while (input.hasNextLine()) {
			Scanner parseLine = new Scanner(input.nextLine());
			int node = parseLine.nextInt();
			List<Integer> adjacent = new LinkedList<Integer>();
			while (parseLine.hasNext())
				adjacent.add(parseLine.nextInt());
			graph.put(node, adjacent);
			parseLine.close();
		}
		
		input.close();
		
	}

}
