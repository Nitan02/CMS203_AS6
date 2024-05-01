/*
 * Class: CMSC203 
 * Instructor:Ashique Tanveer
 * Description: (Bradley Beverage Shop)
 * Due: 04/30/2024
 * Platform/compiler:
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Touch Nitan
*/


public class Alcohol extends Beverage {
	private boolean isWeekend;
	private final double WEEKEND_UPCHARGE = 0.60;

	public Alcohol(String name, Size size, boolean isWeekend) {
		super(name, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}

	public boolean isWeekend() {
		return isWeekend;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alcohol other = (Alcohol) obj;
		return isWeekend == other.isWeekend;
	}

	public void setIsWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}

	public double getBasePrice() {
		return super.getBASE_PRICE();
	}

	@Override
	public String toString() {
	    String priceFormatted = String.format("%.2f", this.calcPrice()); // Format the price to two decimal places
	    String str = "Alcohol Name: " + this.getBevName() + "\n";
	    str += "Size: " + this.getSize() + "\n";
	    str += "Served on Weekends: " + this.isWeekend + "\n";
	    str += "Price: " + priceFormatted + "\n";
	    return str;
	}

	@Override
	public double calcPrice() {
		double price = super.getBASE_PRICE();
		if(super.getSize() == Size.MEDIUM)
			price += super.getSIZE_PRICE();
		else if(super.getSize() == Size.LARGE)
			price += (2 * super.getSIZE_PRICE());
		
		if(isWeekend)
			price += WEEKEND_UPCHARGE;
		
		return price;
	}
}