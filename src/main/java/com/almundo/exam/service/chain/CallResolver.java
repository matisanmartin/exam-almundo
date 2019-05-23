package com.almundo.exam.service.chain;

import com.almundo.exam.model.CallCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CallResolver {

    @Autowired
    private CallCounter callCounter;


    public void resolveCall() {
        //TODO sleep aleatorio entre N y M segundos
        callCounter.decrement();
    }
}
