package other_topic;

import javax.print.attribute.PrintJobAttributeSet;

/**
 * @author tianling
 * @description:
 * @since 2024/1/22
 */
public class LCU_182 {


    public static void main(String[] args) {
        LCU_182 lcu182=new LCU_182();
        System.out.println(lcu182.dynamicPassword("lrloseumgh", 6));

    }

    public String dynamicPassword(String password, int target) {
        String substring = password.substring(0, target);
        return (password+substring).substring(target);
    }

}
