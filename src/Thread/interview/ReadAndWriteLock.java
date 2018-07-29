package Thread.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liubaoqing
 * @createTime 2018-07-27
 * @description
 */
public class ReadAndWriteLock {
   public static void main(String[] args) {
      final ReaderAndWriter rw = new ReaderAndWriter(new HashMap());
      ExecutorService executorService = Executors.newCachedThreadPool();
      for(int i=0;i<100;i++){
         int index = i%(rw.getMap().size()+1);
         executorService.execute(new TestThread(rw,index));
      }
      executorService.shutdown();
      System.out.println(rw.getMap());
   }
}
class TestThread implements Runnable{
   private ReaderAndWriter rw;
   private int CacheIndex ;
   public TestThread(ReaderAndWriter rw,int CacheIndex) {
      this.rw = rw;
      this.CacheIndex = CacheIndex;
   }
   @Override
   public void run() {
      int rand = (int)(Math.random()*100);
      if(rand<30){
         rw.put("cache"+CacheIndex,rand);
      }
   }
}
class ReaderAndWriter<K,V>{
   private ReadWriteLock lock = new ReentrantReadWriteLock();
   private final Lock readlock = lock.readLock();
   private final Lock writelock = lock.writeLock();
   private final Map<K,V> map;
   public Map<K, V> getMap() {
      return map;
   }
   ReaderAndWriter(Map<K, V> map) {
      this.map = map;
   }
   public V put(K key,V value){
      while(true) {
         if(writelock.tryLock()){
            try {
               return map.put(key,value);
            }finally {
               writelock.unlock();
            }
         }
      }
   }
   public V get(K key){
      while(true){
         if(readlock.tryLock()){
          try {
             return map.get(key);
          }finally {
             readlock.unlock();
          }
         }
      }
   }
   public V put1(K key,V value){
      writelock.lock();
      try {
         return map.put(key,value);
      }finally {
         writelock.unlock();
      }
   }
   public V get1(K key){
      readlock.lock();
      try {
         return map.get(key);
      }finally {
         readlock.unlock();
      }
   }
}