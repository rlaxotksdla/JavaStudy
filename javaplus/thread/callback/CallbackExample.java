/*
 * Class CallbackExample
 * Date 23.01.06
 * CompletionHandler를 이용해서 콜백 함수 구현하여 작업 결과 통보 받는 방식
 * 꼭 CompletionHandler를 이용하지 않고 새로 클래스를 생성해도 됨
 */

package javaplus.thread.callback;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackExample {
	private ExecutorService executorService;

	public CallbackExample() {
		executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
		);
	}
	
	private CompletionHandler<Integer, Void> callback = new CompletionHandler<Integer, Void>() {
		@Override
		public void completed(Integer result, Void attachment) {
			System.out.println("completed Method Run : " + result);
		}
		
		@Override
		public void failed(Throwable exc, Void attachment) {
			System.out.println("completed Method Run : " + exc.toString());
		}
	};
	
	
	public void doWork(final String x, final String y) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					int intX = Integer.parseInt(x);
					int intY = Integer.parseInt(y);
					int result = intX + intY;
					callback.completed(result, null);
				} catch (NumberFormatException e) {
					callback.failed(e, null);
				}
			}
		};
		executorService.submit(task);
	}
	
	public void finish() {
		executorService.shutdown();
	}
	
	public static void main(String[] args) {
		CallbackExample example = new CallbackExample();
		example.doWork("3", "3");
		example.doWork("3", "삼");
		example.finish();
	}

}
