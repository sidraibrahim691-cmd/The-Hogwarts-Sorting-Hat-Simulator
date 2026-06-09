package com.hogwarts.houses;

public class Slytherin extends Houses{
    Slytherin(){
        super( "SLYTHERIN","Green and Silver",
                "Where ambition meets cunning and greatness is the only option.");
    }
    @Override
    public void displayTraits(){
        super.displayTraits();
        System.out.println("Others dream of success. You? You plan it." +
                "\nMotto: Ambition is not a dirty word. It is your destiny.");
    }
}
