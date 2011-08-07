/**
 * 
 */
package topcoder;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Sunil
 * 
 */
public class Competitions {
	public enum KEYPAD {
		_(1), A(2), B(2), C(2), D(3), E(3), F(3), G(4), H(4), I(4), J(5), K(5), L(
				5), M(6), N(6), O(6), P(7), R(7), S(7), T(8), U(8), V(8), W(9), X(
				9), Y(9);
		private final int value;

		KEYPAD(int val) {
			this.value = val;
		}

		int getValue() {
			return value;
		}

		public static int getVal(char c) {
			for (KEYPAD k : KEYPAD.values()) {
				if (k.toString().charAt(0) == c) {
					return k.getValue();
				}
			}
			return 1;
		}

	};

	public static long getSumFactorial(int i) {
		long sum = 0L;
		int j = 0;
		long lessFact = 1;
		while (j++ < i) {
			System.out.println("" + j + "= " + lessFact + " * " + j);
			lessFact = lessFact * j;
			sum += lessFact;
		}
		return sum;
	}

	public static long getSumOfDigitsOfExp(int i) {
		long sum = 1L;
		while (i-- > 0) {
			sum *= 2;
		}
		long sumDig = 0;
		while (sum > 9) {
			sumDig += sum % 10;
			sum = sum / 10;
		}
		sumDig += sum;
		return sumDig;
	}

	public static double solveBirthdayParadox(int totalNum) {
		double prob = 0;
		double temp = (CombinationGenerator.getCombination(totalNum, 2) * 1.0) / 365;
		temp = temp * 1000;
		temp = Math.round(temp);
		temp = temp / 1000.0;
		prob += temp;
		log(temp);
		return prob;
	}

	public static long telKeypadProduct(String str) {
		long product = 1;
		str = str.toUpperCase();
		for (int i = 0; i < str.length(); i++) {
			// log(str.charAt(i) + ": " + KEYPAD.getVal(str.charAt(i)));
			product *= KEYPAD.getVal(str.charAt(i));
		}
		return product;
	}

