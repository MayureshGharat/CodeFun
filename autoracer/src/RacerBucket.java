import java.util.ArrayList;

/**
 * Created by mayuresh on 2/12/14.
 */
public class RacerBucket {

    int count;
    int high;
    int low;
    int maxEndTime;
    ArrayList<Racer> racers;

    public int getCount() {
        return count;
    }

    public int getMaxEndTime() {
        return maxEndTime;
    }

    public void setMaxEndTime(int maxEndTime) {
        this.maxEndTime = maxEndTime;
    }

    public ArrayList<Racer> getRacers() {
        return racers;
    }

    public int getHigh() {

        return high;
    }

    public int getLow() {
        return low;
    }

    public void incrementCount()
    {
        this.count++;
    }

    public void updateMaxEndTime(int endTime)
    {
        if(endTime >  this.getMaxEndTime())
        {
            this.setMaxEndTime(endTime);
        }
    }

    public void addId(Racer racer) {
        racers.add(racer);
    }

    public RacerBucket() {
        racers = new ArrayList<>();
        this.count = 0;
        this.maxEndTime = 0;
    }

    RacerBucket(int high, int low)
    {
        racers = new ArrayList<>();
        this.high = high;
        this.low = low;
        this.count = 0;
        this.maxEndTime = 0;
    }



}


