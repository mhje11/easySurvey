package org.survey.global.auth.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.survey.global.auth.jwt.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByRefresh(String refresh);

    void deleteByRefresh(String refresh);

    Optional<RefreshToken> findByUserId(String userId);
}
