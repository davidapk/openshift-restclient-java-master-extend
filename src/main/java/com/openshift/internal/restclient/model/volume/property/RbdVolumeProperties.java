/*******************************************************************************
 * Copyright (c) 2015 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/

package com.openshift.internal.restclient.model.volume.property;

import com.openshift.restclient.model.volume.property.IRbdVolumeProperties;
import org.jboss.dmr.ModelNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 扩展类
 * @author wangchenglin
 */
public class RbdVolumeProperties extends AbstractPersistentVolumeProperties implements IRbdVolumeProperties {

    private static final String PV_SPEC = "spec";
    private static final String PV_RBD = "rbd";
    private static final String MONITORS = "monitors";
    private static final String IMAGE = "image";
    private static final String FSTYPE = "fsType";
    private static final String POOL = "pool";
    private static final String USER = "user";
    private static final String KEYRING = "keyring";
    private static final String SECRETREF = "secretRef";

    private List<String> monitors;
    private String image;
    private String fsType;
    private String pool;
    private String user;
    private String keyring;
    private String  secretRef;

    public RbdVolumeProperties(List<String> monitors, String image, String fsType, String pool, String user, String keyring, String secretRef) {
        this.monitors = monitors;
        this.image = image;
        this.fsType = fsType;
        this.pool = pool;
        this.user = user;
        this.keyring = keyring;
        this.secretRef = secretRef;
    }


    @Override
    public void setProperties(ModelNode node) {
        ModelNode nfs = node.get(PV_SPEC, PV_RBD);
        ModelNode sec = node.get(PV_SPEC, PV_RBD, SECRETREF);
        List<ModelNode> list = new ArrayList<>();
        for (String mo : monitors) {
            ModelNode item = new ModelNode();
            item.set(mo);
            list.add(item);
        }
        nfs.get(MONITORS).set(list);
        nfs.get(IMAGE).set(image);
        nfs.get(FSTYPE).set(fsType);
        nfs.get(POOL).set(pool);
        nfs.get(USER).set(user);
        nfs.get(KEYRING).set(keyring);
        sec.get("name").set(secretRef);
        nfs.get(SECRETREF).set(sec);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RbdVolumeProperties rbdVolumeProperties = (RbdVolumeProperties) o;
        return Objects.equals(pool, rbdVolumeProperties.pool)
                && Objects.equals(monitors, rbdVolumeProperties.monitors)
                && Objects.equals(fsType, rbdVolumeProperties.fsType)
                && Objects.equals(keyring, rbdVolumeProperties.keyring)
                && Objects.equals(secretRef, rbdVolumeProperties.secretRef)
                && Objects.equals(user, rbdVolumeProperties.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash( monitors, image, fsType, pool, user, keyring, secretRef);
    }

    @Override
    public String toString() {
        return "NRbdVolumeProperties{" + "monitors='" + monitors + '\'' + ", image='" + image + '\'' + ", fsType=" + fsType
                + "pool='" + pool + '\'' + ", user='" + user + '\'' + ", keyring=" + keyring
                + "secretRef='" + secretRef
                + '}';
    }

    public static String getPvSpec() {
        return PV_SPEC;
    }

    public static String getPvRbd() {
        return PV_RBD;
    }

    public static String getMONITORS() {
        return MONITORS;
    }

    public static String getIMAGE() {
        return IMAGE;
    }

    public static String getFSTYPE() {
        return FSTYPE;
    }

    public static String getPOOL() {
        return POOL;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getKEYRING() {
        return KEYRING;
    }

    public static String getSECRETREF() {
        return SECRETREF;
    }

    @Override
    public List<String> getMonitors() {
        return monitors;
    }

    @Override
    public void setMonitors(List<String> monitors) {
        this.monitors = monitors;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String getFsType() {
        return fsType;
    }

    @Override
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    @Override
    public String getPool() {
        return pool;
    }

    @Override
    public void setPool(String pool) {
        this.pool = pool;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String getKeyring() {
        return keyring;
    }

    @Override
    public void setKeyring(String keyring) {
        this.keyring = keyring;
    }

    @Override
    public String getSecretRef() {
        return secretRef;
    }

    @Override
    public void setSecretRef(String secretRef) {
        this.secretRef = secretRef;
    }
}
