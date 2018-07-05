package com.spring.app.springbootrxjava;

import ch.qos.logback.core.util.TimeUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rx.Observable;
import rx.schedulers.TestScheduler;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRxjavaApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void flatMap() throws Exception{
		final List<String> items = Lists.newArrayList("a", "b", "c", "d", "e", "f");

		final TestScheduler scheduler = new TestScheduler();

		Observable.from(items)
				.flatMap(i -> {
					final int delay = new Random().nextInt(10);
					return Observable.just(i + "x")
							.delay(delay, TimeUnit.SECONDS, scheduler);
				})
				.toList()
				.doOnNext(System.out::println)
				.subscribe();

		scheduler.advanceTimeBy(1, TimeUnit.MINUTES);
	}
}
