package e04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
@SuppressWarnings("Duplicates")
public class MaxCounters {

	/**********************************************************************************************************
	 * Too much time complexity
	 * https://app.codility.com/demo/results/trainingFDXG72-KBH/
	 **********************************************************************************************************/

	public int[] solution1(int n, int[] a) {
		int[] counters = new int[n];
		int max = 0;

		for (int op: a) {
			if (op>=1 && op<=n) {
				counters[op-1]++;
				max = Math.max(counters[op-1], max);
			} else if (op==n+1) {
				Arrays.fill(counters, max);
			} else
				throw new IllegalArgumentException(String.format("Value: %d out of range: %d", op, n+1));

		}

		return counters;
	}

	/**********************************************************************************************************
	 * Approach 2 = dominator, too much time completixy, but in different tasks
	 * https://app.codility.com/demo/results/trainingVGZ7FS-JMZ/
	 **********************************************************************************************************/

	// returns occurrences of dominating value for array slice
	public int dominator2(int[] a, int left, int right) {
		int max = 0;
		Map<Integer, Integer> counts = new HashMap<>();
		for (int i=left; i<=right; i++) {
			counts.compute(a[i], (key, value) -> value == null ? 1 : value + 1);
			max = Math.max(counts.get(a[i]), max);
		}
		return max;
	}

	public int[] solution2(int n, int[] a) {
		int[] counters = new int[n];
		int lastMaxIndex = -1;

		// find last max operation index and tail counter values
		for (int i=a.length-1; i>=0; i--) {
			int op = a[i];

			if (op>=1 && op<=n) {
				counters[op-1]++;
			} else if (op==n+1) {
				lastMaxIndex = i;
				break;
			} else
				throw new IllegalArgumentException(String.format("Value: %d out of range: %d", op, n+1));

		}

		// scan for max operations and calculate dominator value between them
		int lastMax = 0, max = 0;
		for (int i=0; i<=lastMaxIndex; i++) {
			int op = a[i];

			if (op==n+1) { // found max operation
				if (i-1>=lastMax)
					max = max + dominator2(a, lastMax, i - 1);
				lastMax = i+1;
				if (lastMax>=lastMaxIndex)
					break;
			}
		}

		// add max to tail counters
		for (int i=0; i<counters.length; i++)
			counters[i] += max;

		return counters;
	}

	/**********************************************************************************************************
	 * Replace solution1 array.fill with new array, too much complexity, but better than 1 & 2
	 * https://app.codility.com/demo/results/training5G9GC5-9W9/
	 **********************************************************************************************************/

	public int[] solution3(int n, int[] a) {
		int[] counters = new int[n];
		int max = 0, total = 0;

		for (int op: a) {
			if (op>=1 && op<=n) {
				counters[op-1]++;
				max = Math.max(counters[op-1], max);
			} else if (op==n+1) {
				total = total+max;
				max = 0;
				counters = new int[n];
			} else
				throw new IllegalArgumentException(String.format("Value: %d out of range: %d", op, n+1));

		}

		// add max to tail counters
		for (int i=0; i<counters.length; i++)
			counters[i] += total;

		return counters;
	}

	/**********************************************************************************************************
	 * Uses no array re-creation (a perfect solution)
	 * https://app.codility.com/demo/results/trainingD5TAZW-NMY/
	 **********************************************************************************************************/

	public int[] solution4(int n, int[] a) {
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

		System.out.println(Arrays.toString(new MaxCounters().solution1(5, test)));
		System.out.println(Arrays.toString(new MaxCounters().solution2(5, test)));
		System.out.println(Arrays.toString(new MaxCounters().solution3(5, test)));
		System.out.println(Arrays.toString(new MaxCounters().solution4(5, test)));
	}

}
