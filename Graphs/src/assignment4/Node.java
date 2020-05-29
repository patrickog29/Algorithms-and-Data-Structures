package assignment4;

public class Node {
	boolean isMarked;
	String location;
	public Node(String s)
	{
		isMarked = false;
		location = s;
	}
	public void setMarked(boolean isMarked) {
		this.isMarked = isMarked;
	}
	public boolean isMarked() {
		return isMarked;
	}
	public String getLocation() {
		return location;
	}
	
}
