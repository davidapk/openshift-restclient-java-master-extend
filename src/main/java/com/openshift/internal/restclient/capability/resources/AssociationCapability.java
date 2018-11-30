/*******************************************************************************
 * Copyright (c) 2015 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Red Hat, Inc.
 ******************************************************************************/

package com.openshift.internal.restclient.capability.resources;

import com.openshift.restclient.IClient;
import com.openshift.restclient.model.IResource;

/**
 * Retrieve the associated resource from the given resource's annotation
 * 
 */
public abstract class AssociationCapability extends AnnotationCapability {

    private IClient client;

    public AssociationCapability(String name, IResource resource, IClient client) {
        super(name, resource);
        this.client = client;
    }

    protected IClient getClient() {
        return client;
    }

    @Override
    public boolean isSupported() {
        if (client == null) {
            return false;
        }
        return super.isSupported();
    }

    /**
     * Get the associated resource of the given kind using the name from the
     * annotation key;
     * 
     * @param kind The kind
     * @return the resource
     */
    protected <T extends IResource> T getAssociatedResource(String kind) {
        if (!isSupported()) {
            return null;
        }
        String name = getResource().getAnnotation(getAnnotationKey());
        return getClient().get(kind, name, getResource().getNamespaceName());
    }
}
