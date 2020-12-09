package com.dhbw.kafka.consumer.metrics;

public class SystemMetricsMessage {
    private double cpuUsage;
    private long totalMemory;
    private long freeMemory;

    public SystemMetricsMessage(double cpuUsage, long totalMemory, long freeMemory) {
        this.cpuUsage = cpuUsage;
        this.totalMemory = totalMemory;
        this.freeMemory = freeMemory;
    }

    public SystemMetricsMessage() {
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(long freeMemory) {
        this.freeMemory = freeMemory;
    }

    @Override
    public String toString() {
        long occupiedMemMB = (totalMemory - freeMemory) / 1000000;
        return String.format("CPU usage: %.2f%%%nMemory usage: %d MB of %d MB = %.2f%%%n",
                cpuUsage*100, occupiedMemMB, totalMemory/1000000, (double)occupiedMemMB/(totalMemory/1000000));
    }
}
