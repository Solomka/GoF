package ua.training.gof.singleton;

/*
 * - обєкт в єдиному екземплярі
 * - глобальний доступ(статичний метод)
 * - можна керувати к-стю екземплярів обєкта, які можна створити
 * - єдина точка доступу
 * - небезпека надмірного використання
/*
 * Використання:
 * 	 - єдиний глобальний обєкт, що відповідає за зєднання з бд
 * 	 - обєкт для зчитування налаштувань
 * 
 * Используйте паттерн одиночка, когда:
 * 
 	- должен быть ровно один экземпляр некоторого класса, легко доступный всем клиентам;
 	- единственный экземпляр должен расширяться путем порождения подклас-сов, 
и клиентам нужно иметь возможность работать с расширенным экземп-ляром без модификации своего кода.
 * 	 - 
 */
public class Singleton {

	// eager initialization
	// wrong - immediate instantiation of the instance even if it is not needed
	/*
	 * This will impact your startup time performance, but it may help improve
	 * the runtime performance of your application.
	 * 
	 * this one always creates an instance, even if one is not currently necessary in the program.
	 */
	/* private static final Singleton instance = new Singleton();
	public static SingletonClass getInstance() {
        return INSTANCE;
    }
    */
	
	// lazy initialization - creation of the instance by request
	private static Singleton instance;

	private Singleton() { // preventing Singleton object instantiation from
							// outside
	}

	// lazy initialization - creation of the instance by request
	public static Singleton getInstance() {
		if (instance == null) {
			System.out.println("Singleton was first NULL: " + instance);
			instance = new Singleton();
		}
		return instance;
	}

	public String print() {
		return this.toString();
	}

}
