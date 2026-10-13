class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        // Create a reversed version of string s
        String rev = new StringBuilder(s).reverse().toString();

        // Construct combined string s + '#' + rev
        // The '#' character prevents matching across the s and rev boundary
        String combined = s + "#" + rev;

        // Build the KMP Partial Match Table (LPS - Longest Prefix Suffix)
        int[] lps = buildLPS(combined);

        // lps[combined.length() - 1] gives the length of the longest palindromic prefix of s
        int longestPalindromePrefixLength = lps[combined.length() - 1];

        // Characters remaining after the longest palindromic prefix need to be reversed and added to the front
        String suffixToPrepend = s.substring(longestPalindromePrefixLength);
        String prefix = new StringBuilder(suffixToPrepend).reverse().toString();

        return prefix + s;
    }

    private int[] buildLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}