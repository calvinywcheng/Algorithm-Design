import java.util.*;
import java.io.*;

public class GraphMinCuts {
	
	private static final int N = 200;
	
	private static Map<Integer, List<Integer>> getGraph(File file) throws FileNotFoundException {

		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>(255, 0.8f);
		
		Scanner input = new Scanner(file);
		
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
		
		return graph;
	}
	
	private static int getCut(Map<Integer, List<Integer>> graph) {
		
		if (graph.size() <= 2) {
			return graph.get(0).size();
		}
		else {
			int u = (int)(Math.random() * graph.size());
			int v = graph.get(u).get((int)(Math.random() * graph.get(u).size()));
			contract(graph, u, v);
			return getCut(graph);
		}
	}
	
	private static void contract(Map<Integer, List<Integer>> graph, int u, int v) {
		graph.get(u).addAll(graph.get(graph.get(v)));
		graph.remove(v);
		removeSelfLoops(graph, u);
	}
	
	private static void removeSelfLoops(Map<Integer, List<Integer>> graph, int u) {
		while (graph.get(u).contains(u)) {
			graph.remove(graph.get(u).indexOf(u));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		int minCut = 200;
		File inputFile = new File("KargerMinCut.txt");
		
		for (int repeat = 0; repeat < N; repeat++) {
			int cut = getCut(getGraph(inputFile));
			if (cut < minCut)
				minCut = cut;
		}
		
		System.out.println("After " + N + " iterations of the random contraction algorithm,"
				+ "the minimum cut for the graph was found to be " + minCut + ".");
	}

}
