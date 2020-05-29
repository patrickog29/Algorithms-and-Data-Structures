package assignment4;
import java.util.Queue;

public interface WeightedGraphInterface {
	
	public boolean isEmpty();
	public boolean isFull();
	public void addVertex(Node vertex);
	public String addEdge(Node fromVertex, Node toVertex, int weight);
	public String deleteEdge(Node fromVertex, Node toVertex);
	public int weightIs(Node fromVertex, Node toVertex);
	public Queue<Node> getToVertices(Node vertex);
	public void clearMarks();
	public void markVertex(Node vertex);
	public boolean isMarked(Node vertex);
}
