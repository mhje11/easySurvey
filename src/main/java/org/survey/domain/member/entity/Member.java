package org.survey.domain.member.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "user_id")
    private String userId;

    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private Role role;

    @Builder
    public Member(String name, String userId, String password, LocalDateTime createdAt, Role role) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.createdAt = createdAt;
        this.role = role;
    }
}
