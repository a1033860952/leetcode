package leetcode_1_1000;

public class Leetcode_307 {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1,2);
        System.out.println(numArray.sumRange(0, 2));


    }
}

class NumArray {

    private int[] nums=null;
    public NumArray(int[] nums) {
        this.nums=nums;
    }

    public void update(int index, int val) {
        nums[index]=val;
    }

    public int sumRange(int left, int right) {
        int i=left;
        int result=0;
        while (i<=right){
            result+=nums[i];
            i++;

        }
        return result;
    }
}
