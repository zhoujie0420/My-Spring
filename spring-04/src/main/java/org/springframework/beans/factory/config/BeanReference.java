package org.springframework.beans.factory.config;



/**
 * @author jiezhou
 *
 * bean 的引用
 */

public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return this.beanName;
    }
}
