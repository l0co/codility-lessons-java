package e09;

/**
 * Task: https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/
 * Solution: https://app.codility.com/demo/results/trainingS99SAA-74R/
 * Result: 100%
 * <p>
 * We use the solution proposed in learning material https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/,
 * but it can only calculate positive slice. If we don't have positive slice calculated (and the original algorithm results is 0), we
 * need to get maximum negative slice which consists of the highest negative (or zero) value.
 * </p>
 * @author Lukasz Frankowski
 */
public class MaxSliceSum {

	public int solution(int[] a) {
		int maxEnding = 0, maxSlice = 0, highestNegative = Integer.MIN_VALUE;

		for (int i=0; i<a.length; i++) {
			maxEnding = Math.max(0, maxEnding + a[i]);
			maxSlice = Math.max(maxSlice, maxEnding);
			if (a[i]<=0)
				highestNegative = Math.max(a[i], highestNegative);
		}

		return maxSlice > 0 ? maxSlice : highestNegative;
	}

	public static void main(String [] args) {
		System.out.println(new MaxSliceSum().solution(new int[] {3, 2, -6, 4, 0}));
		System.out.println(new MaxSliceSum().solution(new int[] {-1, -2, -3}));
	}

}
