package org.survey.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.survey.domain.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUserId(String userId);
}
