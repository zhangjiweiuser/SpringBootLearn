package com.zhang.jiwei.config;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;

import com.zhang.jiwei.annotation.Inject;
import com.zhang.jiwei.util.ReflectionUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by Administrator on 2017/5/22 0022.
 */
public class IocHelper {

    static {
        // 获取所有的Bean类与Bean实例之间的映射关系
        Map<Class<?> ,Object> beanMap = BeanHelper.getBeanMap();
        if(MapUtils.isNotEmpty(beanMap)){
            // 遍历Bean Map
            for(Entry<Class<?>,Object> beanEntry : beanMap.entrySet()){
                // 从BeanMap中获取Bean类与Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                // 获取Bean类定义的所有成员变量
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtils.isNotEmpty(beanFields)){
                    // 遍历Bean Field
                    for(Field beanField : beanFields){
                        //　判断当前Bean Field是否带有Inject 注解
                        if(beanField.isAnnotationPresent(Inject.class)){
                            // 在bean Map中获取Bean Field 对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if(null != beanFieldInstance){
                                // 通过反射初始化BeanField
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
