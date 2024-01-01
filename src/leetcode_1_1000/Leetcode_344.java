package leetcode_1_1000;

public class Leetcode_344 {

    public static void main(String[] args) {
        Leetcode_344 leetcode344=new Leetcode_344();
        char[] chars = {'h','e','l','l','o'};
        leetcode344.reverseString(chars);


    }



    public void reverseString(char[] s) {
        int leftLocation=0;
        int rightLocation=s.length-1;

        while (leftLocation<rightLocation){
            char tmp = s[leftLocation];
            s[leftLocation]=s[rightLocation];
            s[rightLocation]=tmp;

            leftLocation++;
            rightLocation--;

        }
    }


}
