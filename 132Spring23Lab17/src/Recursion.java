
public class Recursion {

	public static int triangle(int rows) {
		if (rows == 1) {
			return 1;
		}
		return rows + triangle(rows - 1);
	}

	public static int countX(String s) {
		return countXHelper(s, 0);

	}

	public static int countXHelper(String s, int index) {
		if (index >= s.length()) {
			return 0;
		}
		if (s.charAt(index) == 'x') {
			return 1 + countXHelper(s, index + 1);
		}
		return countXHelper(s, index + 1);
	}

	public static int sumDigits(int n) {
		if (n < 10) {
			return n;
		}
		return (n % 10) + sumDigits(n / 10);
	}

	public static String pairStar(String s) {
		return pairStarHelper(s, 0);
	}

	public static String pairStarHelper(String s, int index) {
		if (index == (s.length() - 1)) {
			return "" + s.charAt(index);
		}

		if (s.charAt(index) == s.charAt(index + 1)) {
			return s.charAt(index) + "*" + pairStarHelper(s, index + 1);

		}
		return s.charAt(index) + pairStarHelper(s, index + 1);

	}

	public static boolean splitArray(int[] nums) {
		return splitArrayHelper(nums, 0, 0, 0);
	}
	public static boolean splitArrayHelper (int[] nums, int start, int sum1, int sum2) {
		if(start == nums.length) {
			return sum1== sum2; 
		}
		return splitArrayHelper(nums, start + 1, sum1 + nums [start], sum2) ||
				splitArrayHelper(nums, start + 1, sum1, sum2 + nums[start]);
	}
}
