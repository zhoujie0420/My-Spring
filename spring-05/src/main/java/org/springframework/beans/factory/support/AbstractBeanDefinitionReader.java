package org.springframework.beans.factory.support;

import org.springframework.core.DefaultResourceLoader;
import org.springframework.core.Resource;
import org.springframework.core.ResourceLoader;

/**
 * @author jiezhou
 */
public class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public void loadBeanDefinitions(Resource resource) {

    }

    @Override
    public void loadBeanDefinitions(Resource... resources) {

    }

    @Override
    public void loadBeanDefinitions(String location) {

    }
}
