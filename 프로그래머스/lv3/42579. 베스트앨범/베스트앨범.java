import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> totalCount = new HashMap<>();        
        HashMap<String,HashMap<Integer,Integer>> doubHashMap = new HashMap<>();      

        String[][] fullDataArr = new String[genres.length][3];

        //input
        for(int i = 0 ; i < genres.length ; i++){
            //장르별 총 재생횟수맵 입력
            totalCount.put(genres[i], totalCount.getOrDefault(genres[i], 0) + plays[i]);       
            
            //fullData 입력
            fullDataArr[i][0] = String.valueOf(i);          //고유번호
            fullDataArr[i][1] = genres[i];                  //장르
            fullDataArr[i][2] = String.valueOf(plays[i]);   //재생횟수            
        }

        //장르별 Distinct만큼반복, -> 여기서 내림차순 정렬해봐야 의미없음
        for(String key : totalCount.keySet()){            
            HashMap<Integer,Integer> playsMap = new HashMap<>();

            for(int i = 0 ; i<genres.length; i++){
                
                //key값과 같은 장르만 판별
                // if(fullDataArr[i][1] == key){ -> 프로그래머스에서 못읽음
                if(key.equals(fullDataArr[i][1]) ){
                    
                    playsMap.put(Integer.parseInt(fullDataArr[i][0]),Integer.parseInt(fullDataArr[i][2]));
                    
                    //key: 재생횟수, value 고유번호 -> 자동정렬됨, 써먹을수 있을듯?
                    //ㄴ> 재생횟수가 유니크하지않아서 안됨
                    // playsMap.put(Integer.parseInt(fullDataArr[i][2]),Integer.parseInt(fullDataArr[i][0]));
                }
            }
            doubHashMap.put(key, playsMap);
        }      
        
        //출력
        ArrayList<Integer> answer = new ArrayList<>();
        
        //doubleHashmap 내림차순 정렬,
        //정렬방법 검색하여 참고함
        List<String> totalCoutnDescList = new ArrayList<>(totalCount.keySet());
        Collections.sort(totalCoutnDescList, (value1, value2) -> (totalCount.get(value2).compareTo(totalCount.get(value1))));        

        for(String doubleKey : totalCoutnDescList){
            HashMap<Integer,Integer> playsMap = doubHashMap.get(doubleKey); // playsMap.
            
            //playsMap 정렬 (Sort by value) Value 값으로 내림차순 정렬            //정렬방법 검색하여 참고함
            List<Integer> listKeySet = new ArrayList<>(playsMap.keySet());
            Collections.sort(listKeySet, (value1, value2) -> (playsMap.get(value2).compareTo(playsMap.get(value1))));
            int count = 0;
            
            for(Integer keykey : listKeySet) {                
                answer.add(keykey);
                count++;
                //상위 두곡만 입력
                if(count > 1 )
                    break;
            }  
        }        
        int[] answerArr = new int[answer.size()];
        for(int i = 0 ; i< answer.size() ; i++){
            answerArr[i] = answer.get(i);
        }
        return answerArr;
    }
}