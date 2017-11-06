package com.yang.framework.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This file is for .
 * User: Simon Xianyu
 * Date: 13-6-19
 * Time: 下午2:50
 */
public class MenuBar {
    private Logger log = LoggerFactory.getLogger(getClass());
    private List<MenuItem> mainitems = new ArrayList<MenuItem>();
    private ArrayList<MenuItem> emptyMenuItems = new ArrayList<MenuItem>(0);

    public void buildFullPath() {
        for (MenuItem item : mainitems) {
            item.setParentPath("");
            item.buildFullPath();
        }
    }

    public List<MenuItem> getAuthedItems() {
        Subject subject = null;
        try {
            subject = SecurityUtils.getSubject();
        } catch (Exception e) {
//            e.printStackTrace();
            log.error("Failed to get subject",e);
            return emptyMenuItems;
        }
        if (subject.hasRole("1")) {
            return getMainitems();
        }
        List<MenuItem> mainItems = new ArrayList<MenuItem>();
        for(MenuItem mainitem: getMainitems()) {
            List<MenuItem> subItems = new ArrayList<MenuItem>();
            for(MenuItem subItem : mainitem.submenus) {
                if (StringUtils.isBlank(subItem.getPerm())){
                    subItems.add(subItem);
                } else if (subject.isPermitted(subItem.getPerm())){
                    subItems.add(subItem);
                }
            }
            if (subItems.size()>0) {
                MenuItem newOne = new MenuItem(mainitem);
                newOne.setSubmenus(subItems);
                mainItems.add(newOne);
            }
        }
        return mainItems;
    }

    public MenuItem findMain(String lookupPath) {
        for(MenuItem main : mainitems) {
            if (main.hasPath(lookupPath)) {
                return main;
            }
        }
        return null;
    }

    public void addMenu(MenuItem item) {
        this.mainitems.add(item);
    }

    public List<MenuItem> getMainitems() {
        return mainitems;
    }

    public void setMainitems(List<MenuItem> mainitems) {
        this.mainitems = mainitems;
    }

}
