package ua.training.gof.builder2;

/*
 * Используйте паттерн строитель, когда:
	-  алгоритм создания сложного объекта не должен зависеть от того, из каких частей состоит объект и как они стыкуются между собой;
	- процесс конструирования должен обеспечивать различные представления конструируемого объекта.
 */
/*
 * - не викликаємо напряму конструктор нашого класу
 * - уникаємо telescopic constructor anti-pattern
 * - ensure consistent object creation
 * - ensure correct order of item's initialization parts 
 */

/*
 * The builder pattern allows you to enforce a step-by-step process to construct a complex object as a finished product. 
 * In this pattern, the step-by-step construction process remains same but the finished products can have different representations.
 * 
 * a client is now insulated from the object creation process
 *  It is the responsibility of the Director to instruct the ConcreteBuilder on the construction process and the ConcreteBuilder in turn will create the finished product.
 *   Finally, the client receives the finished product from the Director.
 */

/*
 *  While abstract factory emphasizes on creating a family of related objects in one go, 
 *  builder is about creating an object through a step-by-step construction process and returning the object as the final step.
 *  In short abstract factory is concerned with what is made, while the builder with how it is made. 
 *  So as you go further into enterprise application development,
 *   whenever you need to create complex objects independently of the construction algorithm 
 *   turn to the classic GoF Builder Pattern!
 */
public class BuilderExample {
	

	public static void main(String[] args) {
		Director director = new Director();
		//director.setBuilder(new SubaruBuilder());
		director.setBuilder(new FordMondeoBuilder());
		
		Car car = director.buildCar();
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

abstract class CarBuilder {
	Car car;

	//create car
	void buildCar() {
		car = new Car();
	}

	/* set car's parts*/
	abstract void buildMark();

	abstract void buildTransmission();

	abstract void buildMaxSpeed();

	Car getCar() {
		return car;
	}
}

class FordMondeoBuilder extends CarBuilder {

	@Override
	void buildMark() {
		car.setMark("Ford Mondeo");
	}

	@Override
	void buildTransmission() {
		car.setTransmission(Transmission.AUTO);
	}

	@Override
	void buildMaxSpeed() {
		car.setMaxSpeed(260);
	}

}

class SubaruBuilder extends CarBuilder {

	@Override
	void buildMark() {
		car.setMark("Subaru");
	}

	@Override
	void buildTransmission() {
		car.setTransmission(Transmission.AUTO);
	}

	@Override
	void buildMaxSpeed() {
		car.setMaxSpeed(360);
	}

}

class Director{
	CarBuilder builder;
	void setBuilder(CarBuilder b){builder = b;}
	
	Car buildCar(){
		
		builder.buildCar();
		
		builder.buildMark();
		builder.buildTransmission();
		builder.buildMaxSpeed();
		
		Car car = builder.getCar();
		
		return car;
	}
}
