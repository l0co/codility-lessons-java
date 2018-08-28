package e06;

import java.util.Arrays;

/**
 * Task: https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
 * Solution: https://app.codility.com/demo/results/training48QPU6-DYH/
 * Result: 100%
 *
 * @author Lukasz Frankowski
 */
public class MaxProductOfThree {

	public int solution(int[] a) {
		Arrays.sort(a);

		int p1 = a[a.length-1] * a[a.length-2] * a[a.length-3];
		int p2 = a[a.length-1] * a[0] * a[1]; // two the least negative check

		return p1>p2 ? p1 : p2;
	}

	public static void main(String [] args) {
		System.out.println(new MaxProductOfThree().solution(new int[] {-3, 1, 2, -2, 5, 6})); // 60
		System.out.println(new MaxProductOfThree().solution(new int[] {-5, 5, -5, 4})); // 125
		System.out.println(new MaxProductOfThree().solution(new int[] {-3, -5, 5, -5, 4})); // 125
		System.out.println(new MaxProductOfThree().solution(new int[] {-10, -2, -4})); // 125
	}

}
