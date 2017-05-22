package com.zhang.jiwei.config;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

import com.zhang.jiwei.util.ReflectionUtil;
import org.apache.commons.collections.map.HashedMap;

/**
 * Created by Administrator on 2017/5/22 0022.
 */
public class BeanHelper {

    private static final Map<Class<?>, Object> BEAN_MAP = new HashedMap();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    public static <T> T getBean(Class<T> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not getbbean by class:" + cls);
        }
        return (T) BEAN_MAP.get(cls);
    }


}
