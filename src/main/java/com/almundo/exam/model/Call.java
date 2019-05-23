package com.almundo.exam.model;

import com.almundo.exam.dto.CallDTO;

public class Call {

    public Call(CallDTO callDTO) {

    }

    public void executeCall() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
