package Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparator {

    public void Comparator() {
        List<Person> persons = new ArrayList<>();
        Person p1 = new Person("B", 25, "CC");
        Person p2 = new Person("A", 20, "AA");
        Person p3 = new Person("A", 15, "BB");
        Person p4 = new Person("B", 25, "AA");

        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);

        Collections.sort(persons, new PersonComparator());

        System.out.println(persons);
    }

    // 정렬 순서
    // 이름이 큰 순서로
    // 이름이 같으면 나이가 많은 순서로
    // 이름도 같으면 주소가 큰 순서로
    private static class PersonComparator implements java.util.Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            int first = firstCompare(o1, o2);
            if (first == 0) {
                int second = secondCompare(o1, o2);
                if (second == 0) {
                    return thirdCompare(o1, o2);
                }

                return second;
            }
            return first;
        }

        private int firstCompare(Person o1, Person o2) {
            return o2.getName().compareTo(o1.getName());
        }

        private int secondCompare(Person o1, Person o2) {
            return o2.getAge().compareTo(o1.getAge());
        }

        private int thirdCompare(Person o1, Person o2) {
            return o2.getAddress().compareTo(o1.getAddress());
        }
    }

    private static class Person {
        private String name;
        private Integer age;
        private String address;

        Person(final String name, final Integer age, final String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        @Override
        public String toString() {
            return "Name : " + name + ", " + "Age : " + age + ", " + "Address : " + address + "\n";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Person)) {
                return false;
            }

            Person obj1 = (Person) obj;
            return this.name.equals(obj1.name) && this.age.equals(obj1.age) && this.address.equals(obj1.address);
        }

        @Override
        public int hashCode() {
            int result = 17;

            result = 31 * result + name.hashCode();
            result = 31 * result + age;
            result = 31 * result + address.hashCode();

            return result;
        }
    }
}
