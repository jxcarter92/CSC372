package SeachingAndSorting;

import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSort {
	
	 // Takes an ArrayList of Students and a Comparator to define sort order
	public void sort(ArrayList<Student> students, Comparator<Student> comparator) {
		
		 // Outer loop: moves the "sorted boundary" forward one step each iteration
		for(int i = 0; i < students.size(); i++) {
			// Assume the current position holds the minimum value
			int min = i; 
			
			// Inner loop: search the unsorted portion for a smaller element
			for(int j = i + 1; j < students.size(); j++) {
				
				// If students[j] is smaller than current minimum, update min index
				if(comparator.compare(students.get(j), students.get(min)) < 0) {
				    min = j;
				}
			}
			 // Swap the found minimum element into position i
				Student temp = students.get(i);// temporarily hold students[i]
				students.set(i, students.get(min));// put minimum into position i
				students.set(min, temp);// put old students[i] into min's spot

			}
			
		}
		
	}


