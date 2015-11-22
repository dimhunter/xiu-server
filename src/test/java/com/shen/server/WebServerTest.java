package com.shen.server;

import org.eclipse.jetty.server.Server;
import org.junit.Test;

public class WebServerTest{
	
	@Test
	public void test_app1(){
	    String file = getClass().getResource("/app1").getFile();
	    Server jettyServer = null;
	    try{
	    	jettyServer = WebServer.createServer(file+"/config/web.xml",file+"/webapp", 9900,"/");
	    	jettyServer.start();
	    	System.out.println("server start ok");
	    	jettyServer.join();
	    }catch(Exception e){
	    	try {
				jettyServer.stop();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	    }
	}
	
	@Test
	public void test_app2(){
	    String file = getClass().getResource("/app2").getFile();
	    Server jettyServer = null;
	    try{
	    	jettyServer = WebServer.createServer(file,9900,"/");
		    jettyServer.start();
		    System.out.println("server start ok");
		    jettyServer.join();
	    }catch(Exception e){
	    	try {
				jettyServer.stop();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	    }
	}
}
