package e02;

// https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
// https://app.codility.com/demo/results/trainingDQS3EA-6U9/
public class OddOccurrencesInArray {

	public int solution(int[] A) {
		// write your code in Java SE 8
		int elem = 0;

		for (int i = 0; i < A.length; i++) {
			elem ^= A[i];
		}
		return elem;
	}

	public static void main(String [] args) {
		System.out.println(new OddOccurrencesInArray().solution(new int[] { 9, 3, 9, 3, 9, 7, 9 }));
	}

}