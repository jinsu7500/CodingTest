package LV3;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 프로그래머스 LV3_표병합 : https://school.programmers.co.kr/learn/courses/30/lessons/150366 * 
 * <요구사항>
 * 1. "UPDATE r c value"    : (r,c) 위치에 있는 값을 value로 변경
 * 2. "UPDATE value1 value" : value1 -> value2 값으로 변경
 * 3. "MERGE r1 c1 r2 c2"   : (r1,c1) , (r2,c2) 병합
 *      ● 같은셀일경우 무시
 *      ● 선택한 두 셀은 서로 인접하지 않을 수도 있습니다. 이 경우 (r1, c1) 위치의 셀과 (r2, c2) 위치의 셀만 영향을 받으며, 그 사이에 위치한 셀들은 영향을 받지 않습니다
 *          ㄴ> 뭔소리야
 *      ● 둘중 하나만 값이 있을경우 그값으로, 둘다 있으면 (r1,c1)으로 셀병합
 *      ● (r1,c1) (r2,c2) 어느셀을 선택해도 병합된 셀로 접근 -> 병합되기전 데이터 보존
 * 4. "UMERGE r c" : (r,c) 위치의 셀을 선택, 해당셀의 모든 병합을 해제
 *      ● 선택한 셀이 포함한 모든셀을 초기화, 
 *      ● 병합을 해제하기 전 셀이 값을 가지고 있었을 경우 (r,c) 위치의 셀이 그값을 가지게됨
 * 
 * 5. "PRINT r c"   : (r,c) 위치의 셀을 선택하여 셀의 값을 출력, 비어있으면 "EMPTY" 출력
 * 
 * <제한사항> 
 * 
 * 참조 : Stream.collet null 리턴 참고 https://www.baeldung.com/stream-collect-returning-null
 * 
 */

public class MergeTables {
    public static final String UPDATE_COMMAND   = "UPDATE";
    public static final String MERGE_COMMAND    = "MERGE";
    public static final String UNMERGE_COMMAND  = "UNMERGE";
    public static final String PRINT_COMMAND    = "PRINT";

     public String[] solution(String[] commands) {
        List<String> printString = new ArrayList<>();        
        List<Cell> table = new ArrayList<>();

        for(String sCommandLs : commands)
        {
            StringTokenizer st = new StringTokenizer(sCommandLs);
            String sNowCommand = st.nextToken();
            switch(sNowCommand)
            {
                case UPDATE_COMMAND:
                    String r = st.nextToken();
                    String c = st.nextToken();
                    if(st.hasMoreTokens() == true)
                    {
                        String value = st.nextToken();
                        //updqte 호출) "UPDATE r c value"
                        table = update(Integer.parseInt(r)
                                      ,Integer.parseInt(c)
                                      ,value
                                      ,table);
                    }
                    else
                    {
                        //update2 호출) "UPDATE value1 value2"
                        table = update2(r, c, table);
                    }
                    break;
                case MERGE_COMMAND:
                    int r1 = Integer.parseInt(st.nextToken());
                    int c1 = Integer.parseInt(st.nextToken());
                    int r2 = Integer.parseInt(st.nextToken());
                    int c2 = Integer.parseInt(st.nextToken());
                    
                    table = merge(r1, c1, r2, c2, table);
                    break;
                case UNMERGE_COMMAND:
                    int r3 = Integer.parseInt(st.nextToken());
                    int c3 = Integer.parseInt(st.nextToken());
                    table = unmerge(r3, c3, table);
                    break;
                case PRINT_COMMAND:
                    int r4 = Integer.parseInt(st.nextToken());
                    int c4 = Integer.parseInt(st.nextToken());
                    printString.add(print(r4, c4, table));
                    break;
                default:
                    System.out.println("명령어 에러");
                    break;

            }
        }

        //배열로 변환 및 출력
        // String[] answer = printString.toArray(new String[printString.size()]);
        String[] answer = new String[printString.size()];
        int count = 0;
        for(String s : printString)
        {            
            answer[count] = s;
            count++;
        }
        return answer;
    }
    
