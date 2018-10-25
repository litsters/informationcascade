package agents;

import decision.Decision;
import interfaces.IAgent;
import interfaces.IDecision;
import interfaces.IWorld;
import interfaces.Waterhole;

/**
 * Created by julio on 10/17/18.
 */

public class Agent2 implements  IAgent{

    private double accuracy = 1.0;
    private double probabilityA = 0.0;
    private double probabilityB = 0.0;
    private double probabilityC = 0.0;

    // Returns a value between 0 and 1 representing how accurate this agent's
    public double getAccuracy(){
        return this.accuracy;
    }

    // probabilities are.
    // Returns this agent's probability of waterhole A
    public double getProbA(){
        return probabilityA;
    }
    // Returns this agent's probability of waterhole B
    public double getProbB(){
        return probabilityB;
    }
    // Returns this agent's probability of waterhole C
    public double getProbC(){
        return probabilityC;
    }

    // Make a decision, taking into account priors of the world`
    public IDecision decide(IWorld world){
        Double highestProbability = Math.max(Math.max(probabilityA,probabilityB),probabilityC);
        Waterhole waterhole = null;

        if(Double.compare(highestProbability,probabilityA) == 0){
            waterhole = Waterhole.A;
        }
        if(Double.compare(highestProbability,probabilityB) == 0){
            waterhole = Waterhole.B;
        }
        if(Double.compare(highestProbability,probabilityC) == 0){
            waterhole = Waterhole.C;
        }

        IDecision selfDecision = new Decision(waterhole,false);

        if(world.priorA() != -1){
            probabilityA = world.priorA();
        }
        if(world.priorB() != -1){
            probabilityB = world.priorB();
        }
        if(world.priorC() != -1){
            probabilityC = world.priorC();
        }

        IDecision cascadeDecision;
        return null;    // Added this to make it compile; this method is not finished.

    }
}
