package challenge.week03_2021_january_15th_january_21st;

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3611/
// Find the Most Competitive Subsequence

public class Q07 {
    public int[] mostCompetitive(int[] nums, int k) {
        final int LEN = nums.length;
        int[] answer = new int[k];
        int start = 0;
        for (int z = 0; z < k; z++) {
            int min = nums[start], minIdx = start;
            for (int i = start + 1, len = LEN - (k - z); i <= len; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                    minIdx = i;
                }
            }
            answer[z] = min;
            start = minIdx + 1;
        }

        return answer;
    }
}
