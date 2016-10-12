package com.dunn.Net;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
public class HttpServer {//用户通过浏览器发送报文至HttpServer进程，HttpServer进程对报文头解析，返回结果至浏览器进行显示
       //private static final boolean shutdown = false;
       public static final String  webroot  = System.getProperty("user.dir")+File.separator+"webroot";
       public void await() throws Exception{
			ServerSocket server = new ServerSocket(8080 , 1 , InetAddress.getByName("127.0.0.1"));	    
			Socket ss = null;
			while(null==ss)	{
				ss = server.accept();
				}
			    BufferedReader in = new BufferedReader(new InputStreamReader(ss.getInputStream()));
			    PrintWriter out = new PrintWriter(ss.getOutputStream());
                MyRequest req = new MyRequest();
                req.phraseUri(in);
                //SOP.p(req.geturiString());
                MyResponse resp = new MyResponse(req,out);
			    resp.sendToCliect();
			    ss.close();
			    server.close();
       }
       public static void main(String[] args)throws Exception{
    	   HttpServer server = new HttpServer();
    	   server.await();
    	   server = null;
       }
}
