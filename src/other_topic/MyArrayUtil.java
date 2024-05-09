package other_topic;


/**
 * @author tianling
 * @description:
 * @since 2024/4/28
 */
public class MyArrayUtil {

    public static int[][] stringTo2DArray(String input) {
        // 去除字符串中的空格和方括号
        input = input.replaceAll("\\s", "").replace("[[", "").replace("]]", "").replace("[", "");
        // 按逗号分割字符串获取每个子数组
        String[] arrays = input.split("],");
        // 创建二维数组
        int[][] result = new int[arrays.length][];
        for (int i = 0;i < arrays.length;i++) {
            // 分割每个子数组获取数字
            String[] numbers = arrays[i].split(",");
            // 创建子数组
            int[] subArray = new int[numbers.length];
            for (int j = 0;j < numbers.length;j++) {
                // 将数字转换为整数
                subArray[j] = Integer.parseInt(numbers[j]);
            }
            // 将子数组放入二维数组
            result[i] = subArray;
        }
        return result;
    }
}
