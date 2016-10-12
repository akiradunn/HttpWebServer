package com.dunn.Net;
import java.io.BufferedReader;
public class MyRequest {
	 private String uriString = ""; 
	 public MyRequest(){
		 
	 }
     public void phraseUri(BufferedReader in) throws Exception{
    	    String buf = "";
    	    String reqString = "";
    	    BufferedReader bufferedReader = in;
    	    if(bufferedReader.ready()){
    	    	 while(null!=(buf=bufferedReader.readLine())){
    	    		  reqString += buf;
    	    	 }
    	    }
    	    SOP.p(reqString);
            int start = reqString.indexOf(' ');
            int end   = reqString.indexOf(' ',start+1);
    	    uriString += reqString.substring(start+1, end).toString();
     }
     public String geturiString(){
    	    return uriString;
     }
}
