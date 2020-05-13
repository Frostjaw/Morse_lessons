package com.example.myapplication.utils;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;

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
    private ArrayList<Integer> characterIndexPool;
    public final Map<Integer, String> morseDictionary = new HashMap<>();
    public final Map<String, Integer> inverseMorseDictionary = new HashMap<>();
    public boolean characterPoolIsEmpty;

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
        characterIndexPool = new ArrayList<>();
        characterPoolIsEmpty = true;
        
        morseDictionary.put(1,"А");
        inverseMorseDictionary.put("А", 1);
        morseDictionary.put(2,"Б");
        inverseMorseDictionary.put("Б", 2);
        morseDictionary.put(3,"В");
        inverseMorseDictionary.put("В", 3);
        morseDictionary.put(4,"Г");
        inverseMorseDictionary.put("Г", 4);
        morseDictionary.put(5,"Д");
        inverseMorseDictionary.put("Д", 5);
        morseDictionary.put(6,"Е");
        inverseMorseDictionary.put("Е", 6);
        morseDictionary.put(7,"Ж");
        inverseMorseDictionary.put("Ж", 7);
        morseDictionary.put(8,"З");
        inverseMorseDictionary.put("З", 8);
        morseDictionary.put(9,"И");
        inverseMorseDictionary.put("И", 9);
        morseDictionary.put(10,"Й");
        inverseMorseDictionary.put("Й", 10);
        morseDictionary.put(11,"К");
        inverseMorseDictionary.put("К", 11);
        morseDictionary.put(12,"Л");
        inverseMorseDictionary.put("Л", 12);
        morseDictionary.put(13,"М");
        inverseMorseDictionary.put("М", 13);
        morseDictionary.put(14,"Н");
        inverseMorseDictionary.put("Н", 14);
        morseDictionary.put(15,"О");
        inverseMorseDictionary.put("О", 15);
        morseDictionary.put(16,"П");
        inverseMorseDictionary.put("П", 16);
        morseDictionary.put(17,"Р");
        inverseMorseDictionary.put("Р", 17);
        morseDictionary.put(18,"С");
        inverseMorseDictionary.put("С", 18);
        morseDictionary.put(19,"Т");
        inverseMorseDictionary.put("Т", 19);
        morseDictionary.put(20,"У");
        inverseMorseDictionary.put("У", 20);
        morseDictionary.put(21,"Ф");
        inverseMorseDictionary.put("Ф", 21);
        morseDictionary.put(22,"Х");
        inverseMorseDictionary.put("Х", 22);
        morseDictionary.put(23,"Ц");
        inverseMorseDictionary.put("Ц", 23);
        morseDictionary.put(24,"Ч");
        inverseMorseDictionary.put("Ч", 24);
        morseDictionary.put(25,"Ш");
        inverseMorseDictionary.put("Ш", 25);
        morseDictionary.put(26,"Щ");
        inverseMorseDictionary.put("Щ", 26);
        morseDictionary.put(27,"Ы");
        inverseMorseDictionary.put("Ы", 27);
        morseDictionary.put(28,"Ь");
        inverseMorseDictionary.put("Ь", 28);
        morseDictionary.put(29,"Э");
        inverseMorseDictionary.put("Э", 29);
        morseDictionary.put(30,"Ю");
        inverseMorseDictionary.put("Ю", 30);
        morseDictionary.put(31,"Я");
        inverseMorseDictionary.put("Я", 31);
        morseDictionary.put(32,"1");
        inverseMorseDictionary.put("1", 32);
        morseDictionary.put(33,"2");
        inverseMorseDictionary.put("2", 33);
        morseDictionary.put(34,"3");
        inverseMorseDictionary.put("3", 34);
        morseDictionary.put(35,"4");
        inverseMorseDictionary.put("4", 35);
        morseDictionary.put(36,"5");
        inverseMorseDictionary.put("5", 36);
        morseDictionary.put(37,"6");
        inverseMorseDictionary.put("6", 37);
        morseDictionary.put(38,"7");
        inverseMorseDictionary.put("7", 38);
        morseDictionary.put(39,"8");
        inverseMorseDictionary.put("8", 39);
        morseDictionary.put(40,"9");
        inverseMorseDictionary.put("9", 40);
        morseDictionary.put(41,"0");
        inverseMorseDictionary.put("0", 41);
        morseDictionary.put(42,".");
        inverseMorseDictionary.put(".", 42);
        morseDictionary.put(43,",");
        inverseMorseDictionary.put(",", 43);
        morseDictionary.put(44,":");
        inverseMorseDictionary.put(":", 44);
        morseDictionary.put(45,";");
        inverseMorseDictionary.put(";", 45);
        morseDictionary.put(46,"( )");
        inverseMorseDictionary.put("( )", 46);
        morseDictionary.put(47,"'");
        inverseMorseDictionary.put("'", 47);
        morseDictionary.put(48,"\" \"");
        inverseMorseDictionary.put("\" \"", 48);
        morseDictionary.put(49,"-");
        inverseMorseDictionary.put("-", 49);
        morseDictionary.put(50,"/");
        inverseMorseDictionary.put("/", 50);
        morseDictionary.put(51,"?");
        inverseMorseDictionary.put("?", 51);
        morseDictionary.put(52,"!");
        inverseMorseDictionary.put("!", 52);
        morseDictionary.put(53,"Знак раздела");
        inverseMorseDictionary.put("Знак раздела", 53);
        morseDictionary.put(54,"Ошибка/перебой");
        inverseMorseDictionary.put("Ошибка/перебой", 54);
        morseDictionary.put(55,"@");
        inverseMorseDictionary.put("@", 55);
        morseDictionary.put(56,"Конец связи");
        inverseMorseDictionary.put("Конец связи", 56);
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

    public void playConcrete(int num){

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

        characterIndexPool.clear();

        if (charArray.length == 0) {
            characterPoolIsEmpty = true;
        }else {
            for (char character:charArray) {
                String curCharacter = Character.toString(character).toUpperCase();
                characterIndexPool.add(inverseMorseDictionary.get(curCharacter));
            }
            characterPoolIsEmpty = false;
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
                characterIndexPool.add(inverseMorseDictionary.get(curCharacter));
            }
            characterPoolIsEmpty = false;
        }
    }

    public int getAndPlayCharacterFromPool() {

        if (!characterIndexPool.isEmpty()) {
            Random random = new Random();
            int curIndex = random.nextInt(characterIndexPool.size()) + 1;
            playConcrete(characterIndexPool.get(curIndex));

            return characterIndexPool.get(curIndex);
        }

        return -1;
    }

    public int getRandomCharacterFromPool() {

        if (!characterIndexPool.isEmpty()) {
            Random random = new Random();
            int curIndex = random.nextInt(characterIndexPool.size()) + 1;

            return characterIndexPool.get(curIndex);
        }

        return -1;
    }

    public String generateRandomText(int numberOfGroups) {
        StringBuilder text = new StringBuilder();
        if (!characterIndexPool.isEmpty()) {
            Random random = new Random();
            for (int i = 0; i < numberOfGroups; i++) {
                for (int j = 0; j < 5; j++) {
                    int curCharacterIndex = random.nextInt(characterIndexPool.size()) + 1;
                    text.append(morseDictionary.get(curCharacterIndex));
                    Log.d(LOG_TAG, String.valueOf(curCharacterIndex));
                }
                text.append(" ");
            }
        }
        return text.toString();
    }

    public void start(){
        soundGenerator.start();
    }

    public void stop(){
        soundGenerator.stop();
    }
}
