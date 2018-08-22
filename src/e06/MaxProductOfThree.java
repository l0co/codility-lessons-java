package e06;

import java.util.PriorityQueue;

// https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
// 44% wrong answer https://app.codility.com/demo/results/training8785K9-CCS/
public class MaxProductOfThree {

	public int solution(int[] a) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i: a) {
			queue.add(i);
			if (queue.size()>3)
				queue.poll();
		}

		int product = 1;
		while (!queue.isEmpty())
			product *= queue.poll();

		return product;
	}

	public static void main(String [] args) {
		System.out.println(new MaxProductOfThree().solution(new int[] {-3, 1, 2, -2, 5, 6}));
	}

}
