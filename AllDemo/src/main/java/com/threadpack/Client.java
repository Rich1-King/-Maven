package com.threadpack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by rich1 on 11/3/16.
 */
public class Client{

    public static void main(String[] args){
      //  testSingleThreadExecutor(); //单线程执行工具
      //  testCreateSimpleThreadPools(); //一定线程池
        // testCreateCachedThreadPools();//几个执行任务几个线程
        //testReturnResultThreadPools();
        testZuSeGet();
       // testInvokeAll();
    }

    //创建线程池的通用方法，具有返回值，需要所有线程执行结束一起返回。
    private static void testThreadPoolExecutor(){
        List<Callable<Object>> callables = new ArrayList();
        for(int i=0; i<50; i++){
            callables.add(new SayThread(i));
        }
        /*
            ThreadPoolExecutor参数解析
            int corePoolSize,//正常允许运行的线程个数
            int maximumPoolSize,//线程池允许运行的最大线程数
            long keepAliveTime,//当线程数大于corePoolSize的时候，如果线程keepAliveTime没有执行，则会被释放
            TimeUnit unit,//keepAliveTime的单位
            BlockingQueue<Runnable> workQueue//允许排队的线程最大数,如果排队的线程大于该值,则创建线程,当创建的线程大于maximumPoolSize,则不允许排队线程
            RejectedExecutionHandler handler//异常处理函数
            ThreadFactory threadFactory//线程池中真正创建线程的工厂
            当corePoolSize已经满了,maximumPoolSize也满了,BlockingQueue也满的时候,继续添加线程，则会抛出异常，遭受拒绝．
        */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,14,
                2,TimeUnit.SECONDS, new ArrayBlockingQueue(30));
        try{
            threadPoolExecutor.invokeAll(callables);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally{
            threadPoolExecutor.shutdown();
        }
    }

    //创建单线程,该线程池只有一个线程
    private static void testSingleThreadExecutor(){
        int count = 50;
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < count; i++){
            SimpleThread simpleThread = new SimpleThread();
            simpleThread.setI(i);
            executorService.execute(simpleThread);
        }
        executorService.shutdown();
    }

    //创建一个简单的线程池
    private static void testCreateSimpleThreadPools(){
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        int count = 50;
        for(int i=0; i<count; i++){
            SimpleThread simpleThread = new SimpleThread();
            simpleThread.setI(i);
            executorService.execute(simpleThread);
        }
        executorService.shutdown();
    }

    //创建最大的线程池个数
    private static void testCreateCachedThreadPools(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        int count = 50;
        for(int i=0; i<count; i++){
            SimpleThread simpleThread = new SimpleThread();
            simpleThread.setI(i);
            executorService.execute(simpleThread);
        }
        executorService.shutdown();
    }

    //具有返回值的多线程池
    private static void testReturnResultThreadPools(){
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolExecutor = new ThreadPoolExecutor(5, 15, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(50));
        int count = 30;
        List<Future<Object>> results = new ArrayList<Future<Object>>();
        for(int i=0; i<count; i++){
            SayThread sayThread = new SayThread(i);
            Future<Object> futureStr = threadPoolExecutor.submit(sayThread);
            results.add(futureStr);
        }
        threadPoolExecutor.shutdown();
        System.out.println("hello");
        try{
            for(Future<Object> obj : results){//results的顺序为线程的添加顺序，所以遍历的顺序也是线程添加的顺序，所以输出有规律，如果线程还没有返回，则循环阻塞，等待前面的线程返回
                //get方法会造成阻塞，只有当线程执行结束并返回值时，才能继续向下走
                Object o = obj.get();
                if(o instanceof String){
                    System.out.println(Thread.currentThread().getName()+"result:"+(String)o);
                }
            }
            System.out.println("==================end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //测试Future的get方法阻塞
    private static void testZuSeGet(){
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolExecutor = new ThreadPoolExecutor(5, 15, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(50));
        int count = 30;
        List<Object> results = new ArrayList<Object>();
        for(int i=0; i<count; i++){
            SayThread sayThread = new SayThread(i);
            Object futureStr = null;
            try{
                futureStr = threadPoolExecutor.submit(sayThread).get(); //会阻塞
                System.out.println(Thread.currentThread().getName()+"result:"+(String)futureStr); //谁先返回谁输出
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (ExecutionException e){
                e.printStackTrace();
            }
            results.add(futureStr);
           // System.out.println(futureStr.toString());
        }
        threadPoolExecutor.shutdown();
        System.out.println("hello");
    }

    /**
     * invokeAll（）当所有线程执行结束，并返回值之后，继续向下运行
     */
    private static void testInvokeAll(){
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolExecutor = new ThreadPoolExecutor(5, 15, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(50));
        int count = 30;
        List<Future<Object>> results = new ArrayList<Future<Object>>();

        List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();
        for(int i=0; i<count; i++){
            SayThread sayThread = new SayThread(i);
            tasks.add(sayThread);
        }
        try{
            results = threadPoolExecutor.invokeAll(tasks);//阻塞在这里
            System.out.println("唤醒进程");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        threadPoolExecutor.shutdown();
        for(int i=0; i<results.size(); i++){
            try{
                System.out.println(String.format("第%s执行结束:"+results.get(i).get().toString(), i));
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (ExecutionException e){
                e.printStackTrace();
            }
        }

    }
}
