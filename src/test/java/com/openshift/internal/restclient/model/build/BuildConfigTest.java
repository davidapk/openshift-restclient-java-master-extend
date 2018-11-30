/*******************************************************************************
 * Copyright (c) 2015-2018 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Red Hat, Inc.
 ******************************************************************************/

package com.openshift.internal.restclient.model.build;

import static com.openshift.internal.util.JBossDmrExtentions.getPath;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jboss.dmr.ModelNode;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.openshift.internal.restclient.model.BuildConfig;
import com.openshift.restclient.IClient;
import com.openshift.restclient.images.DockerImageURI;
import com.openshift.restclient.model.build.BuildSourceType;
import com.openshift.restclient.model.build.BuildStrategyType;
import com.openshift.restclient.model.build.IBinaryBuildSource;
import com.openshift.restclient.model.build.IBuildSource;
import com.openshift.restclient.model.build.IBuildStrategy;
import com.openshift.restclient.model.build.ICustomBuildStrategy;
import com.openshift.restclient.model.build.IDockerBuildStrategy;

public class BuildConfigTest {
    @Mock
    private IClient client;
    private BuildConfig config;
    private ModelNode node = new ModelNode();

    @Before
    public void setup() {
        config = new BuildConfig(node, client, null);
    }

    @Test
    public void testGetCustomBuildStrategy() {
        String[] key = new String[] { "spec", "strategy" };
        node.get(key).get("type").set("Custom");
        node.get(key).get("customStrategy").get("exposeDockerSocket").set(true);
        node.get(key).get("customStrategy").get("image").set("thebaseImage");
        ModelNode env = new ModelNode();
        env.get("name").set("foo");
        env.get("value").set("bar");
        node.get(key).get("customStrategy").get("env").add(env);

        IBuildStrategy strategy = config.getBuildStrategy();
        assertEquals(BuildStrategyType.CUSTOM, strategy.getType());
        ICustomBuildStrategy custom = (ICustomBuildStrategy) strategy;
        assertEquals(new DockerImageURI("thebaseImage"), custom.getImage());
        assertTrue(custom.exposeDockerSocket());
        assertEquals(1, custom.getEnvironmentVariables().size());
        assertTrue("Exp. to find the environment variable", custom.getEnvironmentVariables().containsKey("foo"));
        assertEquals("bar", custom.getEnvironmentVariables().get("foo"));
    }

    @Test
    public void testGetDockerBuildStrategy() {
        node.get(getPath(BuildConfig.BUILDCONFIG_TYPE)).set("Docker");
        node.get(getPath(BuildConfig.BUILDCONFIG_DOCKER_CONTEXTDIR)).set("aContextDir");
        node.get(getPath(BuildConfig.BUILDCONFIG_DOCKER_NOCACHE)).set(true);
        node.get(getPath(BuildConfig.BUILDCONFIG_DOCKER_BASEIMAGE)).set("thebaseImage");

        IBuildStrategy strategy = config.getBuildStrategy();
        assertEquals(BuildStrategyType.DOCKER, strategy.getType());
        IDockerBuildStrategy docker = (IDockerBuildStrategy) strategy;
        assertEquals("aContextDir", docker.getContextDir());
        assertTrue(docker.isNoCache());
        assertEquals(new DockerImageURI("thebaseImage"), docker.getBaseImage());
    }
    
    @Test
    public void testGetBinaryBuildSource() {
        node.get(getPath(BuildConfig.BUILDCONFIG_SOURCE_TYPE)).set("Binary");
        node.get(getPath(BuildConfig.BUILDCONFIG_SOURCE_CONTEXTDIR)).set("aContextDir");

        IBuildSource source = config.getBuildSource();
        assertEquals(BuildSourceType.BINARY, source.getType());
        IBinaryBuildSource binary = (IBinaryBuildSource) source;
        assertEquals("aContextDir", binary.getContextDir());
    }

}
