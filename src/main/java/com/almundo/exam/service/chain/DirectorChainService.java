package com.almundo.exam.service.chain;

import com.almundo.exam.model.Call;
import com.almundo.exam.model.Director;
import com.almundo.exam.model.GenericQueue;
import org.springframework.stereotype.Component;

@Component
public class DirectorChainService extends GenericChainService<Director, Call> {

    @Override
    protected GenericQueue<Director> getQueue() {
        return null;
    }

    @Override
    public GenericChainService<Director, Call> getNext() {
        return null;
    }
}
