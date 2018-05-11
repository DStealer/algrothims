package com.dstealer.algrothims.loadbalance;

/**
 * 处理器
 */
public interface Processor {
    /**
     * 处理方法
     *
     * @param exchange
     * @throws Exception
     */
    void process(Object exchange) throws Exception;

    /**
     * 权重
     *
     * @return
     */
    default int getWeight() {
        return 1;
    }
}
