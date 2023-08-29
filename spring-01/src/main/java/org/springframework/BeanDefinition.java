package org.springframework;

/**
 * 定义bean实例化信息
 *
 */
public class BeanDefinition {
    private Object bean;

    public Object getBean() {
        return bean;
    }

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }
}
