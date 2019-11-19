package com.webank.wecube.platform.core.service.workflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webank.wecube.platform.core.commons.WecubeCoreException;
import com.webank.wecube.platform.core.dto.workflow.ProcInstInfoDto;
import com.webank.wecube.platform.core.dto.workflow.ProcInstOutlineDto;
import com.webank.wecube.platform.core.dto.workflow.StartProcInstRequestDto;
import com.webank.wecube.platform.core.dto.workflow.TaskNodeDefObjectBindInfoDto;
import com.webank.wecube.platform.core.dto.workflow.TaskNodeInstDto;
import com.webank.wecube.platform.core.entity.workflow.ProcDefInfoEntity;
import com.webank.wecube.platform.core.entity.workflow.ProcExecBindingEntity;
import com.webank.wecube.platform.core.entity.workflow.ProcInstInfoEntity;
import com.webank.wecube.platform.core.entity.workflow.TaskNodeDefInfoEntity;
import com.webank.wecube.platform.core.entity.workflow.TaskNodeInstInfoEntity;
import com.webank.wecube.platform.core.jpa.workflow.ProcDefInfoRepository;
import com.webank.wecube.platform.core.jpa.workflow.ProcExecBindingRepository;
import com.webank.wecube.platform.core.jpa.workflow.ProcInstInfoRepository;
import com.webank.wecube.platform.core.jpa.workflow.TaskNodeDefInfoRepository;
import com.webank.wecube.platform.core.jpa.workflow.TaskNodeInstInfoRepository;
import com.webank.wecube.platform.workflow.commons.LocalIdGenerator;
import com.webank.wecube.platform.workflow.model.ProcFlowNodeInst;
import com.webank.wecube.platform.workflow.model.ProcInstOutline;

@Service
public class WorkflowProcInstService extends AbstractWorkflowService {
    private static final Logger log = LoggerFactory.getLogger(WorkflowProcInstService.class);

    @Autowired
    private ProcDefInfoRepository processDefInfoRepository;

    @Autowired
    private ProcInstInfoRepository procInstInfoRepository;

    @Autowired
    private TaskNodeDefInfoRepository taskNodeDefInfoRepository;

    @Autowired
    private TaskNodeInstInfoRepository taskNodeInstInfoRepository;

    @Autowired
    private ProcExecBindingRepository procExecBindingRepository;

    @Autowired
    private WorkflowEngineService workflowEngineService;

    public List<ProcInstInfoDto> getProcessInstances() {
        List<ProcInstInfoDto> result = new ArrayList<>();
        List<ProcInstInfoEntity> procInstInfoEntities = procInstInfoRepository.findAll();

        for (ProcInstInfoEntity e : procInstInfoEntities) {
            ProcInstInfoDto d = new ProcInstInfoDto();
            d.setCreatedTime("");
            d.setId(e.getId());
            d.setOperator(e.getOperator());
            d.setProcDefId(e.getProcDefId());
            d.setProcInstKey(e.getProcInstKey());
            d.setStatus(e.getStatus());

            result.add(d);
        }

        return result;
    }

    public ProcInstOutlineDto getProcessInstanceOutline(Integer id) {
        return null;
    }

