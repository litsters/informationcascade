package agents;

import decision.Decision;
import interfaces.IAgent;
import interfaces.IDecision;
import interfaces.IWorld;
import interfaces.Waterhole;

/**
 * Uses only its highest prior probability to make decisions.
 */
public class Agent1 implements IAgent {
    private double accuracy;
    private double priorA;
    private double priorB;
    private double priorC;

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
        Waterhole choice = highestPrior();

        return new Decision(choice, false);
    }

    private Waterhole highestPrior(){
        Waterhole choice = Waterhole.A;
        double highestPrior = 0;
        if(priorA > highestPrior){
            highestPrior = priorA;
        }
        if(priorB > highestPrior){
            choice = Waterhole.B;
            highestPrior = priorB;
        }
        if(priorC > highestPrior){
            choice = Waterhole.C;
        }

        return choice;
    }
}