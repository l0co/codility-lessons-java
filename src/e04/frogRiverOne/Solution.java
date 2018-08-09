package e04.frogRiverOne;

// https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
// https://app.codility.com/demo/results/trainingPSH3EB-SXQ/
public class Solution {

	public int solution(int len, int[] times) {
		int positions[] = new int[len];
		int positionsCovered = 0;

		for (int second=0; second<times.length; second++) {
			int position = times[second];
			if (position > positions.length)
				throw new IllegalArgumentException(String.format("Position: %d at second: %d greater than len: %d", position, second, len));
			if (positions[position-1]==0) { // record new leaf on position
				positions[position-1] = 1;
				positionsCovered++;
				if (positionsCovered==len) // all positions covered? return time
					return second;
			}

		}

		return -1;
	}

	public static void main(String [] args) {
		System.out.println(new Solution().solution(5, new int[] {1, 3, 1, 4, 2, 3, 5, 4}));
	}

}
