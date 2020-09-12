package questions.q1;

public class Competitor implements Comparable {
    private String name;
    private char first;
    private int count;

    public Competitor(String name) {
        this.name = name;
        first = name.charAt(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getFirst() {
        return first;
    }

    public void setFirst(char first) {
        this.first = first;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        count++;
    }

    public int compareToDesc(Competitor competitor) {
        if (count > competitor.getCount()) return -1;
        else if (count < competitor.getCount()) return 1;
        else {
            if (first <= competitor.getFirst()) return -1;
            return 1;
        }
    }

    @Override
    public int compareTo(Object object) {
        Competitor competitor = (Competitor) object;
        if (count > competitor.getCount()) return 1;
        else if (count < competitor.getCount()) return -1;
        else {
            if (first <= competitor.getFirst()) return 1;
            return -1;
        }
    }

}
