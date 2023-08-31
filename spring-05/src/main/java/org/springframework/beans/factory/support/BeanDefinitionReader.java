package org.springframework.beans.factory.support;

import org.springframework.core.Resource;
import org.springframework.core.ResourceLoader;

/**
 * @author jiezhou
 */
public interface BeanDefinitionReader {


    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource);

    void loadBeanDefinitions(Resource... resources);

    void loadBeanDefinitions(String location);
}
