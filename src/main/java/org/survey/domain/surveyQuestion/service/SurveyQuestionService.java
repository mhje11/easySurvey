package org.survey.domain.surveyQuestion.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.survey.domain.surveyQuestion.repository.SurveyQuestionRepository;

@Service
@RequiredArgsConstructor
public class SurveyQuestionService {
    private final SurveyQuestionRepository surveyQuestionRepository;

}
