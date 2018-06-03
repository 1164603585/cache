package command;

import entity.ICacheble;
import storage.DataContainer;

public class DeleteCommand<K> extends AbstractCommand<K> {

    public DeleteCommand(int id, K key) {
        super(id, key);
    }

    @Override
    public void excute(DataContainer container) {
        container.remove(key);
    }
}