    public ProcInstInfoDto getProcessInstanceById(Integer id) {

        Optional<ProcInstInfoEntity> procInstEntityOpt = procInstInfoRepository.findById(id);
        if (!procInstEntityOpt.isPresent()) {
            throw new WecubeCoreException(String.format("Such entity with id [%s] does not exist.", id));
        }

        ProcInstInfoEntity procInstEntity = procInstEntityOpt.get();

        String procInstanceKernelId = procInstEntity.getProcInstKernelId();

        if (StringUtils.isBlank(procInstanceKernelId)) {
            throw new WecubeCoreException("Unknow kernel process instance.");
        }

        if (!ProcInstInfoEntity.COMPLETED_STATUS.equals(procInstEntity.getStatus())) {
            // TODO refresh status

            ProcInstOutline procInstOutline = workflowEngineService.getProcInstOutline(procInstanceKernelId);
            if (procInstEntity.getStatus().equals(procInstOutline.getStatus())) {
                procInstEntity.setStatus(procInstOutline.getStatus());
                procInstInfoRepository.save(procInstEntity);
            }

            List<TaskNodeInstInfoEntity> nodeInstEntities = taskNodeInstInfoRepository
                    .findAllByProcInstId(procInstEntity.getId());
            for (TaskNodeInstInfoEntity nodeInstEntity : nodeInstEntities) {
                ProcFlowNodeInst pfni = procInstOutline.findProcFlowNodeInstByNodeId(nodeInstEntity.getNodeId());
                if (pfni != null && (pfni.getStatus() != null)
                        && (!pfni.getStatus().equals(nodeInstEntity.getStatus()))) {
                    nodeInstEntity.setStatus(pfni.getStatus());
                    taskNodeInstInfoRepository.save(nodeInstEntity);
                }
            }
        }

        ProcExecBindingEntity procInstBindEntity = procExecBindingRepository
                .findProcInstBindings(procInstEntity.getId());
        
        String entityTypeId = null;
        String entityDataId = null;
        
        if(procInstBindEntity != null){
            entityTypeId = procInstBindEntity.getEntityTypeId();
            entityDataId = procInstBindEntity.getEntityDataId();
        }
        

        ProcInstInfoDto result = new ProcInstInfoDto();
        result.setId(procInstEntity.getId());
        result.setOperator(procInstEntity.getOperator());
        result.setProcDefId(procInstEntity.getProcDefId());
        result.setProcInstKey(procInstEntity.getProcInstKey());
        result.setProcInstName(procInstEntity.getProcDefName());
        result.setEntityTypeId(entityTypeId);
        result.setEntityDataId(entityDataId);
        result.setStatus(procInstEntity.getStatus());

        List<TaskNodeInstInfoEntity> nodeEntities = taskNodeInstInfoRepository
                .findAllByProcInstId(procInstEntity.getId());

        List<TaskNodeDefInfoEntity> nodeDefEntities = taskNodeDefInfoRepository
                .findAllByProcDefId(procInstEntity.getProcDefId());

        for (TaskNodeInstInfoEntity n : nodeEntities) {
            TaskNodeDefInfoEntity nodeDef = findTaskNodeDefInfoEntityByNodeDefId(nodeDefEntities, n.getNodeDefId());
            TaskNodeInstDto nd = new TaskNodeInstDto();
            nd.setId(n.getId());
            nd.setNodeDefId(n.getProcDefId());
            nd.setNodeId(n.getNodeId());
            nd.setNodeName(n.getNodeName());
            nd.setNodeType(n.getNodeType());
            nd.setOrderedNo(n.getOrderedNo());

            if (nodeDef != null) {
                nd.setPreviousNodeIds(unmarshalNodeIds(nodeDef.getPreviousNodeIds()));
                nd.setSucceedingNodeIds(unmarshalNodeIds(nodeDef.getSucceedingNodeIds()));
            }
            nd.setProcDefId(n.getProcDefId());
            nd.setProcDefKey(n.getProcDefKey());
            nd.setProcInstId(n.getProcInstId());
            nd.setProcInstKey(n.getProcInstKey());
            nd.setStatus(n.getStatus());

            result.addTaskNodeInstances(nd);
        }

        return result;
    }

    private TaskNodeDefInfoEntity findTaskNodeDefInfoEntityByNodeDefId(List<TaskNodeDefInfoEntity> nodeDefEntities,
            String nodeDefId) {
        for (TaskNodeDefInfoEntity nodeDef : nodeDefEntities) {
            if (nodeDefId.equals(nodeDef.getId())) {
                return nodeDef;
            }
        }

        return null;
    }

