package e03.permMissingElem;

// https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
// https://app.codility.com/demo/results/trainingRZMA2V-397/
public class Solution {

	public int solution(int[] a) {
		int i = 0;
		while (i < a.length) {
			int currentValue = a[i];
			if (currentValue>0) { // 0 - item already processed
				if (currentValue <= a.length) {
					int posValue = a[currentValue-1];
					a[currentValue-1] = 0;
					if (posValue != currentValue) {
						a[i] = posValue;
						continue;
					}
				}
			}

			i++;
		}

		// scan array again and catch missing index
		for (i=0; i<a.length; i++)
			if (a[i]>0)
				return i+1;

		return a.length+1;
	}

	public static void main(String [] args) {
		System.out.println(new Solution().solution(new int[] {2, 3, 1, 5}));
		System.out.println(new Solution().solution(new int[] {1, 2, 3, 5}));
		System.out.println(new Solution().solution(new int[] {5, 3, 2, 1}));
		System.out.println(new Solution().solution(new int[] {4, 3, 2, 1}));
		System.out.println(new Solution().solution(new int[] {6, 3, 2, 1, 4, 7}));
	}

}
