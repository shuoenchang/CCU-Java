
public class Bicycle implements CarbonFootprint {
	// 0.0128 pounds per mile = 5.806 g per mile
	// http://bit.ly/2JFDiIJ
	
	private static final double gCO2PerMile = 5.806;
	private static final int month = 12; 
	private double milesPerMonth;
	
	public Bicycle(double milesPerMonth) {
		if(milesPerMonth < 0) 
			throw new IllegalArgumentException("miles must be greater than 0.");
		this.milesPerMonth = milesPerMonth;
	}
	
	public void setMiles(double milesPerMonth) {
		this.milesPerMonth = milesPerMonth;
	}
	
	public double getMiles() {
		return milesPerMonth;
	}
	
	@Override
	public String toString() {
		return String.format("Bike has been used %.4f miles per month.", getMiles());
	}
	
	@Override
	public double getCarbonFootprint() {
		return getMiles() * gCO2PerMile * month;
	}
	

}
