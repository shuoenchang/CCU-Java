
public class Building implements CarbonFootprint {
	// 689.551 g per kWh
	// http://bit.ly/2rbgr09
	
	private static final double gCO2PerkWh = 689.551;
	private static final int month = 12; 
	private double kWhPerMonth;
	
	public Building(double kWhPerMonth) {
		if(kWhPerMonth < 0) 
			throw new IllegalArgumentException("kWh must be greater than 0.");
		this.kWhPerMonth = kWhPerMonth;
	}
	
	public void setkWhs(double kWhPerMonth) {
		this.kWhPerMonth = kWhPerMonth;
	}
	
	public double getkWhs() {
		return kWhPerMonth;
	}
	
	@Override
	public String toString() {
		return String.format("Building has been used %.4f kWhs per month.", getkWhs());
	}
	
	@Override
	public double getCarbonFootprint() {
		return getkWhs() * gCO2PerkWh * month;
	}

}
