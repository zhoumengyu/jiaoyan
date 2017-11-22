import java.util.HashMap;
import java.util.Map;

/**
 * Created by juzi on 2017/11/8.
 */
public class Vin {
    /*public static Map<Character, Integer> kv = new HashMap<Character, Integer>();//对应值

    public static Map<Integer, Integer> wv = new HashMap<Integer, Integer>();//加权值

    static {

        for (int i = 0; i < 10; i++) {

            kv.put(String.valueOf(i).charAt(0), i);
        }

        kv.put('a', 1);
        kv.put('b', 2);
        kv.put('c', 3);
        kv.put('d', 4);
        kv.put('e', 5);
        kv.put('f', 6);
        kv.put('g', 7);
        kv.put('h', 8);
        kv.put('j', 1);
        kv.put('k', 2);
        kv.put('l', 3);
        kv.put('m', 4);
        kv.put('n', 5);
        kv.put('p', 7);
        kv.put('q', 8);
        kv.put('r', 9);
        kv.put('s', 2);
        kv.put('t', 3);
        kv.put('u', 4);
        kv.put('v', 5);
        kv.put('w', 6);
        kv.put('x', 7);
        kv.put('y', 8);
        kv.put('z', 9);


        wv.put(1, 8);
        wv.put(2, 7);
        wv.put(3, 6);
        wv.put(4, 5);
        wv.put(5, 4);
        wv.put(6, 3);
        wv.put(7, 2);
        wv.put(8, 10);
        wv.put(9, 0);
        wv.put(10, 9);
        wv.put(11, 8);
        wv.put(12, 7);
        wv.put(13, 6);
        wv.put(14, 5);
        wv.put(15, 4);
        wv.put(16, 3);
        wv.put(17, 2);

    }*/

    public boolean isLegal(String vin) {
        Map<Character, Integer> kv = new HashMap<Character, Integer>();//对应值
        Map<Integer, Integer> wv = new HashMap<Integer, Integer>();//加权值

        for (int i = 0; i < 10; i++) {
            kv.put(String.valueOf(i).charAt(0), i);
        }
        kv.put('a', 1);
        kv.put('b', 2);
        kv.put('c', 3);
        kv.put('d', 4);
        kv.put('e', 5);
        kv.put('f', 6);
        kv.put('g', 7);
        kv.put('h', 8);
        kv.put('j', 1);
        kv.put('k', 2);
        kv.put('l', 3);
        kv.put('m', 4);
        kv.put('n', 5);
        kv.put('p', 7);
        kv.put('q', 8);
        kv.put('r', 9);
        kv.put('s', 2);
        kv.put('t', 3);
        kv.put('u', 4);
        kv.put('v', 5);
        kv.put('w', 6);
        kv.put('x', 7);
        kv.put('y', 8);
        kv.put('z', 9);

        wv.put(1, 8);
        wv.put(2, 7);
        wv.put(3, 6);
        wv.put(4, 5);
        wv.put(5, 4);
        wv.put(6, 3);
        wv.put(7, 2);
        wv.put(8, 10);
        wv.put(9, 0);
        wv.put(10, 9);
        wv.put(11, 8);
        wv.put(12, 7);
        wv.put(13, 6);
        wv.put(14, 5);
        wv.put(15, 4);
        wv.put(16, 3);
        wv.put(17, 2);
        vin = vin.replace(" ","").toLowerCase();
        System.out.println(vin.length());
        if (null == vin || vin.indexOf("i")>0 || vin.indexOf("o")>0 || vin.indexOf("q")>0) {
            System.out.println(false+"----1");
            return false;
        } else if (vin.length() == 17) {
            char[] codes = vin.toCharArray();
            int resultInCode = 0;
            if ("0123456789x".contains(vin.subSequence(8, 9)) && !"0".contains(vin.subSequence(9,10))) {
                if(vin.subSequence(8, 9).toString().equals("x")){
                    resultInCode = 10;
                }else {
                    resultInCode = Integer.valueOf(vin.subSequence(8, 9).toString());
                }
                System.out.println(vin.subSequence(9,10));
            } else {
                System.out.println(false+"----2");
                return false;
            }
            int total = 0;
            for (int i = 1; i < codes.length + 1; i++) {
                char code = codes[i - 1];
                if (kv.containsKey(code)) {
                    if (9 == i) {
                        continue;
                    } else {
                        total += kv.get(code) * wv.get(i);
                        System.out.println("===="+total);
                    }
                }else {
                    System.out.println("车架号不正确请检查是否存在特殊字符");
                    return false;
                }
            }
            boolean r=resultInCode == total % 11?true:false;
            if (r==false){
                System.out.println("车架号不正确或第九位号码有误");
            }
            return r;

        } else {
            System.out.println(false+"----3");
            return false;
        }
    }

    public static void main(String[] args) {
        //  UU6JA69691D713820  LSYYDACKX9K108573  4JGBB56EX9A518221  bbcdehhwxfgkjuxjk  12345678498745612  LFWSRXNH6AAD38754
        String str = "LFMSRXNH5AAD38754";
        Vin checkVin = new Vin();
        boolean c=checkVin.isLegal(str);
        System.out.println(c);
       /* String[] tempStr = str.split(",");
        for (String temp : tempStr) {
            System.out.println(checkVin.isLegal(temp) + "\r\n");
        }*/
    }
    }