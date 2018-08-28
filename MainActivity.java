package com.example.alex.calc;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    Button btn_1, btn_2, btn_3, btn_4,
            btn_5, btn_6, btn_7, btn_8,
            btn_9, btn_0, btn_clrscr, btn_sqrt,
            btnPorM, btn_back, btn_div, btn_mult,
            btn_min, btn_dot, btn_result, btn_plus;

    TextView textDisplay;
    String calcString = "";
    int countNumber = 0;
    int countAfterdot = 0;
    String messageFlag = "";

    inputNumberProcessing numberInput = new inputNumberProcessing();
    signProcessing sign = new signProcessing();
    ClearBackSpaceProcessing clrBack = new ClearBackSpaceProcessing();
    resultProcessing result = new resultProcessing();
    SquareRoot sqrt = new SquareRoot();
    PlusOrMinus plOrMinus = new PlusOrMinus();
    Counter count = new Counter();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_clrscr = (Button) findViewById(R.id.btn_clrscr);
        btn_sqrt = (Button) findViewById(R.id.btn_sqrt);
        btnPorM = (Button) findViewById(R.id.btnPorM);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_min = (Button) findViewById(R.id.btn_min);
        btn_mult = (Button) findViewById(R.id.btn_mult);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_result = (Button) findViewById(R.id.btn_result);

        textDisplay = (TextView) findViewById(R.id.textDisplay);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btnPorM.setOnClickListener(this);
        btn_clrscr.setOnClickListener(this);
        btn_sqrt.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_min.setOnClickListener(this);
        btn_mult.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_result.setOnClickListener(this);


    }

    public void onClick(View view) {

        Button button = (Button)view;
        String buttonTextString = button.getText().toString();
        char buttonTextChar = buttonTextString.charAt(0);
        short symbolCode = (short) buttonTextChar;


        if ((48 <= symbolCode && symbolCode <= 57) || symbolCode == 46){
            //System.out.println("цифра или точка: " + buttonTextChar);
            messageFlag = count.Count(calcString);
            if (messageFlag.equals("")){
                calcString = numberInput.anySymbol(buttonTextString, calcString);
            }
            else if (messageFlag.equals("100")){
                message(messageFlag);
            }
            else if (messageFlag.equals("8")){
                message(messageFlag);
            }
            else if (messageFlag.equals("15")){
                message(messageFlag);
            }
            display();
            //а здесь будет вызываться только display и все.
        }

        else if (symbolCode == 215 || symbolCode == 43 ||
                 symbolCode == 45 || symbolCode == 47){

            System.out.println("знак: " + buttonTextChar);
            count.Count(calcString);
            calcString = sign.anySign(buttonTextString, calcString);
            display();

        }

        else if (symbolCode == 67 || symbolCode == 8592){

            //System.out.println("сброс или backSpace: " + buttonTextChar);
            count.Count(calcString);
            calcString = clrBack.clrscrOrBackSpace(buttonTextString, calcString);
            display();

        }

        else if (symbolCode == 61){
            count.Count(calcString);
            calcString = result.ParseString(calcString);
            display();
            //System.out.println("равно: " + buttonTextChar);
        }

        else if (symbolCode == 177){

            //System.out.println("плюс/минус: " + buttonTextChar);
            calcString = plOrMinus.PlusMinus(calcString);
            display();

        }

        else if (symbolCode == 8730){
            messageFlag = sqrt.testString(calcString);
            if (messageFlag.equals("")) {
                calcString = sqrt.getCalcString();
                display();
                //System.out.println("корень: " + buttonTextChar);
            }
            else {
                message(messageFlag);
            }

        }

    }

    public void message(String massageFlag){
        Toast toast;
        switch (massageFlag){
            case "15":
                toast = Toast.makeText(this, "Превышено максимальное количество цифр (15).", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case "8":
                toast = Toast.makeText(this, " максимальное количество цифр после запятой (8).", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case "100":
                toast = Toast.makeText(this, "Превышено максимальное количество знаков (100).", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case "sqrt20":
                toast = Toast.makeText(this, "Эта функция работает только с одиночным числом" +
                        " введите число и нажмите √", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case "sqrt0":
                toast = Toast.makeText(this, "Введите число", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }

    }

    public void display(){

        textDisplay.setText(calcString);

    }

}
