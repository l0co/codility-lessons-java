package e10.ex;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Lukasz Frankowski
 */
public class DivisorsFinder {

	public class Divisors {
		int count = 0;
		Set<Integer> divisors = new TreeSet<>();

		public void addDivisor(int i) {
			count++;
			divisors.add(i);
		}

		@Override
		public String toString() {
			return "Divisors{" +
				"count=" + count +
				", divisors=" + divisors +
				'}';
		}
	}

	public Divisors findDivisors(int number) {
		Divisors divisors = new Divisors();

		int i = 1;
		while (i*i <= number) {
			if (number % i == 0) {
				divisors.addDivisor(i);
				divisors.addDivisor(number/i);
			}
			i++;
		}

		return divisors;
	}

	public boolean isPrime(int number) {
		int i = 2;
		while (i*i <= number) {
			if (number % i == 0)
				return false;
			i++;
		}

		return true;
	}

	public static void main(String [] args) {
		DivisorsFinder finder = new DivisorsFinder();

		for (int i=1; i<200; i++) {
			System.out.println(String.format("Divisors for: %d is %sprime with divisors: %s", i,
				finder.isPrime(i) ? "" : "not ",
				finder.findDivisors(i)));
		}
	}

}
