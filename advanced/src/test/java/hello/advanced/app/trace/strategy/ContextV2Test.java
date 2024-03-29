package hello.advanced.app.trace.strategy;

import org.junit.jupiter.api.Test;

import hello.advanced.app.trace.strategy.code.strategy.ContextV1;
import hello.advanced.app.trace.strategy.code.strategy.ContextV2;
import hello.advanced.app.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.app.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2Test {

	/**
	 * 전략 패턴 사용
	 */
	@Test
	void strategyV1() {
		ContextV2 contextV2 = new ContextV2();
		contextV2.execute(new StrategyLogic1());
		contextV2.execute(new StrategyLogic2());
	}

	@Test
	void strategyV2() {
		ContextV2 context = new ContextV2();
		context.execute(() -> log.info("비즈니스 로직1 실행"));
		context.execute(() -> log.info("비즈니스 로직2 실행"));
	}
}
