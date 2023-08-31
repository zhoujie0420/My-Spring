# My-Spring

https://bugstack.cn/
手写spring

## spring-01

定义：BeanDefinition，可能这是你在查阅 Spring 源码时经常看到的一个类，例如它会包括 singleton、prototype、BeanClassName
等。但目前我们初步实现会更加简单的处理，只定义一个 Object 类型用于存放对象。
注册：这个过程就相当于我们把数据存放到 HashMap 中，只不过现在 HashMap 存放的是定义了的 Bean 的对象信息。
获取：最后就是获取对象，Bean 的名字就是key，Spring 容器初始化好 Bean 以后，就可以直接获取了。

## spring-02

首先我们需要定义 BeanFactory 这样一个 Bean 工厂，提供 Bean 的获取方法 getBean(String name)，之后这个 Bean 工厂接口由抽象类
AbstractBeanFactory 实现。这样使用模板模式 (opens new window)
的设计方式，可以统一收口通用核心方法的调用逻辑和标准定义，也就很好的控制了后续的实现者不用关心调用逻辑，按照统一方式执行。那么类的继承者只需要关心具体方法的逻辑实现即可。
那么在继承抽象类 AbstractBeanFactory 后的 AbstractAutowireCapableBeanFactory 就可以实现相应的抽象方法了，因为
AbstractAutowireCapableBeanFactory 本身也是一个抽象类，所以它只会实现属于自己的抽象方法，其他抽象方法由继承
AbstractAutowireCapableBeanFactory 的类实现。这里就体现了类实现过程中的各司其职，你只需要关心属于你的内容，不是你的内容，不要参与。这一部分内容我们会在代码里有具体的体现
另外这里还有块非常重要的知识点，就是关于单例 SingletonBeanRegistry 的接口定义实现，而 DefaultSingletonBeanRegistry
对接口实现后，会被抽象类 AbstractBeanFactory 继承。现在 AbstractBeanFactory
就是一个非常完整且强大的抽象类了，也能非常好的体现出它对模板模式的抽象定义。接下来我们就带着这些设计层面的思考，去看代码的具体实现结果

## spring-03

参考 Spring Bean 容器源码的实现方式，在 BeanFactory 中添加 Object getBean(String name, Object... args) 接口，这样就可以在获取
Bean 时把构造函数的入参信息传递进去了。
另外一个核心的内容是使用什么方式来创建含有构造函数的 Bean 对象呢？这里有两种方式可以选择，一个是基于 Java 本身自带的方法
DeclaredConstructor，另外一个是使用 Cglib 来动态创建 Bean 对象。Cglib 是基于字节码框架 ASM 实现，所以你也可以直接通过 ASM
操作指令码来创建对象

## spring-04

属性填充要在类实例化创建之后，也就是需要在 AbstractAutowireCapableBeanFactory 的 createBean 方法中添加
applyPropertyValues 操作。
由于我们需要在创建Bean时候填充属性操作，那么就需要在 bean 定义 BeanDefinition 类中，添加 PropertyValues 信息。
另外是填充属性信息还包括了 Bean 的对象类型，也就是需要再定义一个 BeanReference，里面其实就是一个简单的 Bean
名称，在具体的实例化操作时进行递归创建和填充，与 Spring 源码实现一样。Spring 源码中 BeanReference 是一个接口

## spring-05

资源加载器属于相对独立的部分，它位于 Spring 框架核心包下的IO实现内容，主要用于处理Class、本地和云环境中的文件信息。
当资源可以加载后，接下来就是解析和注册 Bean 到 Spring 中的操作，这部分实现需要和 DefaultListableBeanFactory
核心类结合起来，因为你所有的解析后的注册动作，都会把 Bean 定义信息放入到这个类中。
那么在实现的时候就设计好接口的实现层级关系，包括我们需要定义出 Bean 定义的读取接口 BeanDefinitionReader
以及做好对应的实现类，在实现类中完成对 Bean 对象的解析和注册。