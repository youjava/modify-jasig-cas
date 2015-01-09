package org.stackbox.darkportal.mechanism.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;

public class HttpClientUtils {
	// 连接超时
    private static final int CONNECTIONTIMEOUT = 300 * 1000;
    // 读取数据超时
    private static final int SOTIMEOUT = 300 * 1000;
    private static MultiThreadedHttpConnectionManager connectionManager ;
    private static HttpClient client;
    
    public static HttpClient getInstance() {
        connectionManager = new MultiThreadedHttpConnectionManager();
        client = new HttpClient(connectionManager);
        client.getHttpConnectionManager().getParams().setConnectionTimeout(CONNECTIONTIMEOUT);
        client.getHttpConnectionManager().getParams().setSoTimeout(SOTIMEOUT);
   
        return client;
    }
}
