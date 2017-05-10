package ua.training.gof.state;

/*
 * “Allow an object to alter its behavior when its internal state changes.
 *  The object will appear to change its class.”
 */
public class StateExample {

	public static void main(String[] args) {
		
		Station dfm = new RadioDFM();
		Radio radio = new Radio();
		
		radio.setStation(dfm);
		
		for(int i = 0; i < 10; i++){
			radio.play();
			radio.nextStation();
			
		}
	}
}

// State
interface Station {
	void play();
}

class Radio7 implements Station {

	@Override
	public void play() {
		System.out.println("Station Radio7 is playing...");
	}
}

class RadioDFM implements Station {

	@Override
	public void play() {
		System.out.println("Station RadioDFM is playing...");
	}
}

class VestiFM implements Station {

	@Override
	public void play() {
		System.out.println("Station VestiFM is playing...");
	}
}

// Context
class Radio {
	// state
	Station station;

	void setStation(Station station) {
		this.station = station;
	}
	//change states in the Context
	void nextStation() {
		if (station instanceof Radio7) {
			setStation(new RadioDFM());
		} else if (station instanceof RadioDFM) {
			setStation(new VestiFM());
		} else if (station instanceof VestiFM) {
			setStation(new Radio7());
		}
	}

	//behavior => change realization according to the state
	void play() {
		station.play();
	}

}