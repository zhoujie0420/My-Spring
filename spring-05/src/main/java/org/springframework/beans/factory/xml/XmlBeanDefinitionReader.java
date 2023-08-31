package org.springframework.beans.factory.xml;

import cn.hutool.core.bean.BeanException;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.Resource;
import org.springframework.core.ResourceLoader;

/**
 * @author jiezhou
 * <p>
 * XmlBeanDefinitionReader 类最核心的内容就是对 XML 文件的解析，把我们本来在代码中的操作放到了通过解析 XML 自动注册的方式。
 * <p>
 * loadBeanDefinitions 方法，处理资源加载，这里新增加了一个内部方法：doLoadBeanDefinitions，它主要负责解析 xml
 * 在 doLoadBeanDefinitions 方法中，主要是对xml的读取 XmlUtil.readXML(inputStream) 和元素 Element 解析。在解析的过程中通过循环操作，以此获取 Bean 配置以及配置中的 id、name、class、value、ref 信息。
 * 最终把读取出来的配置信息，创建成 BeanDefinition 以及 PropertyValue，最终把完整的 Bean 定义内容注册到 Bean 容器：getRegistry().registerBeanDefinition(beanName, beanDefinition)
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {


    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    /**
     * 从指定的资源位置加载bean定义
     *
     * @param resource
     * @throws Exception
     */
    @Override
    public void loadBeanDefinitions(Resource resource) throws BeanException {
    }
}
