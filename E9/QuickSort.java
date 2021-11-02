import java.util.*;

class QuickSort {
	static int arr[];

	static void input() {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter Number of Elements : ");
		int num = in.nextInt();
		arr = new int[num];
		for (int i = 0; i < num; i++) {
			System.out.println("Element " + i + " : ");
			arr[i] = in.nextInt();
		}
		in.close();
	}

	static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int partition(int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(i, j);
			}
		}
		swap(i + 1, high);
		return (i + 1);
	}

	static void quickSort(int low, int high) {
		if (low < high) {
			int pi = partition(low, high);
			quickSort(low, pi - 1);
			quickSort(pi + 1, high);
		}
	}

	static void printArray() {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	public static void main(String[] args) {
		input();
		System.out.println("Orignal Array : ");
		printArray();
		quickSort(0, arr.length - 1);
		System.out.println("Sorted array using Quick Sort: ");
		printArray();
	}
}