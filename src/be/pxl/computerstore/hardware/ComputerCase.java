package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.Dimension;

public class ComputerCase extends ComputerComponent{
	private Dimension dimension;
	private double weight;
	
	public ComputerCase(String vendor, String name, double price) {
		super(vendor, name, price);
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		StringBuilder description = new StringBuilder(super.toString());
		description.append(dimension);
		description.append("Weight = ").append(weight).append("kg").append("\n");
		return description.toString();
	}
}
