/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DynamicProgramming;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Sumit
 */
public class DPString {
    
    HashMap<String, String> map = new HashMap<String, String>();
    public static void driver()
    {
       DPString obj = new DPString();
       obj.populateHashTable();
       obj.IntroduceSpacesToCreateMeaningfulString("iamsumit");
    }
    
    public void populateHashTable()
    {
        map.put("i", null);
        map.put("am", null);
        map.put("sumit", null);
        map.put("sum", null);
    }
    
    public List<Integer> findStrings(String str, int startingIndex)
    {
        List<Integer> output = new ArrayList<Integer>();
        
        for(int i = startingIndex; i < str.length(); i++)
        {
            if(map.containsKey(str.substring(startingIndex, i+1)))
            {
                output.add(i+1);
            }
        }
        
        return output;
    }
    
    public void IntroduceSpacesToCreateMeaningfulString(String str)
    {
        int []T = new int[str.length()+1];
        
        // initialize T
        for(int i =0; i <T.length; i++)
        {
            T[i] = -1;
        }
        T[0] = 0;
        
        
        for(int i =0; i < str.length(); i++)
        {
            if(T[i] >= 0)
            {
                List<Integer> output = findStrings(str, i);
                
                for(Integer outP : output)
                {
                    T[outP] = i;
                }
            }
        }
        
    }
}
