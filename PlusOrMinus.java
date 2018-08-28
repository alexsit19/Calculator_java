package com.example.alex.calc;

public class PlusOrMinus {

    public String PlusMinus(String calcString){
        char endOfCalcString;
        endOfCalcString = (calcString.length() == 0) ? '?' : calcString.charAt(calcString.length() - 1);

        if (calcString.length() == 0){
            calcString += "(-";

        }
        else {
            for (int i = calcString.length() - 1; i > -1 ; i--) {
                if (i == 0){
                    calcString = "(-" + calcString;
                    break;
                }
                else if (endOfCalcString == '+' || endOfCalcString == '/' ||
                        endOfCalcString == '×' || endOfCalcString == '√'){

                    calcString = calcString + "(-";
                    break;
                }
                else if  (endOfCalcString == '-'){
                    if(calcString.charAt(i - 1) == '('){
                        calcString = calcString.substring(0, i - 1) + calcString.substring(i + 1, calcString.length());
                        break;
                    }
                    else {
                        calcString = calcString + "(-";
                        break;
                    }
                }
                else if (calcString.charAt(i) == '-' && calcString.charAt(i - 1) == '('){
                    calcString = calcString.substring(0, i - 1) + calcString.substring(i + 1, calcString.length());
                    break;
                }
                else if (calcString.charAt(i) == '-' || calcString.charAt(i) == '+' ||
                        calcString.charAt(i) == '√' || calcString.charAt(i) == '×' ||
                        calcString.charAt(i) == '/'){

                    calcString = calcString.substring(0, i + 1) + "(-" + calcString.substring(i + 1, calcString.length());
                    break;
                }
            }
        }

        return calcString;
    }
}
