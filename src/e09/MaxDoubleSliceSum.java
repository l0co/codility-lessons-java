package e09;

/**
 * Task: https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
 * Solution:
 * Result: 100%
 *
 * @author Lukasz Frankowski
 */
public class MaxDoubleSliceSum {

	protected int calculateSliceSum(int[] a, int x, int y, int z) {
		int idx = x, sum = 0;

		while (++idx < z) {
			if (idx==y)
				continue;
			sum += a[idx];
		}

		return sum;
	}

	public int naive(int[] a) {
		int maxSum = 0, x = 0, y = 0, z = 0;

		for (int ix = 0; ix < a.length; ix++)
			for (int iy = ix+1; iy < a.length; iy++)
				for (int iz = iy+1; iz < a.length; iz++) {
					int sum = calculateSliceSum(a, ix, iy, iz);
					if (sum > maxSum) {
						maxSum = sum;
						x = ix;
						y = iy;
						z = iz;
					}
				}

		System.out.println(String.format("Max slice sum (%d, %d, %d) = %d", x, y, z, maxSum));

		return maxSum;
	}

	public int solution(int[] a) {
		return -1; // TODOLF implement MaxDoubleSliceSum.solution
	}

	protected void test(int[] a) {
		int naive = naive(a);
		int solution = solution(a);

		System.out.println(String.format("Naive: %d, solution: %d", naive, solution));
	}

	public static void main(String [] args) {
		// test slice sum algorithm
//		System.out.println(new MaxDoubleSliceSum().calculateSliceSum(new int[] {3, 2, 6, -1, 4, 5, -1, 2}, 0, 3, 6));
//		System.out.println(new MaxDoubleSliceSum().calculateSliceSum(new int[] {3, 2, 6, -1, 4, 5, -1, 2}, 0, 3, 7));
//		System.out.println(new MaxDoubleSliceSum().calculateSliceSum(new int[] {3, 2, 6, -1, 4, 5, -1, 2}, 3, 4, 5));

		new MaxDoubleSliceSum().test(new int[] {3, 2, 6, -1, 4, 5, -1, 2}); // 17
		new MaxDoubleSliceSum().test(new int[] {3, 2, 6, -1, 4, 5, -1, 2, -4, 3, 2, 5, -7, 4}); // 27
		new MaxDoubleSliceSum().test(new int[] {3, 2, 6, -1, 4, 5, -1, 2, -4, -7, 2, 5, 3, 4}); // 23
	}

}
