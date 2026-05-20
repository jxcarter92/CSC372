package SeachingAndSorting;

public class Student {
	
	private int rollno;
	private String name;
	private String address;
	
	public int getRollno() {//getters setters
		return rollno;
	
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Student(int rollno, String name, String address) {//constructors
		super();
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}
	
	public Student() {
		
	}
	
	@Override
	public String toString() {//toString
		return "Student [rollno: " + rollno + ", name: " + name + ", address: " + address + "] \n";
	} 
	
	

}
