/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Trees;

import java.util.Stack;

/**
 *
 * @author Sumit
 */
public class BinaryTree {
    
    TreeNode root;
    
    public BinaryTree(int data)
    {
        root = new TreeNode(data);        
    }
        
    public void PostOrderNonRecursive()
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = this.root;
        TreeNode prevNode = null;
        
        stack.add(node);
        
        while(!stack.empty())
        {
            node = stack.peek();
            
            if(node.left == null && node.right == null)
            {
                System.out.println(" " + node.data);
                stack.pop();
            }
            else if(node.left == prevNode)
            {
                if(node.right != null)
                {
                    stack.push(node.right);                
                }
                else
                {
                    System.out.println(" " + node.data);
                    stack.pop();
                }
            }
            else if(node.right == prevNode)
            {
                System.out.println(" " + node.data);
                stack.pop();
            }
            else 
            {
                if(node.left != null)
                {
                    stack.push(node.left);
                }
                else
                {
                    stack.push(node.right);
                }
            }
            prevNode = node;
        }
        
        
    }
    
    public static void driver()
    {
        BinaryTree tree = new BinaryTree(1);
        
        tree.root.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(10);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.left.right = new TreeNode(4);
        tree.root.left.left.right.left = new TreeNode(8);
        
        tree.root.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(6);
        tree.root.right.right.left = new TreeNode(7);
        
        tree.PostOrderNonRecursive();
        
    }
    
}
