package e09;

import java.util.ArrayList;
import java.util.List;

/**
 * Task: https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
 * Solution: https://app.codility.com/demo/results/trainingE6P8ZJ-B7N/
 * Result: 100%
 *
 * @author Lukasz Frankowski
 */
public class MaxDoubleSliceSum {

	/**********************************************************************************************************
	 * Naive version for comparison
	 **********************************************************************************************************/

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

	/**********************************************************************************************************
	 * Solution
	 **********************************************************************************************************/

	protected int sliceSumFromPrefixSum(int[] prefixSum, int[] a, int x, int y, int z) {
		return prefixSum[z-1] - prefixSum[x] - a[y];
	}

	public int solution(int[] a) {
		int[] prefixSum = new int[a.length];
		for (int i=0; i<a.length; i++)
			prefixSum[i] = i==0 ? a[i] : a[i] + prefixSum[i-1];

		// find candidate points for X and Z = point where local sum is less than zero, so it's better to cut of this slice than to
		// calculate it

		int sumX = 0, sumZ = 0;

		List<Integer> candidateX = new ArrayList<>(), candidateZ = new ArrayList<>();

		candidateX.add(0);
		candidateZ.add(a.length-1);

		for (int i=1; i<a.length; i++) {

			sumX += a[i];
			if (sumX<0) {
				candidateX.add(i);
				sumX = 0;
			}

			int iz = a.length-1-i;
			sumZ += a[iz];
			if (sumZ<0) {
				candidateZ.add(iz);
				sumZ = 0;
			}

		}

//		System.out.println(String.format("CandidateX: %s, CandidateZ: %s", candidateX, candidateZ));

		// now, we will look through all elements to find left and right slice sum for the element using closest cut-off points

		int xPointer = 0, zPointer = candidateZ.size()-1, maxSliceSum = 0;

		for (int y=1; y<a.length-1; y++) {

			// find next closest value
			while (xPointer<candidateX.size()-1 && candidateX.get(xPointer+1) < y)
				xPointer++;
			while (zPointer>0 && candidateZ.get(zPointer) <= y)
				zPointer--;

			int sliceSum = sliceSumFromPrefixSum(prefixSum, a, candidateX.get(xPointer), y, candidateZ.get(zPointer));
			maxSliceSum = Math.max(maxSliceSum, sliceSum);

//			System.out.println(String.format("For slice (%d, %d, %d) sum=%d", candidateX.get(xPointer), y, candidateZ.get(zPointer), sliceSum));

		}

		return maxSliceSum; 
	}

	protected void test(int[] a) {
		int naive = naive(a);
		int solution = solution(a);

		System.out.println(String.format("Naive: %d, solution: %d\n", naive, solution));
	}

	public static void main(String [] args) {
		// test slice sum algorithm
//		System.out.println(new MaxDoubleSliceSum().calculateSliceSum(new int[] {3, 2, 6, -1, 4, 5, -1, 2}, 0, 3, 6));
//		System.out.println(new MaxDoubleSliceSum().calculateSliceSum(new int[] {3, 2, 6, -1, 4, 5, -1, 2}, 0, 3, 7));
//		System.out.println(new MaxDoubleSliceSum().calculateSliceSum(new int[] {3, 2, 6, -1, 4, 5, -1, 2}, 3, 4, 5));

		new MaxDoubleSliceSum().test(new int[] {3, 2, -6, 4, 0}); // 6
		new MaxDoubleSliceSum().test(new int[] {3, 2, 6, -1, 4, 5, -1, 2}); // 17
		new MaxDoubleSliceSum().test(new int[] {3, 2, 6, -1, 4, 5, -1, 2, -4, 3, 2, 5, -7, 4}); // 27
		new MaxDoubleSliceSum().test(new int[] {3, 2, 6, -1, 4, 5, -1, 2, -4, -7, 2, 5, 3, 4}); // 23
		new MaxDoubleSliceSum().test(new int[] {3, -2, 6, -12, 4, 5, -1, 2, -4, -7, 2, 5, 3, 4}); // 16
		new MaxDoubleSliceSum().test(new int[] {3, -2, 6, -12, 4, 5, -1, 2, -4, -7, 200, 5, 3, 4}); // 214
		new MaxDoubleSliceSum().test(new int[] {3, -2, 6, -12, 4, 5, -1, 2, -4, -7, -14, 5, 3, 4, -9, 3, 2}); // 16
	}

}
