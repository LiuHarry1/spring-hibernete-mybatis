package com.example.transactiondemo.entity;

public class AuserWithSpecificRoleDTO {
    private Long userId;
    private String name;
    private Long roleId;
    private String roleName;

    public AuserWithSpecificRoleDTO(Long userId, String name, Long roleId, String roleName) {
        this.userId = userId;
        this.name = name;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    // Getters and setters
}
