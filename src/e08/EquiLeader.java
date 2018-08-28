package e08;

/**
 * Task: https://app.codility.com/programmers/lessons/8-leader/equi_leader/
 * Solution: https://app.codility.com/demo/results/trainingX7F589-BEW/
 * Result: 100%
 *
 * @author Lukasz Frankowski
 */
@SuppressWarnings("Duplicates")
public class EquiLeader {

	/**
	 * We use the same solution as in {@link Dominator} to find the global leader.
 	 */
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

		int equileadersCount = 0;
		if (!stack.empty()) {
			int leader = stack.pop();
			int leadersCount = 0;

			for (int i = 0; i < a.length; i++)
				if (a[i] == leader)
					leadersCount++;

			if (leadersCount > a.length/2) {

				// now, having a leader and total count of ocurrences, we may now iterate through array to find equileaders
				int leftLeaders = 0, rightLeaders = leadersCount, leftOthers = 0, rightOthers = a.length-leadersCount;

				for (int i=0; i<a.length; i++) {

					if (a[i]==leader) {
						leftLeaders++;
						rightLeaders--;
					} else {
						leftOthers++;
						rightOthers--;
					}

					if (leftLeaders>leftOthers && rightLeaders>rightOthers)
						equileadersCount++;

				}
			}

		}

		return equileadersCount;
	}

	public static void main(String [] args) {
		System.out.println(new EquiLeader().solution(new int[] {4,3,4,4,4,2})); // 2
	}

}
