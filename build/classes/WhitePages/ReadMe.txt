Programme:

Recursion

output[j] = output[i] + 1 
where j > i,
output[i] is minimum for 0..j-1
and input[i] + i >= j

Code assigns output[j] only once when it is discovered. 

Running Time => O(n)

Files:

ArrayHopperSolution.java => Solution to the program. Program takes only valid integer input file else it will not process the input. 

TestCase.java => Tested sample cases.

Generic.java => Contains functionality to read the file.

Input.txt => Sample input file.


