package org.sigmaka.gen20javaspringbootpos.dto.courier;

public class CostsResultResponseDTO {
    private String code;
    private String name;
    private CostResponseDTO costs;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CostResponseDTO getCosts() {
        return costs;
    }

    public void setCosts(CostResponseDTO costs) {
        this.costs = costs;
    }
}
