
public class Car implements CarbonFootprint {
	// 1.4 pounds per mile = 635.029 g per mile
	// http://bit.ly/2JFDiIJ
	
	private static final double gCO2PerMile = 635.029;
	private static final int month = 12; 
	private double milesPerMonth;
	
	public Car(double milesPerMonth) {
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
		return String.format("Car has been used %.3f miles per month.", getMiles());
	}
	
	@Override
	public double getCarbonFootprint() {
		return getMiles() * gCO2PerMile * month;
	}

}
