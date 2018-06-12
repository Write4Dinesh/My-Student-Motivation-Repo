package com.shrinvi.rxj;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.functions.Consumer;

import static org.junit.Assert.assertTrue;

public class RxJavaUnitTest {

    String result = "";

    // Simple subscription to a fix value
    @Test
    public void returnAValue() throws Exception {
        result = "";
        //The source of data which will change over the time and other subscribers listen for it.
        ConcreteObservable<Todo> publisher = new ConcreteObservable<>(getTodos());
        DataListener subscriber = new DataListener();
        publisher.subscribe(subscriber);

        Observable<String> observer = Observable.just("Hello"); // provides datea
        Disposable d = observer.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                result = s;
            }
        }); // Callable as subscriber
        assertTrue(result.equals("Hello"));
    }

    public List<Todo> getTodos() {
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("item1"));
        todos.add(new Todo("item2"));
        return todos;
    }

}

