package e09.ex;

/**
 * Java example of max slice problem solution from https://codility.com/media/train/7-MaxSlice.pdf
 *
 * @author Lukasz Frankowski
 */
public class MaxSlice {

	public int solution(int[] a) {
		int maxEnding = 0, maxSlice = 0;

		for (int i=0; i<a.length; i++) {
			maxEnding = Math.max(0, maxEnding + a[i]);
			maxSlice = Math.max(maxSlice, maxEnding);
			System.out.println(String.format("Step: %d, value: %d, maxEnding: %d, maxSlice: %d", i, a[i], maxEnding, maxSlice));
		}

		return maxSlice;
	}

	public static void main(String [] args) {
		System.out.println(new MaxSlice().solution(new int[] {5, -7, 3, 5, -2, 4, -1}));
	}

}
