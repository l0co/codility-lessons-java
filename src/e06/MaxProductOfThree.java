package e06;

import java.util.PriorityQueue;

// https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
// 88% performance https://app.codility.com/demo/results/trainingQXNTF9-3BV/
public class MaxProductOfThree {

	public int solution(int[] a) {
		PriorityQueue<Integer> biggest = new PriorityQueue<>(3);
		PriorityQueue<Integer> negative = new PriorityQueue<>(2, (i, j) -> -Integer.compare(i, j));

		for (int i: a) {
			biggest.add(i);
			if (biggest.size()>3)
				biggest.poll();
			if (i<0) {
				negative.add(i);
				if (negative.size()>2)
					negative.poll();
			}

		}

		int product = 1;
		int max = -1;
		while (!biggest.isEmpty()) {
			max = biggest.poll();
			product *= max;
		}

		// check negatives
		if (negative.size()==2 && max>-1) {
			int negativeProduct = 1;
			while (!negative.isEmpty())
				negativeProduct *= negative.poll();
			if (negativeProduct * max > product)
				product = negativeProduct * max;
		}

		return product;
	}

	public static void main(String [] args) {
		System.out.println(new MaxProductOfThree().solution(new int[] {-3, 1, 2, -2, 5, 6})); // 60
		System.out.println(new MaxProductOfThree().solution(new int[] {-5, 5, -5, 4})); // 125
		System.out.println(new MaxProductOfThree().solution(new int[] {-3, -5, 5, -5, 4})); // 125
		System.out.println(new MaxProductOfThree().solution(new int[] {-10, -2, -4})); // 125
	}

}
