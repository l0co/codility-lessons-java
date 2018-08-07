package e03.frogJmp;

// https://app.codility.com/demo/results/training468FTP-GKC/
public class Solution {

	public int solution(int x, int y, int d) {
		if (d==0 || y<x)
			throw new IllegalArgumentException();

		return (y-x) / d + (((y-x) % d)==0 ? 0 : 1);
	}

	public static void main(String [] args) {
		System.out.println(new Solution().solution(10, 85, 30));
	}

}
