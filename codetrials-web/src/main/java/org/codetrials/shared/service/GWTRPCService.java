package org.codetrials.shared.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.codetrials.shared.entities.ExecutionResult;
import org.codetrials.shared.entities.Task;
import org.codetrials.shared.entities.Trial;

import java.util.List;

/**
 * @author Polyarnyi Nikolay
 */
@RemoteServiceRelativePath("rpc")
public interface GWTRPCService extends RemoteService{

    List<Trial> getTrials();

    Task getCurrentTask(int id);

    ExecutionResult execute(int id, String command);

}
