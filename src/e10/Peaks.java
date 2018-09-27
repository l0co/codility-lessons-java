package e10;

/**
 * Task: https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/peaks/
 * Solution: https://app.codility.com/demo/results/trainingPVCM2S-9F2/
 * Result: 81% (worng answer, but no test array given)
 *
 * @author Lukasz Frankowski
 */
public class Peaks {

	// checks whether [x, y] subarray has a peak
	protected boolean hasPeak(int[] peaks, int startInclusive, int endInclusive) {
		return peaks[endInclusive] > peaks[startInclusive];
	}

	// checks whether all block of itemsCount length have a peak
	protected boolean hasAllPeaks(int[] peaks, int itemsCount) {
		int i=0, step = peaks.length / itemsCount;

		while (i<peaks.length) {
			if (!hasPeak(peaks, i, i+step-1))
				return false;
			i += step;
		}

		return true;
	}

	public int solution(int[] a) {
		if (a.length<=2)
			return 0;

		// find peaks

		int[] peaks = new int[a.length];
		peaks[0] = 0;

		for (int i=1; i<a.length-1; i++) {
			if (a[i-1] < a[i] && a[i] > a[i+1])
				peaks[i] = peaks[i-1]+1;
			else
				peaks[i] = peaks[i-1];
		}

		peaks[peaks.length-1] = peaks[peaks.length-2];
		int maxPeaks = peaks[peaks.length-1];

		// find divisors

		int i = 0, max = 0;

		double sqrt = Math.sqrt(a.length);
		int isqrt = (int) Math.floor(sqrt);

		while (++i <= isqrt) {
			if (a.length % i == 0) { // divisor found

				for (int j: new int[] {i, a.length/i})
					if (j<=maxPeaks // optimization - there's no more of blocks than all peaks
							&& j>max && hasAllPeaks(peaks, j))
						max = j;

			}
		}

		return max;
	}

	public static void main(String [] args) {
		System.out.println(new Peaks().solution(new int[] {1,2,3,4,3,4,1,2,3,4,3,2})); // 3
		System.out.println(new Peaks().solution(new int[] {5})); // 1
	}


}
