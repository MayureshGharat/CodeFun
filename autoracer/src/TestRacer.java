/**
 * Created with IntelliJ IDEA.
 * User: mgharat
 * Date: 1/27/14
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestRacer {

    public static void main(String args[])
    {
        Racer r1 = new Racer(90, 150 , 1, 0);
        Racer r2 = new Racer(100, 200 , 2, 0);
        Racer r3 = new Racer(110, 190 , 3, 0);
        Racer r4 = new Racer(105, 145 , 4, 0);
        Racer r5 = new Racer(102, 198 , 5, 0);

//        2 100 200
//        3 110 190
//        4 105 145
//        1 90 150
//        5 102 198


//        3 0
//        4 0
//        1 1
//        5 2
//        2 3

        Racer[] racers = new Racer[5];
        racers[0] = r1;
        racers[1] = r2;
        racers[2] = r3;
        racers[3] = r4;
        racers[4] = r5;

//        Heap heap = new Heap(racers);
//        heap.sort();

        AutoRacer autoRacer = new AutoRacer(racers);
        autoRacer.createBuckets();
        autoRacer.performBucketing();
        autoRacer.performSorting();
        Racer[] racers1 = autoRacer.getRacers();

        for(Racer racer : racers1)
        {
            System.out.println(racer.getId() + " : "+racer.getScore() );
        }

    }

}
