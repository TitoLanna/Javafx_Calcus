package com.javafx.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;

public class Controller {
    @FXML
    private TextField display_field;
    private int decimalClick = 0;
    private String operator;
    private double firstOperand;


    @FXML
    private void digitAction (ActionEvent event){
        String digitText= ((Button)event.getSource()).getText();
        display_field.appendText(digitText);

    }
    @FXML
    private  void decimalAction(ActionEvent event){
        if (decimalClick==0){
            display_field.appendText(".");
            decimalClick=1;
        }
    }

    @FXML
    private  void equalAction(ActionEvent event){
        if (operator == null || display_field.getText().trim().isEmpty())
        {
            display_field.setText("Error");
            return;
        }
        try {

            double secondOperand= Double.parseDouble(display_field.getText());
            double result= switch (operator){
                case "+"-> firstOperand + secondOperand;
                case "-"-> firstOperand - secondOperand;
                case "*"-> firstOperand * secondOperand;
                case "/"-> (secondOperand==0)?0:firstOperand/secondOperand;
                default -> 0;
            };
            display_field.setText(String.format("%.2f", result));
            decimalClick = 0;  // reset for next input
            operator = null;
        }
            catch(NumberFormatException e){
            display_field.setText("0");

            }
        }
   @FXML
   private void generalAction(ActionEvent event){
        String action=((Button)event.getSource()).getText();
        switch (action){
            case "AC":
                display_field.clear();
                decimalClick=0;
                operator=null;
                firstOperand=0;
                break;
            case "+/-":
            try{double value=Double.parseDouble(display_field.getText());
                display_field.setText(String.valueOf(-value));}
            catch(NumberFormatException e){
                display_field.setText("0");
            }
                break;
            case "%":
            try{double value = Double.parseDouble(display_field.getText());
                display_field.setText(String.valueOf(value/100));}
            catch (NumberFormatException e){
                display_field.setText("Error");
            }
            break;

            case "*":
            case "/":
            case "-":
            case "+":
                try {
                    firstOperand = Double.parseDouble(display_field.getText());
                    operator = action;
                    display_field.clear();
                    decimalClick = 0;
                } catch (NumberFormatException e) {
                    display_field.setText("0");
                }
                break;
            default:
                break;

        }
   }
}