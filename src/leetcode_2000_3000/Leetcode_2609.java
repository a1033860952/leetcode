package leetcode_2000_3000;

public class Leetcode_2609 {

    public int findTheLongestBalancedSubstring(String s) {

        int result = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            boolean isZero = true;
            int seriesZero = 0;
            int seriesOne = 0;
            while (isZero) {
                if (j==s.length()){
                    break;
                }
                if (charArray[j] == '0') {
                    j++;
                    seriesZero++;
                } else {
                    isZero = false;
                }
            }
            while (!isZero) {
                if (j==s.length()){
                    break;
                }
                if (charArray[j] == '1') {
                    j++;
                    seriesOne++;
                } else {
                    isZero = true;
                }
            }

            result = Math.max(result, Math.min(seriesOne, seriesZero) * 2);

        }

        return result;
    }
}
