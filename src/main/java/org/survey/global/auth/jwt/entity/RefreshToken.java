package org.survey.global.auth.jwt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "refresh_token")
@Getter
@NoArgsConstructor
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String refresh;

    @Column(name = "expiration_time")
    private Instant expiration;

    public RefreshToken(String userId, String refresh) {
        this.userId = userId;
        this.refresh = refresh;
    }

    public void updateRefresh(String newRefreshToken) {
        this.refresh = newRefreshToken;
    }
    public boolean isExpired() {
        return this.expiration.isBefore(Instant.now());
    }
}
