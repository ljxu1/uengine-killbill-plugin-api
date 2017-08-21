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

package org.killbill.billing.notification.plugin.api;

import java.util.UUID;

import org.killbill.billing.ObjectType;

/**
 * The interface {@code ExtBusEvent} represents the event type that is published for Killbill users.
 */
public interface ExtBusEvent {

    /**
     * @return the {@code ExtBusEventType}
     */
    public ExtBusEventType getEventType();

    /**
     * @return the {@code ObjectType}
     */
    public ObjectType getObjectType();

    /**
     * @return the unique id for the object that was created/modified
     */
    public UUID getObjectId();

    /**
     *
     * @return an additional field, specific to the event type:
     * - TENANT_CONFIG_CHANGE, TENANT_CONFIG_DELETION : the per tenant key.
     * - Other events: null
     */
    public String getMetaData();

    /**
     * @return the unique id for the account associated with that object
     */
    public UUID getAccountId();

    public UUID getTenantId();
}
