package e07;

/**
 * Task: https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
 * Solution: https://app.codility.com/demo/results/trainingXZKVV2-CSG/
 * Result: 100%
 *
 * @author Lukasz Frankowski
 */
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

		return opens==0 ? 1 : 0;
	}

	public static void main(String [] args) {
		System.out.println(new Nesting().solution("(()(())())")); // 1
		System.out.println(new Nesting().solution("())")); // 0
		System.out.println(new Nesting().solution("()(()()(((()())(()()))")); // 0
	}

}
