package questions.q1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompetitorExercise {
    public static ArrayList<String> getCompetitors(int nCompetitors,
                                                   int topCompetitors,
                                                   List<String> competitors,
                                                   List<String> reviews) {
        CompetitorManager competitorManager = new CompetitorManager(nCompetitors, topCompetitors);
        competitors.forEach(s -> {
            Competitor competitor = new Competitor(s);
            competitorManager.add(competitor);
            reviews.forEach(s1 -> {
                if (s1.toLowerCase().contains(competitor.getName().toLowerCase())) competitor.addCount();
            });
        });

        return competitorManager.getTops()
                .stream()
                .map(Competitor::getName)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<String> getCompetitorsHeap(int nCompetitors,
                                                   int topCompetitors,
                                                   List<String> competitors,
                                                   List<String> reviews) {
        MaxHeap competitorMaxHeap = new MaxHeap(nCompetitors);
        competitors.forEach(s -> {
            Competitor competitor = new Competitor(s);
            reviews.forEach(s1 -> {
                if (s1.toLowerCase().contains(competitor.getName().toLowerCase())) competitor.addCount();
            });
            competitorMaxHeap.insert(competitor);
        });

        return competitorMaxHeap.getTops(topCompetitors)
                .stream()
                .map(comparable -> ((Competitor) comparable).getName())
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
