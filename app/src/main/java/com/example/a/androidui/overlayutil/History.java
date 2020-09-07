package com.example.a.androidui.overlayutil;

public class History {
    private String _id;
    private String history;


    public History(String id, String history) {
        _id = id;
        this.history = history;

    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }


}
