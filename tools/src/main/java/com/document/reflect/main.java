package com.document.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zl
 * @Date: 2019-12-24 10:02
 */
public class main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<ReflectBean> clzss = ReflectBean.class;
        // 1. 创建实例
        ReflectBean reflectBean = clzss.newInstance();

        // 2. 字段操作
        // 获取字段 (只能获取public的,但是可以获取从父类继承过来的public属性)
        Field name = clzss.getField("pubName");
        Field[] fields = clzss.getFields();

        // 获取字段 (获取当前类的所有字段，但是获取不到父类继承来的属性)
        Field name1 = clzss.getDeclaredField("name");
        Field[] declaredFields = clzss.getDeclaredFields();

        // 获取字段属性
        // 在获取private属性时，必须将该属性设为true才能直接get。你可以选择通过get，set方法来获取
        name1.setAccessible(true);
        name1.set(reflectBean,"反射设置的name");
        String str = (String)name1.get(reflectBean);
        System.out.println(str);

        // 3. 方法操作
        // 获取方法 这里和field一样操作。不多赘述
        Method method = clzss.getMethod("method");
        Method[] methods = clzss.getMethods();
        Method priMethod = clzss.getDeclaredMethod("priMethod", String.class);
        Method[] declaredMethods = clzss.getDeclaredMethods();

        // 调用方法
        Object invoke = method.invoke(reflectBean);

        priMethod.setAccessible(true); // 下面是私有的方法，也要加上这句
        Object string = priMethod.invoke(reflectBean, "string");
        System.out.println(invoke);
        System.out.println(string);

        System.out.println(reflectBean);
    }
}
