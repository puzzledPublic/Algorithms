package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Base64;
import java.util.Base64.Decoder;

//Base64 Decoder
public class SWEA1928 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Decoder decoder = Base64.getDecoder();

		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {	
			bw.write("#" + i + " ");
			String encoded = br.readLine();
			byte[] bs = decoder.decode(encoded);
			for(byte b : bs) {
				bw.write((char)b);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
