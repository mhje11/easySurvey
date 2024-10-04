package org.survey.domain.survey.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.survey.domain.member.entity.Member;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surveyName;

    private String purpose;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @ElementCollection
    private List<String> questionIds;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Builder

    public Survey(String surveyName, String purpose, LocalDateTime startDate, LocalDateTime endDate, List<String> questionIds, Member member) {
        this.surveyName = surveyName;
        this.purpose = purpose;
        this.startDate = startDate;
        this.endDate = endDate;
        this.questionIds = questionIds;
        this.member = member;
    }
}
