package ua.training.gof.singleton;

public class SingletonTest {
	
	public static void main (String [] args){
		
		System.out.println("Bla: " + Singleton.getInstance().print() );
		Singleton.getInstance().print();
		Singleton.getInstance().print();
		Singleton.getInstance().print();
		
		System.out.println("HashCode: " + Singleton.getInstance().hashCode());
		System.out.println("HashCode: " + Singleton.getInstance().hashCode());
		System.out.println("HashCode: " + Singleton.getInstance().hashCode());
		
	}

}
