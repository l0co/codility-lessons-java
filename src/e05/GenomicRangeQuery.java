package e05;

import java.util.Arrays;

// https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
// partial sums for separate impacts; detected time complexity: O(N + M)
// https://app.codility.com/demo/results/training62S6DH-97H/
public class GenomicRangeQuery {

	protected boolean exists(int[] sum, int leftInclusive, int rightInclusive) {
		if (leftInclusive==0 && sum[0]>0)
			return true;
		if (leftInclusive>0 && sum[leftInclusive] > sum[leftInclusive-1])
			return true;
		return sum[rightInclusive] > sum[leftInclusive];
	}

	public int[] solution(String s, int[] p, int[] q) {
		int[] sum1 = new int[s.length()], sum2 = new int[s.length()], sum3 = new int[s.length()];
		int osum1 = 0, osum2 = 0, osum3 = 0;

		for (int i=0; i<s.length(); i++) {
			switch (s.charAt(i)) {
				case 'A':
					osum1++;
					break;
				case 'C':
					osum2++;
					break;
				case 'G':
					osum3++;
					break;
				case 'T':
					break;
				default:
					throw new IllegalArgumentException();
			}
			sum1[i] = osum1;
			sum2[i] = osum2;
			sum3[i] = osum3;
		}

		int[] results = new int[p.length];

		for (int i=0; i<p.length; i++) {
			if (exists(sum1, p[i], q[i]))
				results[i] = 1;
			else if (exists(sum2, p[i], q[i]))
				results[i] = 2;
			else if (exists(sum3, p[i], q[i]))
				results[i] = 3;
			else
				results[i] = 4;
		}

		return results;
	}

	public static void main(String [] args) {
		System.out.println(Arrays.toString(new GenomicRangeQuery().solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6})));
	}

}
