import java.util.*;

public class hash1 {
    LinkedList<Integer>[] table;
    int size;

    hash1(int n) {
        size = n;
        table = new LinkedList[n];
        for (int i = 0; i < n; i++)
            table[i] = new LinkedList<>();
    }

    void insert(int key) {
        int index = key % size;
        table[index].add(key);
    }

    void display() {
        for (LinkedList<Integer> list : table)
            System.out.println(list);
    }

    void search(int key) {
        int index = key % size;
        boolean found = false;

        for (int i = 0; i < table[index].size(); i++) {
            if (table[index].get(i) == key) {
                System.out.println("Found " + key + " at index " + index);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Key " + key + " not found");
        }
    }

    public static void main(String[] args) {
        hash1 ht = new hash1(10);
        ht.insert(10);
        ht.insert(20);
        ht.insert(15);
        ht.insert(25);

        ht.display();

        ht.search(20);   // test
        ht.search(99);   // test
    }
}