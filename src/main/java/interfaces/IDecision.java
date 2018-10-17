package interfaces;

/**
 * Represents a decision created by an Agent.
 */
public interface IDecision {
    public Waterhole getChoice();   // The waterhole that was chosen
    public boolean isCascade();     // True if the decision was changed by an information cascade, false otherwise.
}
