package com.dunn.Net;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
public class MyResponse {
	String path = "";
	MyRequest req = null;
	PrintWriter out = null;
	public MyResponse(MyRequest req,PrintWriter out) {
		this.req = req;
		this.path = path+(req.geturiString().replace('/', '\\'));
		this.out = out;
	}
    public void sendToCliect() throws Exception{//�Կͻ��˽��з���
    	path = HttpServer.webroot+path;
    	//SOP.p(path+" hello");
    	File file = new File(path);
    	   if(file.exists()){//������ش��ھ�ȡ�ļ�����
    		   BufferedReader reader = new BufferedReader(new FileReader(file));
    		   String str = "";
				while(null!=(str=reader.readLine())){
							out.println(str);
							//SOP.p(str);
				   }
				reader.close();
    	   }else{//����������򷵻�404ҳ��
				String str ="HTTP/1.1 404 File Not Found/r/n" +
				            "Content-Type: text/html/r/n" +
				            "Content-Length: 23/r/n" +
				            "/r/n" +
				            "<h1>File Not Found</h1>";
				out.println(str);
    	   }
    	   
    }
}
