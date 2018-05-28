
public class CarbonFootprintInterfaceTest {

	public static void main(String[] args) {
		CarbonFootprint[] testCase = {
				new Bicycle(40441.0053),
				new Building(40441.0053),
				new Car(40441.0053)
		};
		
		for (CarbonFootprint current : testCase) {
			System.out.printf("%s%n%s: %.2f kg%n%n", current.toString(), 
					"Carbon footprint is ", current.getCarbonFootprint()/1000);
		}
	}

}
