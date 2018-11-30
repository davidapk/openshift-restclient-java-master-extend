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

package com.openshift.restclient.model.volume.property;


public interface IGlufsVolumeProperties extends IPersistentVolumeProperties {

    String getPath();

    String getEndpoints();

    boolean isReadOnly();

    void setPath(String path);

    void setEndpoints(String endpoints);

    void setReadOnly(boolean isReadOnly);

}
