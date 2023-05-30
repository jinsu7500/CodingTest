import java.util.ArrayList;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        ArrayList<Integer> yPoints = new ArrayList<>();

        //최초좌표 입력
        yPoints.add(k);

        //y좌표 계산
        while(k >= 1){
            if(k == 1){ break;}
            else if(k%2 == 0){                
                k = k/2;
                yPoints.add(k);
            }
            else{
                k = (k * 3) + 1;
                yPoints.add(k);
            }
        }

        //구간 넓이 계산
        ArrayList<Double> sectionSize = new ArrayList<>();

        for(int i = 0 ; i <yPoints.size() - 1; i++)
        {
            Double width;
            Double triangleWidth = Double.valueOf((Math.abs(yPoints.get(i+1) - yPoints.get(i)) * 0.5));     // 나누기2 하니까 소숫점 날라감

            Double squareWidth = Double.valueOf(Math.min(yPoints.get(i), yPoints.get(i+1))) ;

            width = triangleWidth + squareWidth;
            sectionSize.add(width);
        }

        double[] answer = new double[ranges.length];

        for(int i = 0 ; i < ranges.length ; i++){

            int stPoint = ranges[i][0];                         // 기준점 0 부터 몇번째있는지
            int edPoint = yPoints.size() + ranges[i][1];        // 기준점 Max값에서 - 몇칸갔는지

            if(stPoint >= edPoint || edPoint > ranges.length + 2){
                answer[i] = -1.0;
                continue;
            }
            double width = 0;

            for(int j = stPoint ; j<edPoint-1 ; j++){                
                width += sectionSize.get(j);                
            }
            answer[i] = width;
        }

        return answer;
    }
}