package com.yang.framework.util;

import org.apache.commons.digester3.Digester;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

/**
 * This file is for .
 * User: Simon Xianyu
 * Date: 13-6-19
 * Time: 下午2:52
 */
public class MenuBarSource implements InitializingBean {
    private MenuBar menuBar;

    private Resource menuFile;

    @Override
    public void afterPropertiesSet() throws Exception {
        readMenu();
    }

    public void readMenu() {
        if (menuFile == null || !menuFile.exists()) {
            return;
        }
        Digester dig = createDig();
        InputStream in = null;
        try {
            in = menuFile.getInputStream();
            if (null == in ) {
                throw new RuntimeException("Failed to find menu.xml");
            }
            menuBar = dig.parse(in);
            menuBar.buildFullPath();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read menu.xml");
        } catch (SAXException e) {
            throw new RuntimeException("Failed to parse menu.xml");
        } finally {
            IOUtils.closeQuietly(in);
        }
    }

    private Digester createDig() {
        Digester digester = new Digester();

        digester.addObjectCreate("menus", MenuBar.class);
        digester.addSetProperties("menus");
        digester.addObjectCreate("*/menu", MenuItem.class);
        digester.addSetProperties("*/menu");
        digester.addSetNext("*/menu", "addMenu" );
        return digester;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public Resource getMenuFile() {
        return menuFile;
    }

    public void setMenuFile(Resource menuFile) {
        this.menuFile = menuFile;
    }
}
