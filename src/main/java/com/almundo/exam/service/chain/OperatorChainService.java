package com.almundo.exam.service.chain;

import com.almundo.exam.model.Call;
import com.almundo.exam.model.GenericQueue;
import com.almundo.exam.model.Operator;
import org.springframework.stereotype.Component;

@Component
public class OperatorChainService extends GenericChainService<Operator, Call> {

    @Override
    protected GenericQueue<Operator> getQueue() {
        return null;
    }

    @Override
    public GenericChainService getNext() {
        return null;
    }
}
