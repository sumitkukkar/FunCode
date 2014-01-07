/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DynamicProgramming;

// http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/

/*
Given three strings A, B and C. Write a function that checks whether C is an interleaving of A and B. C is said to be interleaving A and B, if it contains all characters of A and B and order of all characters in individual strings is preserved.

We have discussed a simple solution of this problem here. The simple solution doesn’t work if strings A and B have some common characters. For example A = “XXY”, string B = “XXZ” and string C = “XXZXXXY”. To handle all cases, two possibilities need to be considered.

*/
/**
 *
 * @author Sumit
 */
public class InterLeavingOfTwoStrings {

    public static void driver()
    {
        InterLeavingOfTwoStrings obj = new InterLeavingOfTwoStrings();
        obj.interleavingOfTwoStrings("xyz", "abcc", "xaybczc");
    }
    public void interleavingOfTwoStrings(String str1,String str2, String target)
    {
        boolean [][] IL = new boolean[str1.length() + 1 ][str2.length() + 1];
        
        // base case
        IL[0][0] = true;
        
        // if one string is empty 
        // str1 is empty
        for(int i =1; i < str2.length() + 1; i++)
        {
            if(str2.charAt(i-1)== target.charAt(i-1))
            {
                IL[0][i] = IL[0][i-1];
            }
        }
        
        // similarly if str2 is empty
        
        // if one string is empty 
        // str1 is empty
        for(int i =1; i < str1.length() + 1; i++)
        {
            if(str1.charAt(i-1)== target.charAt(i-1))
            {
                IL[i][0] = IL[i-1][0];
            }
        }
        
        
        
        for(int i =1; i <= str1.length(); i++)
        {
            for(int j= 1; j <=str2.length(); j++)
            {
                if((str1.charAt(i-1) == target.charAt(i+j-1)) && (str2.charAt(j-1) == target.charAt(i+j-1)))
                {
                    IL[i][j] = IL[i-1][j] || IL[i][j-1];
                }
                else if(str1.charAt(i-1) == target.charAt(i+j-1))
                {
                    IL[i][j] = IL[i-1][j];
                }
                else if(str2.charAt(j-1) == target.charAt(i+j-1))
                {
                    IL[i][j] = IL[i][j-1];
                }
            }
        }
        
        System.out.println(" ouput =>>>>>>>>>" + IL[str1.length()][str2.length()]);
        
        
    }
}
