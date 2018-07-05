package com.spring.app.springbootrxjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

@SpringBootApplication
public class SpringBootRxjavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRxjavaApplication.class, args);

		/**
		 *  hello world rxJava
		 */

		String bukus[] ={"java", "kotlin", "ruby", "python"};

		Observable.from(bukus)
				.subscribe(new Action1<String>() {

					@Override
					public void call(String reactivex) {
						System.out.println("Hello "+reactivex+ "!");
					}
				});

		Observable.just("Java", "Kotlin", "Python")
				.subscribe(new Action1<String>() {

					@Override
					public void call(String reactivex) {

						System.out.println(reactivex);
					}
				});

		Observable.just("Hello world rxJava & Spring boot")
				.subscribe(new Subscriber<String>() {

					@Override
					public void onCompleted() {
						System.out.println("on completed !");
					}

					@Override
					public void onError(Throwable throwable) {
						System.err.println("error "+throwable.getLocalizedMessage());
					}

					@Override
					public void onNext(String reactivex) {
						System.out.println("on next "+reactivex);
					}
				});
	}

	/**
	 *  List Rx Java
	 *
	 */


}
