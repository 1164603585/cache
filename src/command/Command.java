package command;

import entity.ICacheble;
import storage.DataContainer;

public interface Command<K> {
    void excute(DataContainer container);
    int getId();
    ICacheble getReturnData();
}
