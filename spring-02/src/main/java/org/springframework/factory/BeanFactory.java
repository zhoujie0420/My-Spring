package org.springframework.factory;

import org.springframework.BeansException;
import org.springframework.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface BeanFactory {
    Object getBean(String name) throws BeansException;
}
