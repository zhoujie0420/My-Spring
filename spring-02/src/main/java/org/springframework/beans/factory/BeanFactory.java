package org.springframework.beans.factory;

import org.springframework.BeansException;

public interface BeanFactory {
    Object getBean(String name) throws BeansException;
}
