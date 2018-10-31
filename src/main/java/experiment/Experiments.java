package experiment;

import interfaces.IDecision;
import interfaces.IExperiment;
import main.ExportUtility;

import java.util.ArrayList;

public class Experiments {

    private ArrayList<IExperiment> collection;

    public Experiments() {
        collection = new ArrayList<IExperiment>();
    }

    public void addExperiment(IExperiment experiment) {
        collection.add(experiment);
    }

    public ArrayList<IExperiment> getExperiments() {
        return collection;
    }

    public void exportResults() {
        //exportCascades();
    }

    public void exportCascades() {
        StringBuilder sb = new StringBuilder();
        int longestExperiment = 0;
        int i = 0;

        sb.append("AgentId");

        // find the experiment with the most agents
        for (IExperiment experiment : this.collection) {
            int numDecisions = experiment.getNumDecisions();
            if (numDecisions > longestExperiment) longestExperiment = numDecisions;
            sb.append(String.format(", Run%d", i++));
        }
        sb.append("\n");

        for (i = 0; i < longestExperiment - 1; i++) {
            sb.append(i);

            for (IExperiment experiment : this.collection) {
                IDecision decision = experiment.getDecision(i);

                sb.append(", ").append(decision.isCascade());
            }

            sb.append("\n");
        }

        sb.append("\r\n");

        String fileName = ExportUtility.GenerateFileName("Cascade", "csv");
        System.out.println("Exporting to: " + fileName);
        ExportUtility.Export(fileName , sb.toString());
    }
}
