package e03;

/**
 * Task: https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 * Solution: https://app.codility.com/demo/results/training468FTP-GKC/
 * Result: 100%
 *
 * @author Lukasz Frankowski
 */
public class FrogJmp {

	public int solution(int x, int y, int d) {
		if (d==0 || y<x)
			throw new IllegalArgumentException();

		return (y-x) / d + (((y-x) % d)==0 ? 0 : 1);
	}

	public static void main(String [] args) {
		System.out.println(new FrogJmp().solution(10, 85, 30));
	}

}
