package be.pxl.computerstore.hardware;

import java.util.Random;

public abstract class ComputerComponent {
	 private static final Random random = new Random();
	 private String vendor;
	 private String name;
	 private double price;
	 private String articleNumber;
	 private static int counter = 0;
	 
	 {
		 counter++;
	 }
	 
	 public ComputerComponent(String vendor, String name, double price) {
		 super();
		 this.vendor = vendor;
		 this.name = name;
		 this.price = price;
		 generateArticleNumber(); //genereren artikelnummer bij aanmaken nieuw obj
	 }

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
		updateArticleNumber();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}
	
	private void updateArticleNumber() {
		setArticleNumber(generateVendorCode() + articleNumber.substring(2));
	}
	
	private void generateArticleNumber() {
		StringBuilder articleNumberBuilder = new StringBuilder();
		articleNumberBuilder.append(generateVendorCode());
		articleNumberBuilder.append("-");
		articleNumberBuilder.append(String.format("%5s", String.valueOf(counter)).replace(' ', '0'));
		articleNumberBuilder.append("-");
		String generatedNumber = String.valueOf(random.nextInt(889) + 111);
		while (generatedNumber.contains("0")) {
			generatedNumber = String.valueOf(random.nextInt(889) + 111); 
		}
		articleNumberBuilder.append(generatedNumber);
		setArticleNumber(articleNumberBuilder.toString());
	}
	
	private String generateVendorCode() {
		if (vendor != null && vendor.length() >= 3) {
			return vendor.substring(0, 3).toUpperCase();
		} else {
			return String.format("%-3s", vendor).replace(' ', 'X').toUpperCase(); //string van 3, links uitlijnen
		}
	}
	
	public String getShortDescription() {
		return articleNumber + " * " + name + " * " + price + "€";
	}
	
	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		description.append("ArticleNumber = ").append(articleNumber).append("\n");
		description.append("Vendor = ").append(vendor).append("\n");
		description.append("Name = ").append(name).append("\n");
		description.append("Price = ").append(price).append("\n");
		return description.toString();
	}
}
