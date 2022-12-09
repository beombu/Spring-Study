package me.beombu.jwttutorial.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity // 데이터베이스의 테이블과 1:1 매핑되는 객체를 의미하는 어노테이션
@Table(name = "`user`") // Table 이름 설정
@Getter
@Setter
@Builder//빌더 패턴를 어노테이션으로 한 것. 생성자가 많은 경우 사용하고, 생성자 인자를 메서드 체인을 통해 명시적으로 대입하여 호출할 수 있게 빌더 클래스를 생성해줌
@AllArgsConstructor
@NoArgsConstructor
public class User {

   @Id
   @Column(name = "user_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)//자동적으로 수를 증가해줌
   private Long userId;

   @Column(name = "username", length = 50, unique = true)
   private String username;

   @Column(name = "password", length = 100)
   private String password;

   @Column(name = "nickname", length = 50)
   private String nickname;

   @Column(name = "activated")
   private boolean activated;

   /**
    * RDB에서는 정규화된 테이블 2개로 다대다 관계를 표현할 수 없다.
    * 그래서 연결 테이블(조인 테이블)을 중간에 추가하여 일대다, 다대일 관계를 이용해야 함
    * @JoinTable를 이용하여 user_authority에서의 일대다, 다대일 관계를 만들어줌
    */
   @ManyToMany
   @JoinTable(
      name = "user_authority",
      joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
      inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
   private Set<Authority> authorities;
}