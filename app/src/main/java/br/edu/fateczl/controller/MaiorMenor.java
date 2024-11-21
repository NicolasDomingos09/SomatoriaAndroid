package br.edu.fateczl.controller;

import android.widget.EditText;
import android.widget.TextView;

public class MaiorMenor {
    public String verificaMenor(EditText etNum1, EditText etNum2){
        int num1 = Integer.parseInt(etNum1.getText().toString());
        int num2 = Integer.parseInt(etNum2.getText().toString());

        if(num1 < num2){
            return String.valueOf(num1);
        } else {
            return String.valueOf(num2);
        }
    }

    public String verificaMaior(EditText etNum1, EditText etNum2){
        int num1 = Integer.parseInt(etNum1.getText().toString());
        int num2 = Integer.parseInt(etNum2.getText().toString());

        if(num1 < num2){
            return String.valueOf(num2);
        } else {
            return String.valueOf(num1);
        }
    }

    public String soma(EditText etNum1, EditText etNum2){
        int menor = Integer.parseInt(verificaMenor(etNum1, etNum2));
        int maior = Integer.parseInt(verificaMaior(etNum1,etNum2));

        int soma = 0;
        for(int i = menor + 1; i < maior; i++){
            if(i % 2 != 0)
                soma += i;
        }
        return String.valueOf(soma);
    }
}
