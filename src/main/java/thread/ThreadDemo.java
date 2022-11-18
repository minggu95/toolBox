package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadDemo extends Thread {

    private String threadName;
    private Thread t;

    public ThreadDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        try {
            for (int i = 1000; i > 0; i--) {
                ping();
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
    public static boolean ping(){
        String ip = "fc.wison.com";
        String ins = "ping "+ ip;
        try{
            Process p = Runtime.getRuntime().exec(ins);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(),"GBK"));
            String line = null;
            while((line = reader.readLine())!=null){
                if(line.indexOf("来自")!=-1){    //这里不同的cmd可能不一样
                    System.out.println(line+ip+" 连接成功");
                    return true;
                }
                if(line.indexOf("请求超时")!=-1){  //这里也是
                    System.out.println(ip+" 连接失败");
                    return false;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
}