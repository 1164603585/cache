package command;

import entity.ICacheble;
import storage.DataContainer;

import java.lang.ref.SoftReference;

public class InsertCommand<K> extends AbstractCommand<K> {


    public InsertCommand(int id, K key, ICacheble value) {
        super(id, key, value);
    }

    @Override
    public void excute(DataContainer container) {
        SoftReference<ICacheble> ref = new SoftReference<ICacheble>(value);
        container.saveOrUpdate(key, ref);
    }
}
