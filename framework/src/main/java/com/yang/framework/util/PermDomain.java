package com.yang.framework.util;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Simon Xianyu
 * Date: 13-10-4
 * Time: 下午3:30
 */
public class PermDomain {
    private String name;
    private String text;
    private List<PermissionDef> permissions = new ArrayList<PermissionDef>();

    public void addPermission(PermissionDef perm) {
        perm.setDomain(this);
        this.permissions.add(perm);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PermissionDef> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionDef> permissions) {
        this.permissions = permissions;
    }
}
