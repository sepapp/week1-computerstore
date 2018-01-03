package be.pxl.computerstore.hardware;

public class HardDisk extends ComputerComponent {
	private int capacity;

	public HardDisk(String vendor, String name, double price, int capacity) {
		super(vendor, name, price);
		setCapacity(capacity);
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		StringBuilder description = new StringBuilder(super.toString());
		description.append("Capacity = ").append(capacity).append("\n");
		return description.toString();
	}

}
