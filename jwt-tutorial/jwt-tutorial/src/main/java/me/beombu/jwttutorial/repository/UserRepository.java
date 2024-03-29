package me.beombu.jwttutorial.repository;

import me.beombu.jwttutorial.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //username을 기준으로 User 정보를 가져올 때 권한 정보도 같이 가져오는 메소드드
    @EntityGraph(attributePaths = "authorities")//쿼리가 수행될 때 Lazy조회가 아니라 Enger조회로 authorities정보를 같이 가져옴
    Optional<User> findOneWithAuthoritiesByUsername(String username);
}
