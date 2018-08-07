package e02.oddOccurrencesInArray;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

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