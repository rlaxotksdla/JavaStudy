/*
 * Class ThreadInfo
 * Date 23.01.05
 * Thread 활용 기초
 */

package javaplus.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadInfo {

	public static void main(String[] args) throws InterruptedException {
		Runnable runnable0 = new ThreadA();
		
		//thread 객체를 생성하기 위해서는 Runnable 인터페이스를 구현한 클래스가 필요하다.
		Thread thread0 = new Thread(runnable0);
		
		//간략히 다음과 같이 사용하는게 좋다
		Thread threadA = new Thread(new ThreadA());
		Thread threadB = new Thread(new ThreadB());
		
		//threadA를 실행하기 위해서는 start 메소드를 호출해야한다.
		//threadA.start();
		//threadB.start();
		
		//Runnable 인터페이스를 구현하지 않고 Runnable 인터페이스가 구현된 Thread를 상속하면 더 간결하게 사용할 수 있지만
		// Thread를 상속하면 다중상속이 안되므로 곤란한경우가 생기기 때문에 주로 Runnable인터페이스를 구현하여 사용한다.
		//Thread threadC = new ThreadC();
		ThreadC threadC = new ThreadC();
		
		//Run 메소드 내의 내용이 길지않고 굳이 클래스를 만들지 않아도 될때에는 람다식이나 익명 객체를 이용해서 다음과 같이 사용하는 것이 좋다.
		
		//익명 객체 활용
		Thread threadD = new Thread(new Runnable() {
			boolean run = true;
			
			public void setRun(boolean a) {
				this.run = a;
			}
			
			@Override
			public void run() {
				while(true) {
					try {
						System.out.println("ThreadD 실행중...");
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			
		});
		
		//람다식 활용
		Thread threadE = new Thread(() -> {
				while(true) {
					try {
						System.out.println("ThreadE 실행중...");
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		});
		
		//현재 스레드의 참조는 Thread.currentThread() 정적 메소드를 통해 얻을 수 있다.
		Thread mainThread = Thread.currentThread();
		
		//스레드의 이름은 메인 스레드는 main 그 외에는 생성 순서대로 Thread-n 이 붙는다.
		System.out.println(mainThread.getName() 
				+ "\n" + threadA.getName()
				+ "\n" + threadB.getName()
				+ "\n" + threadC.getName()
				+ "\n" + threadD.getName()
				+ "\n" + threadE.getName());
		
		//스레드의 명칭을 바꿔주고 싶다면 setName을 이용하면 된다.
		threadA.setName("ThreadA");
		threadB.setName("ThreadB");
		threadC.setName("ThreadC");
		threadD.setName("ThreadD");
		threadE.setName("ThreadE");
		
		System.out.println(mainThread.getName() 
				+ "\n" + threadA.getName()
				+ "\n" + threadB.getName()
				+ "\n" + threadC.getName()
				+ "\n" + threadD.getName()
				+ "\n" + threadE.getName());
		
	
		
		//싱글 코어 CPU에서 멀티 스레드를 실행하면 스레드는 병렬적으로 실행되는것처럼 보이나 실제로는 번갈아가면서 실행하는 동시성작업이 된다.
		//따라서 코어의 갯수보다 스레드의 갯수가 많을 경우 스레드의 상황에 따라 우선순위를 매겨주는게 좋을 수 있다
		// 우선순위의 값은 1~10을 매길수있고 높을 수록 높은 우선순위를 의미한다.
		
		threadA.setPriority(1);
		threadA.setPriority(5);
		threadA.setPriority(10);
		threadA.setPriority(Thread.MIN_PRIORITY);
		threadA.setPriority(Thread.NORM_PRIORITY);
		threadA.setPriority(Thread.MAX_PRIORITY);
		
		//같은 인스턴스의 NonStatic 메소드를 동기화하여 동시에 실행하면 이미 접근한 스레드가 실행이 끝나기 전까지 다른 스레드가 접근 못함 - 초당 1개씩 출력
		NonStaticSyncMethod nssm1 = new NonStaticSyncMethod();
		ThreadForSync1 syncThread1 = new ThreadForSync1();
		ThreadForSync1 syncThread2 = new ThreadForSync1();
		syncThread1.setInstance(nssm1);
		syncThread2.setInstance(nssm1);
//		syncThread1.start();
//		syncThread2.start();
		
		//각각 다른 인스턴스의 NonStatic 메소드를 동기화하여 동시에 실행하면 다른 인스턴스이기때문에 의미가 없음 - 초당 2개씩 출력
		NonStaticSyncMethod nssm2 = new NonStaticSyncMethod();
		syncThread2.setInstance(nssm2);
//		syncThread1.start();
//		syncThread2.start();
		
		//클래스의 Static 메소드를 동기화 하여 동시에 실행하면 이미 접근한 스레드가 실행이 끝나기 전까지 다른 스레드가 접근 못함 - 초당 1개씩 출력
		ThreadForSync2 syncThread3 = new ThreadForSync2();
		ThreadForSync2 syncThread4 = new ThreadForSync2();
//		syncThread3.start();
//		syncThread4.start();
		
		//같은 인스턴스의 NonStatic 필드를 동기화하여 동시에 실행하면 필드전 메소드 내에 진입은 가능하지만 이미 접근한 스레드의 필드가 끝나기 전까지 다른 스레드가 접근 못함 - 진입은 가능하지만 초당 1개씩 출력
		NonStaticSyncField nssm3 = new NonStaticSyncField();
		ThreadForSync3 syncThread5 = new ThreadForSync3();
		ThreadForSync3 syncThread6 = new ThreadForSync3();
		syncThread5.setInstance(nssm3);
		syncThread6.setInstance(nssm3);
//		syncThread5.start();
//		syncThread6.start();
		
		//위에서 한것과 마찬가지로 다른 인스턴스를 사용하는것은 전혀 의미가 없기에 - 초당 2개씩 출력
		NonStaticSyncField nssm4 = new NonStaticSyncField();
		syncThread6.setInstance(nssm4);
//		syncThread5.start();
//		syncThread6.start();
		
		//클래스도 마찬가지로 필드내에 있는건 스레드 하나씩 접근가능하므로 - 초당 1개씩 출력
		ThreadForSync4 syncThread7 = new ThreadForSync4();
		ThreadForSync4 syncThread8 = new ThreadForSync4();
//		syncThread7.start();
//		syncThread8.start();
		
		//스레드의 getState 메소드를 이용하여 스레드 상태를 확인할 수 있다
		//NEW - 객체 생성된 상태
		//RUNNABLE - 실행 대기[start 호출 후 run 메소드 실행하면서 중간중간 대기]
		//WAITING - 다른스레드의 wait() 메소드에 의해 대기중인 상태
		//TIMED_WAITING - wait(time) 메소드에 의해 대기중인 상태
		//BLOCKED - 동기화된 부분에 이미 다른 스레드가 진입해 있어 대기중인 상태
		//TERMINATED - 실행을 마친 상태
		System.out.println(syncThread1.getState());
		
		//스레드 상태 제어를 위한 메소드들
		//intterrupt() - 일시 정지 상태의 스레드에서 IntteruptedException을 발생시켜 예외처리하게 만듬
		//notify() , notifyAll() - wait() 메소드에 의해 일시정지 되어있는 스레드들을 실행 대기로 만듬
		//sleep(millis) 주어진 시간동안 스레드를 일시정지 상태로 만들고 지나면 실행 대기가 됨
		//join() , join(millis) 해당 메소드를 호출한 스레드가 일시정지가 되고 join앞의 스레드가 실행이 완료되거나 매개값으로 주어진 시간이 지나면 실행 대기가 된다.
		//wait() wait(millis) 동기화 블록 내에서 스레드를 일시 정지 상태로 만든다, 시간이 지나면 실행 대기가 되고 시간이 주어지지 않으면 notify or notifyAll메소드에 의해 실행대기가 된다
		//yield() 실행중 우선순위가 동일한 다른스레드에게 실행을 양보하고 실행 대기상태가 된다.

		//그 외 스레드 관련

		//Daemmon 보조 스레드
			//setDaemon 해당 스레드를 호출한 스레드의 데몬 스레드로 설정한다  데몬 스레드는 호출한 스레드가 종료되면 자동 종료된다.
			//isDaemon 해당 스레드가 데몬스레드인지 확인
		
		//ThreadGroup
			//관련 스레드를 묶어 사용하기 위한 클래스
			//int	activeCount()	현재 그룹 및 하위 그룹에서 활동 중인 모든 스레드의 수를 리턴한다.
			//int	activeGroupCount()	현재 그룹에서 활동 중인 모든 하위 그룹의 수를 리턴한다.
			//void	checkAccess()	현재 스레드가 스레드 그룹을 변경할 권한이 있는지 체크한다. 만약 권한이 없으면 SecurityException을 발생시킨다.
			//void	destroy()	현재 그룹 및 하위 그룹을 모두 삭제한다. 단, 그룹 내에 포함된 모든 스레드들이 종료 상태가 되어야 한다.
			//boolean	isDestroyed()	현재 그룹이 삭제되었는지 여부를 리턴한다.
			//int	getMaxPriority()	현재 그룹에 포함된 스레드가 가질 수 있는 최대 우선순위를 리턴한다.
			//void	setMaxPriority(int pri)	현재 그룹에 포함된 스레드가 가질 수 있는 최대 우선순위를 설정한다.
			//String	getName()	현재 그룹의 이름을 리턴한다.
			//ThreadGroup	getParent()	현재 그룹의 부모 그룹을 리턴한다.
			//boolean	parentOf(ThreadGroup g)	현재 그룹이 매개값으로 지정한 스레드 그룹의 부모인지 여부를 리턴한다.
			//boolean	isDaemon()	현재 그룹이 데몬 그룹인지 여부를 리턴한다.
			//void	setDaemon(boolean daemon)	현재 그룹을 데몬 그룹으로 설정한다.
			//void	list()	현재 그룹에 포함된 스레드와 하위 그룹에 대한 정보를 출력한다.
			//void	interrupt()	현재 그룹에 포함된 모든 스레드들을 interrupt한다.
		
		//threadpool 스레드의 숫자를 제한하고 큐에들어오는 작업들을 하나씩 스레드가 맡아 처리하게 하므로 스레드 갯수가 너무 많아져서 메모리 사용량이 많아지고 애플리케이션의 성능이 저하됨을 방지
		
		//이렇게 생성한 스레드풀은 Integer.MAX_VALUE 까지 스레드가 추가될수있고 각 스레드가 60초간 활동을 하지않으면 자동 종료시킨다
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		//이렇게 생성한 스레드풀은 지정한 숫자까지 스레드가 추가되고 스레드를 자동 종료 시키지 않는다.
		executorService = Executors.newFixedThreadPool(10); 
		//이렇게 생성하면 CPU 코어 수만큼 최대 스레드를 사용하는 스레드풀을 생성할 수 있다.
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); 
		
		//executorService 메소드
		
		executorService.shutdown(); // 현재 작업중 작업큐에 대기하고 있는 작업 처리 후에 스레드 풀 종료
//		executorService.shutdownNow(); // 스레드 풀 강제종료 - List<Runnable>을 리턴하는데 작업 큐에 있는 미처리된 목록이다.
		executorService.awaitTermination(10,TimeUnit.SECONDS); // 스레드 shutdown 호출 후 지정 시간내 모든 작업을 처리하면 true 완료하지 못하면 작업중인 스레드를 interrupt 하고 false를 리턴
		
	
	}

}

class ThreadA implements Runnable{
	boolean run = true;
	
	public void setRun(boolean a) {
		this.run = a;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("ThreadA 실행중...");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class ThreadB implements Runnable{
	boolean run = true;
	
	public void setRun(boolean a) {
		this.run = a;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("ThreadB 실행중...");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class ThreadC extends Thread{
	boolean run = true;
	
	public void setRun(boolean a) {
		this.run = a;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("ThreadC 실행중...");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadForSync1 extends Thread{
	private NonStaticSyncMethod nonStaticSyncMethod;
	
	public void setInstance(NonStaticSyncMethod nonStaticSyncMethod) {
		this.nonStaticSyncMethod = nonStaticSyncMethod;
	}
	
	@Override
	public void run() {
		try {
			this.nonStaticSyncMethod.method();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadForSync2 extends Thread{
	
	@Override
	public void run() {
		try {
			StaticSyncMethod.method();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadForSync3 extends Thread{
	private NonStaticSyncField nonStaticSyncField;
	
	public void setInstance(NonStaticSyncField nonStaticSyncField) {
		this.nonStaticSyncField = nonStaticSyncField;
	}
	
	@Override
	public void run() {
		try {
			this.nonStaticSyncField.method();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadForSync4 extends Thread{
	
	@Override
	public void run() {
		try {
			StaticSyncField.method();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class NonStaticSyncMethod{
	public synchronized void method() throws InterruptedException {
		while(true) {
		System.out.println("동기화된 NonStaticMethod 실행");
		Thread.sleep(1000);
		}
	}
	
}

class StaticSyncMethod{
	public static synchronized void method() throws InterruptedException {
		while(true) {
			System.out.println("동기화된 StaticMethod 실행");
			Thread.sleep(1000);
		}
	}
	
}

class NonStaticSyncField{
	public void method() throws InterruptedException {
		System.out.println("NonStaticSyncField 메소드 진입");
		synchronized (this) {
			while(true) {
				System.out.println("NonStaticSyncField 내 코드 실행중");
				Thread.sleep(1000);
			}
		}
		
	}
}

class StaticSyncField{
	public static void method() throws InterruptedException {
		System.out.println("StaticSyncField 메소드 진입");
		synchronized (StaticSyncField.class) {
			while(true) {
				System.out.println("StaticSyncField 내 코드 실행중");
				Thread.sleep(1000);
			}
		}
		
	}
}
