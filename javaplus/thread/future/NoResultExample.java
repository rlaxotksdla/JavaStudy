/*
 * Class NoResultExample
 * Date 23.01.06
 * 
 * 리턴 값이 필요 없는 작업 결과를 알기 위해서는 Runnable 객체를 활용해서 Future 객체를 사용한다.
 * 리턴 값이 필요 없음에도 Future 객체를 리턴하는데 
 * 이건 스레드가 작업처리를 정상적으로 완료하면 Future.get() 메소드로 null 리턴, 작업 처리중 interrupt 되면 InterrutedException, 예외가 발생하면 ExecutionException을 리턴한다
 */

package javaplus.thread.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
		);
		
		System.out.println("[작업 처리 요청]");
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				int sum = 0;
				for (int i = 0; i < 10; i++) {
					sum += i;
				}
				System.out.println("처리 결과 : " + sum);
			}	
		};
		Future future = executorService.submit(runnable);
		
		try {
			future.get();
			System.out.println("[작업 처리 완료]");
		} catch(Exception e) {
			System.out.println("[실행 예외 발생함]" + e.getMessage());
		}
		executorService.shutdown();
	}

}
