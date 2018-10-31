package interfaces;

/**
 * Represents the results of the experiment.
 */
public interface IExperiment {
    public int getNumCorrect();     // Returns the number of people who have chosen the correct water hole.
    public int getNumWrong();       // Returns the number of people who have chosen the wrong water hole.
    public int getNumCascades();    // Returns the number of people whose choice was changed by an information cascade.
    public int longestCascade();    // Returns the length of the longest consecutive information cascade
    public int getNumDecisions();   // Returns the number of agent decisions
    public IDecision getDecision(int index); // Returns the agent decision from a given index

    public void addDecision(IDecision decision);    // Add a decision to the list of decisions made
}
