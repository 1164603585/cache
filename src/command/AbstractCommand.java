package command;

import entity.ICacheble;

public abstract class AbstractCommand<K> implements Command<K> {

    private int id;
    protected Object key;
    protected ICacheble value;


    public AbstractCommand(int id, K key, ICacheble value){
        this.id = id;
        this.key = key;
        this.value = value;
    }

    public AbstractCommand(int id, Object key) {
        this.id = id;
        this.key = key;
        this.value = null;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public ICacheble getReturnData() {
        return null;
    }
}
