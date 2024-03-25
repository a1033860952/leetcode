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
        String[][] array = {{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
        leetcode332.findItinerary(new LinkedList<>(StringUtil.convertToNestedList(array)));

    }


    private List<String> pathList;

    private List<String> resultList;

    private boolean[] isUsed;

    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort(Comparator.comparing(a -> a.get(1)));
        pathList=new LinkedList<>();
        resultList=new LinkedList<>();
        isUsed=new boolean[tickets.size()];


        return resultList;
    }


    private boolean backTracking(List<List<String>> tickets,String startLocation){
        if (pathList.size()==tickets.size()+1){
            resultList=new LinkedList<>(pathList);
            return true;
        }


        for (int i = 0; i < tickets.size(); i++) {
            // 如果已经被使用了，则直接返回false
            if (isUsed[i]){
                continue;
            }
            List<String> ticket = tickets.get(i);
            if (ticket.get(0).equals(startLocation)) {
                pathList.add(ticket.get(1));
                isUsed[i]=true;
                if (backTracking(tickets,ticket.get(1))) {
                    return true;
                }

                pathList.remove(pathList.size()-1);
                isUsed[i]=false;
            }
        }

        return false;

    }




}
