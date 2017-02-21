package helloworld;

import sun.jvm.hotspot.*;

/**
 * Created by zunzunwang on 21/02/2017.
 */
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String sayHello(){
        return "hello,world!";
    }
}
