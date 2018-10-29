package interfaces;

import java.util.List;

/**
 * Represents the state of the world for the experiment.
 */
public interface IWorld {
    public Waterhole correctWaterhole();    // Returns the identity of the working waterhole

    public void updateWorld(IDecision decision);    // Updates the number of people who have gone to each waterhole
    public List<IDecision> getDecisions();          // Gets the list of all previous decisions
}
