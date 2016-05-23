/*
 * Copyright 2016 inpwtepydjuf@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mmarquee.automation;

import mmarquee.automation.cache.CacheRequest;
import mmarquee.automation.condition.Condition;
import mmarquee.automation.condition.raw.IUIAutomationCondition;
import mmarquee.automation.uiautomation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by inpwt on 06/03/2016.
 *
 * Wrapper for the underlying automation element.
 */
public class AutomationElement {

    /**
     * The underlying automation element
     */
    private IUIAutomationElement element;

    /**
     * Constructor of AutomationElement
     * @param element The element
     */
    public AutomationElement(IUIAutomationElement element) {
        this.element = element;
    }

    /**
     * Gets the property associated with the passed in id
     * @param propertyId The property ID to get
     * @return The property ID
     */
    public Object getCurrentPropertyValue(int propertyId) {
        return this.element.getCurrentPropertyValue(propertyId);
    }


    /**
     * Gete the processID property
     * @return Object representing the processId
     */
 //   public Object getProcessId() {
 //       return getCurrentPropertyValue(PropertyID.ProcessId.getValue());
 //   }

    /**
     * Gets the current control type
     * @return The current control type
     */
    public int currentControlType() {
        return this.element.currentControlType();
    }

    /**
     * Gets the current class name of the element
     * @return The current class name
     */
    public String currentClassName() {
        return this.element.currentClassName();
    }

    /**
     * Gets the current IsPassword value.
     * @return True if IsPassword
     */
    public Boolean currentIsPassword() {
        return this.element.currentIsPassword() == 1;
    }

    /**
     * Gets the current name of the control
     * @return The name of the element
     */
    public String currentName() {
        return this.element.currentName();
    }

    /**
     * Gets the cached name of the control
     * @return The cached name of the element
     */
    public String cachedName() {
        return this.element.cachedName();
    }
    /**
     * Sets the name of the element
     * @param name The name to use
     */
    public void setName(String name) {
        this.element.setName(name);
    }

    /**
     * Finds the first element that matches the condition
     * @param scope Tree scope
     * @param condition The condition
     * @return The first matching element
     */
    public AutomationElement findFirst(TreeScope scope, Condition condition) {
        IUIAutomationElement elem = this.element.findFirst(scope, condition.getCondition());

        if (elem != null) {
            return new AutomationElement(elem);
        } else {
            return null;
        }
    }

    /**
     * Finds the first element that matches the raw condition
     * @param scope Tree scope
     * @param condition The raw condition
     * @return The first matching element
     */
    AutomationElement findFirstFromRawCondition(TreeScope scope, IUIAutomationCondition condition) {
        IUIAutomationElement elem = this.element.findFirst(scope, condition);

        if (elem != null) {
            return new AutomationElement(elem);
        } else {
            return null;
        }
    }

    /**
     * Get the current pattern that matches the patternId
     * @param patternId What pattern to get
     * @return The pattern
     */
    public com4j.Com4jObject getCurrentPattern(int patternId) {
        return this.element.getCurrentPattern(patternId);
    }

    /**
     * Sets focus to the element
     */
    public void setFocus() {
        this.element.setFocus();
    }

    /**
     * Gets all of the elements that match the condition and scope
     * @param scope The scope in the element tree
     * @param condition The condition
     * @return List of matching elements
     */
    public List<AutomationElement> findAll(TreeScope scope, IUIAutomationCondition condition) {
        IUIAutomationElementArray collection = this.element.findAll(scope, condition);

        List<AutomationElement> items = new ArrayList<AutomationElement>();

        for (int count = 0; count < collection.length(); count++) {
            items.add(new AutomationElement(collection.getElement(count)));
        }

        return items;
    }

    /**
     * Gets the current ARIA role
     * @return String representing the ARIA role
     */
    public String getAriaRole() {
        return element.currentAriaRole();
    }

    /**
     * Gets the current orientation
     * @return The orientation
     */
    public OrientationType getOrientation() {
        return element.currentOrientation();
    }

    /**
     * Gets the framework ID
     * @return The framework ID
     */
    public String getFrameworkId() {
        return this.element.currentFrameworkId();
    }

    /**
     * Gets the provider description
     * @return The provider description
     */
    public String getProviderDescription() {
        return this.element.currentProviderDescription();
    }
    /**
     * Get the runtime Id
     * @return The runtime ID
     */
    public int[] getRuntimeId() {
        return element.getRuntimeId();
    }

    /**
     * Gets the process ID
     * @return The process ID
     */
    public Object getProcessId() {
        return element.currentProcessId();
    }

    /**
     * Gets the current item status
     * @return The status
     */
    public String getItemStatus() {
        return this.element.currentItemStatus();
    }

    /**
     * Gets the current accelerator key associated with the element
     * @return The accelerator key
     */
    public String getAcceleratorKey() {
        return this.element.currentAcceleratorKey();
    }

    /**
     * Find all, but from the cache
     * @param treeScope The treeScope
     * @param condition The filter condition
     * @param cacheRequest The cache request
     * @return The found collection of elements
     */
    public List<AutomationElement> findAllBuildCache (TreeScope treeScope,
                                                        Condition condition,
                                                        IUIAutomationCacheRequest cacheRequest) {
        IUIAutomationElementArray collection = this.element.findAllBuildCache(treeScope, condition.getCondition(), cacheRequest);

        List<AutomationElement> items = new ArrayList<AutomationElement>();

        for (int count = 0; count < collection.length(); count++) {
            items.add(new AutomationElement(collection.getElement(count)));
        }

        return items;
    }

    /**
     * Finds the first element that matches the condition, building the cache
     * @param treeScope Tree scope
     * @param condition The condition
     * @return The first matching element
     */
    public AutomationElement findFirstBuildCache(TreeScope treeScope,
                                                 Condition condition,
                                                 IUIAutomationCacheRequest cacheRequest) {
        IUIAutomationElement elem = this.element.findFirstBuildCache(treeScope, condition.getCondition(), cacheRequest);

        if (elem != null) {
            return new AutomationElement(elem);
        } else {
            return null;
        }
    }
}