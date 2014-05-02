package org.codetrials.server.web.controllers;

import org.codetrials.bundle.BundleContainer;
import org.codetrials.bundle.entities.CommandOutput;
import org.codetrials.bundle.entities.TaskDescription;
import org.codetrials.server.exceptions.InvalidBundleException;
import org.codetrials.server.service.BundleLoader;
import org.codetrials.server.service.TrialService;
import org.codetrials.server.service.dao.BundleJdbcDao;
import org.codetrials.shared.entities.ExecutionResult;
import org.codetrials.shared.entities.Task;
import org.codetrials.shared.entities.Trial;
import org.codetrials.shared.service.GWTRPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author Polyarnyi Nikolay
 */
@Service
@RequestMapping("codetrials/rpc")
public class GWTRPCServiceController extends AbstractRemoteService implements GWTRPCService {

    @Autowired
    TrialService trialService;

    @Autowired
    BundleLoader bundleLoader;

    @Override
    public List<Trial> getTrials() {
        return trialService.getTrials();
    }

    @Override
    public Task getCurrentTask(int bundleId) {
        BundleContainer bundle = getOrInitBundleContainer(bundleId);
        TaskDescription taskDescription = bundle.getTaskDescription();
        return new Task(taskDescription.getDescription(), taskDescription.getTitle(), taskDescription.getID());
    }

    @Override
    public ExecutionResult execute(int bundleId, String command) {
        BundleContainer bundle = getOrInitBundleContainer(bundleId);
        TaskDescription oldTask = bundle.getTaskDescription();
        CommandOutput output = bundle.processCommand(command);
        TaskDescription newTask = bundle.getTaskDescription();
        Task nextTask = null;
        if (newTask != oldTask) {
            nextTask = new Task(newTask.getDescription(), newTask.getTitle(), newTask.getID());
        }
        return output != null ?
                new ExecutionResult(
                        output.getReaction().getHint(),
                        output.getResult().getExecutionOutput(),
                        output.getResult().getException() == null ?
                                null :
                                output.getResult().getException().getMessage(),
                        true, nextTask) :
                new ExecutionResult(null, null, null, false, nextTask);
    }

    BundleContainer getOrInitBundleContainer(int bundleId) {
        BundleContainer bundle = (BundleContainer) session.get().getAttribute(Integer.toString(bundleId));
        if (bundle == null) {
            try {
                bundle = bundleLoader.createBundleContainer(new URL("file:" + BundleJdbcDao.BUNDLE_ROOT), bundleId);
                session.get().setAttribute(Integer.toString(bundleId), bundle);
            } catch (InvalidBundleException invalidBundleException) {
                return null;
            } catch (MalformedURLException e) {
                throw new IllegalStateException(e);
            }
        }
        return bundle;
    }
}
