package e01;

// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
// https://app.codility.com/demo/results/trainingKYJGEG-FZ5/
class BinaryGap {

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
		System.out.println(new BinaryGap().solution(1041));
		System.out.println(new BinaryGap().solution(529));
		System.out.println(new BinaryGap().solution(15));
		System.out.println(new BinaryGap().solution(619649849));
	}

}