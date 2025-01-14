/*
 * Copyright ConsenSys Software Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package net.consensys.gpact.trie;

import java.util.Map;
import java.util.TreeMap;
import org.apache.tuweni.bytes.Bytes32;

public class StorageEntriesCollector<V> implements TrieIterator.LeafHandler<V> {

  private final Bytes32 startKeyHash;
  private final int limit;
  private final Map<Bytes32, V> values = new TreeMap<>();

  public StorageEntriesCollector(final Bytes32 startKeyHash, final int limit) {
    this.startKeyHash = startKeyHash;
    this.limit = limit;
  }

  public static <V> Map<Bytes32, V> collectEntries(
      final Node<V> root, final Bytes32 startKeyHash, final int limit) {
    final StorageEntriesCollector<V> entriesCollector =
        new StorageEntriesCollector<>(startKeyHash, limit);
    final TrieIterator<V> visitor = new TrieIterator<>(entriesCollector);
    root.accept(visitor, CompactEncoding.bytesToPath(startKeyHash));
    return entriesCollector.getValues();
  }

  private boolean limitReached() {
    return limit <= values.size();
  }

  @Override
  public TrieIterator.State onLeaf(final Bytes32 keyHash, final Node<V> node) {
    if (keyHash.compareTo(startKeyHash) >= 0) {
      node.getValue().ifPresent(value -> values.put(keyHash, value));
    }
    return limitReached() ? TrieIterator.State.STOP : TrieIterator.State.CONTINUE;
  }

  public Map<Bytes32, V> getValues() {
    return values;
  }
}
