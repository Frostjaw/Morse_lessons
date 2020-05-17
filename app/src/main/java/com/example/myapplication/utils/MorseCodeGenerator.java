package com.example.myapplication.utils;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MorseCodeGenerator extends Application {

    private static MorseCodeGenerator instance;
    private SoundGenerator soundGenerator;
    private int dotDuration;
    private Handler handler;
    private ArrayList<Integer> charactersIndexPool;
    public ArrayList<Integer> generatedTextIndexes;
    public boolean charactersPoolIsEmpty;
    public final Map<Integer, String> morseDictionary = new HashMap<>();
    public final Map<String, Integer> inverseMorseDictionary = new HashMap<>();
    private final Map<Integer, Integer> delaysArray = new HashMap<>();

    // Logs
    final String LOG_TAG = "myLogs";

    @Override
    public void onCreate(){
        super.onCreate();

        instance = this;
        SharedPreferences settings = getSharedPreferences("userSettings", MODE_PRIVATE);
        int frequency = settings.getInt("Frequency",1000);
        soundGenerator = new SoundGenerator(frequency);
        dotDuration = settings.getInt("DotDuration", 150);
        handler = new Handler();
        charactersIndexPool = new ArrayList<>();
        generatedTextIndexes = new ArrayList<>();
        charactersPoolIsEmpty = true;

        initDelayArray();
        initMorseDictionary();
        initInverseMorseDictionary();
    }

    public static MorseCodeGenerator getMorseCodeGenerator(){
        return instance;
    }

    public void setFrequency(int frequency){
        soundGenerator = new SoundGenerator(frequency);
    }

    public void setDotDuration(int dotDuration){
        this.dotDuration = dotDuration;
    }

    // A
    public void play1(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
    }

    // Б
    public void play2(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
    }

    // В
    public void play3(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
    }

    // Г
    public void play4(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
    }

    // Д
    public void play5(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
    }

    // Е
    public void play6(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
    }

    // Ж
    public void play7(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
    }

    // З
    public void play8(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
    }

    // И
    public void play9(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
    }

    // Й
    public void play10(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
    }

    // К
    public void play11(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
    }

    // Л
    public void play12(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
    }

    // М
    public void play13(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
    }

    // Н
    public void play14(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
    }

    // О
    public void play15(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
    }

    // П
    public void play16(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
    }

    // Р
    public void play17(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
    }

    // С
    public void play18(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
    }

    // Т
    public void play19(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
    }

    // У
    public void play20(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
    }

    // Ф
    public void play21(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
    }

    // Х
    public void play22(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
    }

    // Ц
    public void play23(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
    }

    // Ч
    public void play24(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
    }

    // Ш
    public void play25(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *15);
    }

    // Щ
    public void play26(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
    }

    // Ы
    public void play27(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
    }

    // Ь
    public void play28(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
    }

    // Э
    public void play29(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
    }

    // Ю
    public void play30(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
    }

    // Я
    public void play31(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
    }

    // 1
    public void play32(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *14);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *17);
    }

    // 2
    public void play33(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *15);
    }

    // 3
    public void play34(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
    }

    // 4
    public void play35(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
    }

    // 5
    public void play36(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
    }

    // 6
    public void play37(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
    }

    // 7
    public void play38(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
    }

    // 8
    public void play39(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *14);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *15);
    }

    // 9
    public void play40(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *15);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *16);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *17);
    }

    // 0
    public void play41(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *15);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *16);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *19);
    }

    // Точка
    public void play42(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
    }

    // Запятая
    public void play43(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *14);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *17);
    }

    // Двоеточие
    public void play44(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *14);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *15);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *16);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *17);
    }

    // Точка с запятой
    public void play45(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *15);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *16);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *17);
    }

    // Скобка
    public void play46(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *14);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *15);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *16);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *19);
    }

    // Апостроф
    public void play47(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *14);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *17);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *18);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *19);
    }

    // Кавычки
    public void play48(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *14);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *15);
    }

    // Тире
    public void play49(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *15);
    }

    // Косая черта
    public void play50(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
    }

    // Вопросительный знак
    public void play51(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *14);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *15);
    }

    // Восклицательный знак
    public void play52(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *15);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *16);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *19);
    }

    // Знак раздела
    public void play53(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
    }

    // Ошибка/перебой
    public void play54(){
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *14);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *15);
    }

    // @
    public void play55(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *5);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *6);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *11);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *12);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *15);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *16);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *17);
    }

    // Конец связи
    public void play56(){
        soundGenerator.start();
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *2);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *3);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *4);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *7);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *8);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *9);
        handler.postDelayed(() -> soundGenerator.start(), dotDuration *10);
        handler.postDelayed(() -> soundGenerator.stop(), dotDuration *13);
    }

    public void playCharacter(int num){

        Class c = this.getClass();
        String methodName = "play" + num;
        Method method = null;
        try {
            method = c.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            method.invoke(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void setCharacterPoolForGeneration(char[] charArray) {

        charactersIndexPool.clear();

        if (charArray.length == 0) {
            charactersPoolIsEmpty = true;
        }else {
            for (char character:charArray) {
                String curCharacter = Character.toString(character).toUpperCase();
                charactersIndexPool.add(inverseMorseDictionary.get(curCharacter));
            }
            charactersPoolIsEmpty = false;
        }
    }

    public void addPunctuationMarksToPool(char[] punctuationMarksArray){
        if (punctuationMarksArray.length != 0){
            for (char character:punctuationMarksArray){

                // additional processing
                String curCharacter;
                switch (character){
                    case 'b':
                        curCharacter = "( )";
                        break;
                    case 'd':
                        curCharacter = "Знак раздела";
                        break;
                    case 'i':
                        curCharacter = "Ошибка/перебой";
                        break;
                    case 'e':
                        curCharacter = "Конец связи";
                        break;
                    default:
                        curCharacter = Character.toString(character).toUpperCase();
                        break;
                }
                charactersIndexPool.add(inverseMorseDictionary.get(curCharacter));
            }
            charactersPoolIsEmpty = false;
        }
    }

    public int getRandomCharacterFromPool() {

        if (!charactersIndexPool.isEmpty()) {
            Random random = new Random();
            int curIndex = random.nextInt(charactersIndexPool.size());

            return charactersIndexPool.get(curIndex);
        }

        return -1;
    }

    public String generateRandomText(int numberOfGroups) {
        generatedTextIndexes.clear();
        StringBuilder text = new StringBuilder();
        if (!charactersIndexPool.isEmpty()) {
            Random random = new Random();
            for (int i = 0; i < numberOfGroups; i++) {
                for (int j = 0; j < 5; j++) {
                    int curIndex = random.nextInt(charactersIndexPool.size());
                    int curCharacterIndex = charactersIndexPool.get(curIndex);

                    generatedTextIndexes.add(curCharacterIndex);
                    text.append(morseDictionary.get(curCharacterIndex));
                }
                generatedTextIndexes.add(-1);
                text.append(" ");
            }
        }
        return text.toString();
    }

    public void playText(String text) {
        int curCharIndex = generatedTextIndexes.get(0);
        playCharacter(curCharIndex);
        handler.postDelayed(() -> playCharacterFromTextAtIndex(1), dotDuration *(delaysArray.get(curCharIndex) + 3));
    }

    public void stopTextPlaying() {
        soundGenerator.stop();
        handler.removeCallbacksAndMessages(null);
    }

    private void playCharacterFromTextAtIndex(int index) {
        int curCharIndex = generatedTextIndexes.get(index);
        int nextIndex = index + 1;
        if (curCharIndex != -1) {
            playCharacter(curCharIndex);

            if (nextIndex < generatedTextIndexes.size()){
                handler.postDelayed(() -> playCharacterFromTextAtIndex(nextIndex), dotDuration *(delaysArray.get(curCharIndex) + 3));
            }
        } else if (nextIndex < generatedTextIndexes.size()){
            handler.postDelayed(() -> playCharacterFromTextAtIndex(nextIndex), dotDuration *5);
        }
    }

    public void start(){
        soundGenerator.start();
    }

    public void stop(){
        soundGenerator.stop();
    }

    private void initDelayArray() {
        delaysArray.put(1, 5);
        delaysArray.put(2, 9);
        delaysArray.put(3, 9);
        delaysArray.put(4, 9);
        delaysArray.put(5, 7);
        delaysArray.put(6, 1);
        delaysArray.put(7, 9);
        delaysArray.put(8, 11);
        delaysArray.put(9, 3);
        delaysArray.put(10, 13);
        delaysArray.put(11, 9);
        delaysArray.put(12, 9);
        delaysArray.put(13, 7);
        delaysArray.put(14, 5);
        delaysArray.put(15, 11);
        delaysArray.put(16, 11);
        delaysArray.put(17, 7);
        delaysArray.put(18, 5);
        delaysArray.put(19, 3);
        delaysArray.put(20, 7);
        delaysArray.put(21, 9);
        delaysArray.put(22, 7);
        delaysArray.put(23, 11);
        delaysArray.put(24, 13);
        delaysArray.put(25, 15);
        delaysArray.put(26, 13);
        delaysArray.put(27, 13);
        delaysArray.put(28, 11);
        delaysArray.put(29, 11);
        delaysArray.put(30, 11);
        delaysArray.put(31, 11);
        delaysArray.put(32, 17);
        delaysArray.put(33, 15);
        delaysArray.put(34, 13);
        delaysArray.put(35, 11);
        delaysArray.put(36, 9);
        delaysArray.put(37, 11);
        delaysArray.put(38, 13);
        delaysArray.put(39, 15);
        delaysArray.put(40, 17);
        delaysArray.put(41, 19);
        delaysArray.put(42, 11);
        delaysArray.put(43, 17);
        delaysArray.put(44, 17);
        delaysArray.put(45, 17);
        delaysArray.put(46, 19);
        delaysArray.put(47, 19);
        delaysArray.put(48, 15);
        delaysArray.put(49, 15);
        delaysArray.put(50, 13);
        delaysArray.put(51, 15);
        delaysArray.put(52, 19);
        delaysArray.put(53, 13);
        delaysArray.put(54, 15);
        delaysArray.put(55, 17);
        delaysArray.put(56, 13);
    }

    private void initMorseDictionary() {
        morseDictionary.put(1,"А");
        morseDictionary.put(2,"Б");
        morseDictionary.put(3,"В");
        morseDictionary.put(4,"Г");
        morseDictionary.put(5,"Д");
        morseDictionary.put(6,"Е");
        morseDictionary.put(7,"Ж");
        morseDictionary.put(8,"З");
        morseDictionary.put(9,"И");
        morseDictionary.put(10,"Й");
        morseDictionary.put(11,"К");
        morseDictionary.put(12,"Л");
        morseDictionary.put(13,"М");
        morseDictionary.put(14,"Н");
        morseDictionary.put(15,"О");
        morseDictionary.put(16,"П");
        morseDictionary.put(17,"Р");
        morseDictionary.put(18,"С");
        morseDictionary.put(19,"Т");
        morseDictionary.put(20,"У");
        morseDictionary.put(21,"Ф");
        morseDictionary.put(22,"Х");
        morseDictionary.put(23,"Ц");
        morseDictionary.put(24,"Ч");
        morseDictionary.put(25,"Ш");
        morseDictionary.put(26,"Щ");
        morseDictionary.put(27,"Ы");
        morseDictionary.put(28,"Ь");
        morseDictionary.put(29,"Э");
        morseDictionary.put(30,"Ю");
        morseDictionary.put(31,"Я");
        morseDictionary.put(32,"1");
        morseDictionary.put(33,"2");
        morseDictionary.put(34,"3");
        morseDictionary.put(35,"4");
        morseDictionary.put(36,"5");
        morseDictionary.put(37,"6");
        morseDictionary.put(38,"7");
        morseDictionary.put(39,"8");
        morseDictionary.put(40,"9");
        morseDictionary.put(41,"0");
        morseDictionary.put(42,".");
        morseDictionary.put(43,",");
        morseDictionary.put(44,":");
        morseDictionary.put(45,";");
        morseDictionary.put(46,"( )");
        morseDictionary.put(47,"'");
        morseDictionary.put(48,"\" \"");
        morseDictionary.put(49,"-");
        morseDictionary.put(50,"/");
        morseDictionary.put(51,"?");
        morseDictionary.put(52,"!");
        morseDictionary.put(53,"Знак раздела");
        morseDictionary.put(54,"Ошибка/перебой");
        morseDictionary.put(55,"@");
        morseDictionary.put(56,"Конец связи");
    }

    private void initInverseMorseDictionary() {
        inverseMorseDictionary.put("А", 1);
        inverseMorseDictionary.put("Б", 2);
        inverseMorseDictionary.put("В", 3);
        inverseMorseDictionary.put("Г", 4);
        inverseMorseDictionary.put("Д", 5);
        inverseMorseDictionary.put("Е", 6);
        inverseMorseDictionary.put("Ж", 7);
        inverseMorseDictionary.put("З", 8);
        inverseMorseDictionary.put("И", 9);
        inverseMorseDictionary.put("Й", 10);
        inverseMorseDictionary.put("К", 11);
        inverseMorseDictionary.put("Л", 12);
        inverseMorseDictionary.put("М", 13);
        inverseMorseDictionary.put("Н", 14);
        inverseMorseDictionary.put("О", 15);
        inverseMorseDictionary.put("П", 16);
        inverseMorseDictionary.put("Р", 17);
        inverseMorseDictionary.put("С", 18);
        inverseMorseDictionary.put("Т", 19);
        inverseMorseDictionary.put("У", 20);
        inverseMorseDictionary.put("Ф", 21);
        inverseMorseDictionary.put("Х", 22);
        inverseMorseDictionary.put("Ц", 23);
        inverseMorseDictionary.put("Ч", 24);
        inverseMorseDictionary.put("Ш", 25);
        inverseMorseDictionary.put("Щ", 26);
        inverseMorseDictionary.put("Ы", 27);
        inverseMorseDictionary.put("Ь", 28);
        inverseMorseDictionary.put("Э", 29);
        inverseMorseDictionary.put("Ю", 30);
        inverseMorseDictionary.put("Я", 31);
        inverseMorseDictionary.put("1", 32);
        inverseMorseDictionary.put("2", 33);
        inverseMorseDictionary.put("3", 34);
        inverseMorseDictionary.put("4", 35);
        inverseMorseDictionary.put("5", 36);
        inverseMorseDictionary.put("6", 37);
        inverseMorseDictionary.put("7", 38);
        inverseMorseDictionary.put("8", 39);
        inverseMorseDictionary.put("9", 40);
        inverseMorseDictionary.put("0", 41);
        inverseMorseDictionary.put(".", 42);
        inverseMorseDictionary.put(",", 43);
        inverseMorseDictionary.put(":", 44);
        inverseMorseDictionary.put(";", 45);
        inverseMorseDictionary.put("( )", 46);
        inverseMorseDictionary.put("'", 47);
        inverseMorseDictionary.put("\" \"", 48);
        inverseMorseDictionary.put("-", 49);
        inverseMorseDictionary.put("/", 50);
        inverseMorseDictionary.put("?", 51);
        inverseMorseDictionary.put("!", 52);
        inverseMorseDictionary.put("Знак раздела", 53);
        inverseMorseDictionary.put("Ошибка/перебой", 54);
        inverseMorseDictionary.put("@", 55);
        inverseMorseDictionary.put("Конец связи", 56);
    }
}
