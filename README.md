
# 派单的并发问题

## 项目结构

```
|-- api-passenger/ 乘客API服务，接收前端请求并分发
|-- internal-common/ 公共模块
|-- service-driver/ 司机服务
|-- service-map/ 地图服务，主要用于请求高德开放API
|-- service-order/ 订单服务
|-- sql/ 建库建表和示例数据
|-- jmeter/ 并发测试用到的 .jmx 文件示例
|-- .run/ 在本地 IDE 跑两个 service-order 实例的配置, 可直接导入 idea 使用

```

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

## 多实例时 v2.0.3

查库发现无空闲司机的情况也要释放锁。防止死锁。