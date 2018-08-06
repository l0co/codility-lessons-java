package e01.binaryGap;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

	public int solution(int N) {
		int result = -1;
		int maxResult = 0;

		while (N>0) {
			int bt = N & 1; // check first byte

			if (bt==1) { // 1 byte - new sequence
				maxResult = Math.max(maxResult, result);
				result = 0;
			} else if (result>=0) { // 0 byte - increment the gap
				result++;
			}

			N = N >> 1; // shift bytes
		}

		return maxResult;
	}


	public static void main(String [] args) {
		System.out.println(new Solution().solution(1041));
		System.out.println(new Solution().solution(529));
		System.out.println(new Solution().solution(15));
		System.out.println(new Solution().solution(619649849));
	}

}