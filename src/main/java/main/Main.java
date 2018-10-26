package main;

import experiment.Experiment;
import interfaces.AccuracyGroup;
import interfaces.IAgent;
import interfaces.IDecision;
import interfaces.Waterhole;
import world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Runs an instance of the experiment, and outputs the results. Takes 3 arguments:
 *  1.  The type of agent to use. Options are "one", "two", or "three", referring to the agent number.
 *  2.  The number of agents to use. Must be greater than 0.
 *  3.  The accuracy group for the run. Must be "high", "mixed", or "poor".
 */
public class Main {
    public static final String AGENT_ONE = "one";
    public static final String AGENT_TWO = "two";
    public static final String AGENT_THREE = "three";

    public static final String ACC_HIGH = "high";
    public static final String ACC_MIXED = "mixed";
    public static final String ACC_POOR = "poor";

    public static void main(String[] args){
        // Check usage
        if(args.length < 3){
            System.err.println("Usage: <agent_type> <number_of_agents> <accuracy_rating>");
            System.exit(1);
        }

        // Generate world
        Waterhole correct = chooseWaterhole();  // Choose which waterhole is correct
        World world = new World(correct);

        // Get number of agents
        int numAgents = Integer.parseInt(args[1]);
        if(numAgents < 1){
            System.err.println("Usage: must have at least 1 agent");
            System.exit(1);
        }

        // Get accuracy rating for the run
        AccuracyGroup accuracy = interpretAccuracy(args[2]);
        if(accuracy == null){
            System.err.println("Usage: accuracy must be \"high\", \"mixed\", or \"poor\"");
            System.exit(1);
        }

        // Generate agents
        AgentFactory factory = new AgentFactory(world, accuracy);
        List<IAgent> agents = new ArrayList<>();
        for(int i = 0; i < numAgents; ++i){
            IAgent agent = factory.generateAgent(args[0]);
            agents.add(agent);
        }

        // Set up experiment
        Experiment experiment = new Experiment(correct);

        // Make decisions
        for(IAgent agent : agents){
            IDecision decision = agent.decide(world);
            world.updateWorld(decision);
            experiment.addDecision(decision);
        }

        // Report results
        System.out.println("Agent type:      " + args[0]);
        System.out.println("Num agents:      " + args[1]);
        System.out.println("Accuracy group:  " + args[2]);
        System.out.println("Num correct:     " + experiment.getNumCorrect());
        System.out.println("Num wrong:       " + experiment.getNumWrong());
        System.out.println("Num cascades:    " + experiment.getNumCascades());
        System.out.println("Longest cascade: " + experiment.longestCascade());
    }

    private static Waterhole chooseWaterhole(){
        int choice = new Random().nextInt(3);
        switch(choice){
            case 0: return Waterhole.A;
            case 1: return Waterhole.B;
            case 2: return Waterhole.C;
            default:
                System.err.println("Error in choosing waterhole; choice = " + choice);
                return Waterhole.A;
        }
    }

    private static AccuracyGroup interpretAccuracy(String input){
        switch(input){
            case ACC_HIGH: return AccuracyGroup.ACCURATE;
            case ACC_MIXED: return AccuracyGroup.MIXED;
            case ACC_POOR: return AccuracyGroup.POOR;
            default: return null;
        }
    }
}
