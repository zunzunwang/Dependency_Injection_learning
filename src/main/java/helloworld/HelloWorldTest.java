package helloworld;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zunzunwang on 21/02/2017.
 */
public class HelloWorldTest {

    @Test
    public void testSayHello(){
        Injector inj = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorld.class).to(HelloWorldImpl.class);
            }
        });

        HelloWorld hw = inj.getInstance(HelloWorld.class);
        Assert.assertEquals(hw.sayHello(),"hello,world!");
    }

}
