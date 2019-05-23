package com.almundo.exam.service.chain;

import com.almundo.exam.model.Call;
import com.almundo.exam.model.CallCounter;
import com.almundo.exam.model.Employee;
import com.almundo.exam.model.GenericQueue;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericChainService<T extends Employee, C extends Call> {

    @Autowired
    private CallCounter counter;

    @Autowired
    private CallResolver callResolver;

    public void process(C element) {
        if(queueIsEmpty())
            getNext().process(element);

        T employee = getQueue().remove();

        callResolver.resolveCall();

        getQueue().add(employee);

        counter.decrement();
    }

    protected abstract GenericQueue<T> getQueue();

    public Boolean queueIsEmpty() {
        return getQueue().isEmpty();
    }

    public abstract GenericChainService<T,C> getNext();

}
