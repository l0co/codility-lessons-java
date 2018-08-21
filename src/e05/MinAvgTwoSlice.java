package e05;

// https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
// this solution is a bit tricy, we calculate min avg for pairs, then we calculate min avg for tripples, if tripples has lesser avg then
// pairs, we then calculate min for fours and check again agains tripples; if tripples doesn't have lesser avg, pairs are winning
// https://app.codility.com/demo/results/trainingWGU5MN-K7W/
public class MinAvgTwoSlice {

	public int solution(int[] a) {
		int step = 1;
		double minAvg = Double.MAX_VALUE;
		int minAvgIdx = 0;

		while (++step < a.length) {

			double localMinAvg = Double.MAX_VALUE;
			int localMinAvgIdx = 0;
			for (int i=0; i<=a.length-step; i++) {
				double sum = 0;
				for (int j=0; j<step; j++)
					sum += a[i+j];
				double avg = sum / step;
				if (avg<localMinAvg) {
					localMinAvg = avg;
					localMinAvgIdx = i;
				}
			}

			if (localMinAvg<minAvg) {
				minAvg = localMinAvg;
				minAvgIdx = localMinAvgIdx;
			} else
				break; // no better min avg found in the iteration, stop

		}

		return minAvgIdx;
	}

	public static void main(String [] args) {
		System.out.println(new MinAvgTwoSlice().solution(new int[] {4, 2, 2, 5, 1, 5, 8})); // 1->2 (1)
		System.out.println(new MinAvgTwoSlice().solution(new int[] {-3, -5, -8, -4, -10})); // 2->4 (2)
		System.out.println(new MinAvgTwoSlice().solution(new int[] {-3, -5, -8, -4, -10, -9})); // 4->5 (4)
		System.out.println(new MinAvgTwoSlice().solution(new int[] {-1000, 1000})); // 0->1 (0) -- boundary condition
	}

}
