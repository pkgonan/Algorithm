package Java;

import java.util.HashSet;
import java.util.Set;

public class SetIntersection {

    public void setIntersection() {
        Set<Integer> A = new HashSet<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);

        Set<Integer> B = new HashSet<>();
        B.add(4);
        B.add(5);
        B.add(6);
        B.add(7);

        boolean isChanged = A.retainAll(B);

        System.out.println("Result : " + isChanged + " A Set Values : " + A.toString() + " B Set Values : " + B.toString());
    }
}
