/******************************************************************************* 
 * Copyright (c) 2016 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/

package com.openshift.restclient.api.models;

/**
 * A resource where the client can define the namespace on the object (e.g.
 * ObjectRef)
 *
 */
public interface INamespaceSetable {

    /**
     * The namespace for the object ref
     * 
     */
    void setNamespace(String namespace);
}
