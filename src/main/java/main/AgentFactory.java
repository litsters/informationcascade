package main;

import agents.Agent1;
import agents.Agent2;
import agents.Agent3;
import interfaces.AccuracyGroup;
import interfaces.IAgent;
import interfaces.IWorld;

import java.util.Random;

/**
 * This class generates agents based on an input string.
 */
public class AgentFactory {
    private IWorld world;
    private AccuracyGroup accuracyGroup;
    private Random generator;
    private Double signal;

    public AgentFactory(IWorld world, AccuracyGroup accuracyGroup, Double signal){
        this.accuracyGroup = accuracyGroup;
        this.world = world;
        this.generator = new Random();
        this.signal = signal;
    }

    public IAgent generateAgent(String type){
        // Generate accuracy
        double accuracy = determineAccuracy();

        switch(type){
            case Main.AGENT_ONE:
                return new Agent1(accuracy, world.correctWaterhole());
            case Main.AGENT_TWO:
                return new Agent2(accuracy, world.correctWaterhole(), signal);
            case Main.AGENT_THREE:
                return new Agent3(accuracy, world.correctWaterhole(), signal);
            default:
                System.err.println("Unrecognized agent type: " + type);
                return null;
        }
    }

    /**
     * Determines the accuracy for an agent, based on the current AccuracyGroup.
     * @return Value between 0 and 1, the accuracy for an agent.
     */
    private double determineAccuracy(){
        // Get upper and lower bounds for the probability
        int upperBound = upperBound();
        int lowerBound = lowerBound();

        // Generate number between bounds
        int rand = generator.nextInt(upperBound - lowerBound + 1) + lowerBound;

        // Convert to a double
        return (double)rand / 100;
    }

    private int upperBound(){
        switch(accuracyGroup){
            case ACCURATE:
            case MIXED: return 95;
            case POOR: return 25;
            default: return 50;
        }
    }

    private int lowerBound(){
        switch(accuracyGroup){
            case ACCURATE: return 75;
            case MIXED:
            case POOR: return 5;
            default: return 25;
        }
    }
}
