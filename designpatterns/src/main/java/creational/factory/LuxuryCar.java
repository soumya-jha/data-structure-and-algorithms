package creational.factory;

public class LuxuryCar extends Car{
	
	public LuxuryCar() {
		super(CarType.LUXURY);
		buildCar();
	}

	public void buildCar() {
		System.out.println("Building Luxury Car");
		System.out.println("Object : " + this);
		//implementation
	}
}
