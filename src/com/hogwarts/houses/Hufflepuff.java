package com.hogwarts.houses;

public class Hufflepuff extends Houses{
    Hufflepuff(){
        super("HUFFLEPUFF","Yellow and Black",
                "Where kindness is a superpower and loyalty never breaks.");
    }
    @Override
    public void displayTraits(){
        super.displayTraits();
        System.out.println("The world needs more people like you — genuine, hardworking, true." +
                "\n Motto: Be kind. Work hard. Show up. Always.");
    }
}
