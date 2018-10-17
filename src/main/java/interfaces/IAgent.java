package interfaces;

/**
 * Represents an agent in the information cascade.
 *
 * 3 types of agent, should be classes:
 *  1. Uses only own information
 *  2. Uses information cascade
 *  3. Uses information cascade and maximum expected utility
 */
public interface IAgent {
    public double getAccuracy();    // Returns a value between 0 and 1 representing how accurate this agent's
                                    // probabilities are.
    public double getProbA();       // Returns this agent's probability of waterhole A
    public double getProbB();       // Returns this agent's probability of waterhole B
    public double getProbC();       // Returns this agent's probability of waterhole C

    public IDecision decide(IWorld world);  // Make a decision, taking into account priors of the world
}
