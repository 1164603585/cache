package test;

import java.util.ArrayList;

import entity.AbstractCacheEntity;
import entity.ICacheble;
import requestManager.CacheManager;

public class Test {
    public static void main(String[] args) {
    	CacheManager<String, ICacheble> manager = CacheManager.newInstance(10);
    	for(int i = 0; i < 10; i++){
    		manager.saveOrUpdateCache("C" + String.valueOf(i), new A());
    		ICacheble c = manager.QueryCache("C4");
        	if(c != null)
        		System.out.println(c.getLastRefreshTime());
    	}
    	
//    	ArrayList<A> ll = new ArrayList<>();
//    	while(true){
//    		ICacheble c = manager.QueryCache("C4");
//        	if(c != null)
//        		System.out.println(c.getLastRefreshTime());
//        	
//        	ll.add(new A());
//        	p();
//    	}
//    	ICacheble c = manager.QueryCache("C4");
//    	if(c != null)
//    		System.out.println(c.getLastRefreshTime());
//    	
//    	byte[] b = new byte[1024*100];
//    	
//    	c = manager.QueryCache("C4");
//    	if(c != null)
//    		System.out.println(c.getLastRefreshTime());
    	
    	
    	   
    	
    	
    }
    
    public static void p(){
    	Runtime currRuntime = Runtime.getRuntime ();   
        int nFreeMemory = ( int ) (currRuntime.freeMemory() / 1024 / 1024);   
        int nTotalMemory = ( int ) (currRuntime.maxMemory() / 1024 / 1024);   
        System. out .println( " 内存信息 :" + nFreeMemory + "M/" + nTotalMemory + "M(free/total)");
    }
}
class A extends AbstractCacheEntity{
	byte[] b = new byte[1024*100];
}
