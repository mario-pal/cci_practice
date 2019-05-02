public class TreeNode {
	private int element;
	public TreeNode[] children;
	private final int MAX_CHILDREN = 2;
	
	public TreeNode() {
		children = new TreeNode[MAX_CHILDREN];
	}
	
	public TreeNode(int element) {
		this.element = element;
		children = new TreeNode[MAX_CHILDREN];
	}
	
	public String toSring() {
		return Integer.toString(element);
	}

}
