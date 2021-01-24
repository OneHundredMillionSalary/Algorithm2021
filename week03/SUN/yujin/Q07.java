package challenge.week02_2021_january_8th_january_14th;

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3599/
// Create Sorted Array through Instructions

import java.util.*;

public class Q07 {
    public int createSortedArray(int[] instructions) {
        final int LEN = instructions.length;
        List<Integer> sortedlist = new ArrayList<>(LEN);
        List<Integer> answer = new ArrayList<>(LEN);
        for (int instruction : instructions) {
            sortedlist.add(instruction);
        }
        sortedlist.sort(Integer::compare);

        answer.add(instructions[0]);
        int sum = 0;
        for (int i = 1; i < LEN; i++) {
            int instruction = instructions[i];
            int idx = sortedlist.indexOf(instruction);
            int cost = 0;
            if (idx < LEN / 2) {
                for (int j = 0, len = answer.size(); j < len; j++) {
                    if (instruction <= answer.get(j)) {
                        cost = j;
                        break;
                    }
                }
            } else {
                for (int j = answer.size() - 1; j >= 0; j--) {
                    if (instruction >= answer.get(j)) {
                        cost = answer.size() - j - 1;
                        break;
                    }
                }
            }
            answer.add(instruction);
            answer.sort(Integer::compareTo);
            sum += cost;
        }

        return sum;
    }
}
