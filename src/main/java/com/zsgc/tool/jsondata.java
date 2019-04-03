package com.zsgc.tool;

import lombok.Data;

import java.io.Serializable;

@Data
public class jsondata implements Serializable {
    private static final long serialVersionUID=1L;
    private int code;
    private Object data;
    private Object msg;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public jsondata(int code, String msg){
        super();
        this.code=code;
        this.msg=msg;
    }
    public jsondata(int code, Object data, String msg){
        super();
        this.code=code;
        this.data=data;
        this.msg=msg;
    }
}
