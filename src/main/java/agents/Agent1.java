package agents;

import interfaces.IAgent;
import interfaces.IDecision;
import interfaces.IWorld;

public class Agent1 implements IAgent {

    @Override
    public double getAccuracy() {
        return 0;
    }

    @Override
    public double getProbA() {
        return 0;
    }

    @Override
    public double getProbB() {
        return 0;
    }

    @Override
    public double getProbC() {
        return 0;
    }

    @Override
    public IDecision decide(IWorld world) {
        return null;
    }
}