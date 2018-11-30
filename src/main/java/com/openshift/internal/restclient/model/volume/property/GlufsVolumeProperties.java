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

import com.openshift.restclient.model.volume.property.IGlufsVolumeProperties;
import com.openshift.restclient.model.volume.property.INfsVolumeProperties;
import org.jboss.dmr.ModelNode;

import java.util.Objects;

public class GlufsVolumeProperties extends AbstractPersistentVolumeProperties implements IGlufsVolumeProperties {

    private static final String PV_SPEC = "spec";
    private static final String PV_GLUSTERFS = "glusterfs";
    private static final String ENDPOINTS = "endpoints";
    private static final String PATH = "path";
    private static final String READ_ONLY = "readOnly";

    private String endpoints;
    private String path;
    private boolean readOnly;

    public GlufsVolumeProperties(String endpoints, String path, boolean readOnly) {
        this.endpoints = endpoints;
        this.path = path;
        this.readOnly = readOnly;
    }

    public String getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(String endpoints) {
        this.endpoints = endpoints;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    @Override
    public void setProperties(ModelNode node) {
        ModelNode nfs = node.get(PV_SPEC, PV_GLUSTERFS);
        nfs.get(ENDPOINTS).set(endpoints);
        nfs.get(PATH).set(path);
        nfs.get(READ_ONLY).set(readOnly);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlufsVolumeProperties nfsVolumeProperties = (GlufsVolumeProperties) o;
        return Objects.equals(readOnly, nfsVolumeProperties.readOnly)
                && Objects.equals(endpoints, nfsVolumeProperties.endpoints) && Objects.equals(path, nfsVolumeProperties.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endpoints, path, readOnly);
    }

    @Override
    public String toString() {
        return "NfsVolumeProperties{" + "endpoints='" + endpoints + '\'' + ", path='" + path + '\'' + ", readOnly=" + readOnly
                + '}';
    }
}
