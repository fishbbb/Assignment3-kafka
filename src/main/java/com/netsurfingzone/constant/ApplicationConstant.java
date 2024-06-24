package com.netsurfingzone.constant;

public class ApplicationConstant {
	public static final String KAFKA_LOCAL_SERVER_CONFIG = "localhost:9092";
	public static final String GROUP_ID_STRING = "group-id-string-1";
	public static final String TOPIC_NAME = "netsurfingzone-topic-1";
	// Logistics topics
	public static final String TOPIC_LOGISTICS_ARRIVAL = "logistics.arrival";
	public static final String TOPIC_LOGISTICS_UNLOADING = "logistics.unloading";
	public static final String TOPIC_LOGISTICS_INSPECTION = "logistics.inspection";

	// Warehouse topics
	public static final String TOPIC_WAREHOUSE_INVENTORY = "warehouse.inventory";
	public static final String TOPIC_WAREHOUSE_OUTBOUND = "warehouse.outbound";
	public static final String KAFKA_LISTENER_CONTAINER_FACTORY = "kafkaListenerContainerFactory";
	public static final String GROUP_ID_JSON = "group-id-json-1";
}

