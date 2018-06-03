package requestManager;

import command.*;
import entity.ICacheble;

public class CacheManager<K, V extends ICacheble> {

    private CommandManager<K, V> commandManager;
    private static int count = 0;

    private CacheManager(int capacity){
        commandManager = CommandManager.newInstance(capacity);
    }

    public ICacheble QueryCache(K key){
        Command<K> command = new QueryConmand<K>(count++, key);
        synchronized (command){
        	commandManager.put(command);
            try {
                command.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return command.getReturnData();
    }

    public void saveOrUpdateCache(K key, V value){
        Command<K> command = new InsertCommand<>(count++, key, value);
        commandManager.put(command);
    }

    public void deleteCache(K key){
        Command<K> command = new DeleteCommand<>(count++, key);
        commandManager.put(command);
    }

    public static CacheManager newInstance(int capacity){
        return new CacheManager(capacity);
    }



}
