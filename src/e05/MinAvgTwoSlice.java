package e05;

import java.util.ArrayList;
import java.util.List;

// https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
// wrong answer 40% (this is a wrong assumption that minimal value will always be involved into minimal average - consider [2, 2, 9, 1, 9])
// https://app.codility.com/demo/results/trainingC89822-GGG/
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
				double leftAvg = a[i];
				int left = i;
				while (--left > 0) {
					double localLeftAvg = (leftAvg + a[left]) / 2;
					if (localLeftAvg<leftAvg || left==i-1) {
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
				double rightAvg = a[i];
				int right = i;
				while (++right < a.length) {
					double localRightAvg = (rightAvg + a[right]) / 2;
					if (localRightAvg<rightAvg || right==i+1) {
						rightAvg = localRightAvg;
						if (rightAvg<minAvg) {
							minAvg = rightAvg;
							minAvgIdx = i;
							break;
						}
					} else {
						break;
					}
				}
			}

		return minAvgIdx;
	}

	public static void main(String [] args) {
		System.out.println(new MinAvgTwoSlice().solution(new int[] {4, 2, 2, 5, 1, 5, 8})); // 1->2 (1)
		System.out.println(new MinAvgTwoSlice().solution(new int[] {-3, -5, -8, -4, -10})); // 2->4 (2)
		System.out.println(new MinAvgTwoSlice().solution(new int[] {-3, -5, -8, -4, -10, -9})); // 4=>5 (4)
	}

}
