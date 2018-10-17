package interfaces;

/**
 * Represents the results of the experiment.
 */
public interface IExperiment {
    public int getNumCorrect();     // Returns the number of people who have chosen the correct water hole.
    public int getNumWrong();       // Returns the number of people who have chosen the wrong water hole.
    public int getNumCascades();    // Returns the number of people whose choice was changed by an information cascade.
    public int longestCascade();    // Returns the length of the longest consecutive information cascade

    public void incNumCorrect();    // Increments the number of people who have chosen correctly.
    public void incNumWrong();      // Increments the number of people who have chosen incorrectly.
    public void incNumCascades();   // Increments the number of information cascades.
}
