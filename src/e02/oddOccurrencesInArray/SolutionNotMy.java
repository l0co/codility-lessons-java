package e02.oddOccurrencesInArray;

// https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
public class SolutionNotMy {

	public int solution(int[] A) {
		// write your code in Java SE 8
		int elem = 0;

		for (int i = 0; i < A.length; i++) {
			elem ^= A[i];
		}
		return elem;
	}

	public static void main(String [] args) {
		System.out.println(new SolutionNotMy().solution(new int[] { 9, 3, 9, 3, 9, 7, 9 }));
	}

}