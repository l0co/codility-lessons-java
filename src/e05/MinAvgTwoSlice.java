package e05;

// https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
// 50% because of error with negative numbers
// https://app.codility.com/demo/results/training26ZWFC-QYD/
public class MinAvgTwoSlice {

	public int solution(int[] a) {
		double avg=0, minAvg=Double.MAX_VALUE;
		int minAvgIndex = 0;

		for (int i=0; i<a.length-1; i++) {
			avg = (double) (a[i] + a[i+1]) / 2;
			if (avg<minAvg) {
				minAvgIndex = i;
				minAvg = avg;
			}
		}

		return minAvgIndex;
	}

	public static void main(String [] args) {
		System.out.println(new MinAvgTwoSlice().solution(new int[] {4, 2, 2, 5, 1, 5, 8}));
	}

}
