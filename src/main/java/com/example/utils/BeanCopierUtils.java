package com.example.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * BeanCopierUtils 拷贝bean对象Utils
 *
 * @author yezw1506
 * @date 2019-02-27
 */
public class BeanCopierUtils {

    public static Map<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<>();

    /**
     * 拷贝方法
     * @param source 拷贝的资源
     * @param target 拷贝到的目标
     */
    public static void copyProperties(Object source, Object target) {
        String beanKey = generateKey(source.getClass(), target.getClass());
        BeanCopier copier;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
    }

    public static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }
}
