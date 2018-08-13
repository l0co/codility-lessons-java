package e05.passingCars;

// https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
// https://app.codility.com/demo/results/trainingGFBV88-XCY/
public class Solution {

	public int solution(int[] a) {
		int carsToEast = 0;
		int passedCars = 0;

		for (int i=0; i<a.length; i++) {
			if (a[i] == 0)
				carsToEast++;
			else
				passedCars += carsToEast;

			if (passedCars>1_000_000_000)
				return -1;
		}

		return passedCars;
	}

	public static void main(String [] args) {
		System.out.println(new Solution().solution(new int[] {0, 1, 0, 1, 1}));
	}

}
