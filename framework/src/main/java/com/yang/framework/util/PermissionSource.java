package com.yang.framework.util;

import org.apache.commons.digester3.Digester;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Simon Xianyu
 * Date: 13-10-4
 * Time: 下午3:18
 */
public class PermissionSource implements InitializingBean {
    private Resource permissionFile;

    private List<PermDomain> domains;
    private List<PermissionDef> permissions = new ArrayList<PermissionDef>();

    @Override
    public void afterPropertiesSet() throws Exception {
        readPermissions();
    }

    public void readPermissions() {
        Digester dig = getDigester();

        InputStream in;
        try {
            in = permissionFile.getInputStream();
            if (in != null) {
                domains = dig.parse(in);
                for(PermDomain domain: domains) {
                    for(PermissionDef def : domain.getPermissions()) {
                        permissions.add(def);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private Digester getDigester() {
        Digester dig = new Digester();
        dig.addObjectCreate("permissions", ArrayList.class);
        dig.addObjectCreate("permissions/domain", PermDomain.class);
        dig.addSetProperties("permissions/domain");
        dig.addSetNext("permissions/domain", "add");

        dig.addObjectCreate("permissions/domain/perm", PermissionDef.class);
        dig.addSetProperties("permissions/domain/perm");
        dig.addSetNext("permissions/domain/perm","addPermission");
        return dig;
    }
    public List<PermDomain> getDomains() {
        return domains;
    }

    public void setDomains(List<PermDomain> domains) {
        this.domains = domains;
    }

    public Resource getPermissionFile() {
        return permissionFile;
    }

    public void setPermissionFile(Resource permissionFile) {
        this.permissionFile = permissionFile;
    }

    public List<PermissionDef> getPermissions() {
        return permissions;
    }
}
