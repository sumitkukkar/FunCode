/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Sumit
 */
public class Graph {
    
    ArrayList<GraphNode> nodes;
    HashMap<String, GraphNode> idToNodeMapping;
    public Graph()
    {
        this.nodes = new ArrayList<GraphNode>();
        this.idToNodeMapping = new HashMap<String, GraphNode>();
    }
    
    public static void driver()
    {
        Graph graph = new Graph();
        graph.createGraph();
    }
    
    public void initializeGraph()
    {
        for(GraphNode node : this.nodes)
        {
            node.setVisited(Visited.NotVisited);            
        }
    }
    
    public GraphNode getNode(String id)
    {        
        return this.idToNodeMapping.get(id);
    }
     
    
    public void createGraph()
    {
        int [][]input = new int[5][5];
        HashMap<Integer, GraphNode> map = new HashMap<Integer, GraphNode>();
        
        for(int i = 0; i < input.length; i++)
        {
            for(int j = 0; j < input[i].length; j++)
            {
                Integer temp = i * input.length + j;
                GraphNode newNode = null;
                if(!map.containsKey(temp))
                {
                    newNode = new GraphNode(temp.toString());
                    map.put(temp, newNode);
                }
                else
                {
                    newNode = map.get(temp);
                }
                
                // now add the neighbours
                // add the left node
                if(j > 0)
                {
                    if(map.containsKey(temp - 1))
                    {
                        GraphNode leftNode = map.get(temp - 1);
                        leftNode.addNeighbors(newNode);
                        newNode.addNeighbors(leftNode);
                    }
                }
                
                if(i > 0)
                {
                    if(map.containsKey(temp - input.length))
                    {
                        GraphNode topNode = map.get(temp - input.length);
                        topNode.addNeighbors(newNode);
                        newNode.addNeighbors(topNode);                    
                    }
                }
                this.nodes.add(newNode);
                this.idToNodeMapping.put(newNode.getId(), newNode);        
            }
        }
    }        
            
    
}
