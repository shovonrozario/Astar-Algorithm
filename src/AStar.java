import java.util.Comparator;
import java.util.PriorityQueue;

public class AStar {
	private int h[];//heuristic value
	private Graph simpleGraph;//graph matrix
	private boolean goalReached;//check whether goal reached
	private int goalState;//goal node number
	private PriorityQueue<Node> open;//priority queue for expanding the nodes and sort them according to their F value
	private Node path[];//keeps track of the nodes to trace back the path
	
	/*
	 * Constructor
	 * @param: heuristicValue, simpleGraph
	 */
	AStar(int h[], Graph simpleGraph){
		this.h = h;
		this.simpleGraph = simpleGraph;
		goalReached = false;
		path = new Node[simpleGraph.getVerticeCount()];
		
		//initializing the Priority-Queue with custom comparator to sort the nodes according to F Values
		open = new PriorityQueue<Node>(simpleGraph.getVerticeCount(),
                new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2){
                if (n1.getF() > n2.getF()){
                    return +1;
                }
                else if (n1.getF() < n2.getF()){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
	}//End: Constructor
	
	/*
	 * AStar search algorithm
	 * @param: startState, goalState
	 * @return: true if solution found, else false
	 */
	public boolean search(int startState, int goalState){
		this.goalState = goalState;
		Node currentNode = new Node();
		currentNode.setNode(startState);
		currentNode.setG(0);
		currentNode.setH(h[startState]);
		currentNode.setParent(startState);							
		open.add(currentNode);
		
		while(open.size() > 0) {
			//remove the node of least F value from the priority queue
			currentNode = (Node)(open.remove());
			path[currentNode.getNode()] = currentNode;
			System.out.println("Node" + currentNode.getNode() + " F: " + currentNode.getF());
			if(currentNode.getNode()==16)
				System.out.println("reached");
			
			//if goal reached, return true
			if (currentNode.getNode() == goalState){
				goalReached = true;				
				return true;
			}
			
			if(currentNode.getNode()==16)
				System.out.println("reached2");
			
			//expand the neighboring nodes for the current node and add them to the priority queue
			for(int i = 0; i < simpleGraph.getVerticeCount(); i++){		
				if(currentNode.getNode()==16 && i==5)
					System.out.println("reached3: "+simpleGraph.getEdge(currentNode.getNode(), i));
				if(simpleGraph.getEdge(currentNode.getNode(), i) != 0){
					Node neighborNode = new Node();
					neighborNode.setNode(i);
					neighborNode.setG(currentNode.getG()+simpleGraph.getEdge(currentNode.getNode(), i));
					neighborNode.setH(h[i]);
					neighborNode.setParent(currentNode.getNode());
					
					open.add(neighborNode);
				}
			}
        }		
		return false;
	}//End: search(int startState, int goalState)
	
	/*
	 * Prints path of the solution found
	 * @return: String
	 */
	public String printPath(){
		String output = "";
		if(goalReached == false){
			output = "Sorry , we didn't find any solution!";
		}else{
			//if goal reached, trace back the parents starting from the goal node to form the path
			Node pathNode = path[goalState];
			System.out.println("Minimum Distance: "+pathNode.getF());
			while(pathNode.getNode() != pathNode.getParent()){
				output = " -> "+pathNode.getNode() + output;
				pathNode = path[pathNode.getParent()];
			}
			output = pathNode.getNode() + output;
		}
		return output;
	}//End: printPath()
	
}//End: Class AStar
