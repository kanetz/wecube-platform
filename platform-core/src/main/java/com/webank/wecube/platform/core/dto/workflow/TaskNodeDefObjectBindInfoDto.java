package com.webank.wecube.platform.core.dto.workflow;

public class TaskNodeDefObjectBindInfoDto {

    private String nodeDefId;
    private int orderedNo;
    private String objectId;

    public int getOrderedNo() {
        return orderedNo;
    }

    public void setOrderedNo(int orderedNo) {
        this.orderedNo = orderedNo;
    }

    // TODO
    public String getNodeDefId() {
        return nodeDefId;
    }

    public void setNodeDefId(String nodeDefId) {
        this.nodeDefId = nodeDefId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

}
