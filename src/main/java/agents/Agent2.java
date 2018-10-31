package agents;

import decision.Decision;
import interfaces.IAgent;
import interfaces.IDecision;
import interfaces.IWorld;
import interfaces.Waterhole;

/**
 * Created by julio on 10/17/18.
 */

public class Agent2 extends Agent1{

    private double accuracy = 1.0;
    private double probabilityA = 0.0;
    private double probabilityB = 0.0;
    private double probabilityC = 0.0;
    private double priorA = 0.0;
    private double priorB = 0.0;
    private double priorC = 0.0;

    public Agent2(double accuracy, Waterhole correct){
        super(accuracy, correct);
    }

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

    private void calculatePrior(){
        //Bayes Rule

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



//        if(this.priorA != -1){
//            probabilityA = priorA
//        }
//        if(this.priorB != -1){
//            probabilityB = priorB
//        }
//        if(this.priorC != -1){
//            probabilityC = priorC
//        }

        IDecision cascadeDecision = null;
        return cascadeDecision;    // Added this to make it compile; this method is not finished.

    }
}
