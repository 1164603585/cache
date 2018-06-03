package command;

import entity.ICacheble;
import storage.DataContainer;

import java.lang.ref.SoftReference;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CommandManager<K, V extends ICacheble>{
    private BlockingQueue<Command<K>> queue;
    private DataContainer<K, SoftReference<ICacheble>> container;
    private Thread handler;

    private CommandManager(int capacity){
        queue = new ArrayBlockingQueue<Command<K>>(capacity);
        container = new DataContainer<>();
        handler = new Handler();
        handler.setDaemon(true);
        handler.start();
    }

    public static CommandManager newInstance(int capacity){
        return new CommandManager(capacity);
    }

    public void put(Command<K> command){
        try {
            queue.put(command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void poll(Command<K> command){
        try {
            queue.put(command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class Handler extends Thread{
        @Override
        public void run() {
            Command command = null;
            while(true){
            	try {
					command = queue.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                if(command != null){
                    command.excute(container);
                    synchronized (command) {
                    	command.notifyAll();
					}
                }else{
                	
                }
            }
        }
    }
}
