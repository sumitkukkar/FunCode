/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//http://www.geeksforgeeks.org/dynamic-programming-set-36-cut-a-rope-to-maximize-product/

/*
Given a rope of length n meters, cut the rope in different parts of integer lengths in a way that maximizes product of lengths of all parts. You must make at least one cut. Assume that the length of rope is more than 2 meters.

Examples:

Input: n = 2
Output: 1 (Maximum obtainable product is 1*1)

Input: n = 3
Output: 2 (Maximum obtainable product is 1*2)

Input: n = 4
Output: 4 (Maximum obtainable product is 2*2)

Input: n = 5
Output: 6 (Maximum obtainable product is 2*3)

Input: n = 10
Output: 36 (Maximum obtainable product is 3*3*4)
*/

//defining optimal substructure property
// F[n] = max( F[i] * (n-i) )
// base case F[1] = 1;
// F[2] = 1;

package DynamicProgramming;

/**
 *
 * @author Sumit
 */
public class MaximumProductCutting {
    
    
    public static void driver()
    {
        MaximumProductCutting obj = new MaximumProductCutting();
        obj.maximumProductCuttingProblem(10);
    }
    public void maximumProductCuttingProblem(int n)
    {
        int []F = new int[n+1];
        int []P = new int[n+1];
        
        // initialize
        // this takes care of base case
        for(int i =0; i <=n; i++)
        {
            F[i] = 1;
            P[i] = 1;
        }
        
        
        for(int i = 3; i <=n; i++)
        {
            for(int j = 1; j < i; j++)
            {
                if(F[i] < F[j]*(i-j) || F[i] < j * (i-j))
                {
                    F[i] = Math.max(F[j] * (i-j), j * (i-j));
                    P[i] = j;
                }
            }
        }
    }
}
