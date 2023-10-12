import java.util.*;
class Solution {
    public int solution(int[] food_times, long k) {
       long sum = 0;
        int len = food_times.length;
        int[] sortedItem = new int[food_times.length];

        for (int i = 0; i < len; i++) {
            sortedItem[i] = food_times[i];
            sum += food_times[i];
        }
        if (sum <= k) { // 만약 장애전에 이미 다돌아버리면 -1리턴하라함
            return -1;
        }

        Arrays.sort(sortedItem); //정렬해주기
        int minIndex = 0;
        int width = len;
        long round = 0;

        // 효율성생각해줘야함    그래서 장애오기전에 한바퀴씩 도는거 whiel문으로 해줘야함
        while (k >= width) {
            k -= width;
            round++;

            while(sortedItem[minIndex] - round == 0) { //만약 hap이 바퀴 돈것인데 그것을 뺐을때 0이되면 그음식은 끝이기 때문에
                minIndex++;
                width--;
            }
        }

        for (int i = 0; i < len; i++) {
            food_times[i] -= round;
        }

        // 남은 시간은 순차적으로 계산
        int i = 0;
        while (k-- > 0) {
            while (food_times[i] <= 0) { // 음식이 있을때까지 인덱스 넘김
                i = (i + 1) % food_times.length; // 음식이 남아있던 말던 i에다가 다음 인덱스 넣어준다
            }
            food_times[i]--;  //0보다크면 하나빼고 다음 인덱스 넣어주기
            i = (i + 1) % food_times.length;
        }

        // 네트워크 장애 이후 다음번째 음식이 있을때까지 인덱스 넘김
        while (food_times[i] <= 0) {
            i = (i + 1) % food_times.length;
        }

        return i +1; // 인덱스니까 1더하기
    
    }
}