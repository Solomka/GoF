package ua.training.gof.observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/*
 * “Define a one-to-many dependency between objects so that when one object changes state,
 *  all its dependents are notified and updated automatically.”
 */
/*
 * Mediator vs Observer
 * 
 * 1. Observable has its state and it sends it to the Observers 
 * (Mediator does not have state just clients)
 * 2. Observable does not have diff type of Observer (all of them are the same)
 * <ediator can have diff types of Observers
 * 3. Observable has method that changes its state
 *  and immediately sends this changed state to the Observers
 * 4. Observers does not have another methods except handleEvent
 * just Observable can sendMessage, Observers can only accept messages
 * in Mediator all the clients can have several methods
 *  and can call sendMessage Mediator method
 */
public class ObserverExample {

	public static void main(String[] args) {

		MeteoStation station = new MeteoStation();
		station.addObserver(new ConsoleOnserver());
		station.addObserver(new FileObserver());

		station.setMeasurements(23, 760);
		station.setMeasurements(27, 700);
	}
}

interface Observed {
	void addObserver(Observer o);

	void removeObserver(Observer o);

	void notifyObserver();
}

// Observable
class MeteoStation implements Observed {

	int temperature;
	int pressure;

	List<Observer> observers = new ArrayList<>();

	public void setMeasurements(int t, int p) {
		temperature = t;
		pressure = p;
		notifyObserver();
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObserver() {
		for (Observer o : observers) {
			o.handlEvent(temperature, pressure);
		}

	}

}

interface Observer {
	void handlEvent(int temp, int presser);
}

class ConsoleOnserver implements Observer {

	@Override
	public void handlEvent(int temp, int presser) {
		System.out.println("Forecast ConsoleObserver: " + "Temperature: " + temp + ", " + " Preassure: " + presser);

	}
}

class FileObserver implements Observer {

	@Override
	public void handlEvent(int temp, int presser) {

		File f;

		try {
			f = File.createTempFile("TempPressure", "_txt");
			PrintWriter pw = new PrintWriter(f);
			pw.print("Forecast FileObserver: " + "Temperature: " + temp + ", " + " Preassure: " + presser);
			pw.println();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}