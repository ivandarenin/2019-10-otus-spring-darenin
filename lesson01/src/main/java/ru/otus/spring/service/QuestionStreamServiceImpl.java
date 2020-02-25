package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

public class QuestionStreamServiceImpl implements QuestionStreamService {

    private final WriteReadService writeReadService;

    @Autowired
    public QuestionStreamServiceImpl(WriteReadService writeReadService){
        this.writeReadService = writeReadService;
    }

    public void writeQuestion(String question){
        writeReadService.writeMessage(question);
    }

    public String readAnswer(){
        return writeReadService.readMessage();
    }

    public void writeResult(String result){
        writeReadService.writeMessage(result);
    }


}
