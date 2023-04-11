/**
 * 프로그래머스 LV3_불량 사용자 : https://school.programmers.co.kr/learn/courses/30/lessons/64064
 */
package LV3;


import java.util.*;
import java.util.regex.Pattern;

public class BannedUser {
    // public int solution(String[] user_id, String[] banned_id) {
    //     /*
    //      * banned_id배열이 주어질떄, user_id로 조합할수 있는 모든 경우의 수를 찾아야됨
    //      * ㄴ> 중복은 카운트 X          
    //     */
    //     int answer = 1;
    //     int[] answerArr = new int[banned_id.length];
    //     boolean[] visit = new boolean[user_id.length];


    //     for(int i = 0 ; i< banned_id.length ; i++){
    //         int count = 0;
    //         boolean countBool = false;            
    //         for(int j = 0 ; j< user_id.length ; j++){
    //             countBool = isEqual(banned_id[i], user_id[j]);
    //             if(countBool){
    //                 count++;                    
    //             }
    //         }

    //         //count에 중복제거 및 고유값 확인이 필요함!!
    //         answerArr[i] = count;
            
    //         System.out.println("***********************");
    //         System.out.println("i : " + i);
    //         System.out.println("count : " + count);
    //         System.out.println("***********************");
    //     }


    //     //계산
    //     for(int i = 0 ; i<answerArr.length ; i++){
    //         if(answerArr[i] != 0){
    //             answer = answer * answerArr[i];
    //         }
    //     }
    //     System.out.println("answer : " + answer);

    //     return answer;
    // }

    // //문자열 같은지 검사하는 함수
    // public boolean isEqual(String banned_id, String user_id){
    //     boolean isEqual = false;
    //     if(user_id.length() != banned_id.length()){
    //         return isEqual;
    //     }            
        
    //     for(int i = 0 ; i<user_id.length();i++){
    //         // *별나오면 예외 
    //         if(banned_id.charAt(i) == '*')
    //             continue;
            
    //         if(user_id.charAt(i) != banned_id.charAt(i)){                
    //             return isEqual;
    //         }               
            
    //     }        
    //     isEqual = true;
    //     return isEqual;
    // }


    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        //유저id만큼 Ban가능여부 체크
        Boolean[] bCanBanned = new Boolean[user_id.length];
        
        //밴당할수있는 유저id 케이스관리
        ArrayList<ArrayList<String>> bannedCase = new ArrayList<>();        

        Arrays.fill(bCanBanned,false);

        //banid와 userid를 비교해서 ban가능여부 확인 배열 입력
        for(int i = 0 ; i< banned_id.length ; i++){    
            ArrayList<String> bannedId = new ArrayList<>(); 

            boolean isBan = false;
            for(int j = 0 ; j< user_id.length ; j++){
                isBan = isEqual(banned_id[i], user_id[j]);
                if(isBan){
                    bCanBanned[j] = true;
                    bannedId.add(user_id[j]);
                }                        
            }
            bannedCase.add(bannedId);
        }
        
        //경우의수 조합 계산
    //    answer = calCase2(bannedCase,banned_id.length,user_id);
       answer = calCase3(bannedCase,banned_id.length,user_id);
       
       
       
