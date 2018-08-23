package e06;

// https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
// 93% exception https://app.codility.com/demo/results/training4VW8F4-65M/
public class NumberOfDiscIntersections {

	public int solution(int[] a) {
		int[] counters = new int[a.length];
		int numberOfPairs = 0;

		for (int center=0; center<a.length; center++) {
			int radius = a[center];
			int end = center + radius;

			// all circles right to the center within the radius range all included
			int includedRight = Math.min(radius, a.length-1-center);
			numberOfPairs += includedRight;
//			System.out.println(String.format("Pairs to the right with circle(%d, %d): %d (total pairs: %d)",
//				center, radius, includedRight, numberOfPairs));

			// all circles fullfilling following equation all also included: (center-radius) <= e < end
			for (int i=Math.max(0, center-radius); i<center; i++) {
				numberOfPairs += counters[i];
//				if (counters[i]>0)
//					System.out.println(String.format("Found: %d pairs to the left with end: %d (total pairs: %d)",
//						counters[i], i, numberOfPairs));
			}

			// build array of counters with endings
			if (end<a.length)
				counters[end]++;

//			System.out.println(String.format("Counters: %s", Arrays.toString(counters)));

			if (numberOfPairs > 10_000_000)
				return -1;
		}

		return numberOfPairs;
	}

	public static void main(String [] args) {
		System.out.println(new NumberOfDiscIntersections().solution(new int[] {1, 5, 2, 1, 4, 0})); // 11
		System.out.println(new NumberOfDiscIntersections().solution(new int[] {3, 0, 0, 0, 0, 0, 0, 3, 5})); // 12
	}

}
