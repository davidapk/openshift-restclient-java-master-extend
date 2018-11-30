/*******************************************************************************
 * Copyright (c) 2015 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Red Hat, Inc.
 ******************************************************************************/

package com.openshift.restclient;

// TODO: replace with a unique name (UnsupportedResourceOperationException?) 
// since there's an identical exception in jdk (which is a runtime exception, too)
public class UnsupportedOperationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnsupportedOperationException(String message) {
        super(message);
    }
}
