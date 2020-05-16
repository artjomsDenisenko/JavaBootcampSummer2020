package jtm.extra02;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMethods {
	List<Integer> myList = new ArrayList<Integer>();

	public List<Integer> checkArray(int comparator, int... numbers) {
		//  #1:Implement method that compares values of passed array with
		// passed comparator.
		// Return list with values that are smaller than comparator.
		for(int i:numbers){
			if (i < comparator){
				myList.add(i);
			}
		}
		// Hint: Investigate how varargs are used.
		return myList;
	}

	public int sumResult() {
		int sum = 0;
		//  #2: Count element sum of the list
		for(int i:myList){
			sum +=i;
		}
		return sum;
	}
}
