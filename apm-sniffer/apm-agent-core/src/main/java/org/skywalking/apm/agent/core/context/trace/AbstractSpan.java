/*
 * Copyright 2017, OpenSkywalking Organization All rights reserved.
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
 *
 * Project repository: https://github.com/OpenSkywalking/skywalking
 */

package org.skywalking.apm.agent.core.context.trace;

import org.skywalking.apm.network.trace.component.Component;

import java.util.Map;

/**
 * Span 接口
 *
 * https://github.com/opentracing-contrib/opentracing-specification-zh/blob/master/specification.md#span
 *
 * The <code>AbstractSpan</code> represents the span's skeleton, which contains all open methods.
 *
 * @author wusheng
 */
public interface AbstractSpan {

    /**
     * 设置 Component
     *
     * Set the component id, which defines in {@link org.skywalking.apm.network.trace.component.ComponentsDefine}
     *
     * @param component
     * @return the span for chaining.
     */
    AbstractSpan setComponent(Component component);

    /**
     * 设置 Component 名字
     *
     * Only use this method in explicit instrumentation, like opentracing-skywalking-bridge. It it higher recommend
     * don't use this for performance consideration.
     *
     * @param componentName
     * @return the span for chaining.
     */
    AbstractSpan setComponent(String componentName);

    /**
     * 设置 SpanLayer
     *
     * @param layer 所属分层
     * @return the span for chaining.
     */
    AbstractSpan setLayer(SpanLayer layer);

    /**
     * 设置 Tag
     *
     * Set a key:value tag on the Span.
     *
     * @return this Span instance, for chaining
     */
    AbstractSpan tag(String key, String value);

    /**
     * Record an exception event of the current walltime timestamp.
     *
     * @param t any subclass of {@link Throwable}, which occurs in this span.
     * @return the Span, for chaining
     */
    AbstractSpan log(Throwable t);

    /**
     * 标记发生异常
     *
     * @return the Span, for chaining
     */
    AbstractSpan errorOccurred();

    /**
     * @return true if the actual span is an entry span.
     */
    boolean isEntry();

    /**
     * @return true if the actual span is an exit span.
     */
    boolean isExit();

    /**
     * Record an event at a specific timestamp.
     *
     * @param timestamp The explicit timestamp for the log record.
     * @param event the events
     * @return the Span, for chaining
     */
    AbstractSpan log(long timestamp, Map<String, ?> event);

    /**
     * 设置操作名
     *
     * Sets the string name for the logical operation this span represents.
     *
     * @return this Span instance, for chaining
     */
    AbstractSpan setOperationName(String operationName);

    /**
     * Start a span.
     *
     * @return this Span instance, for chaining
     */
    AbstractSpan start();

    /**
     * Get the id of span
     *
     * @return id value.
     */
    int getSpanId();

    int getOperationId();

    String getOperationName();

    /**
     * 设置操作编号
     *
     * @param operationId 操作编号
     * @return this Span instance, for chaining
     */
    AbstractSpan setOperationId(int operationId);
}
