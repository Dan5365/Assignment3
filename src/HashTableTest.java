import java.util.Random;

public class HashTableTest {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random rand = new Random();

        for (int i = 0; i < 10000; i++) {
            int id = rand.nextInt(100000);
            MyTestingClass key = new MyTestingClass(id);
            Student value = new Student("Student" + id, rand.nextInt(100));
            table.put(key, value);
        }

        int[] bucketSizes = table.getBucketSizes();
        System.out.println("Bucket sizes:");
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
        }
        System.out.println("Total elements: " + table.size());
    }
}

class MyTestingClass {
    private int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTestingClass other = (MyTestingClass) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        int hash = id * 31;
        hash = hash ^ (hash >> 16);
        return hash;
    }
}


class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}