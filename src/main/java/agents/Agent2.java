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
    public Agent2(double accuracy, Waterhole correct){
        super(accuracy, correct);
    }

    private void calculatePrior(){
        //Bayes Rule

    }

    private void updatePriors(int numA, int numB, int numC){
        // TODO: Make this update priors based on how many have chosen each waterhole
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
    public IDecision decide(IWorld world){
        // If this is the first agent to decide, choose like an Agent1
        if(world.getDecisions().size() == 0) return agent1Decide();

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
