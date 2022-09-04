package com.hproject.banttang.user.infra.repository.custom;

import com.hproject.banttang.user.entity.Member;

public interface UserRepositoryCustom {
    Member findUserKey(String userKey);
    Member findByUserNickname(String nickname);
}
