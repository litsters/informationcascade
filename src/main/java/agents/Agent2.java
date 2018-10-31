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

    private void updatePriors(int numA, int numB, int numC){
        // TODO: Make this update priors based on how many have chosen each waterhole
    }

    private Waterhole chooseHighestPrior(){
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

        return waterhole;
    }

    // Make a decision, taking into account priors of the world`
    public IDecision decide(IWorld world){
        // Make initial decision
        Waterhole initial = this.chooseHighestPrior();

        // Update priors
        this.updatePriors(world.numA(), world.numB(), world.numC());

        // Choose highest prior after updating priors
        Waterhole second = this.chooseHighestPrior();
        if(initial == second) return new Decision(second, false);
        else return new Decision(second, true);
    }
}