    public ProcInstInfoDto createProcessInstance(StartProcInstRequestDto requestDto) {
        if (StringUtils.isBlank(requestDto.getProcDefId())) {
            if (log.isDebugEnabled()) {
                log.debug("Process definition ID is blank.");
            }
            throw new WecubeCoreException("Process definition ID is blank.");
        }

        String rootEntityTypeId = requestDto.getEntityTypeId();
        String rootEntityDataId = requestDto.getEntityDataId();

        String procDefId = requestDto.getProcDefId();
        Optional<ProcDefInfoEntity> procDefInfoEntityOpt = processDefInfoRepository.findById(procDefId);

        if (!procDefInfoEntityOpt.isPresent()) {
            throw new WecubeCoreException(String.format("Invalid process definition ID:%s", procDefId));
        }

        ProcDefInfoEntity procDefInfoEntity = procDefInfoEntityOpt.get();
        if (!ProcDefInfoEntity.DEPLOYED_STATUS.equals(procDefInfoEntity.getStatus())) {
            log.error("expected status {} but {} for procDefId {}", ProcDefInfoEntity.DEPLOYED_STATUS,
                    procDefInfoEntity.getStatus(), procDefId);
            throw new WecubeCoreException(String.format("Invalid process definition ID:%s", procDefId));
        }

        if (StringUtils.isBlank(procDefInfoEntity.getProcDefKernelId())) {
            log.error("cannot know process definition id for {}", procDefId);
            throw new WecubeCoreException(String.format("Invalid process definition ID:%s", procDefId));
        }

        String procInstKey = LocalIdGenerator.generateId();

        ProcInstInfoEntity procInstInfoEntity = new ProcInstInfoEntity();
        procInstInfoEntity.setStatus(ProcInstInfoEntity.NOT_STARTED_STATUS);
        procInstInfoEntity.setOperator("admin");
        procInstInfoEntity.setProcDefId(procDefId);
        procInstInfoEntity.setProcDefKey(procDefInfoEntity.getProcDefKey());
        procInstInfoEntity.setProcDefName(procDefInfoEntity.getProcDefName());
        procInstInfoEntity.setProcInstKey(procInstKey);

        procInstInfoRepository.save(procInstInfoEntity);

        ProcExecBindingEntity procInstBindEntity = new ProcExecBindingEntity();
        procInstBindEntity.setBindType(ProcExecBindingEntity.BIND_TYPE_PROC_INSTANCE);
        procInstBindEntity.setEntityTypeId(rootEntityTypeId);
        procInstBindEntity.setEntityDataId(rootEntityDataId);
        procInstBindEntity.setProcDefId(procDefId);
        procInstBindEntity.setProcInstId(procInstInfoEntity.getId());
        procExecBindingRepository.save(procInstBindEntity);

        List<TaskNodeDefInfoEntity> taskNodeDefInfoEntities = taskNodeDefInfoRepository.findAllByProcDefId(procDefId);

        for (TaskNodeDefInfoEntity taskNodeDefInfoEntity : taskNodeDefInfoEntities) {
            TaskNodeInstInfoEntity taskNodeInstInfoEntity = new TaskNodeInstInfoEntity();
            taskNodeInstInfoEntity.setStatus(TaskNodeInstInfoEntity.NOT_STARTED_STATUS);
            taskNodeInstInfoEntity.setNodeDefId(taskNodeDefInfoEntity.getId());
            taskNodeInstInfoEntity.setNodeId(taskNodeDefInfoEntity.getNodeId());
            taskNodeInstInfoEntity.setNodeName(taskNodeDefInfoEntity.getNodeName());
            taskNodeInstInfoEntity.setOperator("admin");
            taskNodeInstInfoEntity.setProcDefId(taskNodeDefInfoEntity.getProcDefId());
            taskNodeInstInfoEntity.setProcDefKey(taskNodeDefInfoEntity.getProcDefKey());
            taskNodeInstInfoEntity.setProcInstId(procInstInfoEntity.getId());
            taskNodeInstInfoEntity.setProcInstKey(procInstInfoEntity.getProcInstKey());
            taskNodeInstInfoEntity.setNodeType(taskNodeDefInfoEntity.getNodeType());

            taskNodeInstInfoRepository.save(taskNodeInstInfoEntity);

            List<TaskNodeDefObjectBindInfoDto> bindInfoDtos = pickUpTaskNodeDefObjectBindInfoDtos(requestDto,
                    taskNodeDefInfoEntity.getId());

            for (TaskNodeDefObjectBindInfoDto bindInfoDto : bindInfoDtos) {
                ProcExecBindingEntity nodeBindEntity = new ProcExecBindingEntity();
                nodeBindEntity.setBindType(ProcExecBindingEntity.BIND_TYPE_TASK_NODE_INSTANCE);
                nodeBindEntity.setProcInstId(procInstInfoEntity.getId());
                nodeBindEntity.setProcDefId(procDefId);
                nodeBindEntity.setNodeDefId(bindInfoDto.getNodeDefId());
                nodeBindEntity.setTaskNodeInstId(taskNodeInstInfoEntity.getId());
                nodeBindEntity.setEntityTypeId(bindInfoDto.getEntityTypeId());
                nodeBindEntity.setEntityDataId(bindInfoDto.getEntityDataId());

                procExecBindingRepository.save(nodeBindEntity);
            }
        }

        ProcInstInfoDto result = doCreateProcessInstance(procInstInfoEntity, procDefInfoEntity.getProcDefKernelId(),
                procInstKey);

        return result;
    }

    protected ProcInstInfoDto doCreateProcessInstance(ProcInstInfoEntity procInstInfoEntity, String processDefinitionId,
            String procInstKey) {
        ProcessInstance processInstance = workflowEngineService.startProcessInstance(processDefinitionId, procInstKey);

        // TODO handle failure
        Optional<ProcInstInfoEntity> existProcInstInfoEntityOpt = procInstInfoRepository
                .findById(procInstInfoEntity.getId());

        if (!existProcInstInfoEntityOpt.isPresent()) {
            log.error("such record does not exist,id={},procInstKey={}", procInstInfoEntity.getId(), procInstKey);
            throw new WecubeCoreException("Errors while starting process instance.");
        }

        ProcInstInfoEntity procEntity = existProcInstInfoEntityOpt.get();

        Date now = new Date();

        procEntity.setUpdatedTime(now);
        procEntity.setProcInstKernelId(processInstance.getId());
        procEntity.setStatus(ProcInstInfoEntity.IN_PROGRESS_STATUS);

        procInstInfoRepository.save(procEntity);

        ProcInstInfoDto instDto = new ProcInstInfoDto();
        instDto.setId(procEntity.getId());
        instDto.setOperator(procEntity.getOperator());
        instDto.setProcDefId(procEntity.getProcDefId());
        instDto.setProcInstKey(procEntity.getProcDefKey());
        instDto.setStatus(procEntity.getStatus());

        // TODO to render all task nodes

        return instDto;
    }

    private List<TaskNodeDefObjectBindInfoDto> pickUpTaskNodeDefObjectBindInfoDtos(StartProcInstRequestDto requestDto,
            String nodeDefId) {
        List<TaskNodeDefObjectBindInfoDto> result = new ArrayList<>();
        if (requestDto.getTaskNodeBinds() == null) {
            return result;
        }

        for (TaskNodeDefObjectBindInfoDto biDto : requestDto.getTaskNodeBinds()) {
            if (nodeDefId.equals(biDto.getNodeDefId())) {
                result.add(biDto);
            }
        }

        return result;
    }

}
