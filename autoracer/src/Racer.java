/**
 * Created with IntelliJ IDEA.
 * User: mgharat
 * Date: 1/27/14
 * Time: 9:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class Racer {

    private int start;
    private int end;
    private int id;
    private int score;

    public Racer(int start, int end, int id, int score) {
        this.start = start;
        this.end = end;
        this.id = id;
        this.score = score;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}




