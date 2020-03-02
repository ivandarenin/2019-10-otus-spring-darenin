package ru.otus.spring.service;

import lombok.Getter;
import org.springframework.stereotype.Service;


@Getter
@Service
public class StudentAccountServiceImpl implements StudentAccountService {

    private final WriteReadService writeReadService;
    private final LocalizationService localizationService;

    public StudentAccountServiceImpl(WriteReadService writeReadService, LocalizationService localizationService ){
        this.writeReadService = writeReadService;
        this.localizationService = localizationService;
    }

    public void writeAgreement(){
        String greeting = localizationService.getLocalizedMessage("greeting");
        writeReadService.writeMessage(greeting);
    }

    public String readFIO(){
        return writeReadService.readMessage();
    }
}
