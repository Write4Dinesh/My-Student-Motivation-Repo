package com.shrinvi.rxj;

import java.util.List;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class ConcreteObservable<T> implements ObservableOnSubscribe {
    List<T> mTodos;

    public ConcreteObservable(List<T> todos) {
        mTodos = todos;
    }

    @Override
    public void subscribe(ObservableEmitter emitter) throws Exception {
        try {
            for (T todo : mTodos) {
                emitter.onNext(todo);
            }
            emitter.onComplete();
        } catch (
                Exception e)

        {
            emitter.onError(e);
        }

    }
}
