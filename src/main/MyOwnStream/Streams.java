package MyOwnStream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by скурихин on 13.09.2016.
 */
public class Streams<T> {
    private List<T> list;
    private static Streams MyStream;

    private Streams() {
    }

    public static Streams of(List newCollection) {
        MyStream = new Streams();
        MyStream.list = new ArrayList();
        MyStream.list.addAll(newCollection);
        return MyStream;
    }

    public Streams filter(Predicate<T> predicate) {
        for (T t : list) {
            if (!predicate.test(t)) {
                list.remove(t);
            }
        }
        return this;
    }

    public void forEach(Consumer consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
//    public Collection map() {
//
//    }
}
