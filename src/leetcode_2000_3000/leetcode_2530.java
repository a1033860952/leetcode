package leetcode_2000_3000;

public class leetcode_2530 {

    public static void main(String[] args) {
        int [] single = {1,10,3,3,3};
        System.out.println(maxKelements(single, 3));
    }

    public static long maxKelements(int[] nums, int k) {
        long sum=0;
        heapify(nums);

        for (int i = 0; i < k; i++) {
            double doubleNum=nums[0];
            sum+=nums[0];
            nums[0]=(int)Math.ceil(doubleNum / 3);
            realSink(nums,0);
        }


        return sum;


    }

    private static void heapify(int[] nums){
        //倒着来，先比较左右节点的大小，再判断上下节点的大小，然后不停的往下循环

        //一颗树，不是叶子节点的永远只有一半，堆本身都是要有左右叶子的；从后往前能先保证后面的堆是由有效的最大堆
        for (int i = nums.length/2-1; i >= 0; i--) {
            realSink(nums, i);
        }
    }


    private static void realSink(int[] nums,int i){
        int length = nums.length;
        //获取i节点的左子树

        //当此节点还有左子树时，说明可以继续下沉
        while(i*2+1<length){
            int maxLocation=i*2+1;
            //判断是否存在右子树，且如果右子树比左子树大  则更改最大叶子节点位置
            if (i*2+2<length && nums[i*2+1]<nums[i*2+2]){
                maxLocation=i*2+2;

            }
            //当左右子树都小于此节点的时候，说明已经下沉到改到的位置了
            if (nums[i]>nums[maxLocation]){
                break;
            }

            swap(nums,i,maxLocation);
            i=maxLocation;
        }


    }




    private static void swap(int[] nums, int i, int j) {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }


}
