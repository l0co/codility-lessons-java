package e02.cyclicRotation;

import java.util.Arrays;

// https://app.codility.com/demo/results/training35H66K-6QS/
public class Solution {

	public int[] solution(int[] a, int k) {

		if (a.length<1)
			return a;

		for (int rotation=0; rotation<k; rotation++) {
			int right = a[a.length-1];
			for (int i = a.length - 2; i >= 0; i--)
				a[i+1] = a[i];
			a[0] = right;
		}
				

		return a;
	}

	public static void main(String [] args) {
		System.out.println(Arrays.toString(new Solution().solution(new int[]{3, 8, 9, 7, 6}, 3)));;
	}

}
