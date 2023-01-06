/*
 * Class ResultByRunnableExample
 * Date 23.01.06
 * 
 * 리턴 값을 외부로  필요한 작업 결과를 알기 위해서는 Runnable 객체를 활용해서 Future 객체를 사용하는 방법도 있다.
 * 리턴 타입과 Future<> 제네릭을 통일 시키는걸 주의
 * 이 방법으로 result값을 받아오면 get() 메소드에서 Blocking 되기 때문에 먼저 완료된 task의 result를 먼저 받을 수 없어서  비효율적이다.
 */

package javaplus.thread.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class ResultByRunnableExample {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
		);
		System.out.println("[Task request]");
		class Task implements Runnable{
			Result result;
			Task(Result result){
				this.result = result;
			}
			
			@Override
			public void run() {
				System.out.println("Running");
				int sum = 0;
				for(int i = 1; i <= 10; i++) {
					sum += i;
				}
				result.addValue(sum);
			}
		}
		
		Result resultForTask = new Result();
		
		Runnable task1 = new Task(resultForTask);
		Runnable task2 = new Task(resultForTask);
		
		Future<Result> future1 = executorService.submit(task1, resultForTask);
		Future<Result> future2 = executorService.submit(task2, resultForTask);
		
		Thread.sleep(2000);
		System.out.println(future1.isDone());
		System.out.println(future2.isDone());

		System.out.println(resultForTask.accumValue);
		
		try {
			Result result = future1.get();
			System.out.println(future1.isDone());
			System.out.println(future2.isDone());
			System.out.println("[result] " + result.accumValue);
			System.out.println("[Task Complete]");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[Exception Occured] " + e.getMessage());
		}
	

		executorService.shutdown();
		

	}

}

class Result {
	int accumValue;
	synchronized void addValue(int value) {
		accumValue += value;
	}
}
