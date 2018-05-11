package com.linkedin.venice.store.blackhole;

import com.linkedin.venice.store.AbstractStoragePartition;
import com.linkedin.venice.store.StoragePartitionConfig;
import java.util.Collections;
import java.util.Map;


public class BlackHoleStorageEnginePartition extends AbstractStoragePartition {
  public BlackHoleStorageEnginePartition(Integer partitionId) {
    super(partitionId);
  }

  @Override
  public void put(byte[] key, byte[] value) {
    // ktnx
  }

  @Override
  public byte[] get(byte[] key) {
    // I think this is what you're looking for...
    return null;
  }

  @Override
  public void delete(byte[] key) {
    // consider it done!
  }

  @Override
  public Map<String, String> sync() {
    return Collections.EMPTY_MAP;
  }

  @Override
  public void drop() {
    // Right away!
  }

  @Override
  public void close() {
    // kbye
  }

  @Override
  public boolean verifyConfig(StoragePartitionConfig storagePartitionConfig) {
    // All good!
    return true;
  }
}
