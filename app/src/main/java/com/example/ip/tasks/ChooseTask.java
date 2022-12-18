package com.example.ip.tasks;

import java.util.List;

public class ChooseTask extends Task {
    /*
    Класс для создания задания с переводом на русский язык выбранного слова
    (word) правильный ответ размещается в rightAnswer, в options нужно
    указать все варианты ответа, при этом word туда включать нужно
     */
    public final String word;
    public final List<String> options;

    public ChooseTask(String word, List<String> options, String rightAnswer){
        this.word = word;
        this.taskText = "Выберите правильный перевод слова " + word;
        this.options = options;
        this.rightAnswer = rightAnswer;
    }
}
