package com.example.alex.calc;

import java.util.ArrayList;


public class resultProcessing {

    public ArrayList <String> partsOfCalcString = new ArrayList<>();

    String result = "";

    public String ParseString(String calcString){
        char endOfCalcString = '?';
        partsOfCalcString.clear();

        if (calcString.length() != 0){
            endOfCalcString = calcString.charAt(calcString.length() - 1);
            if (endOfCalcString == '-' || endOfCalcString == '+' ||
                endOfCalcString == '/' || endOfCalcString == '×'){

                calcString = calcString + "\nневерный формат";
                result = calcString;
            }
            else if (DivideByZero(calcString) == true){

                calcString = calcString + "\nнедоп. операция";
                result = calcString;
            }

            //else if (calcString)

            else if (signProcessing.MinusTest(calcString) == true){  // куда всунуть это условие чтобы все работало как надо?
                calcString = calcString + ")";
                // здесь вызываем преоразование в ArrayList
                partsOfCalcString = TransformToArrayList(calcString);
                if (partsOfCalcString.size() < 3){

                    result = calcString;
                }
                //System.out.println(partsOfCalcString);
                else {
                    result = Calculate(partsOfCalcString);

                }
            }
            else {
                partsOfCalcString = TransformToArrayList(calcString);
                if (partsOfCalcString.size() < 3){
                    result = calcString;

                }
                else {
                    result = Calculate(partsOfCalcString);
                }
                System.out.println(partsOfCalcString);
            }
        }

        //result = Calculate(partsOfCalcString);





        //result = Calculate(partsOfCalcString);
        System.out.println(result);
        //System.out.println(result);

        return result;
    }

    public String Calculate(ArrayList partsOfCalcString){
        String result = "";
        int index1 = -1;
        int index2 = -1;

        while (partsOfCalcString.size() != 1){ //истинное условие partsOfCalcString.isEmpty() != true

            while (partsOfCalcString.indexOf("×") != -1 || partsOfCalcString.indexOf("/") != -1){
                index1 = partsOfCalcString.indexOf("×");
                index2 = partsOfCalcString.indexOf("/");

                if ((index1 != -1 && index2 != -1) && (index1 > index2)){
                    result = subCalculate("/", partsOfCalcString.get(index2 - 1).toString(), partsOfCalcString.get(index2 + 1).toString());
                    //result = subCalculate("/", partsOfCalcString.get(index2 - 1).toString(), partsOfCalcString.get(index2 - 1).toString());
                    partsOfCalcString.remove(index2 - 1);
                    partsOfCalcString.remove(index2 - 1);
                    partsOfCalcString.remove(index2 - 1);
                    partsOfCalcString.add(index2 - 1, result);
                    System.out.println("////////////////////////////////////");
                    System.out.println(partsOfCalcString);
                    System.out.println("result = " + result);
                    System.out.println();

                }
                else if ((index1 != -1 && index2 != -1) && (index2 > index1)){
                    result = subCalculate("×", partsOfCalcString.get(index1 - 1).toString(), partsOfCalcString.get(index1 + 1).toString());
                    partsOfCalcString.remove(index1 - 1);
                    partsOfCalcString.remove(index1 - 1);
                    partsOfCalcString.remove(index1 - 1);
                    partsOfCalcString.add(index1 - 1, result);
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println(partsOfCalcString);
                    System.out.println("result = " + result);
                    System.out.println();

                }

                else if (index1 != -1 && index2 == -1){
                    result = subCalculate("×", partsOfCalcString.get(index1 - 1).toString(), partsOfCalcString.get(index1 + 1).toString());
                    partsOfCalcString.remove(index1 - 1);
                    partsOfCalcString.remove(index1 - 1);
                    partsOfCalcString.remove(index1 - 1);
                    partsOfCalcString.add(index1 - 1, result);
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println(partsOfCalcString);
                    System.out.println("result = " + result);
                    System.out.println();
                }
                else if (index2 != -1 && index1 == -1){
                    result = subCalculate("/", partsOfCalcString.get(index2 - 1).toString(), partsOfCalcString.get(index2 + 1).toString());
                    partsOfCalcString.remove(index2 - 1);
                    partsOfCalcString.remove(index2 - 1);
                    partsOfCalcString.remove(index2 - 1);
                    partsOfCalcString.add(index2 - 1, result);
                    System.out.println("////////////////////////////////////");
                    System.out.println(partsOfCalcString);
                    System.out.println("result = " + result);
                    System.out.println();
                }
            }

            while (partsOfCalcString.indexOf("+") != -1 || partsOfCalcString.indexOf("-") != -1){
                index1 = partsOfCalcString.indexOf("+");
                index2 = partsOfCalcString.indexOf("-");

                if ((index1 != -1 && index2 != -1) && (index1 > index2)){
                    result = subCalculate("-", partsOfCalcString.get(index2 - 1).toString(), partsOfCalcString.get(index2 + 1).toString());
                    partsOfCalcString.remove(index2 - 1);
                    partsOfCalcString.remove(index2 - 1);
                    partsOfCalcString.remove(index2 - 1);
                    partsOfCalcString.add(index2 - 1, result);
                    System.out.println("----------------------------------");
                    System.out.println(partsOfCalcString);
                    System.out.println("result = " + result);
                    System.out.println();
                }

                else if ((index1 != -1 && index2 != -1) && (index2 > index1)){
                    result = subCalculate("+", partsOfCalcString.get(index1 - 1).toString(), partsOfCalcString.get(index1 + 1).toString());
                    partsOfCalcString.remove(index1 - 1);
                    partsOfCalcString.remove(index1 - 1);
                    partsOfCalcString.remove(index1 - 1);
                    partsOfCalcString.add(index1 - 1, result);
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    System.out.println(partsOfCalcString);
                    System.out.println("result = " + result);
                    System.out.println();
                }

                else if (index1 != -1 && index2 == -1){
                    result = subCalculate("+", partsOfCalcString.get(index1 - 1).toString(), partsOfCalcString.get(index1 + 1).toString());
                    partsOfCalcString.remove(index1 - 1);
                    partsOfCalcString.remove(index1 - 1);
                    partsOfCalcString.remove(index1 - 1);
                    partsOfCalcString.add(index1 - 1, result);
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    System.out.println(partsOfCalcString);
                    System.out.println("result = " + result);
                    System.out.println();
                }

                else if (index2 != -1 && index1 == -1){
                    result = subCalculate("-", partsOfCalcString.get(index2 - 1).toString(), partsOfCalcString.get(index2 + 1).toString());
                    partsOfCalcString.remove(index2 - 1);
                    partsOfCalcString.remove(index2 - 1);
                    partsOfCalcString.remove(index2 - 1);
                    partsOfCalcString.add(index2 - 1, result);
                    System.out.println("----------------------------------");
                    System.out.println(partsOfCalcString);
                    System.out.println("result = " + result);
                    System.out.println();

                }

            }

        }




        return result;
    }


