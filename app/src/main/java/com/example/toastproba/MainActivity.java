package com.example.toastproba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int a;
    public static int b;
    public static int c;
    public static int z=1;//используется как индикатор количества нажатий клавиши равно(см. ниже)
    public static int indplus;
    public static int indminus;
    public static int indumno;
    public static int indrazd;


    //////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    /////////////////////////////////////////////////////////////////////////////
    DisplayUpr Upr=new DisplayUpr();



    public void MyClick1(View view) {

        //Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_SHORT).show();
        TextView textView=findViewById(R.id.textView2);

        textView.setText(textView.getText() + "1");
    }

    public void MyClick2(View view) {
        TextView textView=findViewById(R.id.textView2);

        textView.setText(textView.getText() + "2");
    }

    public void MyClick3(View view) {
        TextView textView = findViewById(R.id.textView2);
        textView.setText(textView.getText() + "3");
    }

    public void MyClick4(View view) {
        TextView textView = findViewById(R.id.textView2);
        textView.setText(textView.getText() + "4");
    }
    public void MyClick5(View view) {
        TextView textView = findViewById(R.id.textView2);
        textView.setText(textView.getText() + "5");
    }
    public void MyClick6(View view) {
        TextView textView = findViewById(R.id.textView2);
        textView.setText(textView.getText() + "6");
    }
    public void MyClick7(View view) {
        TextView textView = findViewById(R.id.textView2);
        textView.setText(textView.getText() + "7");
    }
    public void MyClick8(View view) {
        TextView textView = findViewById(R.id.textView2);
        textView.setText(textView.getText() + "8");
    }
    public void MyClick9(View view) {
        TextView textView = findViewById(R.id.textView2);
        textView.setText(textView.getText() + "9");
    }
    public void MyClick0(View view) {
        TextView textView = findViewById(R.id.textView2);
        textView.setText(textView.getText() + "0");
    }
    /////////////////////////////////////////////////////////////////
    public void MyClickBack(View view){
        TextView textView=findViewById(R.id.textView2);
        StringBuilder sbf=new StringBuilder(textView.getText());
        //При нажатии бэкспэйс с пустым экраном возникала ошибка,программа вылетала
        //добавил условие,и всё прошло)
        if (sbf.length()==0) return;
        else{
        sbf.deleteCharAt(sbf.length()-1);
        String str;
        str=sbf.toString();
        textView.setText(str);}
    }
    /////////////////////////////////////////////////////////////////
    public void MyClickPlus(View view){
        TextView textView=findViewById(R.id.textView2);
        //Проверяем ,если поле не заполнено,выходим из процедуры:
        if(textView.getText()=="") return;

        String strplus;
        strplus=textView.getText().toString();
        int A=Integer.parseInt(strplus);
        a=A;
        //indplus=1;
        //indminus=0;
       // indumno=0;
       // indrazd=0;
        Upr.setPlus();
        textView.setText(null);
       z=1;
    }
    /////////////////////////////////////////////////////////////////
    public void MyClickMinus(View view){
        TextView textView=findViewById(R.id.textView2);
        if(textView.getText()=="") return;
        String strplus;
        strplus=textView.getText().toString();
        int A=Integer.parseInt(strplus);
        a=A;
        Upr.setMinus();
       // indplus=0;
       // indminus=1;
       // indumno=0;
       // indrazd=0;
        textView.setText(null);
        z=1;



    }
    /////////////////////////////////////////////////////////////////
    public void MyClickDel(View view){
        TextView textView=findViewById(R.id.textView2);
        if(textView.getText()=="") return;
        String strplus;
        strplus=textView.getText().toString();
        int A=Integer.parseInt(strplus);
        a=A;
        Upr.setRazd();
       // indplus=0;
        //indminus=0;
       // indumno=0;
       // indrazd=1;
        textView.setText(null);
       z=1;
    }
    /////////////////////////////////////////////////////////////////
    public void MyClickUmn(View view){
        TextView textView=findViewById(R.id.textView2);
        if(textView.getText()=="") return;
        String strplus;
        strplus=textView.getText().toString();
        int A=Integer.parseInt(strplus);
        a=A;
        //indplus=0;
        //indminus=0;
        //indumno=1;
      //  indrazd=0;
        Upr.setUmn();
        textView.setText(null);
      z=1;
    }
    /////////////////////////////////////////////////////////////////
    public void MyClickRav(View view){
        z++;//это переменная индикатор первого нажатия.Больше ни для чего она не нужна))



        ////////////////////////////////////////////////////////////////////////////////////Процедура проверки заполнения экранчика калькулятора
        TextView textView=findViewById(R.id.textView2);
        //Проверяем ,если поле не заполнено,выходим из процедуры:
        if(textView.getText()=="") return;
        ////////////////////////////////////////////////////////////////
        String screen;
        //помещаем содержимое экрана в строку скрин:
        screen=textView.getText().toString();
        //Условие с переменной зет вводим только для того,чтобы сохранитть переменную б(наше вычитаемое)
        //в первоначальном виде.То есть теперь мы получаем начальное значение с экранчика калькулятора и
        //фиксируем его в переменной.
       if (z==2){
        int B=Integer.parseInt(screen);
        //помещаем содержимое строки в переменнную б:
        b=B; }

        /////////////////////////////////////////////////

        if (Upr.getPlus())
            c=a+b;
        else if (Upr.getMinus())
            c=a-b;
        else if (Upr.getRazd())
            c=a/b;
        else if(Upr.getUmn())
            c=a*b;

        String str1;
        str1=Integer.toString(c);
        //Почему то вылетает с этого момента!!!
        //на следующий день разобрался,надо было число преобразовать в строку,прежде чем вставлять в техвиев.
        textView.setText(str1);
        //для корректной обработки повторного нажатия клавиши равно надо освежить значение а:
        int A=Integer.parseInt(textView.getText().toString());
//17.07.2022 осталась нерешённой проблема с повторным нажатием и корректным результатом.Буду думать.
        a=A;
        //Как оставить переменную б неизменой,независимо от количества нажатий?
        //18.07.2022 Итак проблема с неизменностью переменной б решена с помощью счётчика нажатий и условием,но возникла другая.
        //при сбросе и  следующей операции переменнаяпродолжает хранить прошлое значение))
        //будем думать дальше)







    }
}