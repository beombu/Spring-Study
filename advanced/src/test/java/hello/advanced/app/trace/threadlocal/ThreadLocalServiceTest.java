package hello.advanced.app.trace.threadlocal;

import org.junit.jupiter.api.Test;

import hello.advanced.app.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalServiceTest {
	private ThreadLocalService fieldService = new ThreadLocalService();

	@Test
	void threadLocal() {
		log.info("main start");

		Runnable userA = () -> {
			fieldService.logic("userA");
		};

		Runnable userB = () -> {
			fieldService.logic("userB");
		};

		Thread threadA = new Thread(userA);
		threadA.setName("thread-A");

		Thread threadB = new Thread(userB);
		threadB.setName("thread-B");

		threadA.start(); //A실행
		//sleep(2000); //동시성 문제 발생X
		sleep(100); //동시성 문제 발생O -> ThreaLocal 해결

		threadB.start(); //B실행
		sleep(2000); //메인 쓰레드 종료 대기
		log.info("main exit");
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
