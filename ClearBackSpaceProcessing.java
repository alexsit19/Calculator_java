package com.example.alex.calc;

public class ClearBackSpaceProcessing {

    public String clrscrOrBackSpace(String action, String calcString){
        if (action.equals("C")){
            calcString = clearScreen(calcString);
        }
        else {
            calcString = backSpace(calcString);
        }
        return calcString;
    }

    public String clearScreen(String calcString){
        calcString = "";
        return calcString;
    }

    public String backSpace(String calcString){
        if (calcString.length() == 0){

        }
        else if (calcString.endsWith("т")){
            calcString = calcString.substring(0, calcString.length() - 16);
        }
        else if (calcString.endsWith("я")){
            calcString = calcString.substring(0, calcString.length() - 16);
        }
        else {
            calcString = calcString.substring(0, calcString.length() - 1);

        }
        return calcString;
    }
}
