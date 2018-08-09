package e03.tapeEquilibrium;

// https://app.codility.com/demo/results/trainingGJG7EA-6NU/
public class Solution {

	public int solution(int[] a) {
		int total = 0, left = 0, diff = Integer.MAX_VALUE;
		for (int i=0; i<a.length; i++)
			total += a[i];
		for (int i=0; i<a.length-1; i++) {
			left += a[i];
			int right = total - left;
			diff = Math.min(Math.abs(left - right), diff);
		}
		return diff;
	}

	public static void main(String [] args) {
		System.out.println(new Solution().solution(new int[] {3, 1, 2, 4, 3}));
		System.out.println(new Solution().solution(new int[] {3, 1}));
	}

}
