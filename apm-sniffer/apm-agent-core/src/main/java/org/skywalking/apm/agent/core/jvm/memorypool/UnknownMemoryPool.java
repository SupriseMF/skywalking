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

package org.skywalking.apm.agent.core.jvm.memorypool;

import org.skywalking.apm.network.proto.MemoryPool;
import org.skywalking.apm.network.proto.PoolType;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wusheng
 */
public class UnknownMemoryPool implements MemoryPoolMetricAccessor {

    @Override
    public List<MemoryPool> getMemoryPoolMetricList() {
        List<MemoryPool> poolList = new LinkedList<MemoryPool>();
        poolList.add(MemoryPool.newBuilder().setType(PoolType.CODE_CACHE_USAGE).build());
        poolList.add(MemoryPool.newBuilder().setType(PoolType.NEWGEN_USAGE).build());
        poolList.add(MemoryPool.newBuilder().setType(PoolType.OLDGEN_USAGE).build());
        poolList.add(MemoryPool.newBuilder().setType(PoolType.SURVIVOR_USAGE).build());
        poolList.add(MemoryPool.newBuilder().setType(PoolType.PERMGEN_USAGE).build());
        poolList.add(MemoryPool.newBuilder().setType(PoolType.METASPACE_USAGE).build());
        return new LinkedList<MemoryPool>();
    }

}
