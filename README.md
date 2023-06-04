
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

## 多实例时

6个orderId(因为懒得建了)，48条线程