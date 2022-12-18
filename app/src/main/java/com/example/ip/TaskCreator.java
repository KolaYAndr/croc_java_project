package com.example.ip;

import com.example.ip.tasks.ChooseTask;
import com.example.ip.tasks.TranslationTask;
import com.example.ip.tasks.VoiceTask;

import java.util.ArrayList;

public class TaskCreator {

    public static ArrayList<ChooseTask> createChooseTasks(){
        ArrayList<ChooseTask> chooseTasks = new ArrayList<>(10);

        ChooseTask task0 = new ChooseTask("Raindrops", createStringForTask("Капли дождя", "Вода", "Слёзы", "Град"), "Капли дождя");
        chooseTasks.add(task0);

        ChooseTask task1 = new ChooseTask("Tranquility", createStringForTask("Транквилизатор", "Спокойствие", "Обезбаливающее", "Тишина"), "Спокойствие");
        chooseTasks.add(task1);

        ChooseTask task2 = new ChooseTask("Passion", createStringForTask("Страсть", "Любовь", "Влечение", "Желание"), "Страсть");
        chooseTasks.add(task2);

        ChooseTask task3 = new ChooseTask("Eternity", createStringForTask("Пустота", "Пространство", "Смысл", "Вечность"), "Вечность");
        chooseTasks.add(task3);

        ChooseTask task4 = new ChooseTask("Lullaby", createStringForTask("Колыбельная", "Кровать", "Игрушка", "Детство"), "Колыбельная");
        chooseTasks.add(task4);

        ChooseTask task5 = new ChooseTask("Mist", createStringForTask("Дымка", "Туман", "Облако", "Роса"), "Туман");
        chooseTasks.add(task5);

        ChooseTask task6 = new ChooseTask("Aurora", createStringForTask("Северное сияние", "Полярная ночь", "Чудо", "Солнечный ветер"), "Северное сияние");
        chooseTasks.add(task6);

        ChooseTask task7 = new ChooseTask("Meadow", createStringForTask("Лес", "Огород", "Поляна", "Опушка"), "Поляна");
        chooseTasks.add(task7);

        ChooseTask task8 = new ChooseTask("Betrayal", createStringForTask("Дезертирство", "Бегство", "Приказ", "Предательство"), "Предательство");
        chooseTasks.add(task8);

        ChooseTask task9 = new ChooseTask("Oblivion", createStringForTask("Забвение", "Небытие", "Пустота", "Пыль"), "Забвение");
        chooseTasks.add(task9);

        return chooseTasks;
    }

    private static ArrayList<String> createStringForTask(String s0, String s1, String s2, String s3) {
        ArrayList<String> strings = new ArrayList<>(4);
        strings.add(s0);
        strings.add(s1);
        strings.add(s2);
        strings.add(s3);
        return strings;
    }

    public static ArrayList<VoiceTask> createVoiceTasks(){
        ArrayList<VoiceTask> voiceTasks = new ArrayList<>(5);

        VoiceTask task0 = new VoiceTask(R.raw.destiny, createStringForTask("Судьба", "Предназначение", "Путь", "Рок"), "Судьба");
        voiceTasks.add(task0);

        VoiceTask task1 = new VoiceTask(R.raw.freedom, createStringForTask("Воля", "Независимость", "Свобода", "Равенство"), "Свобода");
        voiceTasks.add(task1);

        VoiceTask task2 = new VoiceTask(R.raw.fantastic, createStringForTask("Невероятный", "Фантастический", "Улётный", "Кайфовый"), "Фантастический");
        voiceTasks.add(task2);

        VoiceTask task3 = new VoiceTask(R.raw.smile, createStringForTask("Улыбка", "Гримасса", "Смешок", "Лицо"), "Улыбка");
        voiceTasks.add(task3);

        VoiceTask task4 = new VoiceTask(R.raw.sustainability, createStringForTask("Долговечность", "Устойчивость", "Стабильность", "Прочность"), "Устойчивость");
        voiceTasks.add(task4);

        return voiceTasks;
    }

    public static ArrayList<TranslationTask> createTranslationTasks(){
        ArrayList<TranslationTask> translationTasks = new ArrayList<>(5);

        TranslationTask task0 = new TranslationTask("Desire", "Желание");
        translationTasks.add(task0);

        TranslationTask task1 = new TranslationTask("Glory", "Слава");
        translationTasks.add(task1);

        TranslationTask task2 = new TranslationTask("Experience", "Опыт");
        translationTasks.add(task2);

        TranslationTask task3 = new TranslationTask("Rebellion", "Мятеж");
        translationTasks.add(task3);

        TranslationTask task4 = new TranslationTask("Sunset", "Закат");
        translationTasks.add(task4);

        return translationTasks;
    }

}
