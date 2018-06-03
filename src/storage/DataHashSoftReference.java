package storage;

import entity.ICacheble;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class DataHashSoftReference<T> extends SoftReference<T> {

    private int id;

    public DataHashSoftReference(T referent, ReferenceQueue<T> q) {
        super(referent, q);
    }

}
