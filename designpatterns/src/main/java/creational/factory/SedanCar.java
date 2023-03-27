package creational.factory;

public class SedanCar extends Car{
	
	public SedanCar() {
		super(CarType.SEDAN);
		buildCar();
	}

	public void buildCar() {
		System.out.println("Building Sedan Car");
		System.out.println("Object : " + this);
		//implementation
	}

}
