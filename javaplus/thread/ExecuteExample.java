/*
 * Class ExecuteExample
 * Date 23.01.06
 * ExcutorService 클래스의 submit 메소드와 excute 메소드의 차이 예제
 * excute
 * 작업 처리 결과를 리턴하지 않음, 예외가 발생하면 스레드 종료 후 스레드 풀에서 제거
 * submit 
 * 작업 처리 결과를 Future로 리턴 , 예외가 발생해도 스레드는 종료되지 않고 다음 작업을 위해 재사용
 */

package javaplus.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteExample {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		for(int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor =
							(ThreadPoolExecutor) executorService;
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);
					
					//예외 강제 발생
					int value = Integer.parseInt("예외");
				}
			};
			
			executorService.execute(runnable);
//			executorService.submit(runnable);
			
			Thread.sleep(10);
		}
		
		executorService.shutdown();

	}

}
