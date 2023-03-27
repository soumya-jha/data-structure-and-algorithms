package creational.factory;

public abstract class Car {
	
	public Car(CarType carType) {
		this.carType = carType;
		commonMethodForAllCarType();
	}
	
	private CarType carType = null;
	
	public CarType getCarType() {
		return carType;
	}
	
	public void setCarType(CarType carType) {
		this.carType = carType;
	}
	
	public void commonMethodForAllCarType() {
		System.out.println("Run common implementation for all car");
	}
	
	protected abstract void buildCar();

}
