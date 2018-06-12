package com.shrinvi.rxj;

public class Todo {
    private String mItem;

    public Todo() {
    }

    public Todo(String item) {
        mItem = item;
    }

    public Todo(Todo todo) {
        mItem = todo.getItem();
    }


    public String getItem() {
        return mItem;
    }

    public void setItem(String item) {
        mItem = item;
    }
}
