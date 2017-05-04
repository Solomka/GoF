package ua.training.gof.builder;

public class BuilderExample {
	// не викликаємо напряму конструктор нашого класу

	public static void main(String[] args) {
		Car car = new CarBuilder()
				.buildMark("Mercedess")
				//.buildTransmission(Transmission.AUTO)
				//.buildMaxSpeed(280)
				.build();
		
		System.out.println(car.toString());

	}
}

enum Transmission {
	MANUAL, AUTO
}

class Car {
	String mark;
	Transmission transmission;
	int maxSpeed;

	public void setMark(String mark) {
		this.mark = mark;
	}

	public void setTransmission(Transmission transmition) {
		this.transmission = transmition;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Car [mark=" + mark + ", transmission=" + transmission + ", maxSpeed=" + maxSpeed + "]";
	}
	
	
}

class CarBuilder {

	String m  = "Default";
	Transmission t = Transmission.MANUAL;
	int s = 120;

	public CarBuilder buildMark(String m) {
		this.m = m;
		return this;
	}

	public CarBuilder buildTransmission(Transmission m) {
		this.t = m;
		return this;
	}

	public CarBuilder buildMaxSpeed(int m) {
		this.s = m;
		return this;
	}

	Car build() {
		Car car = new Car();
		car.setMark(m);
		car.setTransmission(t);
		car.setMaxSpeed(s);
		return car;
	}
}
