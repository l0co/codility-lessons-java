package e04;

import java.util.Arrays;

/**
 * Task: https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 * Solution: https://app.codility.com/demo/results/trainingD5TAZW-NMY/
 * Result: 100%
 *
 * @author Lukasz Frankowski
 */
//
@SuppressWarnings("Duplicates")
public class MaxCounters {

	public int[] solution(int n, int[] a) {
		int[] counters = new int[n];
		int max = 0, total = 0;

		for (int op: a) {
			if (op>=1 && op<=n) {
				counters[op-1] = Math.max(total, counters[op-1]) + 1;
				max = Math.max(counters[op-1], max);
			} else if (op==n+1) {
				total = max;
			} else
				throw new IllegalArgumentException(String.format("Value: %d out of range: %d", op, n+1));

		}

		// cleanup
		for (int i=0; i<counters.length; i++)
			counters[i] = Math.max(counters[i], total);

		return counters;
	}


	public static void main(String [] args) {
//		int[] test = new int[] {3, 4, 4, 6, 1, 4, 4};
		int[] test = new int[] {1, 6, 3, 3, 6, 4, 4, 2, 6, 4, 4, 6, 1, 4, 4};

		System.out.println(Arrays.toString(new MaxCounters().solution(5, test)));
	}

}
