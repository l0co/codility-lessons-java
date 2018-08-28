package e07;

import java.util.Stack;

/**
 * Task: https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
 * Solution: https://app.codility.com/demo/results/trainingXUBTFW-Y7N/
 * Result: 100%
 *
 * @author Lukasz Frankowski
 */
public class Fish {

	public int solution(int[] sizes, int[] directions) {
		int countOfGoingLeft = 0; // count of living fish going left
		Stack<Integer> goingRight = new Stack<>(); // sizes of fish going right

		for (int i=0; i<sizes.length; i++) {
			if (directions[i] == 1) { // current fish is going right

				goingRight.push(sizes[i]);

			} else { // current fish is going left

				if (goingRight.empty()) {
					
					// no fish going right, this one will pass
					countOfGoingLeft++;

				} else {

					// the clash
					while (!goingRight.empty()) {
						int sizeOfGoingRight = goingRight.pop();
						int sizeOfGoingLeft = sizes[i];

						if (sizeOfGoingLeft<sizeOfGoingRight) {
							goingRight.push(sizeOfGoingRight); // reput, because going right fish eats the one going left
							break;
						} else {
							// continue iteration, because going left fish eats the one going right
							if (goingRight.empty())
								countOfGoingLeft++;
						}
					}

				}

			}

		}

		return countOfGoingLeft + goingRight.size();
	}

	public static void main(String [] args) {
		System.out.println(new Fish().solution(new int[] {4, 3, 2, 1, 5}, new int[] {0, 1, 0, 0, 0})); // 2
	}

}
