package com.泛型;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class PairDemo2 {
    /**
     * 把多条数据的ResultSet的结果放到 List<T>中
     * @param rs  ResultSet结果集
     * @param obj java类的class
     * @return
     */
    public static <T> List<T> getResult(ResultSet rs, Class<T> obj) {
        try {
            List<T> list = new ArrayList<T>();
            //ResultSetMetaData 有关 ResultSet 中列的名称和类型的信息。
            ResultSetMetaData metaData = rs.getMetaData();
            //获取总的列数
            int count = metaData.getColumnCount();
            //遍历ResultSet
            while (rs.next()) {
                //---创建对象实例
                T instance = obj.newInstance();
                for (int i = 1; i <= count; i++) {
                    //---获取列名
                    String name = metaData.getColumnName(i);
                    // 改变列名格式成 java 命名格式 主要是针对 _ 分割的情况  如user_id
                   // name = toJavaField(name);
                    //---获取类型
                    Class<?> type = obj.getDeclaredField(name).getType();
                    //---获取setter方法
                    // 首字母大写
                    String replace = name.substring(0, 1).toUpperCase() + name.substring(1);
                    Method setMethod = obj.getMethod("set" + replace, type);

                    //---判断读取数据的类型
                    if (type.isAssignableFrom(String.class)) {
                        setMethod.invoke(instance, rs.getString(i));
                    } else if (type.isAssignableFrom(int.class) || type.isAssignableFrom(Integer.class)) {
                        setMethod.invoke(instance, rs.getInt(i));
                    } else if (type.isAssignableFrom(Boolean.class) || type.isAssignableFrom(boolean.class)) {
                        setMethod.invoke(instance, rs.getBoolean(i));
                    } else if (type.isAssignableFrom(Date.class)) {
                        ((Method) setMethod).invoke(instance, rs.getDate(i));
                    }
                }
                list.add(instance);
            }
            return list;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }

}
