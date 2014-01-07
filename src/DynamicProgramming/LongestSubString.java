/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DynamicProgramming;

/**
 *
 * @author Sumit
 */
public class LongestSubString {
    
    public static void driver()
    {
        LongestSubString obj = new LongestSubString();
        obj.findLongestSubString("GeeksforGeeks", "GeeksQuiz");
    }
    
    public void findLongestSubString(String str1, String str2)
    {
        int [][]F = new int[str1.length()+1][str2.length()+1];
        
        // initialize
        for(int i =0; i <=str1.length(); i++)
        {
            for(int j =0; j <=str2.length(); j++)
            {
                F[i][j] = 0;
            }
        }
        
        int result = 0;
       
         for(int i =1; i <=str1.length(); i++)
         {
            for(int j =1; j <=str2.length(); j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                {
                    
                    F[i][j] = F[i-1][j-1] +1;
                    result = Math.max(F[i][j], result);
                }
                else
                {
                    F[i][j] = 0;
                }
                    
            }
         }
         
         System.out.println("Longest length of substring is => " +result);
        
        
    }
}
