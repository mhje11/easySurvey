package org.survey.domain.surveyQuestion.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.survey.domain.surveyQuestion.document.SurveyQuestion;

public interface SurveyQuestionRepository extends MongoRepository<SurveyQuestion, String> {
}
