class Solution {
    public String minWindow(String s, String t) {
        int maxlen = Integer.MAX_VALUE;
        int idx = 0;

        int hash[] = new int[128];
        int cnt = 0;

        int left = 0, right = 0;

        for (int j = 0; j < t.length(); j++) {
            char ch = t.charAt(j);
            hash[ch]++;
        }

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (hash[ch] > 0) {
                cnt++;
            }
            hash[ch]--;

            while (cnt == t.length()) {
                if ((right - left + 1) < maxlen) {
                    maxlen = right - left + 1;
                    idx = left;
                }

                char leftChar = s.charAt(left);
                hash[leftChar]++;

                if (hash[leftChar] > 0) {
                    cnt--;
                }

                left++;
            }

            right++;
        }

        if (maxlen == Integer.MAX_VALUE) return "";
        return s.substring(idx, idx + maxlen);
    }
}