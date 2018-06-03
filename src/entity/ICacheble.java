package entity;

public interface ICacheble {
    public static final int Default_TIMEOUT = 5*60*1000;

    void updateLastRefreashTime();
    long getLastRefreshTime();
    long getTimeOut();
}
