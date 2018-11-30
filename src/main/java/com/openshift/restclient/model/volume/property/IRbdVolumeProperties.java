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


import java.util.List;

public interface IRbdVolumeProperties extends IPersistentVolumeProperties {

    List<String> getMonitors();

    String getImage();

    String getFsType();

    String getPool();

    String getUser();

    String getKeyring();

    String getSecretRef();

    void setMonitors(List<String> monitors);

    void setImage(String image);

    void setFsType(String fsType);

    void setPool(String pool);

    void setUser(String user);

    void setKeyring(String keyring);

    void setSecretRef(String secretRef);

}
