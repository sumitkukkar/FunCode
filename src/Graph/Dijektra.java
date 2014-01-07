/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graph;

import java.util.ArrayList;

/**
 *
 * @author Sumit
 */
public class Dijektra {
    
    Graph graph;
    GraphNode source;
    
    public static void driver()
    {
        Graph graph = new Graph();
        graph.createGraph();
        
        GraphNode source = graph.getNode("2");
        GraphNode destination = graph.getNode("11");
        Dijektra dijektra = new Dijektra(graph, source);
        dijektra.findMinimumDistance();
        
        dijektra.printPath(source);
        dijektra.printPath(destination);
        
        
    }
    
    public Dijektra(Graph graph,GraphNode source)
    {
        this.graph = graph;
        this.source = source;
    }
    
    private GraphNode extractMinValueNode()
    {
        GraphNode minNode = null;
        int minValue = Integer.MAX_VALUE;
        for(GraphNode node : this.graph.nodes)
        {
            if(node.getVisited() == Visited.NotVisited)
            {
                if(minValue > node.getCostFromSource())
                {
                    minNode = node;
                    minValue = node.getCostFromSource();
                }
            }
        }
        
        return minNode;
    }
    
    public void printPath(GraphNode node)
    {
        System.out.println("Path is => ");
        while(node != null)
        {
            System.out.print(node.getId() + " <<== ");
            node = node.getParentNode();
        }
        
    }
    
   private void relaxPath(GraphNode visitedNode, GraphNode notVisitedNode)
   {
       if(notVisitedNode.getCostFromSource() > visitedNode.getCostFromSource() + Integer.parseInt(visitedNode.getId()))
       {
           notVisitedNode.setCostFromSource(visitedNode.getCostFromSource() + Integer.parseInt(visitedNode.getId()));
           notVisitedNode.setParentNode(visitedNode);
       }
   }
    
    public void findMinimumDistance()
    {
        this.graph.initializeGraph();
        this.source.setCostFromSource(0);
        
        ArrayList<GraphNode> visitedNodes = new ArrayList<GraphNode>();
        
        // till all the nodes are visited
        while(visitedNodes.size() < this.graph.nodes.size())
        {
            GraphNode newNodeTobeVisited = extractMinValueNode();
            newNodeTobeVisited.setVisited(Visited.Visited);
            
            visitedNodes.add(newNodeTobeVisited);
            
            for(GraphNode node : newNodeTobeVisited.getNeighbours())
            {
                if(node.getVisited() == Visited.NotVisited)
                {
                    relaxPath(newNodeTobeVisited, node);
                }
            }
            
        }
        
    }
    
}
