package org.springframework.beans.factory;

import org.springframework.BeansException;

/**
 * @author jiezhou
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    // 重载一个含有入参信息的args的getBean 方法   ，方便传递入参给构造函数实例化了
    Object getBean(String name, Object... args) throws BeansException;
}
