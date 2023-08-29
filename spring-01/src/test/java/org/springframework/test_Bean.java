package org.springframework;


import org.junit.Test;


public class test_Bean {

    @Test
    public void test_BeanFactory(){
        BeanFactory beanFactory = new BeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(new UsersService());
        beanFactory.registerBeanDefinition("usersService", beanDefinition);

        UsersService usersService = (UsersService) beanFactory.getBean("usersService");
        usersService.queryUserInfo();
    }
}
