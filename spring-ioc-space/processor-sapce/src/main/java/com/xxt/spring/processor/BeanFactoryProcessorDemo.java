package com.xxt.spring.processor;

import com.xxt.spring.common.entity.Fruit;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 如何使用BeanFactoryProcessor
 */
public class BeanFactoryProcessorDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        System.out.println("容器已经refresh完成");
        Fruit bean = context.getBean(Fruit.class);
        System.out.println(bean);
    }

}
