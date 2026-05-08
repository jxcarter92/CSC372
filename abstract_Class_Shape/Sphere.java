package abstract_Class_Shape;

public class Sphere extends Shape {// Sphere inherits from Shape

	private double radius;
	
	
	public Sphere(double radius) {
		this.radius = radius;
	}

	@Override
	public double surfaceArea() {// calculates and returns surface area of the sphere
		return 4*Math.PI*radius*radius;
	}

	@Override
	public double volume() { // calculates and returns volume of the sphere
		return 4.0/3.0*Math.PI*radius*radius*radius;
	}

	@Override
	public String toString() {// returns a formatted string displaying the sphere's measurements with 3 decimal places. String.format("%.3f", radius)
		return "Sphere [radius=" + String.format("%.3f", radius) + ", surface_area()=" 
				+ String.format("%.3f", surfaceArea()) + ", volume()=" + String.format("%.3f", volume()) + "]";
	}



}
