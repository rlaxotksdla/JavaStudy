/*
 * Class ThreadInfo
 * Date 23.01.05
 * Thread 활용 기초
 */

package javaplus.thread;



public class ThreadInfo {

	public static void main(String[] args) {
		Runnable runnable0 = new ThreadA();
		
		//thread 객체를 생성하기 위해서는 Runnable 인터페이스를 구현한 클래스가 필요하다.
		Thread thread0 = new Thread(runnable0);
		
		//간략히 다음과 같이 사용하는게 좋다
		Thread threadA = new Thread(new ThreadA());
		Thread threadB = new Thread(new ThreadB());
		
		//threadA를 실행하기 위해서는 start 메소드를 호출해야한다.
		//threadA.start();
		//threadB.start();
		
		//Runnable 인터페이스를 구현하지 않고 Runnable 인터페이스가 구현된 Thread를 상속하면 더 간결하게 사용할 수 있다.
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
		syncThread3.start();
		syncThread4.start();
		
/*
 *   synchronized method
 *   
 *	인스턴스 단위로 lock이 걸린다.
 *	메서드가 시작될 때부터 종료될 때까지 동기화가 발생한다.
 *	동일 인스턴스내에서 synchronized키워드가 적용된 곳에서는 lock을 공유한다. 
 *	
 *	synchronized block
 *	인스턴스 단위로 lock이 걸린다.
 *	block내부에서 동기화가 발생한다.
 *	lock 객체를 지정하여 특정 대상에만 lock을 걸 수 있다.
 *	lock을 객체로 설정하면 해당 인스턴스만 lock이 걸리고 .class형식으로 설정하면 클래스 단위로 lock을 건다.
 *	
 *	 
 *	
 *	static synchronized method
 *	
 *	클래스 단위로 lock이 걸린다.
 *	
 *	메서드가 시작될 때부터 종료될 때까지 동기화가 발생한다.
 *	
 *	static synchronized와 synchronized가 혼용되어있을 때 각자의 lock으로 관리된다.
 *	
 *	 
 *	
 *	static synchronized block
 *	
 *	클래스 단위로 lock이 걸린다.
 *	
 *	block내부에서 동기화가 발생한다.
 *	
 *	lock객체를 지정하여 특정 대상에만 lock을 걸 수 있다.
 *	
 *	lock을 객체로 설정하면 해당 인스턴스만 lock이 걸리고 .class형식으로 설정하면 클래스 단위로 lock을 건다.
 *	
 *	
 *	 
 *	
 *	+ 인스턴스 단위라는 것은 synchronized 키워드가 적용된 곳에서는 전부 lock을 공유해서 쓴다. synchronized와 무관한 곳은 lock과 상관없다. 클래스 단위도 마찬가지로 synchronized 키워드가 적용된 곳에서 해당된다. 
 *	
 *	 
 *	
 *	+ method와 block의 차이는 method는 해당 객체 전체에 lock을 걸고, block은 lock의 대상을 지정할 수 있으며 block으로 동기화가 적용되는 범위를 한정시킬 수 있다.
 *	
 *	 
 *	
 *	+ synchronized는 thread의 동기화 순서를 보장하지 않는다.
 */

		
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
