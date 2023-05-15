package com.itheima.demo;
/**
 目标：完成电影信息的展示案例，理解面向对象的编程代码
 “《长津湖》”，9.7，“吴京”
 “《我和我的父辈》”,9.6,“吴京”
 “《扑水少年》”,9.5,“王川”
 */
public class Test {
    public static void main(String[] args) {
        //1.设计电影类
        //2.创建三个电影类对象，封装电影的信息
        //3.定义一个电影类型的数组，存储三部电影对象
        //int[] arr= new int[]
        Movie[] movies= new Movie[3];
        movies[0]=new Movie("《长津湖》",9.7,"吴京");
        movies[1]=new Movie("《我和我的父辈》",9.6,"吴京");
        movies[2]=new Movie("《扑水少年》",9.5,"王川");
        //遍历数组中的每一个电影对象，然后获取他的电影信息展示出来
        for (int i = 0; i < movies.length; i++) {
            Movie m=movies[i];
            System.out.println("电影名称："+ m.getName());
            System.out.println("得分："+ m.getScore());
            System.out.println("演员："+ m.getActor());
            System.out.println("----------------");
        }
    }
}
