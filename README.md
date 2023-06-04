
# 派单的并发问题

## 调用链路

api-pasenger /test-real-time-order/{orderId}

->

service-order /test-real-time-order/{orderId}

->

service-map /terminal/aroundSearch

->

请求高德猎鹰开放API

->

End

场景：

多个乘客抢一个 8 号司机

## service-order 单实例时

问题:

使用 `/jmeter/Thread Group0.jmx` 在 jmeter 中进行并发测试，出现 8 号司机被分配给多个订单的情况。

解决:

加 synchronized

## 多实例时 v2.0.2

问题：

两个 service-order 实例都能拿到锁。8 号司机被分配给了两个订单。

解决：

创建公共的锁，即分布式锁。

但 v2,0,2 锁住的代码太多，造成了死锁。大量请求线程 timeout, 且 redis 的 lockKey TTL 不断延长。

分析：

假设 thread2 抢到锁并更新了订单表，然后释放锁。 thread4 随后抢到锁，但查库发现无空闲司机，无法更新订单表。watchDog 于是一直续期，锁无法释放。