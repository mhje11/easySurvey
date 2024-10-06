package org.survey.global.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.survey.global.auth.jwt.entity.RefreshToken;
import org.survey.global.auth.jwt.repository.RefreshTokenRepository;
import org.survey.global.auth.jwt.util.JwtTokenizer;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenizer jwtTokenizer;

    //RefreshToken 저장

    @Transactional
    public RefreshToken saveRefreshToken(RefreshToken refreshToken) {
        return refreshTokenRepository.save(refreshToken);
    }

    public Optional<RefreshToken> findByRefresh(String refresh) {
        return refreshTokenRepository.findByRefresh(refresh);
    }

    @Transactional
    public void updateRefreshToken(RefreshToken refreshToken, String newRefreshTokenValue) {
        refreshToken.updateRefresh(newRefreshTokenValue);
    }

    @Transactional
    public void deleteRefreshToken(String refresh) {
        refreshTokenRepository.deleteByRefresh(refresh);
    }
    public Optional<RefreshToken> findByuserId(String userId) {
        return refreshTokenRepository.findByUserId(userId);
    }

    @Transactional
    public String[] refreshToken(String refreshToken) {
        if (refreshToken == null) {
            throw new RuntimeException("인가되지 않은 토큰");
        }

        RefreshToken storedToken = findByRefresh(refreshToken)
                .orElseThrow(() -> new RuntimeException("유효하지 않은 토큰"));

        if (jwtTokenizer.isRefreshTokenExpired(refreshToken)) {
            throw new RuntimeException("만료된 토큰");
        }

        String newAccessToken = jwtTokenizer.newAccessToken(refreshToken);
        String newRefreshToken = jwtTokenizer.createRefreshToken(
                storedToken.getId(),
                storedToken.getUserId(),
                jwtTokenizer.parseRefreshToken(refreshToken).get("name", String.class),
                jwtTokenizer.parseRefreshToken(refreshToken).get("role", String.class)
        );

        updateRefreshToken(storedToken, newRefreshToken);

        return new String[]{newAccessToken, newRefreshToken};
    }


}
