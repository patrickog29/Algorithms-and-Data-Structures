package assignment4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DRG implements WeightedGraphInterface{
	
	public static int NULL_EDGE = 0;
	private int numVertices;
	private int maxVertices;
	private Node[] vertices;
	private int[][] edges;
	private boolean[] marks;  
	  
    public DRG(int maxV)
	{
	   numVertices = 0;
	   maxVertices = maxV;
	   vertices = new Node[maxV];
	   marks = new boolean[maxV];
	   edges = new int[maxV][maxV];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addVertex(Node vertex) {		
		vertices[numVertices] = vertex;
	    for (int index = 0; index < numVertices; index++)
	    {
	      edges[numVertices][index] = NULL_EDGE;
	      edges[index][numVertices] = NULL_EDGE;
	    }
	    numVertices++;		
	}
	@Override
	public String addEdge(Node fromVertex, Node toVertex, int weight) {
		//check if airport is in the graph
		int addFlightCheck = 0;
		for(int i=0; i<=numVertices-1; i++)
		{
			if(fromVertex.getLocation().equalsIgnoreCase(vertices[i].getLocation()))
			{
				addFlightCheck++;
                                
                                fromVertex = vertices[i];
                                
                                
                                
			}
			else if(toVertex.getLocation().equalsIgnoreCase(vertices[i].getLocation()))
			{
				addFlightCheck++;
                                toVertex = vertices[i];
			}
		}
		if(addFlightCheck<2)
		{
		
			return ("Both airports must exist");
		}
		//end check for both airports
	    int row;
	    int column; 
	    row = indexIs(fromVertex);
	    column = indexIs(toVertex);
	    edges[row][column] = weight;
            
            return ("Flight Added");
	}
	@Override
	public String deleteEdge(Node fromVertex, Node toVertex) {
		int addFlightCheck = 0;
		for(int i=0; i<=numVertices-1; i++)
		{
			if(fromVertex.getLocation().equalsIgnoreCase(vertices[i].getLocation()))
			{
				addFlightCheck++;
                                fromVertex = vertices[i];
			}
			else if(toVertex.getLocation().equalsIgnoreCase(vertices[i].getLocation()))
			{
				addFlightCheck++;
                                toVertex = vertices[i];
			}
		}
		if(addFlightCheck<2)
		{
			
			return ("Both airports must exist");
		}
		//end check for both airports
		    int row;
		    int column; 
		    row = indexIs(fromVertex);
		    column = indexIs(toVertex);
		    edges[row][column] = NULL_EDGE;
		    //loop through data structure and print the flights
		    return ("Flight deleted +\n");
        }

	@Override
	public int weightIs(Node fromVertex, Node toVertex) {
	    int row;
	    int column; 
	    row = indexIs(fromVertex);
	    column = indexIs(toVertex);
	    return edges[row][column];
	}
	//used for the search
	@Override
	public Queue<Node> getToVertices(Node vertex) {
		Queue<Node> adjVertices = new LinkedList<Node>();
	    int fromIndex;
	    int toIndex;
	    fromIndex = indexIs(vertex);
	    for (toIndex = 0; toIndex < numVertices; toIndex++)
	    {  if (edges[fromIndex][toIndex] != NULL_EDGE)
	        adjVertices.add(vertices[toIndex]);}
	    return adjVertices;
	}

	@Override
	public void clearMarks() {
		// TODO Auto-generated method stub
                
                for(int j = 0; j<numVertices-1; j++)
	    {
		   vertices[j].setMarked(false); 
	    }
		
	}

	@Override
	public void markVertex(Node vertex) {
		vertex.setMarked(true);
	}
	//for search
	@Override
	public boolean isMarked(Node vertex) {
		if(vertex.isMarked())
		{return true;}
		else
		return false;
	}
	//private method to this class
	private int indexIs(Node vertex)
	 // Post: Returns the index of vertex in vertices
	  {
	    int index = 0;
	    while (vertex != vertices[index] && index<numVertices-1)
	      index++;
	    return index;
	  }
        
        public String displayAllFlights() {
        
            String allFlights = "";
              for(int i = 0; i<numVertices; i++)
	    {
		    for(int j = 0; j<numVertices; j++)
		    {
		    	if(edges[i][j]!=NULL_EDGE)
		    	{
		    		//set text of flight schedule to this
		    	allFlights += vertices[i].getLocation()+" to "+vertices[j].getLocation()+" "+edges[i][j] + "\n" + "\n";
                        
		    	}		    
                        
		    }   	
                    
	    }//loop through
              
              return allFlights;
            
            
        }
        
        
        public String depthFirstSearch(WeightedGraphInterface graph, Node startVertex, Node endVertex)
	{
		for(int i=0; i<=numVertices-1; i++)
		{
			if(startVertex.getLocation().equalsIgnoreCase(vertices[i].getLocation()))
			{
				startVertex = vertices[i];
			}
			else if(endVertex.getLocation().equalsIgnoreCase(vertices[i].getLocation()))
			{
				endVertex = vertices[i];
			}
		}
		boolean found = false;
		String path = "Flight Path: \n";
		Stack<Node> stack = new Stack<Node>();
	  	Queue<Node> vertexQueue = new LinkedList<Node>(); 
	  	//boolean found = false;
	  	Node item;
	  	graph.clearMarks();
	  	stack.push(startVertex);
	  	path += "==>"+startVertex.getLocation()+"\n";
	  	do
	  	{
	   		//stack.add(startVertex);
	  		
			Node search = stack.pop();
	    	if(search == endVertex)
	    	{
				found = true;
				path += "==>"+startVertex.getLocation()+"\n";
	    	}
			else
			{
	      		if(!graph.isMarked(search))
	      		{
	        		graph.markVertex(search);
	        		vertexQueue = graph.getToVertices(search);
	        		while (!vertexQueue.isEmpty())
	        		{
	                  	item = vertexQueue.poll();
	        			if(!graph.isMarked(item))
	        			{
	        				stack.push(item);
	        				path += "==>"+item.getLocation()+"\n";
	                	}
	              	}
	            }
			}
	      } while (!stack.isEmpty() && !found);      
	      return path;	      
	  }
        
}
