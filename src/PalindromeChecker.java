public class PalindromeChecker {

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        return isPalindromeRecursive(s, 0, s.length() - 1);
    }

    private static boolean isPalindromeRecursive(String s, int left, int right) {

        if (left >= right) {
            return true;
        }


        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        return isPalindromeRecursive(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("radar")); // true
        System.out.println(isPalindrome("java")); // false
        System.out.println(isPalindrome("A man, a plan, a canal, Panama")); // true
    }
}
