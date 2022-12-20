package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * recode는 class의 중복되는 기본적인 코드들을 간결하게 사용하기 위해 등장하였다.
 * jdk 16버전부터 등작하였다.
 * 필드 캡슐화, 개인 생성자, getter, setter, equals, hashcode, toString 메소드를 자동으로 구현해준다.
 * 매계변수로 필수 변수를 선언해주면 됌
 * class와 비교 링크 : https://blog.hexabrain.net/399
 */
record Person(String name, int age, Address address) { };

record Address(String firstLine, String city){};

//스프링에서 관리할 스프링빈을 정의하는 공간
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Ranga";
    }

    @Bean
    public int age() {
        return 15;
    }

    @Bean
    public Person person() {
        return new Person("Ravi", 20, new Address("서울", "강북구"));
    }

    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address customAddress3){
        return new Person(name, age, customAddress3);
    }

    @Bean(name = "customAddress")
    public Address address() {
        return new Address("서울특별시", "노원구");
    }

    @Bean(name = "customAddress3")
    public Address address3() {
        return new Address("강원도", "속초시");
    }
}
