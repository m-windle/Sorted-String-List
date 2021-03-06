package array;

//----------------------------------------------------------------------------
//ArrayRefSortedList.java       by Dale/Joyce/Weems                 Chapter 7
//
//Implements an array-based sorted linked list of String
//----------------------------------------------------------------------------
import lists.*;

/******************************
 * 	 Implemented Methods by   *
 * 		@author M Windle	  *
 *			100913032         *
 ******************************/

public class ArrayRefSortedStringList implements ListInterface<String>
{
	protected static final int NUL = -1;   // End of list symbol

    protected class AListNode
    {
        private String info;        // The info in a list node
        private int next;           // A link to the next node on the list
    }

    protected AListNode[] nodes;  // Array of AListNode holds the linked list

	protected int list;           // Reference to the first node on the list
	protected int free;           // Reference to the first node on the free list
	
	protected int numElements;    // Number of elements in the list
	protected int currentPos;     // Current position for iteration
	
	// set by find method
	protected boolean found;      // true if element found, else false
	protected int location;       // node containing element, if found
	protected int previous;       // node preceding location

	public ArrayRefSortedStringList(int maxElements)
	// Instantiates and returns a reference to an empty list object with
	// room for maxElements elements
	{
		nodes = new AListNode[maxElements];
		for (int index = 0; index < maxElements; index++)
			nodes[index] = new AListNode();

		// Link together the free nodes.
		for (int index = 1; index < maxElements; index++)
			nodes[index - 1].next = index;
		nodes[maxElements - 1].next = NUL;

		list = NUL;
		free = 0;
		numElements = 0;
		currentPos = NUL;
	}

	protected int getNode()
	// Returns the index of the next available node from the free list
	// and updates the free list index
	{
		int hold;
		hold = free;
		free = nodes[free].next;
		return hold;
	}

	protected void freeNode(int index)
	// Frees the node at array position index by linking it into the
	// free list
	{
		nodes[index].next = free;
		free = index;
	}

	public boolean isFull()
	// Determines whether this list is full
	{
		return (free == NUL);
	}

	@Override
	public boolean remove(String element)
	// Removes an element e from this list such that e.equals(element)
	// and returns true; if no such element exists, returns false
	{
		int hold; // To remember removed node index
		find(element);
		if (found) {
			hold = location;
			if (list == location)
				list = nodes[list].next; // remove first node
			else
				nodes[previous].next = nodes[location].next;
			freeNode(hold);
			numElements--;
		}
		return found;
	}

/*********implemented methods*********/
	
	@Override
	public int size() {
		return numElements;
	}

	@Override
	public void add(String element) {
		if(isFull()) return;

		int current = NUL;
		
		if(list != NUL && nodes[list].info.compareToIgnoreCase(element) < 0){
			current = list;
			while(nodes[current].next != NUL && nodes[nodes[current].next].info.compareToIgnoreCase(element) < 0) 
				current = nodes[current].next;
		}
		
		int index = getNode();
		
		if(current == NUL){
			nodes[index].info = element;
			nodes[index].next = list;
			list = index;
		}else{
			nodes[index].info = element;
			nodes[index].next = nodes[current].next;
			nodes[current].next = index;
		}
		
		numElements++;
	}
	
	private void find(String element) {		
		found = false;
		if(numElements == 0) return; 
		reset();
		int hold = currentPos; 
		String testString = getNext();
		int testCount = 0;

		while(testCount != numElements){ 			
			if(testString.compareToIgnoreCase(element) == 0){
				found = true;
				location = hold; 
				return;
			}

			previous = hold;
			hold = nodes[previous].next;
			testString = getNext();
			testCount++;
		}		
	}

	@Override
	public boolean contains(String element) {
		find(element);
		return found;
	}

	@Override
	public String get(String element) {
		find(element);
		return found ? nodes[location].info : null;
	}

	@Override
	public void reset() {
		currentPos = list;
	}

	@Override
	public String getNext() {
		String output = nodes[currentPos].info;
		currentPos = (nodes[currentPos].next == NUL) ? list : nodes[currentPos].next;
		return output;
	}
	
	public String toString(){
		String output = "\n\tThe Students List: \n";
		int currentIndex = list;
		
		if(list == NUL)
			output += "\t\t~list is empty~\n";
		
		while(currentIndex != NUL){
			if(nodes[currentIndex].info != null){
				output += "\t\t" + nodes[currentIndex].info + "\n";
				currentIndex = nodes[currentIndex].next;
			}
		}
		
		return output;
	}
}