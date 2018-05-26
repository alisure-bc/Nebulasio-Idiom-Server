package com.alisure.entity;

import java.util.List;

/**
 * �����װ��
 */
public class Result {

    private int status = 0;

    public Result() {

    }
    public Result(int status) {
        this.status = status;
    }

    public Result(boolean flag) {
        if(flag){
            this.status = 1;
        }else {
            this.status = 0;
        }
    }

    public int getStatus() {
        return status;
    }

    public Result setStatus(int status) {
        this.status = status;
        return this;
    }
}
