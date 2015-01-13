public class Graph {
	private int graphArray[][];//2d adjacency matrix
	private int vertices;//number of vertices
	private int edges;//number of edges
	
	/*
	 * Graph
	 * @param: numberOfVertices
	 */
	Graph(int vertices){
		this.vertices = vertices;
		graphArray = new int[vertices][vertices];
	}//End: Constructor
	
	/*
	 * Set edge between v1 and v2
	 * @param: v1, v2, pathCost
	 */
	public void setEdge(int v1, int v2, int pathCost){
		if(pathCost <=0){
			System.out.println("Invalid pathCost.");
			return;
		}
		graphArray[v1][v2] = pathCost;
		graphArray[v2][v1] = pathCost;
		edges++;		
	}//End: setEdge(int v1, int v2, int pathCost)
	
	/*
	 * Get path cost between v1 and v2
	 * @return: pathCost
	 */
	public int getEdge(int v1, int v2){
		return graphArray[v1][v2];
	}//End: getEdge(int v1, int v2)
	
	/*
	 * Get number of edges in the graph
	 * @return: edges
	 */
	public int getEdgeCount(){
		return edges;
	}//End: getEdgeCount()
	
	/*
	 * Get number of vertices in the graph
	 * @return: vertices
	 */
	public int getVerticeCount(){
		return vertices;
	}//End: getVerticeCount()
	
}//End: Class AGraph