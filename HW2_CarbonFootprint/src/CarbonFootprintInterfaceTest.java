
public class CarbonFootprintInterfaceTest {

	public static void main(String[] args) {
		CarbonFootprint[] testCase = {
				new Bicycle(1000),
				new Building(12345.67),
				new Car(1000)
		};
		
		for (CarbonFootprint current : testCase) {
			System.out.printf("%s%n%s: %.2f kg%n%n", current.toString(), 
					"Carbon footprint is ", current.getCarbonFootprint()/1000);
		}
	}

}
