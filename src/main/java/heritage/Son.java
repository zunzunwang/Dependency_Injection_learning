package heritage;

/**
 * Created by zunzunwang on 13/02/2018.
 */
public class Son extends Father{
    public Son(){
        System.out.println("Son init");
    }

    public static void main(String[] args){
        Son son = new Son();
        son.call();
    }
}
