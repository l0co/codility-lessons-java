package e06;

import java.util.Arrays;

// example of counting sort
public class CountingSort {

	public int[] solution(int max, int[] a) {
		int[] counters = new int[max+1];
		for (int i=0; i<a.length; i++)
			counters[a[i]]++;
		int pos = 0;
		for (int i=0; i<counters.length; i++) {
			for (int j=0; j<counters[i]; j++)
				a[pos++] = i;
		}
		return a;
	}

	public static void main(String [] args) {
		System.out.println(Arrays.toString(new CountingSort().solution(9,
			new int[] {1, 5, 3, 6, 8, 3, 4, 5, 2, 3, 4, 1, 2, 8, 9, 9, 4, 5, 5})));

	}

}
