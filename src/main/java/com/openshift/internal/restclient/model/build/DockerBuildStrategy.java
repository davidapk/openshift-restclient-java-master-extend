/*******************************************************************************
 * Copyright (c) 2015 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Red Hat, Inc.
 ******************************************************************************/

package com.openshift.internal.restclient.model.build;

import com.openshift.restclient.images.DockerImageURI;
import com.openshift.restclient.model.build.BuildStrategyType;
import com.openshift.restclient.model.build.IDockerBuildStrategy;

public class DockerBuildStrategy implements IDockerBuildStrategy {

    private boolean noCache;
    private DockerImageURI image;
    private String contextDir;

    public DockerBuildStrategy(String contextDir, boolean noCache, String baseImage) {
        this.contextDir = contextDir;
        this.noCache = noCache;
        this.image = new DockerImageURI(baseImage);
    }

    @Override
    public String getType() {
        return BuildStrategyType.DOCKER;
    }

    @Override
    public String getContextDir() {
        return contextDir;
    }

    @Override
    public boolean isNoCache() {
        return noCache;
    }

    @Override
    public DockerImageURI getBaseImage() {
        return image;
    }

}
