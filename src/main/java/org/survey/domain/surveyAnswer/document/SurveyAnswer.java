package org.survey.domain.surveyAnswer.document;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collation = "survey_answers")
@NoArgsConstructor
public class SurveyAnswer {
    @Id
    private String id;

    @Field("survey_id")
    private String surveyId;

    @Field("question_id")
    private String questionId;

    @Field("answer_text")
    private String answerText;

    @Field("selected_options")
    private List<String> selectedOptions;

    @Builder
    public SurveyAnswer(String surveyId, String questionId, String answerText, List<String> selectedOptions) {
        this.surveyId = surveyId;
        this.questionId = questionId;
        this.answerText = answerText;
        this.selectedOptions = selectedOptions;
    }
}
