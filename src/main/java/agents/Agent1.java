package agents;

import decision.Decision;
import interfaces.IAgent;
import interfaces.IDecision;
import interfaces.IWorld;
import interfaces.Waterhole;

import java.util.Arrays;
import java.util.Random;

/**
 * Uses only its highest prior probability to make decisions.
 */
public class Agent1 implements IAgent {
    private double accuracy;
    private double priorA;
    private double priorB;
    private double priorC;
    private Random generator;

    public Agent1(double accuracy, Waterhole correct){
        this.accuracy = accuracy;
        double priorOther = (1 - accuracy) / 2;         // Split the remaining probability evenly between other priors
        double priorOther2 = 1 - accuracy - priorOther;
        switch(correct){
            case A:
                priorA = accuracy;
                priorB = priorOther;
                priorC = priorOther2;
                break;
            case B:
                priorA = priorOther;
                priorB = accuracy;
                priorC = priorOther2;
                break;
            case C:
                priorA = priorOther;
                priorB = priorOther2;
                priorC = accuracy;
        }
        this.generator = new Random();
    }


    @Override
    public double getAccuracy() {
        return accuracy;
    }

    @Override
    public double getProbA() {
        return priorA;
    }

    @Override
    public double getProbB() {
        return priorB;
    }

    @Override
    public double getProbC() {
        return priorC;
    }

    @Override
    public IDecision decide(IWorld world) {
        // Choose a waterhole
        Waterhole choice = selectWaterhole();

        if(choice == null) return null;
        else return new Decision(choice, false);
    }

    private Waterhole selectWaterhole(){
        if(isWaterhole(priorA)) return Waterhole.A;
        else if(isWaterhole(priorB)) return Waterhole.B;
        else return Waterhole.C;
    }

    private boolean isWaterhole(double prior){
        int bound = (int)(prior * 100);
        int rand = generator.nextInt(100) + 1;
        return rand < bound;
    }
}