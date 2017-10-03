package com.reactive.venkat;

import java.util.List;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

public class StockServer {

	private StockServer() {
	}

	public static Observable<StockInfo> getFeed(List<String> symbols) {
		System.out.println("created... ");
		return Observable.create(emitter -> emitPrice(emitter, symbols));
	}

	private static void emitPrice(ObservableEmitter<StockInfo> emitter, List<String> symbols) {
		System.out.println("Ready to emit...");
		int count = 0;
		while (count < 5) {
			symbols.stream().map(StockInfo::fetch).forEach(emitter::onNext);

			sleep(1000);
			count++;
		}

		emitter.onComplete();
		
		// Below line wont print
		emitter.onNext(new StockInfo("bla"));
	}

	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}