       return answer;
    }

    public static HashSet<HashSet<String>> answerSet = new HashSet<>();
    public int calCase3(ArrayList<ArrayList<String>> bannedCase, int bannedCount,String[] user_id){
        int depth = bannedCount-1;
        HashSet<String> innerSet = new HashSet<>();
        int[] indexArr = new int[bannedCount];          
        Arrays.fill(indexArr, 0);
          
        while(true){  
            Boolean isLastTerm = false;
            innerSet = new HashSet<>();  
            int setCount = 0;
            for(int i = 0 ; i< bannedCount ; i++){
                innerSet.add(bannedCase.get(i).get(indexArr[i]));
                setCount++;
                System.out.println("now 탐색값 : " + bannedCase.get(i).get(indexArr[i]));
            }
            System.out.println("사이클 종료 ");

            if(innerSet.size() == bannedCount){
                answerSet.add(innerSet);
            }
            
            //말단++
            indexArr[bannedCount-1]++;

            //말단의말단까지 오면 depth감소 
            // 상위까지 다돌았는지 확인
             System.out.println("indexArr's depth " + indexArr[depth]);
             System.out.println("bannedCase " + bannedCase.get(depth).size());
             
             for(int i = depth ; i < bannedCount; i++){
                int maxCount = bannedCase.get(depth).size();
                if(indexArr[i] >= maxCount-1  ){
                    isLastTerm = true;
                }
                else{
                    isLastTerm = false;
                    break;
                }
             }
            if(indexArr[bannedCount-1] == bannedCase.get(bannedCount-1).size() 
               && setCount == bannedCount
               && indexArr[depth]+1 >= bannedCase.get(depth).size()
               && isLastTerm
              ){
                depth--;
                indexArr[depth]++;
                setCount = 0;
                //하위뎁스 초기화
                for(int i = depth+1 ; i< bannedCount; i++){
                    indexArr[i] = 0;
                }                
            }
            //
            else if (indexArr[bannedCount-1] >= bannedCase.get(bannedCount-1).size()){
                indexArr[depth]++;
                //하위뎁스 초기화
                for(int i = depth ; i< bannedCount; i++){
                    indexArr[i]++;

                    //범위벗어난거 수정
                    if(indexArr[i] > bannedCase.get(i).size() && i != (bannedCount-1)){
                        indexArr[i] = bannedCase.get(i).size()-1;        
                    }
                    else if(indexArr[bannedCount-1] >= bannedCase.get(bannedCount-1).size() && i == bannedCount-1){
                        indexArr[bannedCount-1] = 0;
                    }
                } 
            }
        }



        
    }


















    
    //문자열 같은지 검사하는 함수
    public boolean isEqual(String banned_id, String user_id){
        boolean isEqual = false;
        if(user_id.length() != banned_id.length()){
            return isEqual;
        }            
        
        for(int i = 0 ; i<user_id.length();i++){
            // *별나오면 예외 
            if(banned_id.charAt(i) == '*')
                continue;
            
            if(user_id.charAt(i) != banned_id.charAt(i)){                
                return isEqual;
            }               
        }        
        isEqual = true;
        return isEqual;
    }



    public int calCase2(ArrayList<ArrayList<String>> bannedCase, int bannedCount,String[] user_id){
        
        HashSet<ArrayList<String>> answerHashSet = new HashSet<>();
        ArrayList<Stack<String>> stackArrList = new ArrayList<>();

        //push stack
        for(int i = 0 ; i<bannedCount; i++ ){
            int bannedCaseSize = bannedCase.get(i).size();
            Stack<String> stack = new Stack<>();
            for(int j = 0 ; j <bannedCaseSize; j++){
                stack.push(bannedCase.get(i).get(j));
            }
            stackArrList.add(stack);
        }


        while(true){
            ArrayList<Stack<String>> sample = (ArrayList<Stack<String>>) stackArrList.clone();

            HashSet<String> dupChkSet = new HashSet<>();
            ArrayList<String> answerArrList = new ArrayList<>();        
            //depth
            for(int i = 0 ; i <bannedCount; i++){
                String nowBannedUserId = sample.get(i).peek();
                if(dupChkSet.contains(nowBannedUserId)){
                    sample.get(i).pop();
                    // i--;
                    continue;
                    
                }
                else{
                    answerArrList.add(nowBannedUserId);                    
                    dupChkSet.add(nowBannedUserId);
                    // sample.get(i).pop();
                }               
            }
            Collections.sort(answerArrList);
            answerHashSet.add(answerArrList);            
        }
    }




    /**
     * @param bannedCase : 모든 경우의수가 담긴 2차원 List
     * @param bannedCount : 밴당한 유저ID 갯수 (banned_id.size)
     * @param  String[] user_id : 유저id 배열
     * 
     */
    public int calCase(ArrayList<ArrayList<String>> bannedCase, int bannedCount,String[] user_id){
        


        // //j: 외부 경우의수
        // for(int j = 0 ; j<bannedCase.size();j++){
            //초기화
            ArrayList<String> test = new ArrayList<>();
            int index = 0;
            //중복계산
            HashMap<String,Integer> chkDupMap = new HashMap<>();        
            for(int dupchkIndex = 0 ; dupchkIndex<user_id.length ; dupchkIndex++){
                chkDupMap.put(user_id[dupchkIndex],chkDupMap.getOrDefault(user_id[dupchkIndex], 0) +1);  
            }

            // test.add("frodo");
            // chkDupMap.put("frodo", chkDupMap.getOrDefault("frodo", 0) +1);

            //경우의수 탐색 스타트 -> 확장이 안됨, 단순 중복체크만 하는로직임
            for(int i = 0 ; i < bannedCount ; i++){
                // System.out.println(i + "번째 밴유저리스트");
                // System.out.println(bannedCase.get(i));
                String testString = bannedCase.get(i).get(index);   //frodo
                // System.out.println(chkDupMap.get(testString));
                if(chkDupMap.get(testString) != 1){
                    //중복일경우 다음arr탐색
                    i--;
                    index++;
                    continue;
                }
                else{
                    //중복체크
                    chkDupMap.put(testString,chkDupMap.getOrDefault(testString, 0) +1);     
                    //index 초기화
                    index = 0;                       
                }
                test.add(testString);          
            }
            System.out.println(test);
        return 0;
    }


    // private static boolean[] visited;
    // private static HashSet<String> set = new HashSet<>();

    // public void dfs(String[] user_id, String[] banned_id, int idx, String str){

    //     // if (idx == banned_id.length){
    //     //     StringBuilder sb = new StringBuilder("");

    //     //     for (int i = 0; i < visited.length; i++) {

    //     //         if (visited[i]) sb.append(user_id[i]);
    //     //     }

    //     //     if (!set.contains(sb.toString())) set.add(sb.toString());

    //     //     return;
    //     // }

    //     // for (int i = 0; i < user_id.length; i++) {
    //     //     String user = user_id[i];

    //     //     if (isEqual(str, user)){
    //     //         continue;
    //     //     } 
    //     //     if(visited[i]){
    //     //         continue;
    //     //     }
    //     //     visited[i] = true;
    //     //     dfs(user_id,banned_id,idx+1,str+user);
    //     //     visited[i] = false;
                
    //     // }

    //     if (idx == banned_id.length) {

    //         StringBuilder sb = new StringBuilder("");

    //         for (int i = 0; i < visited.length; i++) {

    //             if (visited[i]) sb.append(user_id[i]);
    //         }

    //         if (!set.contains(sb.toString())) set.add(sb.toString());

    //         return;
    //     }

    //     String ban = banned_id[idx];

    //     String regex = ban.replace("*", ".");

    //     for (int i = 0; i < user_id.length; i++) {

    //         String user = user_id[i];

    //         if (!user.matches(regex)) continue;

    //         if (regex.length() != user.length()) continue;

    //         if (visited[i]) continue;

    //         visited[i] = true;
    //         dfs(user_id,banned_id,idx+1,str+user);
    //         visited[i] = false;
    //     }
    // }
    


    private String[] userId;
    private String[] bannedRegex;
    private boolean[] checked;
    private HashSet<HashSet<Integer>> resultSet;

    public int solution_final(String[] user_id, String[] banned_id) {
        userId = user_id;
        checked = new boolean[user_id.length];
        resultSet = new HashSet<>();
        bannedRegex = new String[banned_id.length];
        for (int i = 0; i < banned_id.length; i++) {
            bannedRegex[i] = banned_id[i].replace("*", ".");
        }
        dfs(0, new HashSet<>());
        return resultSet.size();
    }

    private void dfs(int index, HashSet<Integer> set) {
        // 가장깊이 들어가서 더 탐색할 bannedRegex가 없다면 HashSet의 결과를 넣는다.
        if (index == bannedRegex.length) {
            resultSet.add(set);
            return;
        }
        // 유저의 길이 만큼 탐색한다.
        for (int i = 0; i < userId.length; i++) {
            // bannedId의 조건에 userId가 만족할 경우 그리고 유저아이디가 한번도 탐색하지 않았을 경우
            if (Pattern.matches(bannedRegex[index], userId[i]) && !checked[i]) {
                // 해당 유저는 탐색을 해본 경우이므로 체크
                checked[i] = true;
                // set에 탐색을 한 경우를 추가한다.
                set.add(i);
                // banned_id를 한칸 더 들어가서 탐색한다.
                dfs(index + 1, new HashSet<>(set));

                // 해당 유저보다 깊은 곳은 탐색을 마쳤으므로
                // 다시 돌아가서 다음 유저를 탐색하기 위해 checked 배열 과 Hashset을 초기화한다.
                checked[i] = false;
                set.remove(i);
            }
        }
    }


    
}





    
