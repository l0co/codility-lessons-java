package e06;

import java.util.Arrays;

// example of merge sort
public class MergeSort {

	public int[] solution(int[] a) {
		return sort(a);
	}

	protected int[] sort(int[] a) {
		if (a.length==1)
			return a;

		int half = a.length / 2;
		return merge(sort(Arrays.copyOfRange(a, 0, half)), sort(Arrays.copyOfRange(a, half, a.length)));
	}

	protected int[] merge(int[] a, int[] b) {
		int[] merged = new int[a.length+b.length];
		int aidx=0, bidx=0;
		while (aidx<a.length || bidx<b.length) {
			if (aidx==a.length || (bidx<b.length && b[bidx]<=a[aidx]))
				// b element is lesser or no more a elements
				merged[aidx+bidx] = b[bidx++];
			else if (bidx==b.length || a[aidx]<=b[bidx])
				// a element is lesser or no more b elements
				merged[aidx+bidx] = a[aidx++];
		}

		System.out.println(String.format("Merging: %s and: %s into: %s", Arrays.toString(a), Arrays.toString(b), Arrays.toString(merged)));

		return merged;
	}

	public static void main(String [] args) {
		System.out.println(Arrays.toString(new MergeSort().solution(
			new int[] {1, 5, 3, 6, 8, 3, 4, 5, 2, 3, 4, 1, 2, 8, 9, 9, 4, 5, 5})));

	}

}
