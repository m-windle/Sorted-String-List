# Sorted-String-List
Using a given node class, nodes are stored inside an array of a fixed, user-determined length.

Users have the options to add, remove and display their list of strings. 
Nodes are linked within the array to allow for easy removal and addition of new strings. 
When a new string is added, the list is sorted so that when it is displayed, the strings are in alphabetical order. 
When strings are removed, the max length of strings is maintained and the stored data in the node is removed and set to null. 
The empty nodes are tracked with a counter to determine how many free nodes are available for the user to write to. 
