package basics;

/*
 * This ArrayStack is a custom class created to demonstrate
 * the logic of a potential array-based data structure. 
 * 
 * Note that this is a simply version of an array based structure
 * which is backed by an actual array. Other array-based data structures
 * defined in java will be more complex than what is shown here.
 */
public class ArrayStack {
	/*
	 * This is the array in question...we create an array
	 * and arbitrarily set its size to 5
	 */
	private Integer[] stack = new Integer[5];
	
	public ArrayStack() { }
	
	public ArrayStack(int size) {
		stack = new Integer[size];
	}
	
	/*
	 * This keeps track of the size of our array. 
	 * 'lastElementIndex' is a bit of a misnommer...
	 * this number will always be 1 higher than the
	 * index of the last element in the array.
	 * 
	 * See below for more details
	 */
	private int lastElementIndex = 0;
	
	/*
	 *  A push method used to add elements to the end of 
	 *  our ArrayStack
	 */
	public void push(int element) {
		/*
		 * Before adding new elements to our collection
		 * we will check if our stack has enough space
		 * for that new information
		 */
		if (lastElementIndex >= stack.length) {
			/*
			 * In the event our stack is not big enough...
			 * we will arbitrarily double the size of our 
			 * array
			 */
			Integer[] tempStack = new Integer[stack.length * 2];
			
			for (int j = 0; j<stack.length; j++) {
				/*
				 * place the values from the current stack
				 * into this new temporary one...
				 */
				tempStack[j] = stack[j];
			}
			
			/*
			 * By changing the reference of our stack
			 * to the tempStack object, we are effectively
			 * removing the old object from memory
			 */
			stack = tempStack;
		}
		
		/*
		 * add the new element to our collection
		 */
		stack[lastElementIndex] = element;
		
		// increase the lastElementIndex
		lastElementIndex++;
	}
	
	/*
	 * The pop method 'Removes' the last element from 
	 * the array...In actuality, the variable, 'lastElementIndex'
	 * is manipulated. Since the stack of integers is private
	 * a user has no way to interact with our ArrayStack
	 * unless it is through the push, pop or peek methods.
	 * Due to this, manipulation of the 'lastElementIndex'
	 * variable is effectively the same thing as setting
	 * certain values in the stack to null. There is no
	 * way for the user to look through this collection
	 * otherwise...
	 */
	public Integer pop() {
		if (lastElementIndex > 0) {
			/*
			 * arrayStack.push(111);
			 * lastElementIndex = 1
			 * 
			 * arrayStack.push(222);
			 * lastElementIndex = 2
			 * 	 0    1     
			 * {111, 222, -, -, -}
			 * 
			 * arrayStack.pop();
			 * lastElementIndex = 1
			 * 
			 * arrayStack.push(333); <--- LEI = 1
			 * {111, 222, -, -, -}
			 *   0    1   2
			 * {111, 333, -, -, -}
			 */
			return stack[--lastElementIndex];
		} else {
			return null;
		}
	}

	// View the last element in the stack
	public Integer peek() {
		if (lastElementIndex > 0)
			return stack[lastElementIndex - 1];
		
		return null;
	}
}
