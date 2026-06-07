package com.hogwarts.data;

abstract class ScoringSystem {
    public abstract String determine_house(int gryffindorScore,
                                           int hufflepuffScore,
                                           int ravenclawScore,
                                           int slytherinScore);
}
