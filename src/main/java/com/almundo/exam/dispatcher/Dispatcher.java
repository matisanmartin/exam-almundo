package com.almundo.exam.dispatcher;

import com.almundo.exam.dto.CallDTO;
import com.almundo.exam.model.Call;
import com.almundo.exam.model.CallCounter;
import com.almundo.exam.service.chain.OperatorChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

@Component
public class Dispatcher {

    @Autowired
    private CallCounter callCounter;

    @Autowired
    private OperatorChainService operatorChainService;

    public void dispatch(CallDTO callDTO) {

        if(callCounter.count() == 10)
            throw new RuntimeException("Cannot have more than 10 calls");

        callCounter.increment();
        ForkJoinTask.invokeAll(processTask(callDTO));
    }

    private RecursiveAction processTask(CallDTO callDTO) {
        return new RecursiveAction() {
            @Override
            protected void compute() {
                operatorChainService.process(new Call(callDTO));
            }
        };
    }
}
