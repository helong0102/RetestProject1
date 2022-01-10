package com.fmjava.core.pojo.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeLong
 * @Date: 2022/01/09/14:24
 * @Description:
 */
@Data
public class Result {
    // 布尔值 true操作成功，false操作失败
    private boolean success;
    // 成功信息或者失败信息
    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
