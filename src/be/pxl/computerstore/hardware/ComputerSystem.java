package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.TooManyPeripheralsException;
import be.pxl.computerstore.util.Computable;

public class ComputerSystem implements Computable {
	public static final int MAX_PERIPHERAL = 3;
	private ComputerCase computerCase;
	private HardDisk hardDisk;
	private Processor processor;	
	private Peripheral[] peripherals = new Peripheral[MAX_PERIPHERAL];
	
	public ComputerCase getComputerCase() {
		return computerCase;
	}
	public void setComputerCase(ComputerCase computerCase) {
		this.computerCase = computerCase;
	}
	public HardDisk getHardDisk() {
		return hardDisk;
	}
	public void setHardDisk(HardDisk hardDisk) {
		this.hardDisk = hardDisk;
	}
	public Processor getProcessor() {
		return processor;
	}
	public void setProcessor(Processor processor) {
		this.processor = processor;
	}
	
	
	public void addPeripheral(Peripheral peripheral) throws TooManyPeripheralsException {
		int nextIndex = getNextPeripheralIndex();
		if (nextIndex == -1) {
			throw new TooManyPeripheralsException("You cannot add extra peripherals.");
		}
		peripherals[nextIndex] = peripheral;
	}
	
	public void removePeripheral(String articleNumber) {
		boolean found = false;
		int count = 0;
		while(!found && count < MAX_PERIPHERAL) {
			if (peripherals[count] != null && peripherals[count].getArticleNumber().equals(articleNumber)) {
				found = true;
				peripherals[count] = null;
			}
			count++;
		}
	}
	
	private int getNextPeripheralIndex() {
		for(int i=0; i < MAX_PERIPHERAL; i++) {
			if (peripherals[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public int getNumberOfPeripherals() {
		int count = 0;
		for(int i=0; i < MAX_PERIPHERAL; i++) {
			if (peripherals[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	
	public Peripheral[] getPeripherals() {
		return peripherals;
	}
	
	
	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		if (computerCase != null) {
			description.append("Computercase:\n");
			description.append(computerCase);
		}
		if (hardDisk != null) {
			description.append("Harddisk:\n");
			description.append(hardDisk);
		}
		if (processor != null) {
			description.append("Processor:\n");
			description.append(processor);
		}
		int counter = 1;
		for(Peripheral peripheral: peripherals) {
			if (peripheral != null) {
				description.append("Randapparaat " + counter + ":\n");
				description.append(peripheral);
				counter++;
			}
		}
		description.append("TOTAAL EXCL.: ").append(totalPriceExcl()).append("\n");
		description.append("TOTAAL INCL.: ").append(totalPriceIncl()).append("\n");
		return description.toString();
	}
	@Override
	public double totalPriceExcl() {
		double sum = 0;
		if (computerCase != null) {
			sum += computerCase.getPrice();
		}
	
		if (processor != null) {
			sum += processor.getPrice();
		}
		for(Peripheral peripheral: peripherals) {
			if (peripheral != null) {
				sum += peripheral.getPrice();
			}
		}
		return Math.round(sum * 100) / 100;
	}
}
