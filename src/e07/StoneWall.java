package e07;

import java.util.Stack;

// https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
// https://app.codility.com/demo/results/trainingG8GDDJ-TZH/
public class StoneWall {

	protected int totalHeight;
	protected Stack<Integer> stack;
	protected int count;

	protected void push(int height) {
		stack.push(height);
		totalHeight += height;
	}

	protected int pop() {
		int height = stack.pop();
		totalHeight -= height;
		count++;
		return height;
	}

	protected void cleanup() {
		while (!stack.empty())
			pop();
	}

	public int solution(int[] h) {
		totalHeight = 0;
		stack = new Stack<>();
		count = 0;

		for (int i=0; i<h.length; i++) {
			int height = h[i];

			if (totalHeight == 0) {
				push(height);
			} else if (totalHeight < height) {
				push(height - totalHeight);
			} else if (totalHeight > height) {
				while (totalHeight > height)
					pop();
				if (height - totalHeight > 0)
					push(height - totalHeight);
			}
		}

		cleanup();

		return count;
	}

	public static void main(String [] args) {
		System.out.println(new StoneWall().solution(new int[] {8, 8, 5, 7, 9, 8, 7, 4, 8})); // 7
	}

}
