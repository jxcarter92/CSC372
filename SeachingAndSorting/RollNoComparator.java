package SeachingAndSorting;

import java.util.Comparator;

public class RollNoComparator implements Comparator<Student> {//compare using rollNo

	@Override
	public int compare(Student o1, Student o2) {
		
		return Integer.compare(o1.getRollno(), o2.getRollno());
		
	}

}
