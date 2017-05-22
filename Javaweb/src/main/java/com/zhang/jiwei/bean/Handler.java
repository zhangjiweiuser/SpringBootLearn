package com.zhang.jiwei.bean;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/5/22 0022.
 */
public class Handler {

    /**
     * controller类
     */
    private Class<?> controllerClass;

    /**
     * action方法
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public void setControllerClass(Class<?> controllerClass) {
        this.controllerClass = controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

    public void setActionMethod(Method actionMethod) {
        this.actionMethod = actionMethod;
    }
}
