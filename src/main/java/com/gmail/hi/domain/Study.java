package com.gmail.hi.domain;

import lombok.Data;

@Data
public class Study {
    private int bno;
    private String title;
    private String content;
    private String regdate;
    private String updatedate;
    private int readcnt;
    private String ip;
    private String email;
    private String nickname;
    private String dispdate;
}

