package ru.otus.spring.dao;

import ru.otus.spring.domain.Question;

public interface QuestionDao {
    Question getQuestionByNumber(int number);

}
