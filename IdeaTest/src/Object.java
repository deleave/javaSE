//可变参数列表
public class Object {
    static void f(int required,String...args){
        System.out.println("required: "+required+" ");
        for (String s:args
             ) {
            System.out.println(s+"");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        {
            f(1,"one");
            f(2,"two","three");
            f(0);
        }
    }
}
