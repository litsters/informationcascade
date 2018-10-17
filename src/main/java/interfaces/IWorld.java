package interfaces;

/**
 * Represents the state of the world for the experiment.
 */
public interface IWorld {
    public Waterhole correctWaterhole();    // Returns the identity of the working waterhole
    public double priorA();                 // Returns the number of people who have chosen waterhole A
    public double priorB();                 // Returns the number of people who have chosen waterhole B
    public double priorC();                 // Returns the number of people who have chosen waterhole C

    public void incA();                     // Increments the number of people who have chosen waterhole A
    public void incB();                     // Increments the number of people who have chosen waterhole B
    public void incC();                     // Increments the number of people who have chosen waterhole C
}
