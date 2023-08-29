package org.springframework;
import org.junit.Test;
import org.springframework.factory.config.BeanDefinition;
import org.springframework.factory.support.BeanDefinitionRegistry;
import org.springframework.factory.support.DefaultListableBeanFactory;

public class test_Bean {
    @Test
    public void test_bean() throws BeansException {
        // 初始化bean
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
