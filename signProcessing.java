package com.example.alex.calc;

public class signProcessing {

    public String anySign(String sign, String calcString) {
        if (calcString == "") {

        } else if (calcString.equals("(-")) {

        } else {

            char endOfCalcString = (calcString.charAt(calcString.length() - 1));

            if (endOfCalcString >= 48 && endOfCalcString <= 57) {
                if(MinusTest(calcString) == true){

                    calcString = calcString.substring(0, calcString.length()) + ")" + sign;
                }

                else {
                    calcString = calcString.substring(0, calcString.length()) + sign;
                }


            }

            else {
                if (endOfCalcString == '+' || endOfCalcString == '/' ||
                    endOfCalcString == '×'){

                    calcString = calcString.substring(0, calcString.length() - 1) + sign;
                }
                else if (endOfCalcString == '-'){
                    if (calcString.charAt(calcString.length() - 2) == '('){

                    }
                    else {

                        calcString = calcString.substring(0,calcString.length() - 1) + sign;
                    }
                }
            }


        }
        return calcString;


    }

    public static boolean MinusTest(String calcString) {
        boolean test = false;

        for (int i = calcString.length() - 1; i > -1; i--) {
            if (calcString.charAt(i) == '+' || calcString.charAt(i) == '/' ||
                    calcString.charAt(i) == '×') {
                break;

            }

            else if (calcString.charAt(i) == '-' && calcString.charAt(i - 1) == '(') {

                test = true;
                break;
            }

            else if (calcString.charAt(i) == '-'){
                break;
            }

        }
        return test;

    }
}
