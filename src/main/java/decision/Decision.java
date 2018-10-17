package decision;

import interfaces.IDecision;
import interfaces.Waterhole;

/**
 * Created by julio on 10/17/18.
 */

public class Decision implements IDecision{
    private Waterhole waterhole = null;
    private boolean isCascade = false;

    public Decision(Waterhole waterhole, boolean isCascade){
        this.waterhole = waterhole;
        this.isCascade = isCascade;
    }
    // The waterhole that was chosen
    public Waterhole getChoice(){
        return this.waterhole;
    }
    // True if the decision was changed by an information cascade, false otherwise.
    public boolean isCascade(){
        return this.isCascade;
    }
}
