package java8;

import java.io.IOException;

public class JsonTest {
	public static void main(String args[]) throws IOException
	{
//		ObjectMapper om = new ObjectMapper();
//		File file = new File("C:\\Users\\KHM\\Desktop\\서울시자전거공기주입기설치현황.json");
//		
//		try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\KHM\\Desktop\\서울시자전거공기주입기설치현황2.txt")))){
//		
//			JsonNode jn = om.readTree(file);
//			for(int i = 0 ; i< 570; i++)
//			{
//				if(jn.path(i).path("SET_LOC").getTextValue()=="")
//				{
//					bw.write(jn.path(i).path("LOCATION").getTextValue()+"\r\n");
//				}
//				else if(jn.path(i).path("LOCATION").getTextValue()=="")
//				{
//					bw.write(jn.path(i).path("SET_LOC").getTextValue()+"\r\n");
//				}
//				else
//				{
//					bw.write(jn.path(i).path("SET_LOC").getTextValue()+", "+jn.path(i).path("LOCATION").getTextValue()+"\r\n");
//				}
//			}
//
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
	}
}
