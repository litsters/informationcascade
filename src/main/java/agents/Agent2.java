package agents;

import decision.Decision;
import interfaces.IDecision;
import interfaces.IWorld;
import interfaces.Waterhole;

/**
 * Created by julio on 10/17/18.
 */

public class Agent2 extends Agent1{

    private Double signal;

    public Agent2(double accuracy, Waterhole correct, Double signal){
        super(accuracy, correct);
        this.signal = signal;
    }

    protected void updatePriors(int numA, int numB, int numC, Waterhole waterhole){
        int aCount =  numA + isPriorSame(waterhole);
        int aNegCount = numB + numC  + ((isPriorSame(waterhole) - 1) * -1);
        Double probA = Math.pow((getProbA() * signal), aCount) * Math.pow((1 - signal), aNegCount);

        int bCount =  numB + isPriorSame(waterhole);
        int bNegCount = numA + numC  + ((isPriorSame(waterhole) - 1) * -1);
        Double probB = Math.pow((getProbB() * signal), bCount) * Math.pow((1 - signal), bNegCount);

        int cCount =  numC + isPriorSame(waterhole);
        int cNegCount = numA + numB  + ((isPriorSame(waterhole) - 1) * -1);
        Double probC = Math.pow((getProbC() * signal), cCount) * Math.pow((1 - signal), cNegCount);

        setProbA(probA);
        setProbB(probB);
        setProbC(probC);

    }

    private int isPriorSame(Waterhole waterhole){
        if (chooseHighestPrior() == (waterhole)){
            return 1;
        }
        else{
            return 0;
        }
    }

    private Waterhole chooseHighestPrior(){
        Double highestProbability = Math.max(Math.max(getProbA(),getProbB()),getProbC());
        Waterhole waterhole = null;

        if(Double.compare(highestProbability,getProbA()) == 0){
            waterhole = Waterhole.A;
        }
        if(Double.compare(highestProbability,getProbB()) == 0){
            waterhole = Waterhole.B;
        }
        if(Double.compare(highestProbability,getProbC()) == 0){
            waterhole = Waterhole.C;
        }

        return waterhole;
    }

    // Make a decision, taking into account priors of the world
    @Override
    public IDecision decide(IWorld world){
        // If this is the first agent to decide, choose like an Agent1
        if(world.getDecisions().size() == 0) return agent1Decide();

        // Make initial decision
        Waterhole initial = this.chooseHighestPrior();

        // Update priors
        this.updatePriors(world.numA(), world.numB(), world.numC(), initial);

        // Choose highest prior after updating priors
        Waterhole second = this.chooseHighestPrior();
        if(initial == second) return new Decision(second, false);
        else return new Decision(second, true);
    }
}
