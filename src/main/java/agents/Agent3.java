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

    public Agent3(double accuracy, Waterhole correct){
        super(accuracy, correct);
    }

    // Make a decision, taking into account priors of the world`
    public IDecision decide(IWorld world){
        throw new NotImplementedException();
    }
}
