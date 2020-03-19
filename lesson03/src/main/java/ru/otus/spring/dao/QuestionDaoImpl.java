package ru.otus.spring.dao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.otus.spring.config.AppConfig;
import ru.otus.spring.domain.Question;

import java.util.*;

@Service
public class QuestionDaoImpl implements QuestionDao {

    private List<Question> listOfQuestions = new ArrayList<>();

    private final String resourceFileName;

    public QuestionDaoImpl(AppConfig appConfig){
        resourceFileName = appConfig.getResourceFileName();
        Resource resourceFile = loadQuestions();
        String fileContent = ResourceReader.asString(resourceFile);
        parse(fileContent);
    }

    private Resource loadQuestions() {
        return new ClassPathResource(resourceFileName);
    }

    private void parse(String fileContent){
        if(fileContent!=null){
            String[] lines = fileContent.split("\r\n");
            for (String line: lines){
                String[] elements = line.split(";");
                if(elements.length>1){
                    String questionElement = elements[0];
                    String answerElement = StringUtils.trimWhitespace(elements[1]);
                    Question question = new Question(questionElement, answerElement);
                    listOfQuestions.add(question);
                }
            }

        }
    }


    @Override
    public Question getQuestionByNumber(int number){
        if(listOfQuestions.size() >= number) {
            return listOfQuestions.get(number - 1);
        }
        return null;
    }

}
