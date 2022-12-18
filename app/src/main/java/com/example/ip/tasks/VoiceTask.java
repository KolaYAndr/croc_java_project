package com.example.ip.tasks;


import androidx.annotation.RawRes;

import java.util.List;

public class VoiceTask extends Task {

    /*
        Класс для создания задания с переводом на русский язык озвученного слова
         правильный ответ размещается в rightAnswer, в options нужно
        указать все варианты ответа, при этом word туда включать нужно
         */
    private final int audio;
    public final List<String> options;

    public VoiceTask(@RawRes int audio, List<String> options, String rightAnswer){
        this.audio = audio;
        this.taskText = "Выберите правильный перевод озвученного слова";
        this.options = options;
        this.rightAnswer = rightAnswer;
    }


    public int getAudio() {
        return audio;
    }
}
