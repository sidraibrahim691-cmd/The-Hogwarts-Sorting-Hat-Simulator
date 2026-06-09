package com.hogwarts.data;

public class HouseCalculator extends ScoringSystem {

    @Override
    public String determine_house(int gryffindorScore,
                                  int hufflepuffScore,
                                  int ravenclawScore,
                                  int slytherinScore) {

        String winner = "Gryffindor";
        int highestScore = gryffindorScore;

        if (hufflepuffScore > highestScore) {
            winner = "Hufflepuff";
            highestScore = hufflepuffScore;
        }

        if (ravenclawScore > highestScore) {
            winner = "Ravenclaw";
            highestScore = ravenclawScore;
        }

        if (slytherinScore > highestScore) {
            winner = "Slytherin";
            highestScore = slytherinScore;
        }

        return winner;
    }
}