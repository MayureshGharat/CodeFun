/**
 * Created with IntelliJ IDEA.
 * User: mgharat
 * Date: 1/27/14
 * Time: 9:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Heap {
    int heapSize;
    Racer[] heapArray;

    public Heap(Racer[] racers) {
        this.heapSize = racers.length;
        this.heapArray = racers;
    }

    private void buildHeap()
    {
        for(int i = ((heapSize-1)/2) ; i >= 0 ; i--)
        {
            Heapify(i);
        }
    }

    public void sort()
    {
      buildHeap();
      for(int i = heapArray.length -1 ; i >= 1 ; i --)
      {
          System.out.println(" Racer : " + heapArray[0].getId() + " score : "+heapArray[0].getScore());
          swap(0 , i);
          heapSize --;
          Heapify(1);
      }
    }

    private void Heapify(int i) {

        int left = (2*i + 1);
        int right = (2*i + 2);

        Racer leftRacer = null;
        Racer rightRacer = null;


        if(left < heapSize-1)
        {
            leftRacer = heapArray[left];
        }

        if(right < heapSize-1)
        {
            rightRacer = heapArray[right];
        }

        Racer currRacer = heapArray[i];
        int smallest = i;

        if(left < heapSize-1 && leftRacer.getStart() > currRacer.getStart() && leftRacer.getEnd() < currRacer.getEnd())
        {
            int score = currRacer.getScore();
            currRacer.setScore(++score);
            smallest = left;
            currRacer = heapArray[left];
        }
        else if(left < heapSize-1 && leftRacer.getStart() < currRacer.getStart() && leftRacer.getId() > currRacer.getId())
        {
            int score = currRacer.getScore();
            currRacer.setScore(++score);
            smallest = left;
            currRacer = heapArray[left];
        }

        if(right < heapSize-1 && rightRacer.getStart() > currRacer.getStart() && rightRacer.getEnd() < currRacer.getEnd())
        {
            int score = currRacer.getScore();
            currRacer.setScore(++score);
            smallest = right;
            currRacer = heapArray[right];
        }
        else if(right < heapSize-1 && rightRacer.getStart() < currRacer.getStart() && rightRacer.getId() > currRacer.getId())
        {
            int score = currRacer.getScore();
            currRacer.setScore(++score);
            smallest = right;
            currRacer = heapArray[right];
        }

        if(smallest != i)
        {
            swap(smallest , i);
            Heapify(smallest);
        }
    }

    private void swap(int smallest, int i) {
        Racer r1  = heapArray[smallest];
        heapArray[smallest] = heapArray[i];
        heapArray[i] = r1;
    }

}
