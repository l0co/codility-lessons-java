package e10;

/**
 * Task: https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/
 * Solution: https://app.codility.com/demo/results/trainingUCSHJM-4JZ/
 * Result: 100%
 *
 * @author Lukasz Frankowski
 */
public class MinPerimeterRectangle {

	public int solution(int n) {
		int i = 0, min = Integer.MAX_VALUE;

		double sqrt = Math.sqrt(n);
		int isqrt = (int) Math.floor(sqrt);

		while (++i <= isqrt) {
			if (n % i == 0)
				min = Math.min(min, i*2 + (n / i)*2);
		}

		return min;
	}

	public static void main(String [] args) {
		System.out.println(new MinPerimeterRectangle().solution(30)); // 22
	}

}
