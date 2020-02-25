package ru.otus.spring.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
public class StudentAccountServiceImpl implements StudentAccountService {

    private final WriteReadService writeReadService;

    @Autowired
    public StudentAccountServiceImpl(WriteReadService writeReadService){
        this.writeReadService = writeReadService;
    }

    public void writeAgreement(){
        writeReadService.writeMessage("Введите ФИО студента:");
    }

    public String readFIO(){
        return writeReadService.readMessage();
    }


}
