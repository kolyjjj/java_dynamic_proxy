A Simple Java Proxy

--------------------------------

###学习四步的运用：

* 问题：动态地给一个接口创建实现

* 概念：Proxy Interface, Proxy Instance, Invocation Handler
    * Proxy Interface，就是一个简单的interface，在创建proxy instance的时候需要传入作为参数
    * Proxied instance，被代理的对象．
    * Proxy Instance，使用Proxy.newProxyInstance创建出来的instance，这个是动态创建出来的．动态的意思就是说，并没有一个proxy的类存在，只是有一个Invocation Handler的存在
    * Invocation Handler，其实就是一个invoke方法的wrapper．这个invoke方法会传入代理的那个方法以及调用时候的参数．代理的那个方法是java.reflect.Method的类型．参数就是Object[]的类型．

* 概念之间的关系：从使用者的角度来看，Proxy Interface告诉了具体的方法，也就是输入输出．至于具体的Interface的实现类，只需要知道类的名字就行．整个过程可以这样理解：先是用户通过Proxy Interface知道了具体的方法，然后调用这个Proxy 
Instance的方法，此时实际上调用的是InvocationHandler的invoke函数，invoke函数再调用具体的被代理类的方法．

* 解决方案：无法解决上述问题．能解决的问题是创建代理类，在调用被代理类的方法之前或之后进行一些额外的工作．

Proxy.newProxyInstance里面的实现：基本就是使用reflect包里面的函数，先创建一个代理类，然后获取这个类的constructor方法来创建出一个instance．中间做了一个cache，使用的是ConcurrentHashMap来做cache．cache的key
是对应的classloader，value也是一个ConcurrentHashMap，创建类的过程大概是各种判断，然后使用class.forName来创建．输入的是接口的class，然后通过这个拿到接口的名字．创建完之后写入到文件里面，也会产生一个类的名字．