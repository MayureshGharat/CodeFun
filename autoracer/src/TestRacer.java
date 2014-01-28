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
        Racer r1 = new Racer(100, 200 , 1, 0);
        Racer r2 = new Racer(110, 190 , 2, 0);
        Racer r3 = new Racer(105, 180 , 3, 0);
        Racer r4 = new Racer(90, 150 , 4, 0);
        Racer r5 = new Racer(95, 130 , 5, 0);

        Racer[] racers = new Racer[5];
        racers[0] = r1;
        racers[1] = r2;
        racers[2] = r3;
        racers[3] = r4;
        racers[4] = r5;

        Heap heap = new Heap(racers);
        heap.sort();


    }

}
