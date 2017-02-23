package collections_extends;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by скурихин on 12.01.2017.
 */
public class CellPhone extends Phone {
    public static void main(String[] args) {

        ArrayList<Phone> phones = new ArrayList<>();
        methodList(phones,new CellPhone());
        methodList(phones,new Phone());

        List<CellPhone> subtypeList = new ArrayList<CellPhone>();
        List<? extends Phone> list = subtypeList;
        //error!
        //list.add(new Phone());
        //CellPhone sub = subtypeList.get(0);
    }

    static <T extends Phone,E> void methodList(List<? super T> list, T phone) {
        list.add(phone);
        Object o = list.get(0);
        list.remove(0);
    }
}
