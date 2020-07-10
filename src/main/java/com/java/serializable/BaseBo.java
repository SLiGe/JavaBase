package com.java.serializable;

import java.io.Serializable;

/**
 * @author zJiaLi
 * @since 2020-07-08 11:11
 */
public class BaseBo  implements Serializable {

    private static final long serialVersionUID = -2357918315212663433L;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
