import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by juzi on 2017/11/8.
 */
public class carNum {
    /*public static void main(String[] args) {
        String cph = "W12345";
        Pattern pattern = Pattern.compile("^[\u4e00-\u9fa5|WJ]{1}[A-Z0-9]{6}$");
        Matcher matcher = pattern.matcher(cph);
        if (!matcher.matches()) {
            System.out.println("车牌号格式不对！");
        } else {
            System.out.println("车牌号格式正确！");
        }
    }*/

    public static boolean isEmail(String str) {
        //String regex = "(?i)^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$";//不区分大小写
        String regex = "(?i)^[\\u4e00-\\u9fa5|WJ]{1}[A-Z0-9]{6}$";//不区分大小写
        str=str.replace(" ","");
        if (null==str || !match("^[\\u4E00-\\u9FA5A-Za-z0-9]+$",str)){
            System.out.println("77777777777777777");
            return false;
        }else if (str.length()==7){
            System.out.println(str.replace(" ","").length()+","+str);
            if ("京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼".contains(str.subSequence(0,1)) && !"0123456789".contains(str.subSequence(1,2))){
                System.out.println(str.subSequence(1,2)+"=========="+str.subSequence(0,1));
                String c=(String)str.subSequence(2,7);
                boolean result=match("[a-zA-Z]+",c);//判断是否为纯字母
                if (match("[a-zA-Z]+",c)){
                    System.out.println(c+","+result+"后5位不能为纯字母");
                    return false;
                }else {
                    System.out.println("符合");
                }
            }else {
                System.out.println("首位必须是地区简称或第二位是字母");
                return false;
            }
        }else {
            System.out.println("车牌号必须为7位");
            return false;
        }
        return match(regex, str);
    }

    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        //System.out.println("========="+matcher.matches());
        return matcher.matches();
    }

    public static void main(String[] args) {
        boolean car=carNum.isEmail("辽BH111港");
        System.out.print(car);
        //^((?!0000)[0-9]{4}-((0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])-(29|30)|(0[13578]|1[02])-31)|([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)-02-29)$
        /*String regex="^((?!0000)[0-9]{4}-((0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])-(29|30)|(0[13578]|1[02])-31)|([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)-02-29)$";
        String regev="^[0-9]{4}-(0?[0-9]|1[0-2])-(0?[1-9]|[12]?[0-9]|3[01])$";//yyyy-mm-dd yyyy-m-d
        boolean d=carNum.match(regev,"2017-2-90");
        if (!d){
            System.out.print("格式错误");
            return;
        }
        System.out.print("、正确");*/
        /*boolean special=match("^[\\u4E00-\\u9FA5A-Za-z0-9]+$","辽fH011");
        System.out.print(special);*/
    }
}