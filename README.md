# yuki-rpc
Manual rpc

1.服务端 RpcServer 实现 ApplicationContextAware和 InitializingBean 接口 重写 setApplicationContext 和 afterPropertiesSet 方法，获取所有@RpcService注解的服务接口以及实现
同时在zookeeper上注册类名的临时节点（/registry/data/类名/@{ip+port的hash}），通过netty开启服务接收监听

2.客户端 通过 RpcClient 对请求对象做代理，请求体中包含 类名，方法名，参数名，参数类型以及参数值，同时根据类名从zookeeper中得到ip+port，然后通过netty
发送http请求（请求体通过protobuf序列化），RPCServer接收到请求，反序列化出请求体，根据参数利用代理或者反射执行方法之后将返回结果通过protobuf序列化返回给RpcClient

