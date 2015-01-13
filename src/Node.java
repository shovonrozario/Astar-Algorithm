public class Node {
	private int node;//node number
	private int g;//path cost
	private int h;//heuristic value
	private int parent;//parent node number
	
	/*
	 * Set node number
	 * @param: node
	 */
	public void setNode(int node){
		this.node = node;
	}//End: setNode(int node)
	
	/*
	 * Return node number
	 * @return: node
	 */
	public int getNode(){
		return node;
	}//End: getNode()
	
	/*
	 * Set path cost
	 * @param: g
	 */
	public void setG(int g){
		this.g = g;
	}//End: setG(int g)
	
	/*
	 * Get path cost
	 * @return: g
	 */
	public int getG(){
		return g;
	}//End: getG()
	
	/*
	 * Set heuristic value
	 * @param: h
	 */
	public void setH(int h){
		this.h = h;
	}//End: setH(int h)
	
	/*
	 * Get heuristic value
	 * @return: h
	 */
	public int getH(){
		return h;
	}//End: getH()
	
	/*
	 * Set parent node number
	 * @param: parent
	 */
	public void setParent(int parent){
		this.parent = parent;
	}//End: setParent(int parent)
	
	/*
	 * Get parent node number
	 * @return: parent
	 */
	public int getParent(){
		return parent;
	}//End: getParent()
	
	/*
	 * Get f = g + h
	 * @return: f
	 */
	public int getF(){
		return g+h;
	}//End: getF()
	
}//End: Class Node
