package com.hbu.live.user.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ResultModel {
    public Date timestamp = new Date();
    public int status;
    public String message;
    public String path;



    public ResultModel(ReturnMsg returnMsg, String path) {
        this.status = returnMsg.status;
        this.message = returnMsg.message;
        this.path = path;
    }

}
