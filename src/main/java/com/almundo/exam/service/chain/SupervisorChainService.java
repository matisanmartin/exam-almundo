package com.almundo.exam.service.chain;

import com.almundo.exam.model.Call;
import com.almundo.exam.model.GenericQueue;
import com.almundo.exam.model.Supervisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SupervisorChainService extends GenericChainService<Supervisor, Call> {

    @Autowired
    private DirectorChainService directorChainService;

    private GenericQueue<Supervisor> availableSupervisors;

    @PostConstruct
    public void init() {
        availableSupervisors = new GenericQueue<>();
    }

    @Override
    protected GenericQueue<Supervisor> getQueue() {
        return availableSupervisors;
    }

    @Override
    public GenericChainService getNext() {
        return directorChainService;
    }
}
