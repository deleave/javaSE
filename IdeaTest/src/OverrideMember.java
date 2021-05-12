public class OverrideMember extends CommonMethod{

//通过extends继承了超类的实例字段和实例方法（除了实例构造方法外）
//以下扩展/增加子类成员 				add

    protected int y;

    //定义一个子类实例构造方法 			instance constructor实方法
    public OverrideMember() {
        System.out.println("this is instance constructor in derive class ");
        y = 200;

    }


    //增加一个最终的实方法 				final 实方法
    //该方法不能被子类覆盖
    public final void setY(int iy) {
        System.out.println("this is public int getY() in derive class");
        y = iy;
    }


    //增加一个普通返回值的虚方法 		virtual虚方法  new slot
    public int getY() {
        System.out.println("this is public int getY() in derive class ");
        return y;
    }

    //----------override覆盖虚方法   	override虚方法  reuse slot
    //方法名相同、参数签名相同、返回类型相同
    //访问控制符越来越宽松，private ——> public的方向
    public void proShowMsg() {
        System.out.println("this is public void proShowMsg() in derive class ");
    }

    //----------override覆盖虚方法   	override虚方法  reuse slot
//方法名相同、参数签名相同、返回类型相同
//访问控制符相同
    public void pubShowMsg() {
        System.out.println("this is public void pubshowMsg in derive class");
    }

//-------------覆盖虚方法   		编译错误
//方法名相同、参数签名相同、返回类型相同
    //子类方法的访问控制符越来越严格，public ——> private的方向
   	/*
protected void pubShowMsg() {
        	System.out.println("子类方法的访问控制符越来越严格，编译错误");
}
   	*/

//-------------覆盖虚方法   		编译错误
//方法名相同、参数签名相同、访问控制符相同
//子类方法的返回类型与超类方法的返回类型没有继承关系
   	/*
public void getX() {
        	System.out.println("子类方法的返回类型与超类方法的返回类型没有继承关系，编译错误");
}
   	*/

    //-------------- final覆盖虚方法   	final override虚方法  reuse slot
//方法名相同、参数签名相同、返回类型相同、访问控制符相同
//指定为final最终虚方法
    public final int getX() {
        System.out.println("this is public final int getX() in derive class" );
        return x;
    }

    //-------------覆盖final方法		编译错误
    //final方法不能被子类覆盖
  	/*
  		public void setX(int ix) {
       		x = ix;
    	}
   	*/

    //--------------重载实例方法 		overload
//方法名相同，形参签名不同，表示功能相近。
//Java不允许方法签名相同，而返回类型不同的方法重载
    //增加一个重载的虚方法 				virtual虚方法  new slot
    public void pubShowMsg(String s) {
        System.out.println("this is public void pubShowMsg(String s) in derive class");
    }

//--------------bridge覆盖虚方法   		bridge桥接
//子类方法返回类型是父类方法返回类型的派生类

//在JVM中允许方法签名相同，而返回类型不同的方法重载
//原因是JVM字节码调用方法是通过： 返回类型 + 方法签名
//JVM子类中允许子类方法override超类方法的条件：
//1）	方法名称相同
//2）	参数签名相同
//3）	返回类型相同
//4）	访问控制符相同，或越来越宽松

//在Java中不允许方法签名相同，而返回类型不同的方法重载
//原因是Java调用方法只是通过（与返回类型无关）：方法签名
//Java子类中允许子类方法override超类方法的条件：
//1）	方法名称相同
//2）	参数签名相同
//3）	返回类型相同或是派生类(override + virtual)
//4）	访问控制符相同，或越来越宽松

    //bridge桥接：
//方法名相同、参数签名相同、返回类型是超类方法的派生类、访问控制符相同或更宽松
//编译器产生两个重载的虚方法：
//1、public CommonMethod getObject()    override桥接虚方法  reuse slot（）
//2、public OverrideMember getObject()	virtual重载虚方法   new slot
//virtual重载虚方法（在JVM中生成方法签名相同，而返回类型为派生类的虚方法重载）
//也可以public final OverrideMember getObject()，编译通过。
    public OverrideMember getObject() {
        System.out.println("this is public OverrideMember getObject() in derive class");
        return new OverrideMember();
    }


    //--------------静态方法
    //方法名相同、参数签名相同、返回类型协变、访问控制符越来越宽松
    //覆盖父类中的同名静态方法
    static public OverrideMember stShowMsg() {
        System.out.println("this is static public OverrideMember stShowMsg() in derive class");
        return new OverrideMember();
    }

    //可以定义静态方法的重载
    static public OverrideMember stShowMsg(String s) {
        System.out.println("static public OverrideMember stShowMsg(String s) in derive class ");
        return new OverrideMember();
    }

//---------------静态方法与实例方法在同类或派生类中，方法签名不能相同
    //派生类中的静态方法与父类的实例方法签名相同，语法错误
/*
public static void pubShowMsg() {
        	System.out.println("this is public ShowMsg()");
}
*/

    //派生类中的实例方法与父类的静态方法签名相同，语法错误
/*
public void stShowMsg() {
        	System.out.println("this is static ShowMsg()");
}
*/

    public static void main(String args[]) {
        //声明CommonMethod父类类型的对象变量cm
        CommonMethod cm;
        //声明OverrideMember子类类型的对象变量om
        OverrideMember om;

        //1、生成父类的实例对象，赋予CommonMethod父类类型的对象变量cm
        //  CommonMethod父类型的对象变量cm引用CommonMethod父类型的实例对象
        cm = new CommonMethod();

        //2、生成子类的实例对象，赋予OverrideMember子类类型的对象变量om
        // OverrideMember父类型的对象变量om引用OverrideMember父类型的实例对象
        om = new OverrideMember();

/*
静态调用：由类型名称来确定调用的静态方法成员
1）	确定类型对象的入口地址
根据类名称确定类型对象的入口地址。
2）	确定静态方法代码的入口地址
在类对象中，根据方法的返回值和方法签名进行匹配，获得该静态方法，确定静态方法代码的入口地址。
3）	直接调用该类中的该静态方法的代码。
*/
//静态绑定--- invokestatic静态调用
        CommonMethod.stShowMsg();
        OverrideMember.stShowMsg();
        OverrideMember.stShowMsg("OK! ");

    }
}

