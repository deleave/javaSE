package com.反射.代理;

/**
 * @ClassName StaticProxyTest
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/19 20:22
 * @Version 1.0
 **/
interface  ClothFactory{
    void produceCloth();
}

class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;

    public ProxyClothFactory(){

    }
    public ProxyClothFactory(ClothFactory factory){
        this.factory=factory;
    }
    @Override
    public void produceCloth() {
        System.out.println("代理工厂准备一些工作");
        factory.produceCloth();
        System.out.println("代理工厂后续工作");
    }
}

class AntaClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("安踏工厂生产一批衣服");
    }
}
public class StaticProxyTest {

    public static void main(String[] args) {
        ClothFactory anta = new AntaClothFactory();
        ClothFactory proxyClothFactory = new ProxyClothFactory(anta);

        proxyClothFactory.produceCloth();
    }

}
