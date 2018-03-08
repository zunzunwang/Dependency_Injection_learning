package helloworld;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zunzunwang on 24/01/2018.
 */
public class Test {
    String Myname;

    public Test(){
        Myname = "this is my name";
    }

    public void callMe(){
        System.out.println(Myname);
    }

    public void callMe2() {
        Test2 t2 = new Test2();
        t2.callMeMe();
    }

    class Test2 {
        public void callMeMe() {
            callMe();
        }

    }

    public static void test(String... str){
        for (String s : str)
            System.out.println(s);

    }

    public static void main(String args[]){
        String test = new String("IM_HAEU_1-1_20180101_telecom_localhost-20180124222728093-00001.warc");
        System.out.println(test.split("_")[2]);
        byte[] response;

        Map<String, String> testMap = new HashMap();
        testMap.put("hello", "hellohello");
        System.out.println(testMap.get("hello"));
        System.out.println(testMap.get("bye"));
        System.out.println(testMap.get("bye") == null);
        test("hello", "nihao", "bye");
        Test t = new Test();
        t.callMe2();
    }
}
