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
public class ArrayHopper {
    
    public static void driver()
    {
        ArrayHopper arrayHopper = new ArrayHopper();
        
        int arr[] = {1,2,0,0,0,30,1,1,1,12434345,0};
        
        int []output1 = arrayHopper.minJumps(arr);
        int []output2 = arrayHopper.minjumpsOptimum(arr);
        
        for(int i =0; i < output1.length; i++)
        {
            if(output1[i] != output2[i])
            {
                System.out.println("output is not same at index =>" + i);
                break;
            }
            else
            {
                //System.out.println(i + " => " + output1[i] + " <=> " + output2[i]);
            }
        }
       arrayHopper.printOutput(output2);
    }
    
    public void printOutput(int []output)
    {
        int i = output.length - 2;
        System.out.println();
        System.out.print("output => " +  (i) + ",");
        
        while( output[i] > 1)
        {
            if(output[i] == output[i-1] + 1)
                System.out.print(i-1 + ",");
            
            i--;
        }
        System.out.print("0");
    }
    
    public int[] minjumpsOptimum(int []arr)
    {
        // min_jumps[i] minimum jumps are required to the index i
        // additional index to get out of the array
        int []min_jumps = new int[arr.length+1];
        
        // inintiazlie min_jumps array        
        for(int i = 1; i <= arr.length; i++)
            min_jumps[i] = Integer.MAX_VALUE;
        
        // base case
        min_jumps[0] = 0;
        int max_reached_so_far = 0;
        long temp_sum = 0;
        
        for(int i = 0; i < arr.length; i++)
        {
            // this is to avoid overflow in the integer sum
            temp_sum = i + arr[i];
            if(temp_sum > max_reached_so_far && min_jumps[i] != Integer.MAX_VALUE)
            {
                int j = max_reached_so_far + 1;
                while(j <= temp_sum && j <= arr.length)
                {
                    min_jumps[j] = min_jumps[i] + 1;
                    j++;
                } 
                max_reached_so_far = j - 1;
            }          
            
            // condition to early break
            if(min_jumps[i] == Integer.MAX_VALUE || min_jumps[arr.length] != Integer.MAX_VALUE)
            {
                break;
            }
            
            
        }  
        if(min_jumps[arr.length] == Integer.MAX_VALUE)
        {
            System.out.println("Unable to reach the end of the array Optimum");
        }
        else
        {
            
        }
        return min_jumps;
    }
            

    public int[] minJumps(int []arr)
    {
        // min_jumps[i] minimum jumps are required to the index i
        // additional index to get out of the array
        int []min_jumps = new int[arr.length + 1];
        
        // inintiazlie min_jumps array        
        for(int i = 1; i <= arr.length; i++)
            min_jumps[i] = Integer.MAX_VALUE;
        
        // base case
        min_jumps[0] = 0;
        
        for(int i = 1; i <= arr.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                // condition to check whether array is able to reach the 'i'th index 
                // second condition to avoid overflow by Integer addition
                if(i <= j + arr[j] && min_jumps[j] != Integer.MAX_VALUE)
                {
                    if(min_jumps[i] > min_jumps[j] + 1)
                    {
                        min_jumps[i] = min_jumps[j] + 1;
                    }
                }
                
            }
        }
        
        if(min_jumps[arr.length] != Integer.MAX_VALUE)
            System.out.println("Minimum number of hops => " + min_jumps[arr.length - 1]);
        else
            System.out.println("Unable to reach the end of the arrayNormal");
        
        return min_jumps;
    }
}