	public static long getReverseAlphabetCode(String s) {
		long sum = 0;
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				continue;
			sum += (s.charAt(i) - 123) * -1;
		}
		return sum;
	}

	public static long getPowerFunctionResult(int numSteps) {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 1; i <= numSteps; i++) {
			BigInteger temp = new BigInteger(Integer.valueOf(i).toString());
			BigInteger temp3 = new BigInteger(Integer.valueOf(i + 1).toString());
			temp = temp.pow(i + 1);
			temp3 = temp3.pow(i);
			sum = sum.add(temp);
			sum = sum.add(temp3);
		}
		BigInteger[] result = sum.divideAndRemainder(new BigInteger("10000"));
		return result[1].longValue();
	}

	public static int getDigitsOfPowerFunction(int digits, int x) {
		BigInteger fun = new BigInteger(Integer.valueOf(x).toString());
		BigInteger sum = new BigInteger(Integer.valueOf(4).toString()).pow(x);
		sum = sum.add(fun.pow(3));
		sum = sum.add(fun.pow(2));
		sum = sum.add(fun);
		sum = sum
				.subtract(new BigInteger(Integer.valueOf(2).toString()).pow(x));
		sum = sum.divide(new BigInteger(Integer.valueOf(3).toString()).pow(x));
		log(sum);
		return Integer.parseInt(sum.toString().substring(0, digits));
	}

	public static long getSumOfFirstPrimes(int max) {
		long[] primes = new long[max + 1];
		final int FP = 2;
		primes[1] = FP;
		long n = FP + 1;
		int j = 1; // numbers found
		boolean isPrime = true; // for 3

		for (; j < max;) {
			if (isPrime) {
				primes[++j] = n;
				isPrime = false;
			}
			n += 2;
			for (int k = 2; k <= j && k < max; k++) {
				long q = n / primes[k];
				long r = n % primes[k];
				if (r == 0) {
					break;
				}
				if (q <= primes[k]) {
					isPrime = true;
					break;
				}
			}
		}

		long sum = 0;
		for (int i = 1; i <= max; i++) {
			log(primes[i]);
			sum += primes[i];
		}
		return sum;

	}

	public static long countPrimesBelow(long limit, boolean returnSum) {
		ArrayList<Long> primes = new ArrayList<Long>();
		final int FP = 2;
		primes.add(0, 1L);
		primes.add(1, 2L);
		long n = FP + 1;
		int j = 1; // numbers found
		boolean isPrime = true; // for 3

		for (; n <= limit;) {
			if (isPrime) {
				primes.add(++j, n);
				isPrime = false;
			}
			n += 2;
			for (int k = 2; k <= j && k < limit; k++) {
				long q = n / primes.get(k);
				long r = n % primes.get(k);
				if (r == 0) {
					break;
				}
				if (q <= primes.get(k)) {
					isPrime = true;
					break;
				}
			}
		}
		
		if(returnSum) {
			long sum = 0;
			for(int i=1; i<primes.size(); i++) {
				sum += primes.get(i);
			}
			return sum;
		}

		return (primes.size() - 1);
	}
	
	public static int[] countCordinates(String filename) {
		int[] quads = new int[4];
		try {
			StringBuilder str = new StringBuilder();
			Scanner scn = new Scanner(new FileInputStream(filename));
			int x, y;
			while (scn.hasNextLine()) {
				str.setLength(0);
				str.append(scn.nextLine());
				String[] cords = str.toString().split(",");
				if (cords.length != 2) {
					log("Parse Error: " + str.toString());
					continue;
				}
				x = Integer.parseInt(cords[0]);
				y = Integer.parseInt(cords[1]);
				if (x > 0 && y > 0) {
					quads[0]++;
				} else if (x > 0 && y < 0) {
					quads[3]++;
				} else if (x < 0 && y > 0) {
					quads[1]++;
				} else if (x < 0 && y < 0) {
					quads[2]++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log(e.getMessage());
			return null;
		}
		
		return quads;
	}
	
	public static void main(String[] s) {
		// System.out.println(Competitions.getSumFactorial(15));
		// System.out.println(Competitions.getSumOfDigitsOfExp(50));
		// System.out.println(Competitions.solveBirthdayParadox(25));
		// log(Competitions.telKeypadProduct("Programming Challenges are fun"));
		// log(Competitions.getReverseAlphabetCode("The quick brown fox jumped over the cow"));
		// log(Competitions.getPowerFunctionResult(15));
		// log(Competitions.getDigitsOfPowerFunction(3, 50));
		// log(Competitions.getSumOfFirstPrimes(250));
		// log(Competitions.countPrimesBelow(new Double(Math.pow(10, 7)).longValue(), false));
		// log(Competitions.countPrimesBelow(5000, true));
		log(Competitions.countCordinates("/Users/Sunil/Documents/workspace/codingTest/src/topcoder/cordinates.txt")[2]);
		
	}

	public static void log(Object str) {
		System.out.println(str);
	}

}

class CombinationGenerator {

	public static double getCombination(int n, int r) {
		if (r > n) {
			throw new IllegalArgumentException();
		}
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		BigInteger nFact = getFactorial(n);
		BigInteger rFact = getFactorial(r);
		BigInteger nminusrFact = getFactorial(n - r);
		return nFact.divide(rFact.multiply(nminusrFact)).doubleValue();
		// return (nFact.doubleValue() * 1.0 /
		// (rFact.multiply(nminusrFact).doubleValue()));
	}

	private static BigInteger getFactorial(int n) {
		BigInteger fact = BigInteger.ONE;
		for (int i = n; i > 1; i--) {
			fact = fact.multiply(new BigInteger(Integer.toString(i)));
		}
		return fact;
	}

}
