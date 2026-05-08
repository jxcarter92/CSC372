package abstract_Class_Shape;

public class Cylinder extends Shape {// Cylinder inherits from Shape

	private double radius;
	private double height;
	
	public Cylinder(double radius, double height) {// constructor, sets radius and height when object is created
		this.radius = radius;
		this.height = height;
	}

	@Override
	public double surfaceArea() {// calculates and returns surface area of the cylinder
		return 2* Math.PI * Math.pow(radius, 2) + 2*Math.PI*radius*height;
	}

	@Override
	public double volume(){// calculates and returns volume of the cylinder
		return Math.PI * Math.pow(radius, 2) * height;
	}

	@Override
	public String toString() {// returns a formatted string displaying the cylinders measurements with 3 decimal places. String.format("%.3f", radius) and volume
		return "Cylinder [radius=" + String.format("%.3f", radius) + ", surface_area()=" 
				+ String.format("%.3f", surfaceArea()) + ", volume()=" + String.format("%.3f", volume()) + "]";
		
	}
	
	

}
