package org.springframework.factory.config;

public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
