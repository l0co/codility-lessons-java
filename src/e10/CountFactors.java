package e10;

/**
 * Task: https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/
 * Solution: https://app.codility.com/demo/results/trainingKNGXTJ-M7U/
 * Result: 100%
 *
 * @author Lukasz Frankowski
 */
public class CountFactors {

	public int solution(int n) {
		int i = 0, count=0;

		double sqrt = Math.sqrt(n);
		int isqrt = (int) Math.floor(sqrt);

		while (++i <= isqrt)
			count += n % i == 0 ? (i==sqrt ? 1 : 2) : 0;

		return count;
	}

	public static void main(String [] args) {
		System.out.println(new CountFactors().solution(24)); // 8
		System.out.println(new CountFactors().solution(36)); // 9
		System.out.println(new CountFactors().solution(2147483647)); // 2
	}

}