    /**
     * 업데이트 메소드
     * @param r
     * @param c
     * @param value
     * @param table
     * @return table
     * ex) "UPDATE r c value"
     */
    public List<Cell> update(int r, int c , String value, List<Cell> table)
    {
        List<Cell> cellLs = new ArrayList<>();
        Cell cell = null;

        // Cell cell = (Cell) table.stream()
        //                         .filter(filterCell -> filterCell.getX() == r && filterCell.getY() == c);
        if(table.isEmpty() == false)
        {
            cellLs = table.stream()
                          .filter(filterCell -> filterCell.getX() == r && 
                                                filterCell.getY() == c)
                          .collect(Collectors.toList());
            if(cellLs.isEmpty() == false ) cell = cellLs.get(0);        //좌표중복은 없다고 가정
            else{
                // cell = new Cell(r, c, value);
            }            
        }
        
        //기존값 존재
        if(null != cell)
        {
            // System.out.println("cell X,Y : "  + cell.getX() + ","+ cell.getY() );
            // cell = new Cell(r, c, false, 0, 0, value, value);
            //병합체크
            if(cell.getIsMerged() == true)
            {
                int parentX = cell.parentX;
                int parentY = cell.parentY;
                //병합된 모든셀 탐색
                List<Cell> mergedCellLs =  table.stream()
                                                .filter(filterCell ->   filterCell.getParentX() == parentX &&
                                                                        filterCell.getParentY() == parentY    )
                                                .collect(Collectors.toList());
                
                //TODO: delte -> update 말고 리스트에서 바로수정 가능한지 체크!
                for(Cell updateCell : mergedCellLs)
                {
                    table.remove(updateCell);
                    updateCell.setValue(value);
                    table.add(updateCell);
                }
            }
            //기존값존재 & 병합 X            
            else
            {
                cell.setValue(value);
                cell.setOrg_value(value);
            }
        }
        //신규값
        else
        {            
            table.add(new Cell(r, c, false, 0, 0, value, value));
        }
        return table;   
    }


    /**
     * 업데이트2 메서드
     * @param value1
     * @param value2
     * @param table
     * @return table
     * ex) "UPDATE value1 value2"
     */
    public List<Cell> update2(String value1, String value2, List<Cell> table)
    {
        //변경할 모든셀 탐색
        List<Cell> updateCellLs =  table.stream()
                                        .filter(filterCell -> filterCell.getValue().equals(value1) == true)
                                        .collect(Collectors.toList());
        
        //TODO: delte -> update 말고 리스트에서 바로수정 가능한지 체크!
        for(Cell updateCell : updateCellLs)
        {
            table.remove(updateCell);
            updateCell.setValue(value2);
            updateCell.setOrg_value(value2);
            table.add(updateCell);
    }
        return table;
    }


    /**
     * MERGE 메서드 
     * @param r1
     * @param c1
     * @param r2
     * @param c2
     * @param table
     * @return table
     * EX) "MERGE r1 c1 r2 c2"
     */
    public List<Cell> merge(int r1, int c1, int r2, int c2, List<Cell> table)
    {
        List<Cell> leftCellLs = new ArrayList<>();
        List<Cell> rightCellLs = new ArrayList<>();
        Cell leftCell = null;
        Cell rightCell = null;
        String value = "";

        //값이 같을경우
        if(r1 == r2 && c1 == c2)
        {
            // System.out.println("머지값이 같음");
            return table;
        }
        // System.out.println(table.isEmpty());
         
        //테이블에 해당값 탐색
        leftCellLs = table.stream()
                        .filter(filterCell ->   filterCell.getX() == r1 &&
                                                filterCell.getY() == c1    )
                        .collect(Collectors.toList());
        if(leftCellLs.isEmpty() == false )
        {
            leftCell = leftCellLs.get(0);
        }  
        else
        {
            leftCell = new Cell(r1, c1, "");
        }

        //테이블에 해당값 탐색
        rightCellLs = table.stream()
                           .filter(filterCell ->  filterCell.getX() == r2 &&
                                                  filterCell.getY() == c2    )                                                     
                           .collect(Collectors.toList());

        if(rightCellLs.isEmpty() == false )
        {
            rightCell = rightCellLs.get(0);
        }
        else
        {
            rightCell = new Cell(r2, c2, "");
        }
        

        //둘다 값이 있는경우 (r1,c1)의 값으로 세팅
        if("".equals(leftCell.getValue()) == false && 
           "".equals(rightCell.getValue()) == false )           
        {
            value = leftCell.getValue();            
        }
        //둘중 하나만 값이 있는경우
        else if("".equals(leftCell.getValue()) == false || 
                "".equals(rightCell.getValue()) == false)
        {
            value = "".equals(leftCell.getValue()) ? rightCell.getValue() : leftCell.getValue();                        
        }
        //둘다 값이 없는경우
        else
        {
            value = "";
        }
        
        table = mergedChk(leftCell, rightCell, value, r1, c1, table);
        return table;
    }


