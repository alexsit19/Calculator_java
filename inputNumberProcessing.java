package com.example.alex.calc;

public class inputNumberProcessing {

    public String anySymbol(String symbol, String calcString){
        char endOfCalcString;
        endOfCalcString = (calcString.length() == 0) ? '?' : calcString.charAt(calcString.length() - 1);

        if (symbol.equals("0")){
            calcString = zeroProcessing(calcString, endOfCalcString);

        }
        else if (symbol.equals(".")) {
            calcString = dotProcessing(calcString , endOfCalcString);

        }
        else {
            calcString = anyNumber(calcString, symbol , endOfCalcString);

        }

        return calcString;
    }

    public String zeroProcessing(String calcString, char endOfCalcString){


        if (calcString.length() == 0){
            calcString += "0";
        }
        else if (calcString.length() == 1 && calcString.charAt(0) == '0'){

        }
        else if (endOfCalcString == '-' || endOfCalcString == '+' ||
                 endOfCalcString == '/' || endOfCalcString == '×' ||
                 endOfCalcString == '√'){

            calcString += "0";
        }
        else if (calcString.length() > 2 && calcString.charAt(calcString.length() - 1) == '0' &&
                ((calcString.charAt(calcString.length() - 2) == '-') ||
                 (calcString.charAt(calcString.length() - 2) == '+') ||
                 (calcString.charAt(calcString.length() - 2) == '/') ||
                 (calcString.charAt(calcString.length() - 2) == '×'))){

        }

        else {
            calcString += "0";
        }


        return calcString;
    }

    public String dotProcessing(String calcString, char endOfCalcString){

        if (calcString.length() == 0){
            calcString += "0.";

        }
        else if (endOfCalcString == '-' || endOfCalcString == '+' ||
                 endOfCalcString == '×' || endOfCalcString == '/'){

            calcString += "0.";
        }
        else if (calcString.indexOf('+') != -1 || calcString.indexOf('-') != -1 ||
                 calcString.indexOf('/') != -1 || calcString.indexOf('×') != -1){

            for (int i = calcString.length() - 1; i > 0 ; i--) {
                if (calcString.charAt(i) == '-' || calcString.charAt(i) == '+' ||
                    calcString.charAt(i) == '/' || calcString.charAt(i) == '×'){

                    if (calcString.indexOf('.', i) == -1){
                        calcString += ".";
                    }

                    break;

                }
            }
        }
        else if ((calcString.indexOf('.') == -1)  &&
                ((calcString.indexOf('+') == -1) || (calcString.indexOf('-') == -1) ||
                 (calcString.indexOf('/') == -1) || (calcString.indexOf('×') == -1)))  {

            calcString += ".";
        }

        return calcString;
    }

    public String anyNumber(String calcString, String symbol, char endOfCalcString){
        if (calcString.length() == 1 && calcString.charAt(0) == '0'){
            calcString = symbol;
        }
        else if (calcString.length() > 2 && endOfCalcString == '0' &&
                ((calcString.charAt(calcString.length() - 2) == '-') ||
                 (calcString.charAt(calcString.length() - 2) == '+') ||
                 (calcString.charAt(calcString.length() - 2) == '×') ||
                 (calcString.charAt(calcString.length() - 2) == '/'))){

            calcString = calcString.substring(0, calcString.length() - 1) + symbol;

        }


        else {
            calcString += symbol;

        }

        return calcString;
    }
}


