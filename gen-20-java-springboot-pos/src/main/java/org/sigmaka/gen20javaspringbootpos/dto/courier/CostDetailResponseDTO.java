package org.sigmaka.gen20javaspringbootpos.dto.courier;

public class CostDetailResponseDTO {
    private int value;
    private String etd;
    private String note;

    public CostDetailResponseDTO() {
    }

    public CostDetailResponseDTO(int value, String etd, String note) {
        this.value = value;
        this.etd = etd;
        this.note = note;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getEtd() {
        return etd;
    }

    public void setEtd(String etd) {
        this.etd = etd;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
