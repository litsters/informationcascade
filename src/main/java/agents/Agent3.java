package agents;

import decision.Decision;
import interfaces.IAgent;
import interfaces.IDecision;
import interfaces.IWorld;
import interfaces.Waterhole;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import agents.Agent2;


public class Agent3 extends Agent2 {

    private double[][] utilities = {
            { 100, -50, -100},
            { -50, 100, -100},
            { -25, -25, 100}
    };

    public Agent3(double accuracy, Waterhole correct, Double signal){
        super(accuracy, correct, signal);
    }

    private Waterhole getMaximumExpectedUtility() {
        double max_utility = 0;
        int max_waterhole = -1;

        for (int waterhole = 0; waterhole < 3; waterhole++) {

            // get the probability for current waterhole
            double probability = (waterhole == 0 ? getProbA() : (waterhole == 1 ? getProbB() : getProbC()));

            for (int choice = 0; choice < 3; choice++) {
                double utility = utilities[waterhole][choice] * probability;
                if (utility > max_utility) {
                    max_utility = utility;
                    max_waterhole = waterhole;
                }
            }
        }

        Waterhole result = Waterhole.values()[max_waterhole];
        return result;
    }

    // Make a decision, taking into account priors of the world`
    public IDecision decide(IWorld world){
        // If this is the first agent to decide, choose like an Agent1
        if(world.getDecisions().size() == 0) return agent1Decide();

        // Make initial decision
        Waterhole initial = this.chooseHighestPrior();

        // Update priors
        this.updatePriors(world.numA(), world.numB(), world.numC(), initial);

        // Choose highest prior after updating priors
        Waterhole second = this.getMaximumExpectedUtility();

        if(initial == second) return new Decision(second, false);
        else return new Decision(second, true);
    }
}
