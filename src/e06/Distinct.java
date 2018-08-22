package e06;

import java.util.HashSet;
import java.util.Set;

// https://app.codility.com/programmers/lessons/6-sorting/distinct/
// https://app.codility.com/demo/results/trainingG7MQRJ-S4S/
public class Distinct {

	public int solution(int[] a) {
		Set<Integer> set = new HashSet<>();
		for (int i: a)
			set.add(i);
		return set.size();
	}

	public static void main(String [] args) {
		System.out.println(new Distinct().solution(new int[] {2, 1, 1, 2, 3, 1}));
	}

}
