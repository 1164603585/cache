package test;

import entity.AbstractCacheEntity;
import entity.ICacheble;
import requestManager.CacheManager;

public class Test {
    public static void main(String[] args) {
    	CacheManager<String, ICacheble> manager = CacheManager.newInstance(10);
    	for(int i = 0; i < 10; i++){
    		manager.saveOrUpdateCache("C" + String.valueOf(i), new A());
    	}
    	
    	ICacheble c = manager.QueryCache("C4");
    	if(c != null)
    		System.out.println(c.getLastRefreshTime());
    	
    }
}
class A extends AbstractCacheEntity{
	
}
