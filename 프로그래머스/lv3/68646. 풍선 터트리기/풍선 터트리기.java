

import java.util.HashSet;
class Solution {
     public int solution(int[] a) {
        int answer = 0;

        int left_min = Integer.MAX_VALUE;
        int right_min = Integer.MAX_VALUE;

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i<a.length ; i++)
        {
            left_min = Math.min(left_min,a[i]);
            right_min = Math.min(right_min,a[a.length-i-1]);
            set.add(left_min);
            set.add(right_min);
        }
        answer = set.size();
        return answer;
    }
}