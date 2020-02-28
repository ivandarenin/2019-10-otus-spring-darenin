package ru.otus.spring.service;

public interface StudentsTestService {
    String getCurrentQuestion(String fio);

    void checkCurrentAnswer(String answer);

    boolean isFlagTestFinished();

}
