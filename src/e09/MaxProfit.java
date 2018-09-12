package e09;

/**
 * Task: https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
 * Solution: https://app.codility.com/demo/results/training93VRSJ-2QZ
 * Result: 100%
 *
 * @author Lukasz Frankowski
 */
public class MaxProfit {

	public int solution(int[] a) {
		if (a.length<=1)
			return 0;

		int min = a[0], max = a[0], maxGrowth = 0;

		for (int i=1; i<a.length; i++) {
			if (a[i] < min) {
				// new minimum
				min = a[i];
				max = a[i];
			} else {
				// check for new max
				max = Math.max(max, a[i]);
			}

			maxGrowth = Math.max(maxGrowth, max - min);
		}

		return maxGrowth;
	}

	public static void main(String [] args) {
		System.out.println(new MaxProfit().solution(new int[] {23171, 21011, 21123, 21366, 21013, 21367})); // 356 [1, 5]
		System.out.println(new MaxProfit().solution(new int[] {2, 3, 4, 5, 1, 1, 3})); // 3 [0, 3]
	}

}
