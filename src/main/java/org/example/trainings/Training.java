package org.example.trainings;

import java.util.ArrayList;

public class Training {
    int kind;
    boolean interval;
    boolean light;
    boolean warmUp;
    boolean hitch;
    boolean integral;
    int lenghtKm;
    int lenghtLightKm;


    public Training(int kind, boolean interval, boolean light, boolean warmUp, boolean hitch, boolean integral, int lenghtKm, int lenghtLightKm) {
        this.kind = kind;
        this.interval = interval;
        this.light = light;
        this.warmUp = warmUp;
        this.hitch = hitch;
        this.integral = integral;
        this.lenghtKm = lenghtKm;
        this.lenghtLightKm = lenghtLightKm;
    }

    public int[] createTrain(boolean light, boolean warmUp, boolean hitch, boolean integral, int lenghtKm, int lenghtLightKm) {
        int [] train = new int[100];
        if (light = true) {
            train[0]=1;

        }

        return train;
    }

    public void phaseSeqence(int level){

    }
}
