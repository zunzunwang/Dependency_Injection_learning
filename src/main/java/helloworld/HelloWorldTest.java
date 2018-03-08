package helloworld;

import com.google.inject.*;
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
                //Question3 code.
                //binder.bind(HelloWorld.class).to(HelloWorldSecondImp.class);
            }
        });

        HelloWorld hw = inj.getInstance(HelloWorld.class);
        Assert.assertEquals(hw.sayHello(),"hello,world!");

        //Question1: The HelloWorld is a singleton?
        HelloWorld hw2 = inj.getInstance(HelloWorld.class);
        System.out.println("***************** Question 1 *********************");
        System.out.println(hw.hashCode() + "->" + hw2.hashCode());
        //Assert.assertEquals(hw.hashCode(), hw2.hashCode());
        //Answer1: The HelloWorld is not a singleton. Each time it will return a new instance.

        //Question2: The instance of HelloWorld is HelloWorldImpl?
        System.out.println("***************** Question 2 *********************");
        System.out.println("Class of HelloWorld: " + hw.getClass().getName());
        //Answer2: It's just a simple HelloWorldImpl instance.

        //Question3: If we bind more Implements to a same interface, What will happened?
        //Answer3: Guice can't link more implements to a same interface.

        //Question4: Can we bind a implement to a implement?
        /*
        Injector inj4 = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorldImpl.class).to(HelloWorldImpl.class);
            }
        });
        HelloWorld hw4 = inj4.getInstance(HelloWorldImpl.class);
        System.out.println(hw4.sayHello());

        */
        //Answer4: No, We can't. error: 'Binding points to itself.'

        //Question5: bind a son class.
        Injector inj5 = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorldImpl.class).to(HelloWorldSubImpl.class);
            }
        });

        HelloWorld hw5 = inj5.getInstance(HelloWorldImpl.class);
        System.out.println("***************** Question 5 *********************");
        System.out.println(hw5.sayHello());
        //Answer5: Yes, We can bind a son class to a implement class. Module looks like a Map.

        //Question6: Can we bind to a instance?
        Injector inj6 = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorld.class).toInstance(new HelloWorldImpl());
            }
        });

        HelloWorld hw6 = inj6.getInstance(HelloWorld.class);
        System.out.println("***************** Question 6 *********************");
        System.out.println(hw6.sayHello());

        //Question7: Don't want to create a object.
        Injector inj7 = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorld.class).toProvider(new Provider<HelloWorld>() {
                    @Override
                    public HelloWorld get() {
                        return new HelloWorldImpl();
                    }
                });
            }
        });
        HelloWorld hw7 =  inj7.getInstance(HelloWorld.class);
        System.out.println("***************** Question 7 *********************");
        System.out.println(hw7.sayHello());

        //Question8: Dose it work if we don't bind the instance class.
        Injector inj8 = Guice.createInjector();
        HelloWorld hw8 = inj8.getInstance(HelloWorldImpl.class);
        System.out.println("***************** Question 8 *********************");
        System.out.println(hw8.sayHello());
        //Answer8: Guice will search the implement class automatically.

        //Question9: use announcement to realize injection.
        //by add @ImplementedBy(HelloWorldAnnouncementImpl.class)
        // manuel is higher than announcement.
        Injector inj9 = Guice.createInjector();
        HelloWorld hw9 = inj9.getInstance(HelloWorld.class);
        System.out.println("***************** Question 9 *********************");
        System.out.println(hw9.sayHello());

        //Question10 how to bind a singleton?
        Injector inj10 = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorld.class).to(HelloWorldImpl.class).in(Scopes.SINGLETON);
            }
        });



















    }

}
