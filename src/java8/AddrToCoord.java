package java8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class AddrToCoord {

	public static void main(String args[])
	{
		/*
		try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\KHM\\Desktop\\����������Ű������Ա⼳ġ��Ȳ2.txt"))))
		    ;BufferedWriter out = new BufferedWriter(new FileWriter(new File("C:\\Users\\KHM\\Desktop\\AddrToCoord.txt"))))
		{
			ObjectMapper om = new ObjectMapper();
			String line = null;
			while((line=in.readLine())!=null)
			{
				loop(om, line,out);
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		coordToJs();

	}
	//����api�� �ּҰ˻��Ͽ� ��ǥ�� ��������
	/*
	public static void loop(ObjectMapper om, String addr,BufferedWriter out)
	{
		try { 
			//ObjectMapper om = new ObjectMapper();
			//�ּ� ���ڵ�
			String encodingResult = URLEncoder.encode(addr,"UTF-8");
			//url ����
			URL url = new URL("https://apis.daum.net/local/v1/search/keyword.json?apikey=05773f117e634e194f7f2308134d4e7f&query="+encodingResult);
			//connection ����
			URLConnection URLConnection =  url.openConnection();
			//json ������ �޾� ���ڵ� �� ���Ͽ� ����
			try(BufferedReader in = new BufferedReader(new InputStreamReader(URLConnection.getInputStream(),"UTF-8")))
			{
				JsonNode jn = om.readTree(in);
				out.write(jn.path("channel").path("item").path(0).path("title").getTextValue()+","+
						jn.path("channel").path("item").path(0).path("latitude").getTextValue()+","+
						jn.path("channel").path("item").path(0).path("longitude").getTextValue()+"\r\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	//��ǥ���� ��Ŀ��� ����ϱ� ���� js�������� �ٲ�
	public static void coordToJs()
	{
		try(BufferedReader in = new BufferedReader(new FileReader(new File("C:\\Users\\KHM\\Desktop\\AddrToCoord.txt")));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\KHM\\Desktop\\AddrToJs.js"), "UTF-8")))
		{
			out.write("var positions = [");
			String line = null;
			while((line=in.readLine())!=null)
			{
				String[] results = line.split(",");
				out.write("{ content:'<div>"+results[0]+"</div>', latlng:new daum.maps.LatLng("+results[1]+","+results[2]+")},");
			}
			out.write("];");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
