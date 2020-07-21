package com.example.day8homework.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    private CompositeDisposable compositeDisposable = null;

    public void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            synchronized (BaseModel.class) {
                if (compositeDisposable == null) {
                    compositeDisposable = new CompositeDisposable();
                }
            }
        }
        compositeDisposable.add(disposable);
    }

    public void destroy() {
        compositeDisposable.dispose();
    }

    public void remove(Disposable disposable) {
        if (disposable != null) {
            compositeDisposable.remove(disposable);
        }
    }
}
