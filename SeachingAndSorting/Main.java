package SeachingAndSorting;

import java.util.ArrayList;

public class Main {
	

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();//list for students to add name, rollNo, and address
		//adding students to the arraylist
		students.add(new Student(12345, "Jose", "3445 Main St"));
		students.add(new Student(16548, "David", "123 Maple"));
		students.add(new Student(15445, "Jessica", "13 Elm St"));
		students.add(new Student(12222, "Angelo", "3 ParK Ave"));
		students.add(new Student(11489, "Terell", "4332 Blossom St"));
		students.add(new Student(36526, "Moninca", "5040 Binkin RD"));
		students.add(new Student(10515, "Xavier", "420 Pinon Ln"));
		students.add(new Student(32562, "Bobby", "232 Patty Dr"));
		students.add(new Student(23301, "Jacob", "3444 Main St"));
		students.add(new Student(14747, "Andrew", "2 Alta Vista Ln"));
		//StudentManager manager = new StudentManager(); 
		
		
		//ArrayList<Student>students = manager.readFromFile("src/SeachingAndSorting/students.txt");
		//manager.handleDuplicates(students, "src/SeachingAndSorting/students.txt");
		//manager.saveToFile(students, "src/SeachingAndSorting/students.txt");
		
		//instances to sort names and rollNo 
		NameComparator name = new NameComparator();
		RollNoComparator roll = new RollNoComparator();
		SelectionSort sorter = new SelectionSort(); 
		sorter.sort(students, roll);
		
		
		sorter.sort(students, name);
		System.out.println("---Sort by Names--- \n");
		for(Student s: students){
			System.out.println(s);
		}
		System.out.println("---Sort by ROLLNO--- \n");
		sorter.sort(students, roll);
		for(Student s: students) {
			System.out.println(s);
		}
	}

}
