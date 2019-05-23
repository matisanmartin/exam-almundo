package com.almundo.exam.service.chain;

import com.almundo.exam.model.Call;
import com.almundo.exam.model.GenericQueue;
import com.almundo.exam.model.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class OperatorChainService extends GenericChainService<Operator, Call> {

    @Autowired
    private SupervisorChainService supervisorChainService;

    private GenericQueue<Operator> availableOperators;

    @PostConstruct
    public void init() {
        availableOperators = new GenericQueue<>();
    }

    @Override
    protected GenericQueue<Operator> getQueue() {
        return availableOperators;
    }

    @Override
    public GenericChainService getNext() {
        return supervisorChainService;
    }
}
