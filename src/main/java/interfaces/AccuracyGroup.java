package interfaces;

/**
 * This defines the options for accuracy for a run of the experiment.
 *  1. ACCURATE - Most agents have high accuracy; accuracy runs between .75 and .95
 *  2. MIXED - Some agents are accurate, others are not; accuracy runs between .5 and .95
 *  3. POOR - Most agents have low accuracy; accuracy runs between .5 and .25
 */
public enum AccuracyGroup {
    ACCURATE, MIXED, POOR
}
