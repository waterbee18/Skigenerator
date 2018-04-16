package guesski.model;

public class Score implements Comparable<Score> {

    private String username;
    private int score;

    public Score(String username, int score) {
        this.username = username;
        this.score = score;
    }

    @Override
    public int compareTo(Score o) {
        if (o.getScore() > score){
            return -1;
        } else {
            return 1;
        }
    }

    public String getUsername() {
        return username;
    }

    public int getScore(){
        return score;
    }
}
