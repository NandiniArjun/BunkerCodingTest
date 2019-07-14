package com.bunker.code.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//any property for which we don’t have a corresponding field in the Data class will be ignored. 
@JsonIgnoreProperties(ignoreUnknown = true)
public class URLData {
	
	private String agentVersion;
	private String[] alertIds;
	private String architecture;
	private Collector collector;
	private String cpuModel;
	private String description;
	private String discoveryDate;
	private String externalIp;
	
	public String getAgentVersion() {
		return agentVersion;
	}
	public void setAgentVersion(String agentVersion) {
		this.agentVersion = agentVersion;
	}
	public String[] getAlertIds() {
		return alertIds;
	}
	public void setAlertIds(String[] alertIds) {
		this.alertIds = alertIds;
	}
	public String getArchitecture() {
		return architecture;
	}
	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}
	public Collector getCollector() {
		return collector;
	}
	public void setCollector(Collector collector) {
		this.collector = collector;
	}
	public String getCpuModel() {
		return cpuModel;
	}
	public void setCpuModel(String cpuModel) {
		this.cpuModel = cpuModel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDiscoveryDate() {
		return discoveryDate;
	}
	public void setDiscoveryDate(String discoveryDate) {
		this.discoveryDate = discoveryDate;
	}
	public String getExternalIp() {
		return externalIp;
	}
	public void setExternalIp(String externalIp) {
		this.externalIp = externalIp;
	}
	@Override
	public String toString() {
		return "{\"agentVersion\" : \"" + agentVersion + "\", \"alertIds\" : \"" + alertIds.length + "\", \"architecture\" : \"" + architecture
				+ "\", \"collector\" : \"" + collector.getCollectorName() + "\", \"cpuModel\" : \"" + cpuModel + "\", \"description\" : \"" + description
				+ "\", \"discoveryDate\" : \"" + discoveryDate + "\", \"externalIp\" : \"" + externalIp + "\"}";
	}
	
}
