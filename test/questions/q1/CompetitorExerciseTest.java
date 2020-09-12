package questions.q1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CompetitorExerciseTest {

    private String competitorStr1;
    private String competitorStr2;
    private String competitorStr3;
    private String competitorStr4;
    private String competitorStr5;
    private List<String> competitors;
    private List<String> reviews;
    private Competitor competitor1;
    private Competitor competitor2;
    private Competitor competitor3;
    private Competitor competitor4;
    private Competitor competitor5;

    @BeforeEach
    public void setup() {
        competitorStr1 = "João";
        competitorStr2 = "Maria";
        competitorStr3 = "José";
        competitorStr4 = "Sônia";
        competitorStr5 = "Joana";
        reviews = List.of("João gave this review", "João and Maria gave this review",
                "João and Maria gave this review",  "João and Sônia gave this review");
        competitor1 = new Competitor(competitorStr1);
        competitor2 = new Competitor(competitorStr2);
        competitor3 = new Competitor(competitorStr3);
        competitor4 = new Competitor(competitorStr4);
        competitor5 = new Competitor(competitorStr5);
    }

    @Test
    public void shouldGetCompetitors() {
        CompetitorManager competitorManager = new CompetitorManager(2, 2);
        competitorManager.add(competitor1);
        competitorManager.add(competitor2);
        competitorManager.add(competitor3);
        competitorManager.add(competitor4);
        competitorManager.add(competitor5);

        competitors= List.of(competitorStr1, competitorStr2);
        ArrayList<String> expected = new ArrayList<>();
        expected.add(competitorStr1);
        expected.add(competitorStr2);
        Assertions.assertEquals(expected, CompetitorExercise.getCompetitors(2,2, competitors, reviews));
    }

    @Test
    public void shouldGetCompetitorsHeap() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add(competitorStr1);
        expected.add(competitorStr2);
        expected.add(competitorStr4);
        competitors= List.of(competitorStr3, competitorStr5, competitorStr1, competitorStr2, competitorStr4);
        Assertions.assertEquals(expected, CompetitorExercise.getCompetitorsHeap(5,3, competitors, reviews));
    }

}
