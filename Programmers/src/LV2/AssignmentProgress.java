package LV2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * <알고리즘 스터디 46회차 2023.06.15>
 *  LV2 과제진행하기 : https://school.programmers.co.kr/learn/courses/30/lessons/176962
 */

public class AssignmentProgress {


    // 우선순위큐 사용하기위해 Comparable 인터페이스 상속
    // Comparable 관련 정의  : https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html#method.summary
    public class Plan implements Comparable<Plan>
    {
        String name;
        int start;
        int playtime;

        public Plan(String name, int start, int playtime)
        {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }

        //우선순위큐를 Plan클래스로 사용하기위해 compareTo메소드 오버라이딩
        @Override
        public int compareTo(Plan target)
        {
            return this.start >= target.start ? 1 : - 1;    //시작시간이 작은 순으로 정렬
        }
    }

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Stack<HashMap<String,Integer>> stopStack = new Stack<>();

        //-> 문제에서 주어진 시간이 정렬되지 않을수도 있다고 명시했음, 우선순위 큐로 변경
        // List<Plan> PlanLS = new ArrayList<>();
        PriorityQueue<Plan> PlanLS = new PriorityQueue<>();
        
        //plans 길이만큼 루프        
        for(int plansIDX = 0 ; plansIDX < plans.length ; plansIDX++)
        {
            String name  = plans[plansIDX][0];
            int start    = hourToMiniute(plans[plansIDX][1]);
            int playtime = Integer.parseInt(plans[plansIDX][2]);
            
            //plan 구조체 생성
            Plan plan = new Plan(name, start, playtime);

            //PlanLs 생성
            PlanLS.add(plan);
        }

        //과제진행
        while(PlanLS.isEmpty() == true || stopStack.isEmpty() == true)
        {               
            //현재 과제 정보 추출
            String name   = PlanLS.peek().name;
            int startTime = PlanLS.peek().start;
            int playTime  = PlanLS.peek().playtime;
            PlanLS.poll();

            //현재 진행중인 과제가 다음 과제 시작전에 안끝날 경우
            if(startTime + playTime >= PlanLS.peek().start)
            {
                
            }
        }
        return answer;
        
    }

    /**
     * HH:MM 타입을 정수형 인트로 변경해주는 함수
     * @param arr
     * @return
     */
    public int hourToMiniute(String arr){
        int iTime = 0;

        int ihour = Integer.parseInt(arr.replace(":", "").substring(0, 2));
        int iminute = Integer.parseInt(arr.replace(":", "").substring(2, 4));        
        System.out.println("hour : " + ihour);
        System.out.println("minute : " + iminute);

        iTime = (ihour * 60) + iminute;
        System.out.println("iTime : " + iTime);
        return iTime;
    }
}