    /**
     * 추가병합 체크 및 병합처리
     * @param leftCell
     * @param rightCell
     * @param value
     * @param value
     * @param 
     * @param table
     * @return List<Cell> table
     */
    public List<Cell> mergedChk(Cell leftCell, Cell rightCell,String value, int r1, int c1, List<Cell> table)
    {
        //병합된 셀 추가병합인지 체크
        if(leftCell.getIsMerged() == true || rightCell.getIsMerged() == true)
        {
            // System.out.println("둘중하나만있는경우의 추가병합값 : " + value);                
            int rightParentX = rightCell.parentX;
            int rightParentY = rightCell.parentY;

            //오른쪽 병합된셀이 없을경우
            if(rightCell.getIsMerged() == false)
            {
                table.remove(rightCell);
                rightCell.setParentX(leftCell.getParentX());
                rightCell.setParentY(leftCell.getParentY());
                rightCell.setValue(value);
                rightCell.setIsMerged(true);
                table.add(rightCell);
            }
             //오른쪽 병합된 모든셀 탐색
            else
            { 
                List<Cell> RightmergedCellLs =  table.stream()
                                                .filter(filterCell ->   filterCell.getParentX() == rightParentX &&
                                                                        filterCell.getParentY() == rightParentY    )
                                                .collect(Collectors.toList());
                //수정
                for(Cell updateCell : RightmergedCellLs)
                {
                    table.remove(updateCell);                        
                    updateCell.setParentX(leftCell.getParentX());
                    updateCell.setParentY(leftCell.getParentY());
                    updateCell.setValue(value);
                    updateCell.setIsMerged(true);
                    table.add(updateCell);
                }
            }
        }

        else
        {            
            // System.out.println("최초 병합값 : " + value);

            table.remove(leftCell);
            table.remove(rightCell);

            leftCell.setIsMerged(true);
            rightCell.setIsMerged(true);

            leftCell.setValue(value);
            rightCell.setValue(value);

            leftCell.setParentX(r1);
            leftCell.setParentY(c1);

            rightCell.setParentX(r1);
            rightCell.setParentY(c1);

            table.add(leftCell);
            table.add(rightCell); 
        }        
        return table;
    }



    /**
     * 표 병합 해제 메서드
     * @param r
     * @param c
     * @param table
     * @return List<Cell> table
     * EX) "UNMERGE 1 4"
     */
    public List<Cell> unmerge(int r, int c, List<Cell> table)    
    {
        Cell selectedCell = null;
        List<Cell> selectedCellLs = table.stream()
                                         .filter(filterCell  ->  filterCell.getX() == r &&
                                                                 filterCell.getY() == c    )
                                         .collect(Collectors.toList());

        if(selectedCellLs.isEmpty() == false)
        {            
            selectedCell = selectedCellLs.get(0);

            if(selectedCell.getIsMerged() == true)
            {
                int parentX = selectedCell.getParentX();
                int parentY = selectedCell.getParentY();

                //병합된 모든셀 탐색
                List<Cell> mergedCellLs =  table.stream()
                                                .filter(filterCell ->   filterCell.getParentX() == parentX &&
                                                                        filterCell.getParentY() == parentY    )
                                                .collect(Collectors.toList());
                
                //기존값 삭제
                for(Cell updateCell : mergedCellLs)
                {
                    table.remove(updateCell);               
                    

                }

                //병합해제된 셀 추가
                selectedCell.setIsMerged(false);
                selectedCell.setValue(selectedCell.getValue());
                selectedCell.setParentX(0);
                selectedCell.setParentY(0);
                table.add(selectedCell);
            }
            
            
        }  
        else
        {
            System.out.println("unmerger 에러, 셀을 찾지못함");
        }
        return table;
    }

    /**
     * 출력함수
     * @param r
     * @param c
     * @param table
     * @return String printString
     */
    public String print(int r, int c , List<Cell> table)
    {
        String printString = "EMPTY";
        Cell selectedCell = null;
        List<Cell> selectedCellLs = table.stream()
                                         .filter(filterCell  ->  filterCell.getX() == r &&
                                                                 filterCell.getY() == c    )
                                         .collect(Collectors.toList());

        if(selectedCellLs.isEmpty() == false )
        {
            selectedCell = selectedCellLs.get(0);
            if("".equals(selectedCell.getValue()) == false) 
            {
                printString = selectedCell.getValue();    
            }
            
        }       
        System.out.println(printString);
        return printString;
    }

/****************************************Data Class Cell ***************************************************************/
    public class Cell
    {
        private int x;
        private int y;
        private boolean isMerged = false;
        private int parentX;
        private int parentY;
        private String value;
        private String org_value;

        /***********************getter_setter *******************************/
        public int getX() {
            return this.x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return this.y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public boolean getIsMerged() {
            return this.isMerged;
        }

        public void setIsMerged(boolean isMerged) {
            this.isMerged = isMerged;
        }

        public int getParentX() {
            return this.parentX;
        }

        public void setParentX(int parentX) {
            this.parentX = parentX;
        }

        public int getParentY() {
            return this.parentY;
        }

        public void setParentY(int parentY) {
            this.parentY = parentY;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getOrg_value() {
            return this.org_value;
        }

        public void setOrg_value(String org_value) {
            this.org_value = org_value;
        }

        /***********************Constructor *******************************/        
        public Cell(int x, int y , boolean isMerged, int parentX, int parentY, String value, String org_value)
        {
            this.x = x;
            this.y = y;
            this.isMerged = isMerged;
            this.parentX = parentX;
            this.parentY = parentY;
            this.value = value;
            this.org_value = org_value;
        }

        public Cell(int x, int y, String value) 
        {
            this.x = x;
            this.y = y;
            this.value = value;
        }
        
    }
}