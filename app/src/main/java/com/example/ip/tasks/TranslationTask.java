package com.example.ip.tasks;


public class TranslationTask extends Task {
    /*
        Класс для создания задания с переводом на русский язык показанного слова
         правильный ответ размещается в rightAnswer, в options нужно
        указать все варианты ответа, при этом word туда включать нужно
         */

    private final String word;

    public TranslationTask(String word, String rightAnswer){
        this.word = word;
        this.taskText = "Напишите правильный перевод слова " + word;
        this.rightAnswer = rightAnswer;
    }
}