    public ArrayList<String> TransformToArrayList(String calcString){
        int beginIndex = 0;
        for (int i = 0; i <= calcString.length() - 1; i++){
            if ((calcString.charAt(i) >= 48 && calcString.charAt(i) <= 57) ||
                    (i == calcString.length() - 1 && calcString.charAt(i) == ')')){
                if (i == calcString.length() - 1){
                    partsOfCalcString.add(calcString.substring(beginIndex, i + 1));
                }

            }
            else if (calcString.charAt(i) == '+' || calcString.charAt(i) == '×' ||
                    calcString.charAt(i) == '/'){

                partsOfCalcString.add(calcString.substring(beginIndex, i));
                partsOfCalcString.add(calcString.substring(i, i + 1));
                beginIndex = i + 1;
            }
            else if (calcString.charAt(i) == '-') {
                if (calcString.charAt(i - 1) == '('){

                }
                else {
                    calcString.substring(beginIndex, i);
                    partsOfCalcString.add(calcString.substring(beginIndex, i));
                    partsOfCalcString.add(calcString.substring(i, i + 1));
                    beginIndex = i + 1;
                }
            }


        }
        return partsOfCalcString;
    }

    public String subCalculate(String sign, String bufer1, String bufer2){

        String res = "";
        double operand1 = 0;
        double operand2 = 0;
        bufer1 = (bufer1.startsWith("(")) ? bufer1.substring(1, bufer1.length() - 1) : bufer1;
        operand1 = Double.parseDouble(bufer1);
        bufer2 = (bufer2.startsWith("(")) ? bufer2.substring(1, bufer2.length() - 1) : bufer2;
        operand2 = Double.parseDouble(bufer2);

        switch (sign){
            case "×":
                res = String.valueOf(operand1 * operand2);
                break;
            case "/":
                res = String.valueOf(operand1 / operand2);
                break;
            case "+":
                res = String.valueOf(operand1 + operand2);
                break;
            case "-":
                res = String.valueOf(operand1 - operand2);
                break;
        }


        return res;
    }

    public boolean DivideByZero(String calcString){
        boolean test = false;
        int beginIndex = 0;
        double d = 0;
        String bufer;

        if (calcString.endsWith("/0")){
            test = true;
        }
        else {
            for (int i = 0; i <= calcString.length() - 1; i++) {
                if (calcString.charAt(i) == '/') {
                    beginIndex = i;
                    for (int j = beginIndex + 1; j <= calcString.length() - 1; j++) {

                        if (calcString.charAt(j) == '×' || calcString.charAt(j) == '+' ||
                                calcString.charAt(j) == '/' ||
                                (calcString.charAt(j) == '-' && calcString.charAt(j - 1) != '(')) {

                            bufer = calcString.substring(beginIndex + 1, j);
                            System.out.println(bufer);
                            if (bufer.startsWith("(") && bufer.endsWith(")")){
                                d = Double.parseDouble(bufer.substring(1, bufer.length() - 1));
                                if (d == 0){
                                    test = true;
                                    break;
                                }

                                break;
                            }
                            else{
                                d = Double.parseDouble(bufer);
                                if (d == 0){
                                    test = true;
                                    break;
                                }

                                break;
                            }



                        }

                    }

                }




            }
        }
        return test;
    }


}
