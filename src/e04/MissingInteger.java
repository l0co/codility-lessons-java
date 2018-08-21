package e04;

// https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
// https://app.codility.com/demo/results/trainingNFW285-8RT/
public class MissingInteger {

	public int solution(int[] a) {
		int occurrences[] = new int[a.length];
		int i=0;
		for (i=0; i<a.length; i++) {
			int item = a[i];
			if (a[i]>=1 && a[i]<=a.length)
				occurrences[a[i]-1]++;
		}
		for (i=0; i<occurrences.length; i++) {
			if (occurrences[i]==0)
				return i+1;
		}

		return i+1;
	}

	public static void main(String [] args) {
		System.out.println(new MissingInteger().solution(new int[] {1, 3, 6, 4, 1, 2}));
		System.out.println(new MissingInteger().solution(new int[] {1, 2, 3}));
		System.out.println(new MissingInteger().solution(new int[] {-1, -3}));
		System.out.println(new MissingInteger().solution(new int[] {1, 3, 6, 4, 1, 2, 100000}));
	}

}
