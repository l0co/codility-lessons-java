package e10;

/**
 * Task: https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/
 * Solution: https://app.codility.com/demo/results/trainingAFSTTT-DCM/
 * Result: 92% because of performance
 *
 * @author Lukasz Frankowski
 */
public class CountFactors {

	public int solution(int n) {
		int i = 1, count = 0;

		while (i*i < n) {
			if (n % i == 0)
				count += 2;
			i++;
		}

		return i*i==n ? count+1 : count;
	}

	public static void main(String [] args) {
		System.out.println(new CountFactors().solution(24)); // 8
	}

}
