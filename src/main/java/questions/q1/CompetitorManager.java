package questions.q1;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Data
public class CompetitorManager {
    private int max;
    private int top;
    private ArrayList<Competitor> competitors;

    public CompetitorManager(int max, int top) {
        this.max = max;
        this.top = top;
        this.competitors = new ArrayList<>();
    }

    public void add(Competitor competitor) {
        this.competitors.add(competitor);
    }

    public ArrayList<Competitor> getTops() {
        Comparator<Competitor> competitorComparator = Competitor::compareToDesc;
        Collections.sort(competitors, competitorComparator);
        return new ArrayList<>(competitors.subList(0, top));
    }
}
