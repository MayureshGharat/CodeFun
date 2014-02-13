import java.util.ArrayList;

/**
 * Created by mayuresh on 2/12/14.
 */
public class AutoRacer {

    RacerBucket[] bucket;
    int minStartTime;
    Racer[] racers;


    public AutoRacer(Racer[] racers) {
        this.racers = racers;
    }

    public void setMinStartTime(int minStartTime)
    {
      this.minStartTime = minStartTime;
    }

    public void createBuckets()
    {
        int minStart = Integer.MAX_VALUE;
        int maxStart = Integer.MIN_VALUE;

        for(Racer r : racers)
        {
          if(minStart > r.getStart())
          {
              minStart = r.getStart();
          }

          if(maxStart < r.getStart())
          {
            maxStart = r.getStart();
          }
        }

        int numberOfBuckets = (Math.abs(minStart - maxStart))/racers.length;

        setMinStartTime(minStart);
        this.bucket = new RacerBucket[numberOfBuckets];

        for(int i = 0;  i < bucket.length; i ++ )
        {
            bucket[i] = new RacerBucket();
        }
    }

    public void performBucketing()
    {

        for(Racer r : racers)
        {
            int bucketIndex = ((Math.abs(r.getStart() - minStartTime))%racers.length);

            bucket[bucketIndex].incrementCount();
            bucket[bucketIndex].addId(r);

            if(bucket[bucketIndex].maxEndTime < r.getEnd())
            {
                bucket[bucketIndex].setMaxEndTime(r.getEnd());
            }
        }
    }

    public void performSorting()
    {
      for(Racer r :  racers)
      {
          int bucketIndex = (Math.abs(r.getStart() - minStartTime)) % racers.length;

          for(int i = 0/* bucketIndex*/ ; i < bucket.length ; i++)
          {
              if(bucket[i].maxEndTime < r.getEnd())
              {
                 int score = r.getScore();
                 if(bucket[i].getRacers().contains(r))
                 {
                     score += bucket[i].count - 1;
                 }
                  else
                 {
                     score += bucket[i].count;
                 }
                 r.setScore(score);
              }
              else
              {
                  ArrayList<Racer> racerList = bucket[i].getRacers();

                  for(Racer racer : racerList)
                  {
                    if(r == racer)
                    {
                        continue;
                    }
                    else
                    {
                       if(racer.getEnd() < r.getEnd() && racer.getStart() > r.getStart())
                       {
                           int score = r.getScore();
                           r.setScore(++score);
                       }
                    }
                  }
              }



          }
      }
    }

    public Racer[] getRacers() {
        return racers;
    }
}
