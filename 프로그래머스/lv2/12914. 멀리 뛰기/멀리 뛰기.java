class Solution {
    public long solution(int n) {
        if(n<=1) return n;  //n이 1보다 작을 때에는 값 반환
        else{
            long answer = 0;
            long A = 0;             
            long B = 1;         

            for(int i = 2 ; i<=n+1; i++){                
                answer = (A + B) % 1234567;
                A = B;
                B = answer;
            }            
            return answer;
        }
    }
}