package SeachingAndSorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

	private Scanner scan = new Scanner(System.in);
		
	public ArrayList<Student> findDuplicates(ArrayList<Student>students){
		
		ArrayList<Student> duplicates= new ArrayList();// holds any duplicates found
		
		for(int i = 0; i < students.size()-1; i++) {
			if(students.get(i).getRollno() == students.get(i+1).getRollno()) {
				duplicates.add(students.get(i+1));
			}
		}
		
		return duplicates;
		
	}
	
	public void deleteDuplicate(ArrayList<Student>students, Student duplicate) {
		
		students.remove(duplicate);
		System.out.print("Duplicate successfully removed!");
	}
	
	public void editDuplicate(Student duplicate) {//edit duplicate input. must change rollNo then prompt to update name/address
		System.out.println("Please enter new RollNo: ");
		int newRoll = scan.nextInt();
		duplicate.setRollno(newRoll);
		
		System.out.println("Would you like to update any other field?");
		System.out.println("1. Name");
		System.out.println("2. Address");
		System.out.println("3. Edit Name & Address");
		System.out.println("4. Update File/ Exit");
		
		
		switch(scan.nextInt()) {//switch method to update name and address
			
		case 1: 
			System.out.println("What would you like to change the name to?: ");
			scan.nextLine();
			duplicate.setName(scan.nextLine());
			System.out.println("Name updated to: " + duplicate.getName()); 
			break; 
			
		case 2: 
			System.out.println("What would you like to change the address to?: ");
			scan.nextLine();
			duplicate.setAddress(scan.nextLine());
			System.out.println("Adress updated to: " + duplicate.getAddress());
			break; 
			
	
		case 3: 
			System.out.println("What would you like to change the name to?: ");
			scan.nextLine();
			duplicate.setName(scan.nextLine());
			System.out.println("Name updated to: " + duplicate.getName());
			System.out.println("What would you like to change the address to?: ");
			duplicate.setAddress(scan.nextLine());
			System.out.println("Adress updated to: " + duplicate.getAddress());
			break; 
			
		case 4: 
			System.out.println("Updating List...");
			break; 
			
		default:
		    System.out.println("Invalid choice.");
		    break;
			
		}
		
	}
	
	public ArrayList<Student>readFromFile(String filename){
		ArrayList<Student> students = new ArrayList<>();// container for our students
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filename))){// opens file
			String line;
			
			while((line = reader.readLine()) != null){// reads until no more lines
				String[] parts = line.split(","); // breaks line into 3 parts
				
				int rollNo = Integer.parseInt(parts[0]);// converts "12345" to 12345
				String name = parts[1];// grabs name
				String address = parts[2];//grabs address
				
				students.add(new Student(rollNo, name, address)); // creates and stores Student
				
			}
			
		}catch(IOException e) { // handles file not found etc.
			e.printStackTrace();
		}
		
		return students;  // hands back the complete list
		
	}
	
	public void saveToFile(ArrayList<Student> students, String filename) {
		
		try(PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
	    	
	    	if(students.isEmpty()) {
	    		System.out.println("No students listed in file!");
	    	}else {
	    		for(Student s: students) {
	    			writer.println(s.getRollno() + "," + s.getName() + "," + s.getAddress());
	    		}
	    	}
	    
	    }catch (IOException e) {
			
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}
	
	public void handleDuplicates(ArrayList<Student>students, String filename) {
		
		
		SelectionSort sorter = new SelectionSort();
		RollNoComparator roll = new RollNoComparator();
		
		sorter.sort(students, roll);
		
		ArrayList<Student> duplicates = findDuplicates(students); 
		
		if(duplicates.isEmpty()) {
			System.out.println("There are no duplicate roll numbers in the list");
		}
		
		for(Student duplicate: duplicates) {
			int duplicateIndex = -1;
			for(int i = 0; i < students.size(); i++) {
				if(students.get(i) == duplicate) {
					duplicateIndex = i;
					break;
				}
			}
			for(Student s: students) {
				if(s.getRollno() == duplicate.getRollno() && s != duplicate) {
					System.out.println("\nDuplicates Found at Index: ");
					System.out.println("original: " + s + " at index: " + students.indexOf(s));
					break; 
				}
			}
			
			System.out.println("Duplicates: " + duplicate + " at index: " + duplicateIndex);
			
			System.out.println("\nWhat would you like to do for the duplicates: ");
			System.out.println("Press 1 to Delete duplicates: ");
			System.out.println("Press 2 to Edit Duplicates: ");
			
			int choice = scan.nextInt();
			
			if(choice == 1) {
			    deleteDuplicate(students, duplicate);
			    saveToFile(students, filename); // ✅ save after delete
			    
			} else if(choice == 2) {
			    editDuplicate(duplicate);
			    saveToFile(students, filename); // ✅ save after edit
			}
				}
				}
			
			
			
		}
		
	

