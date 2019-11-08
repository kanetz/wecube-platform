package com.webank.wecube.platform.core.service.workflow;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.webank.wecube.platform.core.domain.plugin.PluginConfigInterface;
import com.webank.wecube.platform.core.entity.workflow.ProcExecBindingEntity;
import com.webank.wecube.platform.core.entity.workflow.ProcInstInfoEntity;
import com.webank.wecube.platform.core.entity.workflow.TaskNodeInstInfoEntity;
import com.webank.wecube.platform.core.support.plugin.PluginServiceStub;
import com.webank.wecube.platform.core.support.plugin.dto.PluginResponse.ResultData;

@Service
public class PluginInvocationProcessor {

    private static final Logger log = LoggerFactory.getLogger(PluginInvocationProcessor.class);

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void process(PluginInvocationOperation operation) {

        executorService.execute(new Runnable() {

            @Override
            public void run() {
                operation.operate();
            }

        });
    }

    public static class PluginInvocationOperation implements PluginOperation {
        private PluginServiceStub pluginServiceStub;
        private Consumer<PluginInterfaceInvocationResult> callback;
        private List<Map<String, Object>> pluginParameters;
        private String interfacePath;
        private String instanceHost;

        private PluginInterfaceInvocationContext pluginInterfaceInvocationContext;

        public PluginInterfaceInvocationContext getPluginInterfaceInvocationContext() {
            return pluginInterfaceInvocationContext;
        }

        public void setPluginInterfaceInvocationContext(
                PluginInterfaceInvocationContext pluginInterfaceInvocationContext) {
            this.pluginInterfaceInvocationContext = pluginInterfaceInvocationContext;
        }

        public PluginServiceStub getPluginServiceStub() {
            return pluginServiceStub;
        }

        public void setPluginServiceStub(PluginServiceStub pluginServiceStub) {
            this.pluginServiceStub = pluginServiceStub;
        }

        public Consumer<PluginInterfaceInvocationResult> getCallback() {
            return callback;
        }

        public void setCallback(Consumer<PluginInterfaceInvocationResult> callback) {
            this.callback = callback;
        }

        public List<Map<String, Object>> getPluginParameters() {
            return pluginParameters;
        }

        public void setPluginParameters(List<Map<String, Object>> pluginParameters) {
            this.pluginParameters = pluginParameters;
        }

        public String getInterfacePath() {
            return interfacePath;
        }

        public void setInterfacePath(String interfacePath) {
            this.interfacePath = interfacePath;
        }

        public String getInstanceHost() {
            return instanceHost;
        }

        public void setInstanceHost(String instanceHost) {
            this.instanceHost = instanceHost;
        }

        public PluginInvocationOperation withInstanceHost(String instanceHost) {
            this.instanceHost = instanceHost;
            return this;
        }

        public PluginInvocationOperation withInterfacePath(String interfacePath) {
            this.interfacePath = interfacePath;
            return this;
        }

        public PluginInvocationOperation withPluginParameters(List<Map<String, Object>> pluginParameters) {
            this.pluginParameters = pluginParameters;
            return this;
        }

        public PluginInvocationOperation withCallback(Consumer<PluginInterfaceInvocationResult> callback) {
            this.callback = callback;
            return this;
        }

        public PluginInvocationOperation withPluginServiceStub(PluginServiceStub pluginServiceStub) {
            this.pluginServiceStub = pluginServiceStub;
            return this;
        }

        public PluginInvocationOperation withPluginInterfaceInvocationContext(PluginInterfaceInvocationContext ctx) {
            this.pluginInterfaceInvocationContext = ctx;
            return this;
        }

        @Override
        public void operate() {
            if (log.isDebugEnabled()) {
                log.debug("call {} {}", getInstanceHost(), getInterfacePath());
            }

            ResultData<Object> responseData = null;

            try {
                responseData = getPluginServiceStub().callPluginInterface(getInstanceHost(), getInterfacePath(),
                        getPluginParameters());
            } catch (Exception e) {
                log.error("errors while operating {} {}", getInstanceHost(), getInterfacePath());
                PluginInterfaceInvocationResult errResult = new PluginInterfaceInvocationResult();
                errResult.setErrMsg(e.getMessage());
                errResult.setSuccess(false);

                handleResult(errResult);

                return;
            }

            if (responseData == null) {
                log.error("response data is null, {} {}", getInstanceHost(), getInterfacePath());
                PluginInterfaceInvocationResult nullResult = new PluginInterfaceInvocationResult();
                nullResult.setErrMsg("response data is null.");
                nullResult.setSuccess(false);
                handleResult(nullResult);

                return;
            }

            List<Object> resultData = responseData.getOutputs();

            PluginInterfaceInvocationResult result = new PluginInterfaceInvocationResult();
            result.setResultData(resultData);
            result.setSuccess(true);

            handleResult(result);

        }

        private void handleResult(PluginInterfaceInvocationResult result) {
            if (getCallback() != null) {
                getCallback().accept(result);
            }
        }

    }

    public static class PluginInterfaceInvocationContext {
        private ProcInstInfoEntity procInstEntity;
        private TaskNodeInstInfoEntity taskNodeInstEntity;
        private PluginConfigInterface pluginConfigInterface;
        private List<ProcExecBindingEntity> nodeObjectBindings;

        public ProcInstInfoEntity getProcInstEntity() {
            return procInstEntity;
        }

        public void setProcInstEntity(ProcInstInfoEntity procInstEntity) {
            this.procInstEntity = procInstEntity;
        }

        public TaskNodeInstInfoEntity getTaskNodeInstEntity() {
            return taskNodeInstEntity;
        }

        public void setTaskNodeInstEntity(TaskNodeInstInfoEntity taskNodeInstEntity) {
            this.taskNodeInstEntity = taskNodeInstEntity;
        }

        public PluginConfigInterface getPluginConfigInterface() {
            return pluginConfigInterface;
        }

        public void setPluginConfigInterface(PluginConfigInterface pluginConfigInterface) {
            this.pluginConfigInterface = pluginConfigInterface;
        }

        public List<ProcExecBindingEntity> getNodeObjectBindings() {
            return nodeObjectBindings;
        }

        public void setNodeObjectBindings(List<ProcExecBindingEntity> nodeObjectBindings) {
            this.nodeObjectBindings = nodeObjectBindings;
        }
    }

    public static class PluginInterfaceInvocationResult {
        private List<Object> resultData;
        private boolean success;
        private String errMsg;

        private PluginInterfaceInvocationContext pluginInterfaceInvocationContext;

        public List<Object> getResultData() {
            return resultData;
        }

        public void setResultData(List<Object> resultData) {
            this.resultData = resultData;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

        public PluginInterfaceInvocationContext getPluginInterfaceInvocationContext() {
            return pluginInterfaceInvocationContext;
        }

        public void setPluginInterfaceInvocationContext(
                PluginInterfaceInvocationContext pluginInterfaceInvocationContext) {
            this.pluginInterfaceInvocationContext = pluginInterfaceInvocationContext;
        }

    }

}