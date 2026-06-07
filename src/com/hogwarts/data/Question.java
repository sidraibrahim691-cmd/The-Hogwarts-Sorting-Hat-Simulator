package com.hogwarts.data;

import java.util.ArrayList;

public class Question {
    private String question_text;
    private String[] options;
    private String[] house_weights;

    public Question(String question_text, String[] option, String[] house_weight){
        this.question_text = question_text;
        this.options = option;
        this.house_weights = house_weight;
    }

    public String getQuestion_text(){
        return question_text;
    }

    public String[] getOptions(){
        return options;
    }

    public String[] getHouse_weights(){
        return house_weights;
    }
}
