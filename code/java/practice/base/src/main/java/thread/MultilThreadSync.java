package thread;

import org.apache.commons.collections4.CollectionUtils;

import java.util.LinkedList;

public class MultilThreadSync<T> {

    private LinkedList<T> linkedList = new LinkedList<>();
    int max = 10;


    public synchronized void put(T t) {
        while (linkedList.size() == max) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        linkedList.push(t);
        notifyAll();
    }

    public synchronized T get() {
        while (CollectionUtils.isEmpty(linkedList)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t1 = linkedList.removeFirst();
        notifyAll();
        return t1;
    }


}
