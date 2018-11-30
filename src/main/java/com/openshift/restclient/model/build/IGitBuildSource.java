/*******************************************************************************
 * Copyright (c) 2015-2018 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Red Hat, Inc.
 ******************************************************************************/

package com.openshift.restclient.model.build;

public interface IGitBuildSource extends IBuildSource {

    /**
     * The branch/tag/ref to build
     * 
     */
    String getRef();
    
    /**
     * The URI to the source repo
     * 
     */
    String getURI();
}
