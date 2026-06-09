package com.hogwarts.houses;

public class Houses {
    protected String houseName;
    protected String houseColors;
    protected String description;

    Houses(String houseName, String houseColors, String description){
        this.houseName = houseName;
        this.houseColors = houseColors;
        this.description = description;
    }
    public void displayTraits(){
        System.out.println("The Sorting Hat has spoken...");
        System.out.println("You belong in "+ houseName);
        System.out.println("House Colors: " + houseColors);
        System.out.println(description);
    }
}
