package experiment;

import interfaces.IDecision;
import interfaces.IExperiment;
import interfaces.Waterhole;
import main.ExportUtility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Holds data about an experiment
 */
public class Experiment implements IExperiment {
    private int numCorrect;
    private int numWrong;
    private int numCascades;
    private List<IDecision> decisions;
    private Waterhole correct;

    public Experiment(Waterhole correct){
        this.correct = correct;
        decisions = new ArrayList<>();
        numCorrect = 0;
        numWrong = 0;
        numCascades = 0;
    }


    @Override
    public int getNumCorrect() {
        return numCorrect;
    }

    @Override
    public int getNumWrong() {
        return numWrong;
    }

    @Override
    public int getNumCascades() {
        return numCascades;
    }

    @Override
    public int longestCascade() {
        int longestCascade = 0;
        int currentCascade = 0;
        for(IDecision decision : decisions){
            if(decision.isCascade()){
                ++currentCascade;
                if(currentCascade > longestCascade) longestCascade = currentCascade;
            } else currentCascade = 0;
        }

        return longestCascade;
    }

    @Override
    public void addDecision(IDecision decision) {
        this.decisions.add(decision);
        if(decision.getChoice() == correct) ++numCorrect;
        else ++numWrong;

        if(decision.isCascade()) ++numCascades;
    }

    @Override
    public int getNumDecisions() {
        return this.decisions.size();
    }

    @Override
    public IDecision getDecision(int index) {
        if (index > decisions.size() - 1) return null;

        return decisions.get(index);
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        int i = 0;

        buf.append("AgentId, Choice, Is Cascade?");

        for (IDecision decision : this.decisions) {
            buf.append(String.format("%d, %s, %s", i++, decision.getChoice(), decision.isCascade()));
        }

        return buf.toString();
    }
}
