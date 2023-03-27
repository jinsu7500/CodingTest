class Solution {
    public String solution(int n) {
        String answer = "";
        for(int i = 0 ; i< n ; i++){
            if(i % 2 == 0){
                System.out.print("수");
                answer += "수";
            }
                
            else{
                System.out.print("박");
                answer += "박";
            }
        }
        return answer;
    }
}