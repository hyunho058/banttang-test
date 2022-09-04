package com.hproject.banttang.user.infra.repository;

import com.hproject.banttang.user.entity.Member;
import com.hproject.banttang.user.infra.repository.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Member, Long>, UserRepositoryCustom {
    Optional<Member> findByUserKey(String userKey);
}
