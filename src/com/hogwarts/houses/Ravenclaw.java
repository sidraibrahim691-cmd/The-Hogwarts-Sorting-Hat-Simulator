package com.hogwarts.houses;

public class Ravenclaw extends Houses{
    Ravenclaw(){
        super("RAVENCLAW","Blue and Bronze",
                "Where wit is worshipped and wisdom lights the way.");
    }
    @Override
    public void displayTraits(){
        super.displayTraits();
        System.out.println("Your mind is your greatest weapon — and what a sharp one it is." +
                "\nMotto: Knowledge is power. Curiosity is everything.");
    }
}
