/*******************************************************************************
 * Copyright (c) 2015 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Red Hat, Inc.
 ******************************************************************************/

package com.openshift.internal.restclient.model.build;

import org.apache.commons.lang.StringUtils;

import com.openshift.restclient.model.build.IWebhookTrigger;

public class WebhookTrigger implements IWebhookTrigger {

    private String type;
    private String secret;
    private String baseURL;

    public WebhookTrigger(String triggerType, String secret, String baseURL) {
        this.type = triggerType;
        this.secret = secret;
        this.baseURL = baseURL;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getSecret() {
        return secret;
    }

    @Override
    public String getWebhookURL() {
        if (StringUtils.isBlank(baseURL)) {
            return "";
        }

        return String.format("%s/webhooks/%s/%s", baseURL, secret, type.toLowerCase());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((secret == null) ? 0 : secret.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        WebhookTrigger other = (WebhookTrigger) obj;
        if (secret == null) {
            if (other.secret != null) {
                return false;
            }
        } else if (!secret.equals(other.secret)) {
            return false;
        }
        if (type != other.type) {
            return false;
        }
        return true;
    }

}
