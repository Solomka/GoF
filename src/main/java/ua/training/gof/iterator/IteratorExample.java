package ua.training.gof.iterator;

public class IteratorExample {

	public static void main(String[] args) {

		Tasks aggrr = new Tasks();

		// дозволяє проходити по колекціїї, не розкрваючи її внутрішньої будови (ми не знаємо чи це масив, чи це список....)
		Iterator iterator = aggrr.getIterator();
		while (iterator.hasNext()) {
			System.out.println((String) iterator.next());
		}
	}
}

// спосіб роботи з колекцією
interface Iterator {

	boolean hasNext();

	Object next();
}

// Aggregate
interface Container {
	Iterator getIterator();
}

// ConcreteAggregate
class Tasks implements Container {
	String[] tasks = { "Build the house", "Give birth to the sun", "Plant the tree" };

	/* open interface for inner class */
	// Moreover, create TaskIterator on demand
	// specific iterator for specific collection
	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new TaskIterator();
	}

	// inner class closed for outer world
	private class TaskIterator implements Iterator {
		int index = 0;

		@Override
		public boolean hasNext() {
			if (index < tasks.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			// first get element by index
			// then increment position
			return tasks[index++];
		}
	}
}
