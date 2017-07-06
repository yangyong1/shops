package com.yang.framework.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This file is for .
 * User: Simon Xianyu
 * Date: 13-6-19
 * Time: 下午2:49
 */
public class MenuItem {
    private String text;
    protected String path;
    protected String parentPath;
    protected String fullPath;
    protected String key;
    protected String roles;
    protected String domain;
    protected String perm;
    protected String iconCls;
    protected List<MenuItem> submenus = new ArrayList<MenuItem>();

    public MenuItem() {
    }

    public MenuItem(MenuItem o) {
        this.path = o.path;
        this.parentPath = o.parentPath;
        this.fullPath = o.fullPath;
        this.key = o.key;
        this.roles = o.roles;
        this.domain = o.domain;
        this.perm = o.perm;
        this.iconCls = o.iconCls;
        this.text = o.getText();
    }

    public boolean isHasText() {
        return StringUtils.isNotBlank(text);
    }

    public void buildFullPath() {
        this.fullPath = ensureNotNull(this.parentPath) + ensureNotNull(this.path);
        for (MenuItem item : submenus) {
            item.setParentPath(fullPath);
            item.buildFullPath();
        }
    }
    public boolean isHasChildren() {
        return submenus != null && submenus.size()>0;
    }
    public String getFullPath() {
        return fullPath;
    }

    public void addMenu(MenuItem item) {
        this.submenus.add(item);
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getParentPath() {
        return parentPath;
    }

    public List<MenuItem> getSubmenus() {
        return submenus;
    }

    public void setSubmenus(List<MenuItem> submenus) {
        this.submenus = submenus;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getKey() {
        if (key == null) {
            return "menu"+(ensureNotNull(this.parentPath)
                    +ensureNotNull(this.path)).replace('/','.');
//            return "menu"+(this.path).replace('/','.');
        }
        return key;
    }

    public String getTabid() {
        return getKey().replace('.','_');
    }

    private String ensureNotNull(String str) {
        if (null == str) {
            return "";
        }
        return str;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    public boolean hasPath(String lookupPath) {
        if (StringUtils.isNotBlank(this.getFullPath()) && lookupPath.startsWith(this.getFullPath())) {
            return true;
        }
        for(MenuItem menuItem : this.getSubmenus()) {
            if (menuItem.hasPath(lookupPath)) {
                return true;
            }
        }
        return false;
    }


    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = StringUtils.trimToNull(text);
    }
}
