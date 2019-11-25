// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class TopNCompetitors {

    class Competitor {
        String name;
        int count;

        Competitor(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> topNCompetitors(int numCompetitors,
                                             int topNCompetitors,
                                             List<String> competitors,
                                             int numReviews,
                                             List<String> reviews) {

        ArrayList<String> topNCompetitorsList = new ArrayList<>();
        if (numCompetitors < 0 && competitors.isEmpty()) {
            return topNCompetitorsList;
        }
        if (numReviews < 0 && reviews.isEmpty()) {
            return topNCompetitorsList;
        }
        ArrayList<Competitor> competitorsReviews = new ArrayList<>(numCompetitors);

        for (String comp : competitors) {
            competitorsReviews.add(new Competitor(comp, 0));
        }

        competitorsReviews.stream().forEach(comp -> countReviewsForEachCompetitor(reviews, comp));
        Collections.sort(competitorsReviews, (c1, c2) -> c1.count != c2.count ? c2.count - c1.count : c1.name.compareTo(c2.name));
        if (topNCompetitors > numCompetitors) {
            topNCompetitors = numCompetitors;
        }
        for (int i = 0; i < topNCompetitors; i++) {
            topNCompetitorsList.add(competitorsReviews.get(i).name);
        }
        return topNCompetitorsList;


    }

    private void countReviewsForEachCompetitor(List<String> reviews, Competitor comp) {
        for (String review : reviews) {
            if (review.toLowerCase().contains(comp.name.toLowerCase())) {
                comp.count++;
            }

        }
    }
    // METHOD SIGNATURE ENDS
}
