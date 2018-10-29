package world;

import interfaces.IDecision;
import interfaces.IWorld;
import interfaces.Waterhole;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the world of the experiment. It knows which waterhole is correct and calculates priors for each waterhole
 * based on how many people have visited them.
 */
public class World implements IWorld {
    private List<IDecision> decisions;
    private Waterhole correct;

    public World(Waterhole correct){
        this.correct = correct;
        this.decisions = new ArrayList<>();
    }

    @Override
    public Waterhole correctWaterhole() {
        return this.correct;
    }

    @Override
    public void updateWorld(IDecision decision) {
        this.decisions.add(decision);
    }

    @Override
    public List<IDecision> getDecisions() {
        return decisions;
    }
}
