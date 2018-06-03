package test;

import entity.ICacheble;
import requestManager.CacheManager;

public class Test {
    public static void main(String[] args) {
    	CacheManager<String, ICacheble> manager = CacheManager.newInstance(10);
    	System.out.println(123);
    }
}
