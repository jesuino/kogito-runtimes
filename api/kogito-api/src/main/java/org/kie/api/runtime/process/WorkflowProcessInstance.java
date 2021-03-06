/*
 * Copyright 2010 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.api.runtime.process;

import java.util.Date;

/**
 * A workflow process instance represents one specific instance of a
 * workflow process that is currently executing.  It is an extension
 * of a <code>ProcessInstance</code> and contains all runtime state
 * related to the execution of workflow processes.
 *
 * @see org.kie.api.runtime.process.ProcessInstance
 */
public interface WorkflowProcessInstance
    extends
    ProcessInstance,
    NodeInstanceContainer {

    /**
     * Returns the value of the variable with the given name.  Note
     * that only variables in the process-level scope will be searched.
     * Returns <code>null</code> if the value of the variable is null
     * or if the variable cannot be found.
     *
     * @param name the name of the variable
     * @return the value of the variable, or <code>null</code> if it cannot be found
     */
    Object getVariable(String name);

    /**
     * Sets process variable with given value under given name
     * @param name name of the variable
     * @param value value of the variable
     */
    void setVariable(String name, Object value);
    
    /**
     * Returns start date of this process instance
     * @return actual start date
     */
    Date getStartDate();
    
    /**
     * Returns end date (either completed or aborted) of this process instance
     * @return actual end date
     */
    Date getEndDate();
    
    /**
     * Returns node definition id associated with node instance
     * that failed in case this process instance is in an error 
     * @return node definition id of the failed node instance
     */
    String getNodeIdInError();
    
    /**
     * Returns error message associated with this process instance in case it is in an error
     * state. It will consists of
     * <ul>
     *  <li>unique error id (uuid)</li>
     *  <li>fully qualified class name of the root cause</li>
     *  <li>error message of the root cause</li>
     * </ul>
     * @return error message
     */
    String getErrorMessage();

}
