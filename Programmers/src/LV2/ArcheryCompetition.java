package LV2;

/**
 * 라이언 : 전 우승자 -> 패널티
 * 어피치 : 도전자
 * 1. 어피치가 다쏜뒤 라이언이 쏨
 * 2. 점수판은 0점~10점 , 총 11가지
 * 
 * 각 점수라인(K)에 더 많이 맞춘 선수가 K점을 가저감, a=b일경우 어피치가 가짐
 * 최종점수가 높은쪽이 우승, 같을경우 어피치가 우승
 * 어피치가 다 쏜상황, 라이언이 가장 큰 차이로 이기기 위해서는?
 * 
 * 
 * param : 
 *          화살의 개수 N
 *          어피치가 이미 쏜 10점부터 0점까지 순서대로 담은 배열 info
 * return : 가장 큰점수로 이기기위한 10점~0점순서 정수배열, 못이기면 -1리턴
 * 
 * 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 
 * 가장 낮은 점수를 더 많이 맞힌 경우를 return
 * 
 */
public class ArcheryCompetition {
     public int[] solution(int n, int[] info) {

        int sum = 0;
        for(int i=0; i<info.length; i++){
            if(info[i] != 0) 
            {
                sum += (10-i);
            }
        }
        int[] answer = {};
        return answer;
    }
    
}
