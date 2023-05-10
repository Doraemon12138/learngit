/*模拟购物车*/
/*-----------------------------*/
package com.itheima.Demo;
//模拟购物车
public class Goods {
    int id;//编号
    String name;//名称
    double price;//价格
    int buyNumber;//购买数量
}

/*-----------------------------*/
package com.itheima.Demo;

import java.util.Scanner;

/* 目标：面向对象编程训练，购物车模块模拟
 */
public class ShopCarTest {
    public static void main(String[] args) {
        //1.定义商品类，用于后期创建商品对象
        //2.定义购物车对象：使用数组对象表示
        Goods[] shoperCar=new Goods[100];
        //3.搭建架构来操作
        while (true) {
            System.out.println("请您选择如下命令来操作：");
            System.out.println("添加商品到购物车：add");
            System.out.println("查询商品到购物车：query");
            System.out.println("修改商品到购物车：update");
            System.out.println("结算购买商品的金额：pay");
            Scanner sc= new Scanner(System.in);
            System.out.println("请您输入您的选择：");
            String command=sc.next();
            switch (command){
                case "add":
                    //添加商品到购物车
                    addGoods(shoperCar,sc);
                    break;
                    //查询商品到购物车
                case "query":
                    queryGoods(shoperCar);
                    break;
                    //修改商品到购物车
                case "update":
                    updateGoods(shoperCar,sc);
                    break;
                    //结算购买商品金额
                case  "pay":
                    payGoods(shoperCar);
                    break;
                default:
                    System.out.println("您输入有误，没有该功能！");
            }
        }

    }

    private static void payGoods(Goods[] shopCar) {
        queryGoods(shopCar);
        //1.定义一个求和变量累加金额
        //2.遍历购物车数组中全部商品对象，累加单价*数量
        //[g1,g2....]
        double sum=0;
        for (int i = 0; i < shopCar.length; i++) {
            Goods g=shopCar[i];//把购物车数组放到商品类中
            if (g!=null) {
                sum+=(g.price* g.buyNumber);
            } else {
                break;
            }
        }
        System.out.println("订单总金额："+sum);
    }

    private static void updateGoods(Goods[] shopCar,Scanner sc) {
        //让用户输入要修改商品的id，根据id查询出要修改的商品对象。
        while (true) {
            System.out.println("请输入你要查询的商品id：");
            int id=sc.nextInt();
            Goods g=getGoodBuId(shopCar,id);//封装到Good类
            if (g==null){
                System.out.println("抱歉哦亲，您还没有购买商品！");
            }else {
                //说明存在该商品对象，可以去修改
                System.out.println("请您输入"+g.name+"商品最新购买数量：");
                int buyNumber=sc.nextInt();
                g.buyNumber=buyNumber;
                System.out.println("修改完成！");
                queryGoods(shopCar);
                break;
            }
        }

    }
    public static Goods getGoodBuId(Goods[] shopCar,int id){
        //shopCar=[g1,g2,g3,null,null,...]
        for (int i = 0; i < shopCar.length; i++) {
            Goods g=shopCar[i];
            if (g!=null){
                //判断这个商品是否是我们要找的
                if (g.id==id){
                    return g;
                }else {
                    return null;
                }
            }
        }
        return null;
    }

    private static void queryGoods(Goods[] shopCar) {
        //shopCar[]={a,b,null..}
        System.out.println("============查询购物车内容如下=============");
        System.out.println("编号\t\t名称\t\t价格\t\t购买数量");
        for (int i = 0; i < shopCar.length; i++) {
            Goods g=shopCar[i];
            if (g!=null)
            {
                System.out.println(g.id+"\t\t"+g.name+"\t\t"+g.price+"\t\t"+g.buyNumber);
            }
            else {
                break;
            }
        }
    }

    private static void addGoods(Goods[] shopCar,Scanner sc) {
        //1.录入用户输入的购买商品信息
        System.out.println("请您输入购买商品的编号（不重复）：");
        int id=sc.nextInt();
        System.out.println("请您输入购买商品的名称：");
        String name=sc.next();
        System.out.println("请您输入购买商品的数量：");
        int buyNumber=sc.nextInt();
        System.out.println("请您输入购买商品的金额：");
        double price=sc.nextDouble();
        //2.把这个购买商品的信息封装成一个商品对象
        Goods g=new Goods();
        g.id=id;
        g.name=name;
        g.buyNumber=buyNumber;
        g.price=price;
        //3.把这个商品对象添加到购物车数组中去
        for (int i = 0; i < shopCar.length; i++) {
            if (shopCar[i]==null){
                shopCar[i]=g;
                break;
            }
        }
        System.out.println("您的商品："+g.name+"添加购物车完成！");
    }
}
