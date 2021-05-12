class CommonMethod {

    protected int x;

    //定义一个超类实例构造方法 			instance constructor 实方法
    public CommonMethod() {
        System.out.println("this is instance constructor in Common class ");
        x = 100;

    }

    //定义一个最终的实方法 				final 实方法
    //该方法不能被子类覆盖
    public final void setX(int ix) {
        System.out.println("public final void setX(int ix) in Common class");
        x = ix;
    }

    //定义一个普通返回值的虚方法 		virtual虚方法  new slot
    public int getX() {
        System.out.println("this is public int getX() in Common class");
        return x;
    }

    //定义一个返回超类实例的虚方法  	virtual虚方法  new slot
    public CommonMethod getObject() {
        System.out.println("this is public CommonMethod getObject() in Common class");
        return new CommonMethod();
    }

    //定义一个具有保护权限的虚方法 		virtual虚方法  new slot
    protected  void proShowMsg() {
        System.out.println("this is protected void proShowMsg() in Common class");
    }

    //定义一个具有公共访问权限的虚方法	virtual虚方法  new slot
    public void pubShowMsg() {
        System.out.println("this is public void pubshowMsg() in Common class");
    }

    //定义一个具有保护权限的静态方法		静态方法
    static protected CommonMethod stShowMsg() {
        System.out.println("this is static protected CommonMethod stShowMsg() in Common class");
        return new CommonMethod();
    }

}
