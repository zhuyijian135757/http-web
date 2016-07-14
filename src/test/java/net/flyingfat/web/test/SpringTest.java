package net.flyingfat.web.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import net.flyingfat.web.model.Jobject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SpringTest {

	public static void main(String[] args) {
		sendPostReq();
	}
	
	public static void sendHeadReq(){
		try {
			HttpClient client=new DefaultHttpClient();
			HttpHead head=new HttpHead("http://localhost/user/getUserHeader");
			HttpResponse resp=client.execute(head);
			System.out.println(resp.getAllHeaders());
			client.getConnectionManager().shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendPostReq(){
		try {
			HttpClient client=new DefaultHttpClient();
			HttpPost post=new HttpPost("http://localhost/user/getLogInfo");
			post.setHeader("content-type","application/json");
			Jobject o=new Jobject();
			o.setId("1");
			o.setName("2");
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(o);
			HttpEntity entity=new StringEntity(json);
			post.setEntity(entity);
			client.execute(post);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void sendReqByByte(){
		try {
			HttpClient client=new DefaultHttpClient();
			HttpGet get=new HttpGet("http://localhost/user/getInfoByByte");
			get.setHeader("Accept","application/octet-stream");
			HttpResponse resp=client.execute(get);
			byte[] by=new byte[1024];
			InputStream inputStream=resp.getEntity().getContent();
			ByteArrayOutputStream output=new ByteArrayOutputStream();
			int len=0;
			while((len=inputStream.read(by))!=-1){
				output.write(by,0,len);
			};
			System.out.println(new String(output.toByteArray(),"utf-8"));;
			inputStream.close();
			output.close();
			client.getConnectionManager().shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
