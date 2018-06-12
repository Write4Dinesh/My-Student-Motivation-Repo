package com.shrinvi.rxj;

import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

public class DataListener implements ObservableEmitter {

    @Override
    public void onNext(Object value) {

    }

    @Override
    public void onError(Throwable error) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void setDisposable(Disposable d) {

    }

    @Override
    public void setCancellable(Cancellable c) {

    }

    @Override
    public boolean isDisposed() {
        return false;
    }

    @Override
    public ObservableEmitter serialize() {
        return null;
    }

    @Override
    public boolean tryOnError(Throwable t) {
        return false;
    }
}

