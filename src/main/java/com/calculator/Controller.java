package com.calculator;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_0;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_9;

    @FXML
    private Button btn_clear;

    @FXML
    private Button btn_clearAll;

    @FXML
    private Button btn_comma;

    @FXML
    private Button btn_divide;

    @FXML
    private Button btn_equals;

    @FXML
    private Button btn_minus;

    @FXML
    private Button btn_multiplication;

    @FXML
    private Button btn_percent;

    @FXML
    private Button btn_plus;

    @FXML
    private Label label_field;

    private String str_num = "";
    private int first_num;
    private char operation;

    @FXML
    void initialize() {
        btn_0.setOnAction(event -> {
            addNumber(0);
        });
        btn_1.setOnAction(event -> {
            addNumber(1);
        });
        btn_2.setOnAction(event -> {
            addNumber(2);
        });
        btn_3.setOnAction(event -> {
            addNumber(3);
        });
        btn_4.setOnAction(event -> {
            addNumber(4);
        });
        btn_5.setOnAction(event -> {
            addNumber(5);
        });
        btn_6.setOnAction(event -> {
            addNumber(6);
        });
        btn_7.setOnAction(event -> {
            addNumber(7);
        });
        btn_8.setOnAction(event -> {
            addNumber(8);
        });
        btn_9.setOnAction(event -> {
            addNumber(9);
        });
        btn_clearAll.setOnAction(event -> {
            clearAllButton();
        });
        btn_plus.setOnAction(event -> {
            pressMathButton('+');
        });
        btn_minus.setOnAction(event -> {
            pressMathButton('-');
        });
        btn_divide.setOnAction(event -> {
            pressMathButton('/');
        });
        btn_multiplication.setOnAction(event -> {
            pressMathButton('*');
        });
        btn_equals.setOnAction(event -> {
            equalsFunction();
        });
        btn_percent.setOnAction(event -> {
            if (this.str_num != "") {
                float num = Float.parseFloat(this.str_num) * 0.1f;
                this.str_num = Float.toString(num);
                label_field.setText(str_num);
            }
        });
        btn_clear.setOnAction(event -> {
            clearNumber();
        });
    }

    private void equalsFunction() {
        float fl_res = 0;
        int int_res = 0;
        switch (this.operation) {
            case '+':
                int_res = this.first_num + Integer.parseInt(this.str_num);
                label_field.setText(Integer.toString(int_res));
                break;
            case '-':
                int_res = this.first_num - Integer.parseInt(this.str_num);
                label_field.setText(Integer.toString(int_res));
                break;
            case '/':
                if (Integer.parseInt(this.str_num) != 0) {
                    fl_res = this.first_num / Float.parseFloat(this.str_num);
                    label_field.setText(Float.toString(fl_res));
                } else
                    fl_res = 0;
                break;
            case '*':
                int_res = this.first_num * Integer.parseInt(this.str_num);
                label_field.setText(Integer.toString(int_res));
                break;
        }

        this.str_num = "";
        this.operation = 'A';
        this.first_num = 0;

    }

    void addNumber(int number) {
        str_num += Integer.toString(number);
        label_field.setText(str_num);
    }

    void clearNumber() {
        this.str_num = label_field.getText();
        if (this.str_num.length() > 0) {
            String new_str_num = this.str_num.substring(0, this.str_num.length() - 1);
            label_field.setText(new_str_num);
        }
    }

    void pressMathButton(char operation) {
//        if ( this.operation != '+' && this.operation != '+' && this.operation != '-'
//                && this.operation != '/' && this.operation != '*'
        this.first_num = Integer.parseInt(this.str_num);
        label_field.setText(String.valueOf(operation));
        this.str_num = "";
        this.operation = operation;
    }


    void clearAllButton() {
        str_num = "0";
        label_field.setText(str_num);
        str_num = "";
    }
}
