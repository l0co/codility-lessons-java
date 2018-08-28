package e05;

/**
 * Task: https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 * Solution: https://app.codility.com/demo/results/trainingNGBENQ-ER3/
 * Result: 100%
 *
 * @author Lukasz Frankowski
 */
public class PermCheck {

	public int solution(int[] a) {
		int[] b = new int[a.length];
		for (int i=0; i<a.length; i++) {
			int val = a[i];
			if (val > a.length) // value outside boundary
				return 0;
			if (b[val-1] != 0) // value exists again
				return 0;
			b[val-1] = 1;
		}
		return 1;
	}

	public static void main(String [] args) {
		System.out.println(new PermCheck().solution(new int[] {4, 1, 3, 2}));
		System.out.println(new PermCheck().solution(new int[] {4, 1, 3}));
		System.out.println(new PermCheck().solution(new int[] {2, 1}));
		System.out.println(new PermCheck().solution(new int[] {2}));
		System.out.println(new PermCheck().solution(new int[] {1}));
		System.out.println(new PermCheck().solution(new int[] {5, 1, 3, 2, 4, 6, 7}));
		System.out.println(new PermCheck().solution(new int[] {}));
	}

}
