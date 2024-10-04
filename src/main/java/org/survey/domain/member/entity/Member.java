package org.survey.domain.member.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "login_id")
    private String loginId;

    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public Member(String name, String loginId, String password, LocalDateTime createdAt) {
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.createdAt = createdAt;
    }
}
