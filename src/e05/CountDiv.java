package e05;

// https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
// https://app.codility.com/demo/results/trainingB8XTH2-3RZ/
public class CountDiv {

	public int solution(int a, int b, int k) {
		// left boundary
		int left = a + (a%k==0 ? 0 : k-(a%k));
		if (left > b)
			return 0;

		// right boundary
		int right = b - (b % k);
		if (right<a)
			return 1;

		return (right-left) / k + 1;
	}

	public static void main(String [] args) {
		System.out.println(new CountDiv().solution(6, 11, 2));
		System.out.println(new CountDiv().solution(11, 345, 17));
	}

}
