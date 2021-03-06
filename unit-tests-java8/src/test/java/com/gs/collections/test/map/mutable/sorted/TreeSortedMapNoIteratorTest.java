/*
 * Copyright 2015 Goldman Sachs.
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

package com.gs.collections.test.map.mutable.sorted;

import java.util.Comparator;
import java.util.Iterator;

import com.gs.collections.api.map.sorted.MutableSortedMap;
import com.gs.collections.impl.block.factory.Comparators;
import com.gs.collections.impl.map.sorted.mutable.TreeSortedMap;
import com.gs.collections.test.bag.mutable.sorted.OrderedIterableNoIteratorTest;
import com.gs.junit.runners.Java8Runner;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNull;

@RunWith(Java8Runner.class)
public class TreeSortedMapNoIteratorTest implements MutableSortedMapIterableTestCase, OrderedIterableNoIteratorTest
{
    @Override
    public <T> MutableSortedMap<Object, T> newWith(T... elements)
    {
        int i = elements.length;
        MutableSortedMap<Object, T> result = new TreeSortedMapNoIterator<>(Comparators.reverseNaturalOrder());
        for (T each : elements)
        {
            assertNull(result.put(i, each));
            i--;
        }
        return result;
    }

    @Override
    public void Iterable_remove()
    {
        OrderedIterableNoIteratorTest.super.Iterable_remove();
    }

    public static class TreeSortedMapNoIterator<K, V> extends TreeSortedMap<K, V>
    {
        public TreeSortedMapNoIterator()
        {
            // For serialization
        }

        public TreeSortedMapNoIterator(Comparator<? super K> comparator)
        {
            super(comparator);
        }

        @Override
        public Iterator<V> iterator()
        {
            throw new AssertionError("No iteration patterns should delegate to iterator()");
        }
    }
}
