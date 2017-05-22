package com.zhang.jiwei;

import com.zhang.jiwei.config.BeanHelper;
import com.zhang.jiwei.config.ClassHelper;
import com.zhang.jiwei.config.ControllerHelper;
import com.zhang.jiwei.config.IocHelper;
import com.zhang.jiwei.util.ClassUtil;

/**
 * Created by Administrator on 2017/5/22 0022.
 */
public class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
