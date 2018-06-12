package com.shrinvi.rxj;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import static org.junit.Assert.assertTrue;

public class Main {

    public static void main(String[] args) {
       // Observable<Todo> todoObservable = Observable.create(new ConcreteObservable<Todo>(new RxJavaUnitTest().getTodos()));
        final String result = "";
        Observable<String> observer = Observable.just("Hello1"); // provides datea
        observer.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("Result=" + s);
            }
        }); // Callable as subscriber
        //assertTrue(result.equals("Hello"));
    }
}
