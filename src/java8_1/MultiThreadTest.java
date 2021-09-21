package java8_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadTest {

	public static void main(String args[]) throws InterruptedException{
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		for(int i = 0; i < 5; i++) {
			CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
				StringBuilder sb = new StringBuilder();
				try {
				URL url = new URL("https://te31.com");
				HttpURLConnection connection = (HttpURLConnection)url.openConnection();
				connection.setRequestMethod("GET");
//				connection.addRequestProperty("accept", "application/json");
				connection.connect();
				
				String str = "";
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while((str = br.readLine()) != null) {
					sb.append(str);
				}
				}catch(Exception e) {
					e.printStackTrace();
				}
				return sb.toString();
			}, executor).thenAccept(System.out::println);
		}
		executor.shutdown();
		executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
		
//		CompletionService<String> completionService = new ExecutorCompletionService<>(executor);
		
//		for(int i = 0; i < 10; i++) {
//			completionService.submit(() -> {				
//				URL url = new URL("https://te31.com");
//				HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//				connection.setRequestMethod("GET");
////				connection.addRequestProperty("accept", "application/json");
//				connection.connect();
//				
//				String str = "";
//				StringBuilder sb = new StringBuilder();
//				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//				while((str = br.readLine()) != null) {
//					sb.append(str);
//				}
//				return sb.toString();
//			});
//		}
//		try {
//			for(int i = 0; i < 10; i++) {
//				Future<String> f = completionService.take();
//				System.out.println(f.get());
//			}
//			executor.shutdown();
//			executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
//		}catch(InterruptedException e) {
//			Thread.currentThread().interrupt();
//		}catch (ExecutionException e) {
//			e.printStackTrace();
//		}
		
	}
}
