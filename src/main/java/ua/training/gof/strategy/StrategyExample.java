package ua.training.gof.strategy;

import java.util.Arrays;

/*
 * 1. In State pattern diff states provide diff behavior (work/relax) - change object state
 * In Strategy behavior the same - one aim - sort array-how we sort, 
 * behavior algorithm is changing( BubbleSort/InsertionSort) - change object behavior
 * !!! 2. In State pattern state is changed in the Context or in the State
 * In Strategy it's not true - just client can change the Strategy
 */
public class StrategyExample {

	public static void main(String[] args) {

		StrategyClient strategyClient = new StrategyClient();

		int[] arr0 = { 1, 3, 2, 1 };
		strategyClient.setStrategy(new BubbleSort());
		strategyClient.executeStrategy(arr0);

		int[] arr1 = { 11, 4, 4, 3, 12, 14 };
		strategyClient.setStrategy(new SelectionSort());
		strategyClient.executeStrategy(arr1);
	}
}

// context
class StrategyClient {

	Sorting strategy;

	public void setStrategy(Sorting strategy) {
		this.strategy = strategy;
	}

	public void executeStrategy(int[] arr) {
		strategy.sort(arr);
	}
}

// Startegy
interface Sorting {
	void sort(int[] arr);
}

class BubbleSort implements Sorting {

	@Override
	public void sort(int[] arr) {
		System.out.println("Bubble sort");
		System.out.println("Array before sorting:\t" + Arrays.toString(arr));

		int temp;
		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}

		}
		System.out.println("After\t" + Arrays.toString(arr));
	}
}

class SelectionSort implements Sorting {

	@Override
	public void sort(int[] arr) {
		System.out.println("Selection sort");
		System.out.println("Array before sorting:\t" + Arrays.toString(arr));

		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;// searching for lowest index
				}
			}
			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}

		System.out.println("After\t" + Arrays.toString(arr));

	}

}
