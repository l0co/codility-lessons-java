package e10.ex;

import java.util.Set;
import java.util.TreeSet;

/**
 * Counting number of divisors and primality test from https://codility.com/media/train/8-PrimeNumbers.pdf
 *
 * @author Lukasz Frankowski
 */
public class DivisorsFinder {

	public class Divisors {
		protected int count = 0;
		protected Set<Integer> divisors = new TreeSet<>();

		public void addDivisor(int i) {
			count++;
			divisors.add(i);
		}

		public int getCount() {
			return count;
		}

		public Set<Integer> getDivisors() {
			return divisors;
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
				if (number/i != i)
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
