package ua.training.gof.facade;

/*
 * simple interface for complex system
 */
public class FacadeExample {

	public static void main(String[] args) {
		
		/* complex interface */		
		/*
		Power power = new Power();
		power.on();
		
		DVDRom dvd = new DVDRom();
		dvd.load();
		dvd.unload();
		
		HDD hdd = new HDD();
		hdd.copyFromDVD(dvd);
		*/
		
		/* unified Facade interface */
		Computer computer = new Computer();
		computer.copy();
	}
}

//facade -> unified interface for the complex system
class Computer{
	
	Power power = new Power();
	DVDRom dvd = new DVDRom();
	HDD hdd = new HDD();	
	
	void copy(){
		power.on();
		dvd.load();
		hdd.copyFromDVD(dvd);	
	}
}

class Power{
	
	void on(){
		System.out.println("Switch on the computer");
	}
	
	void off(){
		System.out.println("Switch off the computer");
	}	
}

class DVDRom{
	
	private boolean data = false;
	
	public boolean hasData(){
		return data;
	}
	
	void load(){
		data = true;
		System.out.println("Data is loaded");
	}
	
	void unload(){
		data = false;
		System.out.println("Data is unloaded");
	}
}

class HDD{
	void copyFromDVD(DVDRom dvd){
		if(dvd.hasData()){
			System.out.println("Copy data from disk");
		}else{
			System.out.println("Set disk with data");
		}
	}
}

