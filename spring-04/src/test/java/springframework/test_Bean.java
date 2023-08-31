package springframework;
import org.junit.Test;
import org.springframework.BeansException;
import org.springframework.factory.PropertyValue;
import org.springframework.factory.PropertyValues;
import org.springframework.factory.config.BeanDefinition;
import org.springframework.factory.config.BeanReference;
import org.springframework.factory.support.DefaultListableBeanFactory;

public class test_Bean {
    @Test
    public void test_bean() throws BeansException {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注入bean
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. 设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uid", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));


        // UserService bean注入
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
