package leetcode_1_1000;

import other_topic.StringUtil;

import java.util.*;

/**
 * @author tianling
 * @description:
 * @since 2024/3/22
 */
public class Leetcode_332 {


    public static void main(String[] args) {
        Leetcode_332 leetcode332=new Leetcode_332();
        // String[][] array = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        // String[][] array = {{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
        // String[][] array = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        String[][] array = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","JFK"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"}};
        leetcode332.findItinerary(new LinkedList<>(StringUtil.convertToNestedList(array)));

    }


    private List<String> pathList;

    private List<String> resultList;

    private Map<String,List<String>> map;
    private int total;

    public List<String> findItinerary(List<List<String>> tickets) {
        // tickets.sort(Comparator.comparing(a -> a.get(1)));
        pathList=new LinkedList<>();
        resultList=new LinkedList<>();
        map=new HashMap<>();
        total=tickets.size()+1;

        for (List<String> ticket : tickets) {
            add(ticket.get(0),ticket.get(1));
        }
        pathList.add("JFK");

        backTracking("JFK");
        return resultList;
    }






    private boolean backTracking(String startLocation){
        if (pathList.size()==total){
            resultList=new LinkedList<>(pathList);
            return true;
        }
        List<String> ticketList = map.get(startLocation);
        if (ticketList==null || ticketList.isEmpty()){
            return false;
        }
        int size = ticketList.size();

        // 这里面会有个问题，比如有非常多的重复机票，我们回溯的时候可能重复机票递归的情况，这样会超时的
        // 所以我们在同一层的时候，用一个set来存储下，如果这个机票之前已经有人走过了，且无法走通的情况下，则后面的机票就不用再重复了

        Set<String> repeatSet=new HashSet<>();
        for (int i = 0; i < size; i++) {
            String ticketEnd = ticketList.get(i);
            // 避免重复机票
            if (repeatSet.contains(ticketEnd)){
                continue;
            }
            repeatSet.add(ticketEnd);

            pathList.add(ticketEnd);
            ticketList.remove(i);
            if (backTracking(ticketEnd)) {
                return true;
            }
            pathList.remove(pathList.size()-1);
            ticketList.add(i,ticketEnd);
        }

        return false;

    }


    private void add(String key,String value){
        List<String> valueList = map.get(key);
        if (valueList==null){
            valueList=new LinkedList<>();
            valueList.add(value);
            map.put(key,valueList);
        }else{
            // valueList.add(value);
            int size = valueList.size();
            for (int i = 0; i < size; i++) {
                if (valueList.get(i).compareTo(value)>0){
                    valueList.add(i,value);
                    return;
                }
            }
            valueList.add(valueList.size(),value);

        }


    }






}
