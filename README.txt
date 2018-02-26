[Date: NOV 07, 2017]
[By: Aravindhan Venkituswamy]

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile:
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code

ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=NUM_THREADS
-Darg3="XYZ1 XYZ2 XYZ3" -Darg4=DEBUG_VALUE

Example:
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=3 -Darg3="XYZ1 XYZ2 XYZ3" -Darg4=2

-----------------------------------------------------------------------
## To create tarball for submission
tar -zcvf wordTree/src.tar.gz wordTree/src

-----------------------------------------------------------------------
## To unzip tarball for execution
tar -xvf wordTree/src.tar.gz

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

In Result - ArrayList is used 

Add      : O(1)
Remove   : O(n)
Get      : O(1)
Contains : O(n)

Used Binary Search Tree - BST: The advantage of binary search trees over other data structures is that the insert & delete operations are in sorting order, so that the search algorithms such as inorder traversal and relavent future insertion & deletion operations can be very efficient (logarithm), i.e; at most of the times, the above mentioned operation tend to skip half of the tree, they are also easy to code as well.

WorstCase:
Insert: O(n)	
Delete: O(n)
Search: O(n)

AverageCase:
Insert: O(log n)	
Delete: O(log n)
Search: O(log n)

BestCase:
Insert: O(log n)	
Delete: O(log n)
Search: O(log n)

DEBUG_VALUE=2 [Print to stdout before writing to file]
DEBUG_VALUE=1 [Print to stdout everytime a thread is created]

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
