package e06.ex;

import java.util.Arrays;

/**
 * Example of merge sort
 *
 * @author Lukasz Frankowski
 */
public class MergeSort {

	public int[] solution(int[] a) {
		return sort(a, 0, a.length);
	}

	protected int[] sort(int[] a, int leftInclusive, int rightExclusive) {
		int len = rightExclusive-leftInclusive;
		if (len<=1)
			return a;

		int half = len / 2;
		sort(a, leftInclusive, leftInclusive+half);
		sort(a, leftInclusive+half, leftInclusive+len);
		return merge(a, leftInclusive, leftInclusive+half, leftInclusive+len);
	}

	protected int[] merge(int[] a, int leftInclusive, int half, int rightExclusive) {
		int len = rightExclusive-leftInclusive;
		int[] merged = new int[len];
		int aidx=leftInclusive, bidx=half, midx=0;
		while (aidx<half || bidx<rightExclusive) {
			if (aidx==half || (bidx<rightExclusive && a[bidx]<=a[aidx]))
				merged[midx++] = a[bidx++];
			else if (bidx==rightExclusive || a[aidx]<=a[bidx])
				merged[midx++] = a[aidx++];
		}

		System.out.println(String.format("Merging: %s and: %s into: %s",
			Arrays.toString(Arrays.copyOfRange(a, leftInclusive, half)),
			Arrays.toString(Arrays.copyOfRange(a, half, rightExclusive)),
			Arrays.toString(merged)));

		// fill merged into the original array
		for (int i=0; i<merged.length; i++)
			a[leftInclusive+i] = merged[i];

		return merged;
	}

	public static void main(String [] args) {
		System.out.println(Arrays.toString(new MergeSort().solution(
			new int[] {1, 5, 3, 6, 8, 3, 4, 5, 2, 3, 4, 1, 2, 8, 9, 9, 4, 5, 5})));

	}

}
