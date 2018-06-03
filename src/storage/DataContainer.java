package storage;

import entity.ICacheble;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Date;
import java.util.HashMap;

public class DataContainer<K , V extends SoftReference<? extends ICacheble>> {

    private HashMap<K, V> map;
    private ReferenceQueue<V> queue;

    public DataContainer() {
        this.map = new HashMap<>();
        this.queue = new ReferenceQueue<>();
    }

//    public void insert(K key, V value){
//        map.put(key, value);
//    };
    public void saveOrUpdate(K key, V value){
        map.put(key, value);
        clearQueue();
    }

    public ICacheble query(K key){
        ICacheble value = null;
        V v = map.get(key);
        if(v != null){
            if(isTimeOut(v)){
                map.remove(key);
            }else{
                value = v.get();
            }
        }
        clearQueue();
        return value;
    }

    public void remove(K key){
        map.remove(key);
        clearQueue();
    }

    private boolean isTimeOut(V v){
        if(v != null){
            ICacheble c = v.get();
            if(c != null) {
                if (new Date().getTime() - c.getLastRefreshTime() < c.getTimeOut())
                    return false;
            }
        }
        clearQueue();
        return true;
    }
    
    private void clearQueue(){
//    	while(queue.poll() != null)
//    		System.out.println("queue出队");
    }

    public static void main(String[] args) {

    }
}
