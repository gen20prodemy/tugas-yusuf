package org.sigmaka.gen20javaspringbootpos.dto.courier;

public class ProvinceResponseDTO {
    private String provinceId;
    private String province;

    public ProvinceResponseDTO() {
    }

    public ProvinceResponseDTO(String provinceId, String province) {
        this.provinceId = provinceId;
        this.province = province;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
