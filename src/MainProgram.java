import java.io.*;
import java.util.Scanner;

public class MainProgram {
	
	public static void main(String[] Args){
		System.out.println("A simple A* Search algorithm:");
		
		//number of vertices in the graph
		int vertices = 20;
		//file path for the graph-data
		String filePath = "data/graph-data.txt";
		boolean searchResult = false;
		
		//heuristic values for individual cities
		int h[] = { 366, 374, 380, 253, 178, 0, 80, 199, 226, 234, 329, 244, 241, 242, 160, 193, 98, 77, 151, 161 };		
		
		//initiate the graph; we are using adjacency matrix in this case
		Graph simpleGraph = makeGraph(vertices, filePath);
				
		//initiate AStar algorithm with the provided graph and heuristic values
		AStar astar = new AStar(h,simpleGraph);
		
		//search(sourceVertice, destinationVertice) returns true if solution found, else returns false
		searchResult = astar.search(0, 5);
		
		if (searchResult == true){
			//if solution found
			System.out.println("Minimum path to destination has been found.");
			System.out.println("Path: "+astar.printPath());
		}else{
			//if solution not found
			System.out.println("Minimum path to destination could not be found");
		}
		
	}//End: main()
	
	/*
	 * makeGraph
	 * @param: numberOfNodes, filePath
	 * @return: a graph object
	 */
	private static Graph makeGraph(int vertices, String filePath){
		Graph simpleGraph = new Graph(vertices);
		File dataFile;
		Scanner graphData;
		String[] data;
		int v1;//vertice 1
		int v2;//vertice 2
		int pathCost;//pathcost between v1 and v2
		
		try{
			dataFile = new File(filePath);
			graphData = new Scanner(dataFile);
			
			while(graphData.hasNext()){
				data = graphData.nextLine().split(",");
				
				//parse data to integer value
				v1 = Integer.parseInt(data[0]);
				v2 = Integer.parseInt(data[1]);
				pathCost = Integer.parseInt(data[2]);
				
				simpleGraph.setEdge(v1, v2, pathCost);
			}
			
		}catch (FileNotFoundException e) {
			System.out.println("File could not be found");
		}
		return simpleGraph;
		
	}//End: makeGraph(int vertices, String filePath)
	
}//End: Class MainProgram



