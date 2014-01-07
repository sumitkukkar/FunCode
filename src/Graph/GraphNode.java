/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graph;

import java.util.ArrayList;


enum Visited { Visited, NotVisited };
/**
 *
 * @author Sumit
 */
public class GraphNode {
    private String id;
    private int data;
    private int level;
    private Visited visited;
    private int costFromSource;
    private ArrayList<GraphNode> neighbors;
    private GraphNode parentNode;
    
    public GraphNode(String id)
    {
        this.id = id;
        this.neighbors = new ArrayList<>();
        this.visited = Visited.NotVisited;
        this.costFromSource = Integer.MAX_VALUE;
        this.parentNode = null;
    }
    
    public void addNeighbors(GraphNode node)
    {
        this.neighbors.add(node);
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the visited
     */
    public Visited getVisited() {
        return visited;
    }

    /**
     * @param visited the visited to set
     */
    public void setVisited(Visited visited) {
        this.visited = visited;
    }

    /**
     * @return the costFromSource
     */
    public int getCostFromSource() {
        return costFromSource;
    }

    /**
     * @param costFromSource the costFromSource to set
     */
    public void setCostFromSource(int costFromSource) {
        this.costFromSource = costFromSource;
    }

    /**
     * @return the neighbors
     */
    public ArrayList<GraphNode> getNeighbours() {
        return neighbors;
    }

    /**
     * @param neighbors the neighbors to set
     */
    public void setNeighbours(ArrayList<GraphNode> neighbors) {
        this.neighbors = neighbors;
    }

    /**
     * @return the parentNode
     */
    public GraphNode getParentNode() {
        return parentNode;
    }

    /**
     * @param parentNode the parentNode to set
     */
    public void setParentNode(GraphNode parentNode) {
        this.parentNode = parentNode;
    }
}
