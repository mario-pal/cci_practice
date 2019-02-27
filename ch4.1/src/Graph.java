import java.util.ArrayDeque;
import java.util.Vector;
/*
 * Author: Mario Palma
 * Date: 2/26/2019
 * Purpose: This Class can represent a directed or undirected graph 
 *          (consisting of nodes and unweighted edges). 
 */
public class Graph {
	private Vector<Node> nodes;
	
	public Graph() {
		nodes = new Vector<Node>();
	}
	
	public Graph(int numVertices) {
		nodes = new Vector<Node>(numVertices);
		for(int i = 0; i < numVertices; i++) 
			 addNode();
	}
	
	/*
	 * Function name: addNode
	 * Purpose: Adds a new node to the graph with no edges.
	 *          The "name" (i.e. index field) of this newly inserted node will be a non-negative
	 *          number of type int that is automatically assigned to it based on the
	 *          number of nodes in the graph. For example, if the graph currently has 
	 *          3 nodes, then the name name of the newly added node will be 3.
	 *          
	 */
	public void addNode() {
		Node currNode = new Node();
		nodes.add(currNode);
		currNode.index = nodes.size() - 1;
	}
	
	/*Function name: addChild
	 * Purpose: Make node n2 a child of node n1
	 */
	public void addChild(int n1, int n2) {
		Node parentNode = nodes.get(n1);
		parentNode.children.add(n2);
	}
	
	/*
	 * Function name: biConnect
	 * Purpose: connect two nodes to each other such that they are children of each other.
	 */
	public void biConnect(int n1, int n2) {
		addChild(n1, n2);
		addChild(n2, n1);
	}
	
	/*public Vector<Node> getNodes(){
		return nodes;
	}*/
	
	public boolean pathExists(int start, int end) {
		ArrayDeque<Integer> q  = new ArrayDeque<Integer>();
		Integer currNode;
		Vector<Integer> theseChildren;
		
		for(Node n : nodes)  //as you may have run pathExists before
			n.visited = false;
		
		q.addLast(Integer.valueOf(start));
		
		while(!q.isEmpty()) {
			currNode = q.removeFirst();
			theseChildren = nodes.get(currNode.intValue()).children;
			
			for(Integer childIndex : theseChildren) {
				if(!nodes.get(childIndex.intValue()).visited) {
				  if(childIndex.intValue() == end)
					 return true;
				
					nodes.get(childIndex.intValue()).visited = true;
				    q.addLast(childIndex);
				}
			}
			nodes.get(currNode.intValue()).visited = true;
		}
		return false;		
	}
	/*
	 * ****************************************
	 * ****************************************
	 */
	public class Node{
		private Vector<Integer> children;
		private boolean visited;
		private int index;
		
		public Node(){
			children = new Vector<Integer>();
			visited = false;
		}
	}
	
	
}
