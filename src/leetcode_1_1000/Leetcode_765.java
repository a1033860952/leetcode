package leetcode_1_1000;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_765 {

    public int minSwapsCouples(int[] row) {

        int result = 0;
        //先挑选出待排序的值
        List<Integer> waitingHoldHands =new ArrayList<>();
        for (int i = 0; i < row.length; i=i+2) {
            if (row[i]-row[i+1]!=1 && row[i]-row[i+1]!=-1){
                waitingHoldHands.add(row[i]);
                waitingHoldHands.add(row[i+1]);
            }
        }


        List<Integer> recordSortedIndex=new ArrayList<>();
        //选择排序
        for (int i = 0; i < waitingHoldHands.size(); i=i+2) {
            Integer firstValue = waitingHoldHands.get(i);
            Integer secondValue = waitingHoldHands.get(i+1);
            if (firstValue-secondValue==1 && firstValue-secondValue==-1){
                continue;
            }

//            for (int j = i+1; j < waitingHoldHands.size()-1; j++) {
            for (int j = 0; j < waitingHoldHands.size()-1; j++) {
                if (j==i || recordSortedIndex.contains(j)){
                    continue;
                }

                Integer value = waitingHoldHands.get(j+1);
                if (firstValue-value==1 || firstValue-value==-1){
                    int tmp=value;
                    waitingHoldHands.set(j+1,firstValue);
                    waitingHoldHands.set(i,tmp);
                    recordSortedIndex.add(j+1);
                    if ((j+1)%2==0){
                        recordSortedIndex.add(j+2);
                    }else{
                        recordSortedIndex.add(j);

                    }
                    result++;
                    break;
                }
            }

        }

        return result;

    }


}
