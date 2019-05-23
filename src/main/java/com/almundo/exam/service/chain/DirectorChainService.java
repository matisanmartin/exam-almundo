package com.almundo.exam.service.chain;

import com.almundo.exam.model.Call;
import com.almundo.exam.model.Director;
import com.almundo.exam.model.GenericQueue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DirectorChainService extends GenericChainService<Director, Call> {

    private GenericQueue<Director> availableDirectors;

    @PostConstruct
    public void init() {
        this.availableDirectors = new GenericQueue<>();
    }
    @Override
    protected GenericQueue<Director> getQueue() {
        return availableDirectors;
    }

    @Override
    public GenericChainService<Director, Call> getNext() {
        throw new RuntimeException("No next element");
    }
}
