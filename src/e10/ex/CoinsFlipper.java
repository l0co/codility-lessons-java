package e10.ex;

import java.util.Arrays;

/**
 * Coins flipper algorithms from https://codility.com/media/train/8-PrimeNumbers.pdf (10.3 Excercises).
 *
 * @author Lukasz Frankowski
 */
public class CoinsFlipper {

	public enum CoinSide {
		H {
			@Override
			public CoinSide reverse() {
				return CoinSide.T;
			}
		},
		
		T {
			@Override
			public CoinSide reverse() {
				return CoinSide.H;
			}
		};

		public abstract CoinSide reverse();
	}

	/**
	 * O(n*logn) naive
	 */
	public CoinSide[] naive(int n) {
		CoinSide[] sides = new CoinSide[n];
		Arrays.fill(sides, CoinSide.H);

		for (int i=1; i<=n; i++) {
 			int j = 1, pos = i;
			while (pos<=n) {
				sides[pos-1] = sides[pos-1].reverse();
				j += 1;
				pos = i*j;
			}
		}

		return sides;
	}

	/**
	 * O(n*logn) using {@link DivisorsFinder}. Each coin will be flipped exactly number of divisor times.
	 */
	public CoinSide[] slow(int n) {
		CoinSide[] sides = new CoinSide[n];
		DivisorsFinder finder = new DivisorsFinder();

		for (int i=0; i<n; i++)
			sides[i] = finder.findDivisors(i+1).getCount() % 2 == 0 ? CoinSide.H : CoinSide.T;

		return sides;
	}

	/**
	 * O(n) using symmetric divisor. If the whole number N has whole number sqrt(N) divisor, it has odd number of divisors, because all
	 * other divisors have symmetric divisors (two = even).
	 */
	public CoinSide[] fast(int n) {
		CoinSide[] sides = new CoinSide[n];

		for (int i=0; i<n; i++)
			sides[i] = Math.sqrt(i+1) % 1 == 0 ? CoinSide.T : CoinSide.H; // sqrt % 1 = 0 --> sqrt is the whole number --> has odd number of divisors

		return sides;
	}

	public void flip(int n) {
		System.out.println(String.format("Flipping: %d", n));
		System.out.println(String.format("  naive:\t%s", Arrays.toString(naive(n))));
		System.out.println(String.format("  slow:\t\t%s", Arrays.toString(slow(n))));
		System.out.println(String.format("  fast:\t\t%s", Arrays.toString(fast(n))));
	}

	public static void main(String [] args) {
		CoinsFlipper flipper = new CoinsFlipper();
		flipper.flip(10);
	}

}
