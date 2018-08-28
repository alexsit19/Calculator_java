package com.example.alex.calc;

public class Counter {

    public String Count(String calcString) {
        int digitCount = 0;
        int digitAfterDotCount = 0;
        String messageFlag = "";
        char endOfCalcString = '?';
        if (calcString.length() == 0) {

        } else if (calcString.length() == 100) {
            messageFlag = "100";
        } else if (endOfCalcString == '-' || endOfCalcString == '+' ||
                endOfCalcString == '/' || endOfCalcString == '×' ||
                endOfCalcString == '√' || endOfCalcString == '.') {

        } else {
            for (int i = calcString.length() - 1; i > -1; i--) {
                if (calcString.charAt(i) == '-' || calcString.charAt(i) == '+' ||
                        calcString.charAt(i) == '/' || calcString.charAt(i) == '×' ||
                        calcString.charAt(i) == '√') {

                    break;
                } else {
                    if (calcString.charAt(i) >= 48 && calcString.charAt(i) <= 57) {
                        digitCount += 1;

                        if (digitCount == 15){
                            messageFlag = "15";
                            break;
                        }

                    } else if (calcString.charAt(i) == '.') {
                        digitAfterDotCount = calcString.length() - i - 1;

                        if (digitAfterDotCount == 8){
                            messageFlag = "8";
                            break;
                        }

                    }

                }
            }

        }

        return messageFlag;
    }
}
