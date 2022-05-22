package com.xxt.spring.processor;

import com.xxt.spring.common.entity.Fruit;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ApplicationConfig {

    @Bean(initMethod = "init")
    public Fruit fruit(){
        Fruit fruit = new Fruit();
        fruit.setName("橘子");
        return fruit;
    }

    /**
     * 注册BeanFactoryPostProcessor需要把方法声明为static，以保证生命周期的正确性，具体的提示信息如下：
     * @Bean method ApplicationConfig.myBeanFactoryPostProcessor is non-static and returns an object assignable to Spring's BeanFactoryPostProcessor interface. This will result in a failure to process annotations such as @Autowired, @Resource and @PostConstruct within the method's declaring @Configuration class. Add the 'static' modifier to this method to avoid these container lifecycle issues; see @Bean javadoc for complete details
     * @return
     */
    @Bean
    public static BeanFactoryPostProcessor myBeanFactoryPostProcessor() {
        return new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
                System.out.println("myBeanFactoryPostProcessor#postProcessBeanFactory方法被调用了");
            }
        };
    }

    /**
     * 获取所有的BeanDefinition，将其设置为延迟加载
     * @return
     */
    @Bean
    public static BeanFactoryPostProcessor makeAllBeanLazyBeanFactoryProcessor() {
        return new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
                String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
                Arrays.stream(beanDefinitionNames).forEach(beanDefinitionName->{
                    BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanDefinitionName);
                    beanDefinition.setLazyInit(true);
                });
            }
        };
    }

}
