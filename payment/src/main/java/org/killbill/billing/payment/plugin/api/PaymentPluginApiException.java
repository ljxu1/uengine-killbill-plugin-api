/*
 * Copyright 2010-2013 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.killbill.billing.payment.plugin.api;

import org.killbill.billing.BillingExceptionBase;

public class PaymentPluginApiException extends Exception {

    private static final long serialVersionUID = 15642965L;

    private final String errorType;
    private final String errorMessage;

    public PaymentPluginApiException(final String msg, final Throwable e) {
        super(msg, e);
        errorMessage = msg;
        errorType = e.getMessage();
    }

    public PaymentPluginApiException(final String errorType, final String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorType = errorType;
    }

    public PaymentPluginApiException(final String errorType, BillingExceptionBase billingExceptionBase) {
        this.errorMessage = billingExceptionBase.getMessage();
        this.errorType = errorType;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PaymentPluginApiException");
        if (errorMessage != null) {
            sb.append("{errorMessage='").append(errorMessage).append('\'');
        }
        if (errorType != null) {
            sb.append(", errorType='").append(errorType).append('\'');
        }
        sb.append('}');
        return sb.toString();
    }
}
