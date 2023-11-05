package leetcode_2000_3000;

public class leetcode_2525 {

    public static void main(String[] args) {
        System.out.println(categorizeBox(1,1,1,100));
    }

    public static String categorizeBox(int length, int width, int height, int mass) {
        long volume=1l*length*width*height;

        boolean isBulky=false;
        boolean isHeavy=false;

        if (length>=10000 || width>=10000 || height>=10000 || volume>=1000000000){
            isBulky=true;
        }

        if (mass>100){
            isHeavy=true;
        }

        if (isBulky && isHeavy){
            return "Both";
        }

        if (!isBulky && !isHeavy){
            return "Neither";
        }

        if (isBulky){
            return "Bulky";
        }

        return "Heavy";

    }



}
