package abstract_Class_Shape;


public class ShapeArray {

	public static void main(String[] args) {//main method running the classes in an array. 
		Shape[] shapeArray = new Shape[3];// creates an array that holds 3 Shape objects

		shapeArray[0] = new Sphere(3);// creates a Sphere with radius 3 and stores it
		shapeArray[1] = new Cylinder(3,4);// creates a Cylinder with radius 3, height 4 and stores it
		shapeArray[2] = new Cone(5,6);// creates a Cone with radius 5, height 6 and stores it
		
		for(int i = 0; i < shapeArray.length; i++) {// loops through each shape in the array
			System.out.println(shapeArray[i].toString());// prints each shape's formatted measurements
		}
	}

}
