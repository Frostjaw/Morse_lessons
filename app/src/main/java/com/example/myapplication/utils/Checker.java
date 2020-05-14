package com.example.myapplication.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

public class Checker {
    private TextView _textView;
    private int counter;
    private int[] characterCode;
    private CountDownTimer timer;

    public Checker(TextView textview){
        _textView = textview;
        counter = 0;

        timer = new CountDownTimer(1000, 1000) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                _textView.setText("Неверно");
                counter = 0;
            }
        };
    }

    public void check(int curCharacter, int curCode){
        switch (curCharacter) {
            // А
            case 1:
                characterCode = new int[]{0,1};
                break;
            // Б
            case 2:
                characterCode = new int[]{1,0,0,0};
                break;
            // В
            case 3:
                characterCode = new int[]{0,1,1};
                break;
            // Г
            case 4:
                characterCode = new int[]{1,1,0};
                break;
            // Д
            case 5:
                characterCode = new int[]{1,0,0};
                break;
            // Е
            case 6:
                characterCode = new int[]{0};
                break;
            // Ж
            case 7:
                characterCode = new int[]{0,0,0,1};
                break;
            // З
            case 8:
                characterCode = new int[]{1,1,0,0};
                break;
            // И
            case 9:
                characterCode = new int[]{0,0};
                break;
            // Й
            case 10:
                characterCode = new int[]{0,1,1,1};
                break;
            // К
            case 11:
                characterCode = new int[]{1,0,1};
                break;
            // Л
            case 12:
                characterCode = new int[]{0,1,0,0};
                break;
            // М
            case 13:
                characterCode = new int[]{1,1};
                break;
            // Н
            case 14:
                characterCode = new int[]{1,0};
                break;
            // О
            case 15:
                characterCode = new int[]{1,1,1};
                break;
            // П
            case 16:
                characterCode = new int[]{0,1,1,0};
                break;
            // Р
            case 17:
                characterCode = new int[]{0,1,0};
                break;
            // С
            case 18:
                characterCode = new int[]{0,0,0};
                break;
            // Т
            case 19:
                characterCode = new int[]{1};
                break;
            // У
            case 20:
                characterCode = new int[]{0,0,1};
                break;
            // Ф
            case 21:
                characterCode = new int[]{0,0,1,0};
                break;
            // Х
            case 22:
                characterCode = new int[]{0,0,0,0};
                break;
            // Ц
            case 23:
                characterCode = new int[]{1,0,1,0};
                break;
            // Ч
            case 24:
                characterCode = new int[]{1,1,1,0};
                break;
            // Ш
            case 25:
                characterCode = new int[]{1,1,1,1};
                break;
            // Щ
            case 26:
                characterCode = new int[]{1,1,0,1};
                break;
            // Ы
            case 27:
                characterCode = new int[]{1,0,1,1};
                break;
            // Ь
            case 28:
                characterCode = new int[]{1,0,0,1};
                break;
            // Э
            case 29:
                characterCode = new int[]{0,0,1,0,0};
                break;
            // Ю
            case 30:
                characterCode = new int[]{0,0,1,1};
                break;
            // Я
            case 31:
                characterCode = new int[]{0,1,0,1};
                break;
            // 1
            case 32:
                characterCode = new int[]{0,1,1,1,1};
                break;
            // 2
            case 33:
                characterCode = new int[]{0,0,1,1,1};
                break;
            // 3
            case 34:
                characterCode = new int[]{0,0,0,1,1};
                break;
            // 4
            case 35:
                characterCode = new int[]{0,0,0,0,1};
                break;
            // 5
            case 36:
                characterCode = new int[]{0,0,0,0,0};
                break;
            // 6
            case 37:
                characterCode = new int[]{1,0,0,0,0};
                break;
            // 7
            case 38:
                characterCode = new int[]{1,1,0,0,0};
                break;
            // 8
            case 39:
                characterCode = new int[]{1,1,1,0,0};
                break;
            // 9
            case 40:
                characterCode = new int[]{1,1,1,1,0};
                break;
            // 0
            case 41:
                characterCode = new int[]{1,1,1,1,1};
                break;
            // Точка
            case 42:
                characterCode = new int[]{0,0,0,0,0,0};
                break;
            // Запятая
            case 43:
                characterCode = new int[]{0,1,0,1,0,1};
                break;
            // Двоеточие
            case 44:
                characterCode = new int[]{1,1,1,0,0,0};
                break;
            // Точка с запятой
            case 45:
                characterCode = new int[]{1,0,1,0,1,0};
                break;
            // Скобка
            case 46:
                characterCode = new int[]{1,0,1,1,0,1};
                break;
            // Апостроф
            case 47:
                characterCode = new int[]{0,1,1,1,1,0};
                break;
            // Кавычки
            case 48:
                characterCode = new int[]{0,1,0,0,1,0};
                break;
            // Тире
            case 49:
                characterCode = new int[]{1,0,0,0,0,1};
                break;
            // Косая черта
            case 50:
                characterCode = new int[]{1,0,0,1,0};
                break;
            // Вопросительный знак
            case 51:
                characterCode = new int[]{0,0,1,1,0,0};
                break;
            // Восклицательный знак
            case 52:
                characterCode = new int[]{1,1,0,0,1,1};
                break;
            // Знак раздела
            case 53:
                characterCode = new int[]{1,0,0,0,1};
                break;
            // Ошибка/перебой
            case 54:
                characterCode = new int[]{0,0,0,0,0,0,0,0};
                break;
            // @
            case 55:
                characterCode = new int[]{0,1,1,0,1,0};
                break;
            // Конец связи
            case 56:
                characterCode = new int[]{0,0,1,0,1};
                break;
        }

        timer.cancel();
        if (counter < characterCode.length) {
            if (curCode == characterCode[counter]) {
                counter++;
                timer.start();
                if (counter == characterCode.length) {
                    _textView.setText("Верно");
                    counter = 0;
                    timer.cancel();
                }
            } else {
                counter = 0;
                _textView.setText("Неверно");
            }
        }
    }

    public int checkCharacterInText(int curCharacter, int curCode) {
        switch (curCharacter) {
            // А
            case 1:
                characterCode = new int[]{0,1};
                break;
            // Б
            case 2:
                characterCode = new int[]{1,0,0,0};
                break;
            // В
            case 3:
                characterCode = new int[]{0,1,1};
                break;
            // Г
            case 4:
                characterCode = new int[]{1,1,0};
                break;
            // Д
            case 5:
                characterCode = new int[]{1,0,0};
                break;
            // Е
            case 6:
                characterCode = new int[]{0};
                break;
            // Ж
            case 7:
                characterCode = new int[]{0,0,0,1};
                break;
            // З
            case 8:
                characterCode = new int[]{1,1,0,0};
                break;
            // И
            case 9:
                characterCode = new int[]{0,0};
                break;
            // Й
            case 10:
                characterCode = new int[]{0,1,1,1};
                break;
            // К
            case 11:
                characterCode = new int[]{1,0,1};
                break;
            // Л
            case 12:
                characterCode = new int[]{0,1,0,0};
                break;
            // М
            case 13:
                characterCode = new int[]{1,1};
                break;
            // Н
            case 14:
                characterCode = new int[]{1,0};
                break;
            // О
            case 15:
                characterCode = new int[]{1,1,1};
                break;
            // П
            case 16:
                characterCode = new int[]{0,1,1,0};
                break;
            // Р
            case 17:
                characterCode = new int[]{0,1,0};
                break;
            // С
            case 18:
                characterCode = new int[]{0,0,0};
                break;
            // Т
            case 19:
                characterCode = new int[]{1};
                break;
            // У
            case 20:
                characterCode = new int[]{0,0,1};
                break;
            // Ф
            case 21:
                characterCode = new int[]{0,0,1,0};
                break;
            // Х
            case 22:
                characterCode = new int[]{0,0,0,0};
                break;
            // Ц
            case 23:
                characterCode = new int[]{1,0,1,0};
                break;
            // Ч
            case 24:
                characterCode = new int[]{1,1,1,0};
                break;
            // Ш
            case 25:
                characterCode = new int[]{1,1,1,1};
                break;
            // Щ
            case 26:
                characterCode = new int[]{1,1,0,1};
                break;
            // Ы
            case 27:
                characterCode = new int[]{1,0,1,1};
                break;
            // Ь
            case 28:
                characterCode = new int[]{1,0,0,1};
                break;
            // Э
            case 29:
                characterCode = new int[]{0,0,1,0,0};
                break;
            // Ю
            case 30:
                characterCode = new int[]{0,0,1,1};
                break;
            // Я
            case 31:
                characterCode = new int[]{0,1,0,1};
                break;
            // 1
            case 32:
                characterCode = new int[]{0,1,1,1,1};
                break;
            // 2
            case 33:
                characterCode = new int[]{0,0,1,1,1};
                break;
            // 3
            case 34:
                characterCode = new int[]{0,0,0,1,1};
                break;
            // 4
            case 35:
                characterCode = new int[]{0,0,0,0,1};
                break;
            // 5
            case 36:
                characterCode = new int[]{0,0,0,0,0};
                break;
            // 6
            case 37:
                characterCode = new int[]{1,0,0,0,0};
                break;
            // 7
            case 38:
                characterCode = new int[]{1,1,0,0,0};
                break;
            // 8
            case 39:
                characterCode = new int[]{1,1,1,0,0};
                break;
            // 9
            case 40:
                characterCode = new int[]{1,1,1,1,0};
                break;
            // 0
            case 41:
                characterCode = new int[]{1,1,1,1,1};
                break;
            // Точка
            case 42:
                characterCode = new int[]{0,0,0,0,0,0};
                break;
            // Запятая
            case 43:
                characterCode = new int[]{0,1,0,1,0,1};
                break;
            // Двоеточие
            case 44:
                characterCode = new int[]{1,1,1,0,0,0};
                break;
            // Точка с запятой
            case 45:
                characterCode = new int[]{1,0,1,0,1,0};
                break;
            // Скобка
            case 46:
                characterCode = new int[]{1,0,1,1,0,1};
                break;
            // Апостроф
            case 47:
                characterCode = new int[]{0,1,1,1,1,0};
                break;
            // Кавычки
            case 48:
                characterCode = new int[]{0,1,0,0,1,0};
                break;
            // Тире
            case 49:
                characterCode = new int[]{1,0,0,0,0,1};
                break;
            // Косая черта
            case 50:
                characterCode = new int[]{1,0,0,1,0};
                break;
            // Вопросительный знак
            case 51:
                characterCode = new int[]{0,0,1,1,0,0};
                break;
            // Восклицательный знак
            case 52:
                characterCode = new int[]{1,1,0,0,1,1};
                break;
            // Знак раздела
            case 53:
                characterCode = new int[]{1,0,0,0,1};
                break;
            // Ошибка/перебой
            case 54:
                characterCode = new int[]{0,0,0,0,0,0,0,0};
                break;
            // @
            case 55:
                characterCode = new int[]{0,1,1,0,1,0};
                break;
            // Конец связи
            case 56:
                characterCode = new int[]{0,0,1,0,1};
                break;
        }

        int test = 0;

        timer.cancel();
        if (counter < characterCode.length) {
            if (curCode == characterCode[counter]) {
                counter++;
                timer.start();
                if (counter == characterCode.length) {
                    _textView.setText("Верно");
                    counter = 0;
                    timer.cancel();

                    test = 1;
                }
            } else {
                counter = 0;
                _textView.setText("Неверно");

                test = 1;
            }
        }

        return test;
    }
}
