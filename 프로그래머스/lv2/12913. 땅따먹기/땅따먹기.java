class Solution {
    //누적합으로 신규 2차원배열을 생성
    public int solution(int[][] land) {
        int answer[][] = new int[land.length][4];
        int lastMaxIdx = Integer.MIN_VALUE;

        for(int i = 0 ; i < land.length ; i++){
            if(i== 0){
                answer[i][0] = land[i][0];  //0열
                answer[i][1] = land[i][1];  //1열
                answer[i][2] = land[i][2];  //2열
                answer[i][3] = land[i][3];  //3열
            }
            else{
                //n-1행에서 자기열을 제외한 최대값을 누적해서 쌓아올림
                answer[i][0] = land[i][0] + Math.max(Math.max(answer[i-1][1],  answer[i-1][2]),answer[i-1][3]);  //0열
                answer[i][1] = land[i][1] + Math.max(Math.max(answer[i-1][0],  answer[i-1][2]),answer[i-1][3]);  //1열
                answer[i][2] = land[i][2] + Math.max(Math.max(answer[i-1][0],  answer[i-1][1]),answer[i-1][3]);  //2열
                answer[i][3] = land[i][3] + Math.max(Math.max(answer[i-1][0],  answer[i-1][1]),answer[i-1][2]);  //3열
            }
        }

        //n행에서 최대값 찾기
        for(int i = 0 ; i <4 ; i++){
            if(lastMaxIdx < answer[land.length-1][i]){
                lastMaxIdx = answer[land.length-1][i];
            }
        }       
        return lastMaxIdx;
    }
}