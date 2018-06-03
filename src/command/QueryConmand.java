package command;

import entity.ICacheble;
import storage.DataContainer;

public class QueryConmand<K> extends AbstractCommand<K> {


    public QueryConmand(int id, Object key) {
        super(id, key);
    }

    @Override
    public void excute(DataContainer container) {
        value = container.query(key);
    }

    @Override
    public ICacheble getReturnData() {
        return value;
    }
}
