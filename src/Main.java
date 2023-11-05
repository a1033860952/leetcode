import leetcode_1_1000.Leetcode_187;
import leetcode_2000_3000.Leetcode_2003;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {

    /**
     * leetcode 准则
     * 1.每月有三次补卡机会，如果超过了不能补卡
     * 2.如果在做题时候，比如最后一天的时候，写了超过3小时还没写出来，可以暂时复制已有的算法
     * 3，或者这个月已经超过3天了，且写了超过3小时（或者不可抗力，比如加班之类的），可与这哪是复制已有的算法
     * 4、但是还是要给老姐钱，且后续需要补回来
     * @param args
     */
    public static void main(String[] args) {

        int[][] test={{0,2},{0,5},{2,4},{1,6},{5,4}};
        int[] test2={-1,0,3,5,9,12};
        String[] test1={"1313579440F2036","2921522980M5644"};
        String testStr="AAAAAAAAAAA";



        int[] parent=new int[]{-1,0,1,0,3,3};
        int[] nums=new int[]{5,4,6,2,1,3};


        Leetcode_2003 leetcode_2003=new Leetcode_2003();
        System.out.println(Arrays.toString(leetcode_2003.smallestMissingValueSubtree(parent, nums)));
    }

    public static int countPoints(String rings) {
        Map<Integer, HashSet<Character>> resultMap=new HashMap<>();
        int length = rings.length();
        for (int i=0,j=2;j<=length;i=i+2,j=j+2){
            String substring = rings.substring(i, j);
            int ringNum=Integer.parseInt(String.valueOf(substring.charAt(1)));
            HashSet<Character> hashSet = resultMap.get(ringNum) == null ? new HashSet<>() : resultMap.get(ringNum);
            hashSet.add(substring.charAt(0));
            resultMap.put(ringNum,hashSet);
        }

        int resultCount=0;
        for (HashSet<Character> hashSet : resultMap.values()) {
            if (hashSet.size()==3) {
                resultCount++;
            }
        }
        return resultCount;

    }


    public static int search(int[] nums, int target) {
        int length = nums.length;
        int mid=length/2;
        int left=0;
        int right=length-1;
        return dichotomySearch(nums, left, mid, right,target);

    }

    private static int dichotomySearch(int[] nums,int left,int mid,int right,int target){
        int midValue = nums[mid];
        int leftValue = nums[left];
        int rightValue = nums[right];
        if (midValue==target){
            return mid;
        }

        if (left>=mid || mid >=right){
            return -1;
        }

        if (midValue<=target){
            return dichotomySearch(nums,mid,(right+mid)/2,right,target);
        }

//        midValue>=target
        return dichotomySearch(nums, left, (left + mid) / 2, mid, target);


    }
















}


