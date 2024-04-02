package org.sigmaka.gen20javaspringbootpos.dto.auth;

import org.sigmaka.gen20javaspringbootpos.entity.RolesEntity;
import org.sigmaka.gen20javaspringbootpos.entity.UsersEntity;

import java.sql.Timestamp;

public class SignupDTO {
    private String email;
    private String username;
    private String password;
    private int roleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsersEntity dtoToEntity(){
        UsersEntity user = new UsersEntity();
        RolesEntity roles = new RolesEntity();
        roles.setId(roleId);

        user.setEmail(this.email);
        user.setUsername(this.username);
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return user;
    }
}
