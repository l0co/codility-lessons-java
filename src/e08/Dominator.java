package e08;

/**
 * Task: https://app.codility.com/programmers/lessons/8-leader/dominator/
 * Solution: https://app.codility.com/demo/results/training4AX98N-ZN7/
 * Result: 100%
 *
 * @author Lukasz Frankowski
 */
public class Dominator {

	protected static class SameValueStack {

		protected Integer value = null;
		protected int size = 0;

		protected void push(int i) {
			if (value != null && !value.equals(i))
				throw new IllegalArgumentException();
			value = i;
			size++;
		}

		protected int pop() {
			if (empty())
				throw new UnsupportedOperationException();

			int ret = value;
			if (--size == 0)
				value = null;
			return ret;
		}

		protected int peek() {
			if (empty())
				throw new UnsupportedOperationException();

			return value;
		}

		protected boolean empty() {
			return size == 0;
		}

		@Override
		public String toString() {
			if (empty())
				return "SameValueStack{empty}";

			return "SameValueStack{" +
				"value=" + value +
				", size=" + size +
				'}';
		}
	}

	public int solution(int[] a) {
		SameValueStack stack = new SameValueStack();

		for (int i=0; i<a.length; i++) {
			int value = a[i];

			if (stack.empty()) {

				stack.push(value);

			} else {

				if (stack.peek() == value)
					stack.push(value);
				else
					stack.pop();

			}
		}

		if (!stack.empty()) {
			int value = stack.pop();
			int count = 0;

			for (int i=0; i<a.length; i++)
				if (a[i] == value) {
					count++;
					if (count>a.length/2)
						return i;
				}
		}

		return -1;
	}

	public static void main(String [] args) {
		System.out.println(new Dominator().solution(new int[] {3,4,3,3,2,3,-1,3,3})); // any index of (3)
		System.out.println(new Dominator().solution(new int[] {3,4,3,2,3,-1,3,3})); // any index of (3)
		System.out.println(new Dominator().solution(new int[] {3,4,4,4,4,4,3,2,3,-1,3,3})); // -1
	}

}
