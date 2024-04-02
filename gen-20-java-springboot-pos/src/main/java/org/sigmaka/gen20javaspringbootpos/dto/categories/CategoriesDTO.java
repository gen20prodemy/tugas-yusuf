package org.sigmaka.gen20javaspringbootpos.dto.categories;

import org.sigmaka.gen20javaspringbootpos.entity.CategoriesEntity;

import java.sql.Timestamp;

public class CategoriesDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoriesEntity dtoToEntity(){
        CategoriesEntity category = new CategoriesEntity();
        category.setName(name);
        category.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        category.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return category;
    }
}
