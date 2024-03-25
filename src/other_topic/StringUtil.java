package other_topic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tianling
 * @description:
 * @since 2024/3/23
 */
public class StringUtil {
    public static List<List<String>> convertToNestedList(String[][] array) {
        return Arrays.stream(array)
                .map(strings -> Arrays.stream(strings).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
