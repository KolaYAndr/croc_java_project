package com.example.ip.tasks;

public abstract class Task {
    public String taskText;
    public String rightAnswer;

    public boolean checkIfAnswerGivenIsRight(String givenAnswer){
        return rightAnswer.equalsIgnoreCase(givenAnswer);
    }
}
