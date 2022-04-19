package hello.servlet.basic;


import lombok.Getter;//자동으로 getter 생성
import lombok.Setter;//자동으로 setter 생성

@Getter @Setter
public class HelloData {

    private String username;
    private int age;

}
