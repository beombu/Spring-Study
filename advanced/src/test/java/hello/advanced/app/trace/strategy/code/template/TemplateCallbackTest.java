package hello.advanced.app.trace.strategy.code.template;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateCallbackTest {
	/**
	 * 템플릿 콜백 패턴
	 */
	@Test
	void callbackV1() {
		TimeLogTemplate template = new TimeLogTemplate();
		template.execute(() -> log.info("비즈니스 로직1 실행"));
		template.execute(() -> log.info("비즈니스 로직2 실행"));
	}
}
