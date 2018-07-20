package com.linkedin.venice.stats;

import com.linkedin.venice.kafka.consumer.StoreIngestionTask;
import io.tehuti.metrics.MetricsRepository;

//TODO: once we've migrated this stats to multi-version. We might want to consider merge it with DIVStats
public class AggStoreIngestionStats extends AbstractVeniceAggStats<StoreIngestionStats> {
  public AggStoreIngestionStats(MetricsRepository  metricsRepository) {
    super(metricsRepository,
          (metricsRepo, storeName) -> new StoreIngestionStats(metricsRepo, storeName));
  }

  public void recordBytesConsumed(String storeName, long bytes) {
    totalStats.recordBytesConsumed(bytes);
    getStoreStats(storeName).recordBytesConsumed(bytes);
  }

  public void recordRecordsConsumed(String storeName, int count) {
    totalStats.recordRecordsConsumed(count);
    getStoreStats(storeName).recordRecordsConsumed(count);
  }

  public void recordPollRequestLatency(String storeName, double latency) {
    totalStats.recordPollRequestLatency(latency);
    getStoreStats(storeName).recordPollRequestLatency(latency);
  }

  public void recordPollResultNum(String storeName, int count) {
    totalStats.recordPollResultNum(count);
    getStoreStats(storeName).recordPollResultNum(count);
  }

  public void recordConsumerRecordsQueuePutLatency(String storeName, double latency) {
    totalStats.recordConsumerRecordsQueuePutLatency(latency);
    getStoreStats(storeName).recordConsumerRecordsQueuePutLatency(latency);
  }

  public void recordUnexpectedMessage(String storeName, int count) {
    totalStats.recordUnexpectedMessage(count);
    getStoreStats(storeName).recordUnexpectedMessage(count);
  }

  public void recordKeySize(String storeName, long bytes) {
    //keySize aggregation among multiple stores is not necessary
    getStoreStats(storeName).recordKeySize(bytes);
  }

  public void recordValueSize(String storeName, long bytes) {
    //valueSize aggregation among multiple stores is not necessary
    getStoreStats(storeName).recordValueSize(bytes);
  }

  public void updateStoreConsumptionTask(String storeName, StoreIngestionTask task) {
    getStoreStats(storeName).updateStoreConsumptionTask(task);
  }
}
