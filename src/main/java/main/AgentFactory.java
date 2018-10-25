package main;

import agents.Agent1;
import agents.Agent2;
import interfaces.IAgent;
import interfaces.IWorld;

/**
 * This class generates agents based on an input string.
 */
public class AgentFactory {
    private IWorld world;

    public AgentFactory(IWorld world){
        this.world = world;
    }

    public IAgent generateAgent(String type){
        switch(type){
            case Main.AGENT_ONE:
                return new Agent1();
            case Main.AGENT_TWO:
                return new Agent2();
            case Main.AGENT_THREE:
            default:
                System.err.println("Unrecognized agent type: " + type);
                return null;
        }
    }
}
