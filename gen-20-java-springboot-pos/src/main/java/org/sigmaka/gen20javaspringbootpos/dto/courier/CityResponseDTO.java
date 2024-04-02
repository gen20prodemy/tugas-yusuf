package org.sigmaka.gen20javaspringbootpos.dto.courier;

public class CityResponseDTO {
    private String cityId;
    private String provinceId;
    private String province;
    private String type;
    private String cityName;
    private String postalCode;

    public CityResponseDTO() {
    }

    public CityResponseDTO(String cityId, String provinceId, String province, String type, String cityName, String postalCode) {
        this.cityId = cityId;
        this.provinceId = provinceId;
        this.province = province;
        this.type = type;
        this.cityName = cityName;
        this.postalCode = postalCode;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
