package com.reactive.venkat;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

/*
	Reactive programming: Event driven, Scalable, Resilient, Responsive
	Observable has 3 channels: Data channel, Completion channel, Error channel.
	Allows you to postpone concurrency
*/
public class Sample {

	public static void main(String[] args) {
		List<String> symbols = Arrays.asList("GOG", "AMZN", "ITC");
		
		Observable<StockInfo> feed = StockServer.getFeed(symbols);
		System.out.println("got observable...");
		
		feed
			//.onErrorResumeNext()
			//.filter(stockInfo -> stockInfo.getValue().equals("ITC"))
			.map(stockInfo -> new StockInfo(stockInfo.getValue() + "  - mapped"))
			.subscribe(
				stockInfo -> System.out.println(stockInfo),
				err -> System.out.println("ERROR: " + err), 
				() -> System.out.println("DONE")
		);
	}
}