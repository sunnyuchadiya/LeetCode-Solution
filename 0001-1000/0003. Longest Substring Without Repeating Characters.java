class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);

        int l = 0, max = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (map[c] >= l) {
                l = map[c] + 1;
            }

            map[c] = r;
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}