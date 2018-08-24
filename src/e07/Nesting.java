package e07;

// https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
// 75% (wrong answer) https://app.codility.com/demo/results/trainingU3R8HQ-8F9/
public class Nesting {

	public int solution(String s) {
		int opens = 0;
		for (Character c: s.toCharArray()) {
			if (c=='(')
				opens++;
			else
				opens--;
			if (opens<0)
				return 0;
		}

		return 1;
	}

	public static void main(String [] args) {
		System.out.println(new Nesting().solution("(()(())())"));
		System.out.println(new Nesting().solution("())"));
	}

}
