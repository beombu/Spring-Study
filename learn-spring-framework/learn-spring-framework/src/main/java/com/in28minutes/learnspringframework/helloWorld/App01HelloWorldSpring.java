package com.in28minutes.learnspringframework.helloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App01HelloWorldSpring {
    public static void main(String[] args) {

        try(
                //spring framework의 어노테이션컴피그어플리캐이션컨텍스트를 활용해 스프링 빈들을 스프링에서 관리하도록 적용한다.
                var context =
                        new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
                ) {

            //@Configuration을 통해 스프링빈을 만들고 만들어진 스프링빈을 메소드명으로 호출 가능
            System.out.println(context.getBean("name"));

            System.out.println(context.getBean("age"));

            System.out.println(context.getBean("person"));

            System.out.println(context.getBean("person2MethodCall"));

            System.out.println(context.getBean("person3Parameters"));

            System.out.println(context.getBean("customAddress"));

            System.out.println(context.getBean(Address.class));

            System.out.println(context.getBean("person5Qualifier"));

    //        Arrays.stream(context.getBeanDefinitionNames())
    //                .forEach(System.out::println);
        }

    }
}
