package requestManager;

import entity.ICacheble;

public interface RequstManager <K, V extends ICacheble>{
	ICacheble QueryCache(K key);
	void saveOrUpdateCache(K key, V value);
	void deleteCache(K key);
}
