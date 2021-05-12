/*派生类的构造器调用前，必先调用基类的构造器。因为编译器自动在构造器第一个语句前加super();
若是含参的构造器，则要自己添加含参的super(i);
 */
public class Cartoon extends Drawing{
 Cartoon(){
     super(11);
     System.out.println("Cartoon");
 }
    public static void main(String[] args) {
        Cartoon x=new Cartoon();
        //Drawing a=new Drawing();
    }
}
class Art{
    Art(int i){
        System.out.println("Art");
    }
}
class Drawing extends Art{
    Drawing(int i){
        super(i);
        System.out.println("Drawing");
    }
}
