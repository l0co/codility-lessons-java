package e07;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Task: https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 * Solution: https://app.codility.com/demo/results/trainingD26SHV-3Z2/
 * Result: 100%
 *
 * @author Lukasz Frankowski
 */
public class Brackets {

	protected static final Map<Character, BracketDef> BRACKETS = new HashMap<>();

	protected static class BracketDef {
		Character chr;
		boolean opening;
		BracketDef reverse;

		public BracketDef(Character chr, boolean opening, Map<Character, BracketDef> regMap) {
			this.chr = chr;
			this.opening = opening;
			regMap.put(chr, this);
		}

		public Character getChr() {
			return chr;
		}

		public boolean isOpening() {
			return opening;
		}

		public boolean isClosing() {
			return !isOpening();
		}

		public BracketDef getReverse() {
			return reverse;
		}

		public BracketDef withReverse(BracketDef reverse) {
			this.reverse = reverse;
			return this;
		}

		public static void registerPair(Character openingChar, Character closingChar) {
			new BracketDef(openingChar, true, BRACKETS)
				.withReverse(new BracketDef(closingChar, false, BRACKETS));
		}

	}

	static {
		BracketDef.registerPair('(', ')');
		BracketDef.registerPair('{', '}');
		BracketDef.registerPair('[', ']');
	}

	public int solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (Character c: s.toCharArray()) {
			BracketDef bracket = BRACKETS.get(c);
			if (bracket==null)
				throw new IllegalArgumentException();
			else if (bracket.isOpening())
				stack.push(c);
			else { // is closing
				if (stack.empty())
					return 0; // invalid string
				Character openingBracket = stack.pop();
				if (!BRACKETS.get(openingBracket).getReverse().getChr().equals(c))
					return 0;
			}
		}

		return stack.empty() ? 1 : 0;
	}

	public static void main(String [] args) {
		System.out.println(new Brackets().solution("{[()()]}")); // 1
		System.out.println(new Brackets().solution("{[()()]}}")); // 0
		System.out.println(new Brackets().solution("{[()()]")); // 0
		System.out.println(new Brackets().solution("([)()]")); // 0
	}

}
