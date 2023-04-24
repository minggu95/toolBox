package util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
/**
 * HTTPS 调用接口
 *
 */
public class HttpUtils {

	public static Logger logger = Logger.getLogger(HttpUtils.class);

	//获取接口数据
	public static String post(String url ,String requestBody){
		String result = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content-type","application/json");
		httpPost.setHeader("Accept", "*/*");
		httpPost.setEntity(new StringEntity(requestBody, Charset.forName("UTF-8").toString()));
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpclient.execute(httpPost);
			HttpEntity entity = httpResponse.getEntity();
			System.out.println(httpResponse.getStatusLine());
			if(entity!=null){
				result = EntityUtils.toString(entity,Charset.forName("UTF-8").toString());
			}
		} catch (ClientProtocolException e) {
			logger.error("接口异常错误:" + e.getMessage());
		} catch (IOException e) {
			logger.error("接口异常错误:" + e.getMessage());
		} finally {
			try {
				// 释放资源
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static String dopost(String postURL, NameValuePair[] data) {
		String result = "";
		try {
			PostMethod postMethod = null;
			postMethod = new PostMethod(postURL) ;
			postMethod.setRequestHeader("User-Agent", "Mozilla/4.0 compatible; MSIE 5.0;Windows NT; DigExt)");//（主要是这一句）
			postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8") ;
			//参数设置，需要注意的就是里边不能传NULL，要传空字符串

			postMethod.setRequestBody(data);

			org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
			int response = httpClient.executeMethod(postMethod); // 执行POST方法
			result = postMethod.getResponseBodyAsString() ;
			System.out.println(response);
			System.out.println(result);
		} catch (Exception e) {
			// logger.info("请求异常"+e.getMessage(),e);
			throw new RuntimeException(e.getMessage());
		}
		return result;
	}

	public static String dopost(String postURL, String cookies) {
		String result = "";
		try {
			PostMethod postMethod = null;
			postMethod = new PostMethod(postURL) ;
			postMethod.setRequestHeader("accept", "application/json, text/javascript, */*; q=0.01");
			postMethod.setRequestHeader("connection", "Keep-Alive");
			postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36");//（主要是这一句）
			postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8") ;
			postMethod.setRequestHeader("Accept-Language", "zh-CN,zh;q=0.9");
			postMethod.setRequestHeader("Cookie", cookies) ;
			//参数设置，需要注意的就是里边不能传NULL，要传空字符串
			NameValuePair[] data = {
					new NameValuePair("companyName","wadwqer")
			};
			postMethod.setRequestBody(data);

			org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
			int response = httpClient.executeMethod(postMethod); // 执行POST方法
			BufferedReader in = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(), "utf-8"));
			StringBuffer sb = new StringBuffer();
			int len;
			while ((len = in.read()) != -1) {
				sb.append((char) len);
			}
			result = sb.toString();
			in.close();
			postMethod.releaseConnection();
		} catch (Exception e) {
			// logger.info("请求异常"+e.getMessage(),e);
			throw new RuntimeException(e.getMessage());
		}
		return result;
	}

	//获取接口数据
	public static String get(String url){
		String result = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("Content-type","application/json; charset=utf-8");
		httpGet.setHeader("Accept", "application/json");
		try {
			HttpResponse httpResponse = httpclient.execute(httpGet);
			HttpEntity entity = httpResponse.getEntity();
			System.out.println(httpResponse.getStatusLine());
			if(entity!=null){
				result = EntityUtils.toString(entity,Charset.forName("UTF-8").toString());
			}
		} catch (ClientProtocolException e) {
			logger.error("接口异常错误:" + e.getMessage());
		} catch (IOException e) {
			logger.error("接口异常错误:" + e.getMessage());
		} finally {
			try {
				// 释放资源
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	//参数base就是我们创建的DefaultHttpClient对象
	/*public static HttpClient wrapClient(HttpClient base)
	{
	    try {
	        SSLContext ctx = SSLContext.getInstance("TLS");
	        X509TrustManager tm = new X509TrustManager() {

	            public X509Certificate[] getAcceptedIssuers()
	            {
	                // TODO Auto-generated method stub
	                return null;
	            }

				public void checkClientTrusted(X509Certificate[] arg0,
						String arg1) throws CertificateException {
					// TODO Auto-generated method stub

				}

				public void checkServerTrusted(X509Certificate[] arg0,
						String arg1) throws CertificateException {
					// TODO Auto-generated method stub

				}

	        };
	        ctx.init(null, new TrustManager[] { tm }, null);
	        SSLSocketFactory ssf = new SSLSocketFactory(ctx);
	        ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
	        ClientConnectionManager ccm = base.getConnectionManager();
	        SchemeRegistry sr = ccm.getSchemeRegistry();
	        //设置要使用的端口，默认是443
	        sr.register(new Scheme("https", ssf, 443));
	        return new DefaultHttpClient(ccm, base.getParams());
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return null;
	    }
	}*/
}
