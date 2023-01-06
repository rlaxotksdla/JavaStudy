/*
 * Class ResultByCallableExample
 * Date 23.01.06
 * 
 * 리턴 값이 필요한 작업 결과를 알기 위해서는 callable 객체를 활용해서 Future 객체를 사용한다.
 * 리턴 타입과 Future<> 제네릭을 통일 시키는걸 주의
 */

package javaplus.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByCallableExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
		);
		
		System.out.println("[작업 처리 요청]");
		Callable<Integer> task = new Callable<Integer>() {
			
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for(int i = 1; i <= 10; i++) {
					sum += i;
				}
				return sum;
			}
		};
		
		//리턴 타입과 제네릭을 당연히 맞춰줘야함
		Future<Integer> future = executorService.submit(task);
		
		try {
			int sum = future.get();
			System.out.println("[처리 결과] " + sum);
			System.out.println("[작업 처리 완료]");
		} catch (Exception e) {
			System.out.println("[실행 예외 발생함]" + e.getMessage());
		}
		
		executorService.shutdown();
	}

}
