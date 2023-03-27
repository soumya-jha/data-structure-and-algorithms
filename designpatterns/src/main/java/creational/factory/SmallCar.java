package creational.factory;

public class SmallCar extends Car{
	
	public SmallCar() {
		super(CarType.SMALL);
		buildCar();
	}

	@Override
	protected void buildCar() {
		System.out.println("Building Small Car");
		System.out.println("Object : " + this);
		//implementation
	}

}
