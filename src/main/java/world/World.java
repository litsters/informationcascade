package world;

import interfaces.IWorld;
import interfaces.Waterhole;

/**
 * Represents the world of the experiment. It knows which waterhole is correct and calculates priors for each waterhole
 * based on how many people have visited them.
 */
public class World implements IWorld {
    private int numA;
    private int numB;
    private int numC;
    private Waterhole correct;

    private double priorA;
    private double priorB;
    private double priorC;

    public World(Waterhole correct){
        this.correct = correct;
        numA = 0;
        numB = 0;
        numC = 0;

        priorA = -1;
        priorB = -1;
        priorC = -1;
    }

    @Override
    public Waterhole correctWaterhole() {
        return this.correct;
    }

    /**
     * Gets the current prior value for waterhole A.
     * @return -1 if no prior value has been calculated, or the current value otherwise.
     */
    @Override
    public double priorA() {
        return priorA;
    }

    /**
     * Gets the current prior value for waterhole B.
     * @return -1 if no prior value has been calculated, or the current value otherwise.
     */
    @Override
    public double priorB() {
        return priorB;
    }

    /**
     * Gets the current prior value for waterhole C.
     * @return -1 if no prior value has been calculated, or the current value otherwise.
     */
    @Override
    public double priorC() {
        return priorC;
    }

    @Override
    public void incA() {
        ++numA;
        // Update priorA
    }

    @Override
    public void incB() {
        ++numB;
        // Update priorB
    }

    @Override
    public void incC() {
        ++numC;
        // Update priorC
    }
}
