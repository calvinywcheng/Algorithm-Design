import java.util.*;
import java.io.*;

public class GraphMinCuts {
	
	private static final int N = 1000;
	private static Random rand = new Random(System.currentTimeMillis());
	
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
			Iterator<Map.Entry<Integer, List<Integer>>> iter = graph.entrySet().iterator();
			return iter.next().getValue().size();
		}
		else {
			int u = getRandomKey(graph);
			int v = graph.get(u).get(rand.nextInt(graph.get(u).size()));
			contract(graph, u, v);
			return getCut(graph);
		}
	}
	
	private static int getRandomKey(Map<Integer, List<Integer>> graph) {
		Iterator<Integer> iter = graph.keySet().iterator();
		int rn = rand.nextInt(graph.size());
		for (int i = 0; i < rn; i++) {
			iter.next();
		}
		return iter.next();
	}
	
	private static void contract(Map<Integer, List<Integer>> graph, int u, int v) {
		graph.get(u).addAll(graph.get(v));
		graph.remove(v);
		fixEdges(graph, u, v);
		removeSelfLoops(graph, u);
	}
	
	private static void fixEdges(Map<Integer, List<Integer>> graph, int u, int v) {
		Iterator<Map.Entry<Integer, List<Integer>>> entry = graph.entrySet().iterator();
		while (entry.hasNext()) {
			List<Integer> li = entry.next().getValue();
			while (li.contains(v)) {
				li.set(li.indexOf(v), u);
			}
		}
	}
	
	private static void removeSelfLoops(Map<Integer, List<Integer>> graph, int u) {
		while (graph.get(u).contains(u)) {
			graph.get(u).remove(graph.get(u).indexOf(u));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		int minCut = 200;
		File inputFile = new File("KargerMinCut.txt");
		
		for (int repeat = 0; repeat < N; repeat++) {
			int cut = getCut(getGraph(inputFile));
			//System.out.println("Iteration " + repeat + ": " + cut);
			if (cut < minCut)
				minCut = cut;
		}
		
		System.out.println("After " + N + " iterations of the random contraction algorithm,"
				+ " the minimum cut for the graph was found to be " + minCut + ".");
	}

}
