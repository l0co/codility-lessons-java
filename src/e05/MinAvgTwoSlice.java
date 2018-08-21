package e05;

import java.util.ArrayList;
import java.util.List;

// https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
public class MinAvgTwoSlice {

	public int solution(int[] a) {
		List<Integer> minValIdx = new ArrayList<>();
		int minVal = Integer.MAX_VALUE;

		// find indices of minimal value in the array
		for (int i=0; i<a.length; i++) {
			if (minVal>a[i]) {
				minVal = a[i];
				minValIdx.clear();;
			}
			if (minVal==a[i])
				minValIdx.add(i);
		}


		double minAvg = Double.MAX_VALUE;
		int minAvgIdx = 0;

		// for each minimal value find the minimal average going left and right
		for (int i: minValIdx)
			if (i>0) {
				double leftAvg = (double) (a[i] + a[i-1]) / 2;
				int left = i-1;
				while (--left > 0) {
					double localLeftAvg = (double) (leftAvg + a[left]) / 2;
					if (localLeftAvg<leftAvg) {
						leftAvg = localLeftAvg;
						if (leftAvg<minAvg) {
							minAvg = leftAvg;
							minAvgIdx = left;
						}
					} else {
						break;
					}
				}
			}

		for (int i: minValIdx)
			if (i<a.length-1) {
				double rightAvg = (double) (a[i] + a[i+1]) / 2;
				int right = i+1;
				while (++right < a.length-1) {
					double localRightAvg = (double) (rightAvg + a[right]) / 2;
					if (localRightAvg<rightAvg) {
						rightAvg = localRightAvg;
						if (rightAvg<minAvg) {
							minAvg = rightAvg;
							minAvgIdx = right;
						}
					} else {
						break;
					}
				}
			}

		return minAvgIdx;
	}

	public static void main(String [] args) {
//		System.out.println(new MinAvgTwoSlice().solution(new int[] {4, 2, 2, 5, 1, 5, 8}));
//		System.out.println(new MinAvgTwoSlice().solution(new int[] {-3, -5, -8, -4, -10}));
		System.out.println(new MinAvgTwoSlice().solution(new int[] {-3, -5, -8, -4, -10, -9}));
	}

}
