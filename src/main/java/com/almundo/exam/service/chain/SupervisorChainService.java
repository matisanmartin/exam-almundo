package com.almundo.exam.service.chain;

import com.almundo.exam.model.GenericQueue;
import com.almundo.exam.model.Supervisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SupervisorChainService implements GenericChainService<Supervisor> {

    @Autowired
    private DirectorChainService directorChainService;

    private GenericQueue<Supervisor> availableSupervisors;

    @PostConstruct
    public void init() {
        availableSupervisors = new GenericQueue<>();
    }

    @Override
    public void process(Supervisor element) {

        if(availableSupervisors.isEmpty())
            getNext().process(element);
    }

    @Override
    public GenericChainService<Supervisor> getNext() {
        return directorChainService;
    }
}
