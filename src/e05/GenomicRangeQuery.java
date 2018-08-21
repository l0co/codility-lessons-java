package e05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
// the most naive solution is 62% because of performance, Detected time complexity: O(N * M)
// https://app.codility.com/demo/results/training49P7D8-A4Z/
public class GenomicRangeQuery {

	public static final Map<Character, Integer> MAP = new HashMap<Character, Integer>() {{
		put('A', 1);
		put('C', 2);
		put('G', 3);
		put('T', 4);
	}};

	protected int[] impacts(String s) {
		int[] impacts = new int[s.length()];
		for (int i=0; i<s.length(); i++)
			impacts[i] = MAP.get(s.charAt(i));
		return impacts;
	}

	protected int calcMin(int[] impacts, int leftInclusive, int rightInclusive) {
		int min = 4;
		for (int i=leftInclusive; i<=rightInclusive; i++) {
			min = Math.min(min, impacts[i]);
			if (min==1)
				break;
		}

		return min;
	}

	public int[] solution(String s, int[] p, int[] q) {
		int[] impacts = impacts(s);
		int[] results = new int[p.length];

		for (int i=0; i<p.length; i++)
			results[i] = calcMin(impacts, p[i], q[i]);

		return results;
	}

	public static void main(String [] args) {
		System.out.println(Arrays.toString(new GenomicRangeQuery().solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6})));
	}

}
