package com.example.alex.calc;

public class SquareRoot {

    public String calcString = "";

    public String testString(String calcString) {
        this.calcString = calcString;
        String messageFlag = "";
        if (calcString.equals("")) {
            messageFlag = "sqrt0";

        } else if (calcString.length() > 20) {
            messageFlag = "sqrt20";

        } else {
            try {
                Double d1 = new Double(calcString);
                d1 = Math.sqrt(d1);
                this.calcString = d1.toString();
            } catch (NumberFormatException e) {
                messageFlag = "sqrt20";
            }

        }
        return messageFlag;
    }


    public String getCalcString () {
        return this.calcString;
        }
    }

