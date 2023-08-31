package org.springframework.beans.factory.config;

/**
 * @author jiezhou
 */
public class BeanDefinition {
    private Class beanClass;
    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }
    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
