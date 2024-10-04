package org.survey.domain.surveyQuestion.document;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collation = "survey_questions")
@NoArgsConstructor
public class SurveyQuestion {

    @Id
    private String id;

    @Field("question_text")
    private String questionText;

    private List<String> options;

    @Field("question_type")
    private String questionType;

    @Builder
    public SurveyQuestion(String questionText, List<String> options, String questionType) {
        this.questionText = questionText;
        this.options = options;
        this.questionType = questionType;
    }
}
