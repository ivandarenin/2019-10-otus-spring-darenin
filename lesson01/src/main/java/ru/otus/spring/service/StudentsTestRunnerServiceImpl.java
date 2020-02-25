package ru.otus.spring.service;


import org.springframework.beans.factory.annotation.Autowired;

public class StudentsTestRunnerServiceImpl implements StudentsTestRunnerService{

    private final StudentsTestService studentsTestService;
    private final StudentAccountService studentAccountService;
    private final QuestionStreamService questionStreamService;

    @Autowired
    public StudentsTestRunnerServiceImpl(StudentsTestService studentsTestService, StudentAccountService studentAccountService, QuestionStreamService questionStreamService){
        this.studentsTestService = studentsTestService;
        this.studentAccountService = studentAccountService;
        this.questionStreamService = questionStreamService;
    }

    public void run(String[] args){
        studentAccountService.writeAgreement();
        String fio = studentAccountService.readFIO();

        String question =  studentsTestService.getCurrentQuestion(fio);
        questionStreamService.writeQuestion(question);
        while (!studentsTestService.isFlagTestFinished()){
            String answer = questionStreamService.readAnswer();
            studentsTestService.checkCurrentAnswer(answer);
            question =  studentsTestService.getCurrentQuestion(fio);
            questionStreamService.writeResult(question);
        }
    }

}
