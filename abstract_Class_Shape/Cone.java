package abstract_Class_Shape;

public class Cone extends Shape {// Cone inherits from Shape

	private double radius;
	private double height;
	
	public Cone(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	@Override
	public double surfaceArea() {// calculates and returns surface area of the cone
		return Math.PI * Math.pow(radius, 2) + Math.PI * radius * Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
	}

	@Override
	public double volume() {// calculates and returns volume of the cone
		return 1.0 / 3.0 * Math.PI * Math.pow(radius, 2) * height;
	}

	@Override
	public String toString() {// returns a formatted string displaying the cone's measurements
		return "Cone [radius=" + String.format("%.3f", radius) + ", surface_area()=" 
				+ String.format("%.3f", surfaceArea()) + ", volume()=" + String.format("%.3f", volume()) + "]";
	}

	
}
