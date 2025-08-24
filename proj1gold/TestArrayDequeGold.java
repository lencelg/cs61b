import org.junit.Test;
import static org.junit.Assert.*;
public class TestArrayDequeGold {
    @Test
    public void randomtestStudentArrayDeque(){
        StudentArrayDeque<Integer> saq = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        String output = "";
        for (int i = 0; i < 1000; i++) {
            if (saq.isEmpty()) {
                int addNumber = StdRandom.uniform(1000);
                int headOrBack = StdRandom.uniform(2);
                if (headOrBack == 0) {
                    output = output + "addFirst(" + addNumber + ")\n";
                    ads.addFirst(addNumber);
                    saq.addFirst(addNumber);
                } else {
                    output = output + "addLast(" + addNumber + ")\n";
                    ads.addLast(addNumber);
                    saq.addLast(addNumber);
                }
            } else {
                int x = StdRandom.uniform(4);
                int addNumber = StdRandom.uniform(1000);
                Integer testremoveNumber = 1;
                Integer stdremoveNumber = 1;
                switch (x) {
                    case 0:
                        output = output + "addFirst(" + addNumber + ")\n";
                        ads.addFirst(addNumber);
                        saq.addFirst(addNumber);
                        break;
                    case 1:
                        output = output + "addLast(" + addNumber + ")\n";
                        ads.addLast(addNumber);
                        saq.addLast(addNumber);
                        break;
                    case 2:
                        output = output + "removeFirst()\n";
                        testremoveNumber = ads.removeFirst();
                        stdremoveNumber = saq.removeFirst();
                        break;
                    case 3:
                        output = output + "removeLast()\n";
                        testremoveNumber = ads.removeLast();
                        stdremoveNumber = saq.removeLast();
                        break;
                    default:
                }
                assertEquals(output, stdremoveNumber, testremoveNumber);
            }
        }
    }
}