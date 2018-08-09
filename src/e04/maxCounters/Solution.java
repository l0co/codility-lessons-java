package e04.maxCounters;

import java.util.Arrays;

// https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
// https://app.codility.com/demo/results/trainingFDXG72-KBH/
public class Solution {

	public int[] solution(int n, int[] a) {
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

	public static void main(String [] args) {
		System.out.println(Arrays.toString(new Solution().solution(5, new int[] {3, 4, 4, 6, 1, 4, 4})));
		System.out.println(Arrays.toString(new Solution().solution(5, new int[] {})));
	}

}
