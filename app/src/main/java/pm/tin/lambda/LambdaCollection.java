package pm.tin.lambda;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by angadn on 24/11/16.
 */

public class LambdaCollection<T> implements Collection<T>  {
    private Collection<T> collection;

    public LambdaCollection(Collection<T> collection) {
        this.collection = collection;
    }

    public Collection<T> unwrap() {
        return this.collection;
    }

    public LambdaCollection<T> filter(FilterLambda<T> filterLambda) {
        ArrayList<T> ret = new ArrayList<>();
        for (T value : collection) {
            if (filterLambda.filter(value)) {
                ret.add(value);
            }
        }

        return new LambdaCollection<>(ret);
    }

    public <M> LambdaCollection<M> map(MapLambda<T, M> mapLambda) {
        Collection<M> ret = new ArrayList<M>();
        for (T value : collection) {
            ret.add(mapLambda.map(value));
        }

        return new LambdaCollection<M>(ret);
    }

    /* Proxy methods */

    @Override
    public int size() {
        return this.collection.size();
    }

    @Override
    public boolean isEmpty() {
        return this.collection.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.collection.contains(o);
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return this.collection.iterator();
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return this.collection.toArray();
    }

    @NonNull
    @Override
    public <T1> T1[] toArray(@NonNull T1[] t1s) {
        return this.collection.toArray(t1s);
    }

    @Override
    public boolean add(T t) {
        return this.collection.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return this.collection.remove(o);
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.collection.containsAll(collection);
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends T> collection) {
        return this.collection.addAll(collection);
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.collection.removeAll(collection);
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.collection.retainAll(collection);
    }

    @Override
    public void clear() {
        this.collection.clear();
    }
}
