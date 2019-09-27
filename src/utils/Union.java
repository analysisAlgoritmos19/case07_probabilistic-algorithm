package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Union {

    public <T> ArrayList<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<T>();
        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }
}