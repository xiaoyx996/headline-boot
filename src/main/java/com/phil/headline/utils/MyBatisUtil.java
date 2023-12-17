package com.phil.headline.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/5 10:12
 */
public class MyBatisUtil {
    //1.私有化构造器
    private MyBatisUtil(){

    }

    //懒汉式单例模式
    /*
    volatile:避免指令重排问题
     */
    private static volatile SqlSessionFactory sqlSessionFactory;
    public static SqlSession getSqlSession(){
        if(sqlSessionFactory == null){ // 如果sqlSessionFactory为null，需要new
            synchronized (MyBatisUtil.class){
                if(sqlSessionFactory == null){//前边可能有线程已执行完同步代码块
                    InputStream inputStream = null;
                    try {
                        // 读取配置文件
                        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (inputStream != null) {
                            try {
                                // 关闭流资源
                                inputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return sqlSessionFactory.openSession();
    }
}
