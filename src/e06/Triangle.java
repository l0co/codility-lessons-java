package e06;

import java.util.Arrays;

/**
 * Task: https://app.codility.com/programmers/lessons/6-sorting/triangle/
 * Solution: https://app.codility.com/demo/results/trainingC7CKNP-N4C/
 * Result: 93% - wrong answer, but no data given to reproduce (probably boundary 2,147,483,647++)
 *
 * @author Lukasz Frankowski
 */
public class Triangle {

	public int solution(int[] arr) {
		Arrays.sort(arr);

		int a,b,c;

		for (int i=0; i<arr.length-2; i++) {
			a = arr[i];
			b = arr[i+1];
			int cLesserThan = a + b;
			int cGreaterThan = Math.max(a-b, b-a);

//			System.out.println(String.format("Checking: [%d, %d] -> 1)  -->  c < %d  &&  c > %d", a, b, cLesserThan, cGreaterThan));
			int j = i+1;
			while (++j<arr.length && arr[j]<cLesserThan && arr[j]>cGreaterThan)
				return 1;
		}

		return 0;
	}

	public static void main(String [] args) {
		System.out.println(new Triangle().solution(new int[] {10, 2, 5, 1, 8, 20}));
	}

}
