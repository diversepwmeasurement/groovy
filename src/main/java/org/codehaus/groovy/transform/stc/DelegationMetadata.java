/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.codehaus.groovy.transform.stc;

import org.codehaus.groovy.ast.ClassNode;

/**
 * Stores the delegation strategy and delegate type of closures.
 * <p>
 * As closures can be nested, a delegation metadata may have a parent.
 */
class DelegationMetadata {
    private final DelegationMetadata parent;
    private final ClassNode type;
    private final int strategy;

    public DelegationMetadata(final ClassNode type, final int strategy, final DelegationMetadata parent) {
        this.strategy = strategy;
        this.type = StaticTypeCheckingVisitor.wrapTypeIfNecessary(type); // non-primitive
        this.parent = parent;
    }

    public DelegationMetadata(final ClassNode type, final int strategy) {
        this(type, strategy, null);
    }

    public int getStrategy() {
        return strategy;
    }

    public ClassNode getType() {
        return type;
    }

    public DelegationMetadata getParent() {
        return parent;
    }
}
