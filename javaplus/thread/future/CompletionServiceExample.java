/*
 * Class CompletionServiceExample
 * Date 23.01.06
 * 
 * 먼저 완료된 작업의 결과를 받기 위해서 사용하는 CompletionService 사용법
 */

package javaplus.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceExample extends Thread{

	public static void main(String[] args) {
		ExecutorService excutorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
		);
		
		CompletionService<Integer> completionService = 
				new ExecutorCompletionService<Integer>(excutorService);
		
		System.out.println("[Task Request]");
		for(int i = 0; i < 3; i++) {
			completionService.submit(new Callable<Integer>() {
				
				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for (int i = 1; i <= 10; i++) {
						sum += i;
					}
					return sum;
				}
			});
		}
		System.out.println("[Check Completed Task]");
		excutorService.submit(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						Future<Integer> future = completionService.take();
						int value = future.get();
						System.out.println("[Task Result] : " + value);
					} catch (Exception e) {
						System.out.println("[Exception Occured]");
						e.printStackTrace();
						break;
					}
				}
			}
		});
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		excutorService.shutdown();
		System.out.println("[ThreadPool Down]");
	}

}
