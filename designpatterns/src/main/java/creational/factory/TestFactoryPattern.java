package creational.factory;

public class TestFactoryPattern {
	
	public static void main(String[] args) {
		
		CarFactory.buildCar(CarType.SMALL);
		CarFactory.buildCar(CarType.SEDAN);
		CarFactory.buildCar(CarType.LUXURY);
	}
}
