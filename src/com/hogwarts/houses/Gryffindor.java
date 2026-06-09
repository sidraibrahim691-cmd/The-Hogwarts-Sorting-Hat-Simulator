package com.hogwarts.houses;

public class Gryffindor extends Houses {
    public Gryffindor() {
        super("GRYFFINDOR","Scarlet and Gold",
                "Where the brave dare to tread and the bold dare to lead!");
    }
    @Override
    public void displayTraits(){
        super.displayTraits();
        System.out.println("Your courage burns brighter than the scarlet in your robes." +
                "\nMotto: Courage above all. Fortune favors the brave.");
    }
}