package entity;

import java.util.Date;

public class AbstractCacheEntity implements ICacheble{
    private long lastRefreshTime;
    private long timeOut;

    public AbstractCacheEntity(long timeOut){
        lastRefreshTime = new Date().getTime();
        this.timeOut = timeOut;
    }

    public AbstractCacheEntity() {
        this(Default_TIMEOUT);
    }

    @Override
    public void updateLastRefreashTime() {
        lastRefreshTime = new Date().getTime();
    }

    @Override
    public long getLastRefreshTime() {
        return lastRefreshTime;
    }

    @Override
    public long getTimeOut() {
        return timeOut;
    }

}
