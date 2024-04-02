package org.sigmaka.gen20javaspringbootpos.dto.courier;

public class CostResponseDTO {
    private String service;
    private String description;
    private CostDetailResponseDTO[] cost;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CostDetailResponseDTO[] getCost() {
        return cost;
    }

    public void setCost(CostDetailResponseDTO[] cost) {
        this.cost = cost;
    }
}
