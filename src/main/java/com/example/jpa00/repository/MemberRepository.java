package com.example.jpa00.repository;


import com.example.jpa00.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//jpa를 쓸때는 맴버 엔티티와 문자열로 (엔티티용 레포지토리) 맴버 아이디의 id값은 문자열
public interface MemberRepository extends JpaRepository<MemberEntity, String> {

}
