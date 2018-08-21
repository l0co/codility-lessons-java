package e02;

// https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
public class OddOccurrencesInArray_NotMy {

	public int solution(int[] A) {
		// write your code in Java SE 8
		int elem = 0;

		for (int i = 0; i < A.length; i++) {
			elem ^= A[i];
		}
		return elem;
	}

	public static void main(String [] args) {
		System.out.println(new OddOccurrencesInArray_NotMy().solution(new int[] { 9, 3, 9, 3, 9, 7, 9 }));
	}

}