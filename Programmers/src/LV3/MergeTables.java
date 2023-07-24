package LV3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
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
        String[] answer = {};
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
                    break;
                case UNMERGE_COMMAND:
                    break;
                case PRINT_COMMAND:
                    break;
                default:
                    System.out.println("에러");
                    break;

            }
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
        }
        

        //기존값 존재
        if(null != cell)
        {
            System.out.println("cell X,Y : "  + cell.getX() + ","+ cell.getY() );
            // cell = new Cell(r, c, false, 0, 0, value, value);
            //병합체크
            if(cell.isMerged == true)
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
     * 업데이트 메서드2 
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

        public boolean isIsMerged() {
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


