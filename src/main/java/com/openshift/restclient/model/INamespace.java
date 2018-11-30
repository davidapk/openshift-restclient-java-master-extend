/*******************************************************************************
 * Copyright (c) 2015 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Red Hat, Inc.
 ******************************************************************************/

package com.openshift.restclient.model;

import java.util.List;

/**
 * @author Thomas Krause
 */
public interface INamespace extends IResource {

    /**
     * Retrieves resource of the given kind that are scoped to this project
     * 
     * @param kind
     *            the resource kind to retrieve
     * @return a list of {@link INamespace}s
     */
    <T extends IResource> List<T> getResources(String kind);

    String getDisplayName();

    void setDisplayName(String displayName);

    String getDescription();

    void setDescription(String description);

    String getRequester();

    void setRequest(String requester);
}
