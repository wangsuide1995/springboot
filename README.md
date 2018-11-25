# springboot
#                                                  2019.11.19  
#学习Git的相关知识

#  1.
#因为之前学习的是SVN，现在又学习了Git，所以总结一下两者的区别...
#SVN与Git的最主要的区别？
 　SVN是集中式版本控制系统，版本库是集中放在中央服务器的，而干活的时候，用的都是自己的电脑，所以首先要从中央服务器那里得到最新的版本，
然后干活，干完后，需要把自己做完的活推送到中央服务器。集中式版本控制系统是必须联网才能工作，如果在局域网还可以，带宽够大，速度够快，
如果在互联网下，如果网速慢的话，就麻烦了。
　　Git是分布式版本控制系统，那么它就没有中央服务器的，每个人的电脑就是一个完整的版本库，这样，工作的时候就不需要联网了，
因为版本都是在自己的电脑上。既然每个人的电脑都有一个完整的版本库，那多个人如何协作呢？比如说自己在电脑上改了文件A，
其他人也在电脑上改了文件A，这时，你们两之间只需把各自的修改推送给对方，就可以互相看到对方的修改了。又因为有GitHub的存在，所以可以很好方便的保存托管项目。

#  2.
#在STS或者IDEA上创建好项目后，可以先提交到本地Git中，在上传到GitHub上，所以这就涉及到了工作区和缓存区了。

#理解工作区与暂存区的区别？
   工作区：就是你在电脑上看到的目录，比如目录下testgit里的文件(.git隐藏目录版本库除外)。或者以后需要再新建的目录文件等等都属于工作区范畴。
版本库(Repository)：工作区有一个隐藏目录.git,这个不属于工作区，这是版本库。其中版本库里面存了很多东西，其中最重要的就是stage(暂存区)，
还有Git为我们自动创建了第一个分支master,以及指向master的一个指针HEAD。

#我们前面说过使用Git提交文件到版本库有两步：
#第一步：是使用 git add 把文件添加进去，实际上就是把文件添加到暂存区。
#第二步：使用git commit提交更改，实际上就是把暂存区的所有内容提交到当前分支上，保存在本地库中。
#第三步：把本地库的内容推送到远程，使用 git push命令，实际上是把当前分支master推送到远程。

#  3.创建分支和合并分支
# 　git checkout 命令加上 –b参数表示创建并切换
#   git branch查看分支，会列出所有的分支，当前分支前面会添加一个星号。然后我们在dev分支上继续做demo
#   git merge命令用于合并指定分支到当前分支上
#   git branch –d name命令用于删除分支

#  4.解决分支之间的冲突
   首先master主分支应该是非常稳定的，也就是用来发布新版本，一般情况下不允许在上面干活，干活一般情况下在
新建的dev分支上干活，干完后，比如上要发布，或者说dev分支代码稳定后可以合并到主分支master上来，这期间可能
会发生冲突，Git会让我们选择冲突两方的信息，然后合并到主分支。


#                                                  2019.11.20
#学习Maven的相关知识

#  1.maven基础
# Maven的好处是：
节省空间 对jar包做了统一管理 依赖管理，一键构建，可跨平台，应用在大型项目可提高开发效率
# Maven的仓库
本地仓库(本机)
远程仓库（太极私服）
中央仓库
# Maven构成
#项目坐标
```xml
<groupId>cn.com.taiji</groupId>
<artifactId>maven</artifactId>
<version>0.0.1-SNAPSHOT</version>
```
#Packaging  
打包方式 : Jar  war  pom
#jar包依赖管理
<dependencies>
 <dependency>
 </dependency>
</dependencies>
#项目插件
<plugins>
<plugin>
</plugin>
</plugins>

#父工程和子工程
#可以在子工程的pom文件中添加：
```xml
  <parent>
    <groupId>cn.com.taiji</groupId>
    <artifactId>taiji_demo4</artifactId>
    <version>0.0.1-SNAPSHOT</version>
  </parent>
```  
#开发项目是可以用他来控制版本号，方便管理
```xml
  <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>io.spring.platform</groupId>
        <artifactId>platform-bom</artifactId>
        <version>Cairo-SR5</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
  </dependencyManagement>
``` 
  
#                                                  2019.11.21
#学习spring IOC的相关知识
#   1.
IOC :控制反转,将对象的创建权交给了 Spring. 
DI :Dependency Injection 依赖注入.需要有IOC的环境,Spring创建这个类的过程中,Spring将类的依赖的属性设置进去.
#   2.
# xml配置文件中的属性作用
id :Bean的名字. 在约束中采用 ID 的约束:唯一. 必须以字母开始，可以使用字母、数字、连字符、下划线、句话、冒号。id:不能出现特殊字符.  
name:Bean 起个名字. 没有采用 ID 的约束.  name:出现特殊字符.如果<bean>没有 id 的话 , name 可以当做 id 使用. 
#   3.
# scope 属性：Bean 的作用范围. 
 singleton  :默认值，单例的. 
 prototype  :多例的. 
 request  :WEB 项目中,Spring 创建一个 Bean 的对象,将对象存入到 request 域中. 
 session  :WEB 项目中,Spring 创建一个 Bean 的对象,将对象存入到 session 域中. 
 globalSession :WEB 项目中,应用在 Porlet 环境.如果没有 Porlet环境那么globalSession 相当于 session. 
 #   4.
# Bean的生命周期的配置: 
通过配置<bean>标签上的 init-method 作为 Bean 的初始化的时候执行的方法，配置destroy-method 作为 Bean 的销毁的时候执行的方法。 
销毁方法想要执行，需要是单例创建的 Bean 而且在工厂关闭的时候，Bean 才会被销毁. 
#   5.
# Spring生成 Bean的时候三种方式
方式一：无参数的构造方法的实例化  
<bean id="bean1" class="cn.com.taiji.spring.demo.Bean1"></bean> 
方式二：java代码的配置方式(如下)
```java
@Configuration  //告诉spring，将此类注入到容器中
public class config {

    @Bean(value = "hello")
    public helloword bean(){
        helloword hello = new helloword();
        return hello;
    }

    @Bean(value = "wang")
    public another wang(){
        another another = new another();
        return another;
    }
}
```
方式三：静态工厂实例化的方式提供一个工厂类
<bean id="bean2" class="cn.com.taiji.spring.spring.demo3.Bean2Factory" factory-method="getBean2"/>

#   6.
#Spring的Bean的属性注入: 
 第一种：构造方法的方式  
 <bean id="car" class="cn.com.taiji.spring.demo4.Car"> 
  <constructor-arg name="name" value="保时捷"/>   
  <constructor-arg name="price" value="100000"/>  
 </bean> 
 第二种：set方法的方式   
 <bean id="car2" class="cn.com.taiji.spring.demo4.Car2"> 
   <property name="name" value=" 奇瑞"/>   
   <property name="price" value="40000"/>  
 </bean> 
#Spring 的属性注入：对象类型的注入: 
 注入对象类型的属性:  
 <bean id="person" class="cn.com.taiji.spring.demo4.Person"> 
  <property name="name" value="王绥德"/>   
   ref属性:引用另一个bean的id或name   
  <property name="car2" ref="car2"/>  
 </bean> 
 
 
#                                                   2019.11.22  到  11.23
#学习spring boot的相关知识
#   1.
#我对springboot的理解
简化了Spring应用开发的一个框架； 
整个Spring技术栈的一个大整合； 
J2EE开发的一站式解决方案； 
# spring boot的starter依赖
```xml
  <parent>  
     <groupId>org.springframework.boot</groupId>  
     <artifactId>spring‐boot‐starter‐parent</artifactId>   
     <version>1.5.9.RELEASE</version>   
  </parent>    
 <dependencies>      
   <dependency>           
      <groupId>org.springframework.boot</groupId>     
    <artifactId>spring‐boot‐starter‐web</artifactId>   
   </dependency>    
 </dependencies>
```
// 这个插件，可以将应用打包成一个可执行的jar包；
```xml
  <build>        
       <plugins>         
        <plugin>         
        <groupId>org.springframework.boot</groupId>   
        <artifactId>spring‐boot‐maven‐plugin</artifactId>    
      </plugin>     
    </plugins>   
  </build>
```
 
   
#启动springboot应用
@SpringBootApplication //来标注一个主程序类，说明这是一个SpringBoot应用  
 @SpringBootApplication public class SpringbootApplication {      
  public static void main(String[] args) {                 
     SpringApplication.run(SpringbootApplication.class,args);   
   }
  }
 
#Spring Boot将所有的功能场景都抽取出来，做成一个个的starters（启动器），只需要在项目里面引入这些starter 相关场景的所有依赖都会导入进来。要用什么功能就导入什么场景的启动器就ok

#springboot的一些注解作用
@SpringBootApplication: Spring Boot应用标注在某个类上说明这个类是SpringBoot的主配置类，SpringBoot 就应该运行这个类的main方法来启动SpringBoot应用；
@SpringBootConﬁguration:Spring Boot的配置类；标注在某个类上，表示这是一个Spring Boot的配置类；
@Conﬁguration:配置类上来标注这个注解；配置类配置文件；配置类也是容器中的一个组件；@Component
@EnableAutoConﬁguration：开启自动配置功能；以前我们需要配置的东西，Spring Boot帮我们自动配置；此注解告诉SpringBoot开启自动配置功能；这样自动配置才能生效；
@AutoConﬁgurationPackage：自动配置包
@Import(AutoConﬁgurationPackages.Registrar.class)：Spring的底层注解@Import，给容器中导入一个组件；导入的组件由 AutoConﬁgurationPackages.Registrar.class；
将主配置类（@SpringBootApplication标注的类）的所在包及下面所有子包里面的所有组件扫描到Spring容器；
#注：EnableAutoConﬁgurationImportSelector：导入哪些组件的选择器；
 将所有需要导入的组件以全类名的方式返回；这些组件就会被添加到容器中；
 会给容器中导入非常多的自动配置类（xxxAutoConﬁguration）；就是给容器中导入这个场景需要的所有组件，并配置好这些组件；
等等...

#我使用的IDE是IDEA，所以我简单记录一下创建过程
IDEA：使用 Spring Initializer快速创建项目 
IDE都支持使用Spring的项目创建向导快速创建一个Spring Boot项目； 选择我们需要的模块；向导会联网创建Spring Boot项目； 默认生成的Spring Boot项目；
主程序已经生成好了，我们只需要我们自己的逻辑 
resources文件夹中目录结构 
static：保存所有的静态资源； js、css、images；
templates：保存所有的模板页面；
（Spring Boot默认jar包使用嵌入式的Tomcat，默认不支持JSP页面）,可以使用模板引擎（freemarker、thymeleaf）；
application.properties或application.yml配置文件：Spring Boot应用的配置文件；可以修改一些默认设置；（两者都存在的话application.properties优先级更高）

#SpringBoot使用一个全局的配置文件，配置文件名是固定的； 
application.properties 
application.yml

# YAML
YAML：以数据为中心，比json、xml等更适合做配置文件
YAML：配置例子
#YAML基本语法 
k:(空格)v：表示一对键值对（空格必须有）；
以空格的缩进来控制层级关系；只要是左对齐的一列数据，都是同一个层级的
server:   
   port: 8081
属性和值也是大小写敏感；
值的写法 字面量：普通的值（数字，字符串，布尔） 
 k: v：字面直接来写；
  字符串默认不用加上单引号或者双引号；
  ""：双引号；不会转义字符串里面的特殊字符；特殊字符会作为本身想表示的意思
 name: "wangsuide \n lisi"：输出；wangsuide 换行 lisi
  ''：单引号；会转义特殊字符，特殊字符终只是一个普通的字符串数据
 name: ‘wangsuide \n lisi’：输出；wangsuide \n lisi 

# application.properties 
#普通配置文件的书写格式（如下）
设置本项目的访问端口号
server.port=8001
设置admin项目来监控本项目的运行
spring.boot.admin.url=http://localhost:8000

#yml支持多文档块方（用“---”来分割）
```yaml
name: qwer
age: 123

spring:
    profiles:
      active: dev
---
spring:
  profiles: hello
name: wang
---
spring:
  profiles: dev
age: 12356
```
***激活指定proﬁle 
 1、在配置文件中指定 spring.proﬁles.active=dev
 2、命令行：
  java -jar spring-boot-02-conﬁg-0.0.1-SNAPSHOT.jar --spring.proﬁles.active=dev；
 
# 配置文件加载位置顺序
springboot 启动会扫描以下位置的application.properties或者application.yml文件作为Spring boot的默认配置文件
–ﬁle:./conﬁg/
–ﬁle:./ 
–classpath:/conﬁg/ 
–classpath:/
优先级由高到底，高优先级的配置会覆盖低优先级的配置；
SpringBoot会从这四个位置全部加载主配置文件；实现互补配置； 


#springboot整合日志框架
日志框架有：Jboss-logging、logback、log4j、log4j2、slf4j....
如果要用其他日志框架，必须把logging屏蔽：
```xml
<dependency>
           <groupId>org.springframework</groupId>       
       <artifactId>spring‐core</artifactId>          
            <exclusions>           
               <exclusion>       
           <groupId>commons‐logging</groupId>     
           <artifactId>commons‐logging</artifactId>   
        </exclusion>               
            </exclusions>          
 </dependency>
 ```
# SpringBoot默认帮我们配置好了日志；
 记录器  
 ```java  
   Logger logger = LoggerFactory.getLogger(getClass());    
   @Test    
   public void contextLoads() {   
    //System.out.println();    
      //日志的级别；        
     //由低到高  
     //trace<debug<info<warn<error     
    //可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效    
   logger.trace("这是trace日志...");       
   logger.debug("这是debug日志...");        
   //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root 级别   
   logger.info("这是info日志...");
   logger.warn("这是warn日志...");    
   logger.error("这是error日志...");    
           }
 ```
#在配置文件修改日志级别
设置log4j日志的显示级别
```properties
 logging.level.root=warn
 logging.level.org.springframework.web=debug
 logging.file=mylog.log
 ```
 
#Spring boot Admin监控
Spring Boot Admin是一个针对spring-boot的actuator接口进行UI美化封装的监控工具。
实现对多个spring boot应用进行监控，每个客户端应用可以通过HTTP或者使用Eureka注册到admin server中进行展示。

## 监控引用  admin-server：8000

1. pom.xml
```xml
   		<!--引入admin server依赖-->
   		<dependency>
   			<groupId>de.codecentric</groupId>
   			<artifactId>spring-boot-admin-server</artifactId>
   			<version>1.5.6</version>
   		</dependency>
   		<!--admin server的展示-->
   		<dependency>
   			<groupId>de.codecentric</groupId>
   			<artifactId>spring-boot-admin-server-ui</artifactId>
   			<version>1.5.6</version>
   		</dependency>
```

2. 启动类上加注解
```java
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
```

然后在浏览器上用http://localhost:8000访问

## 被监控应用 admin-client：8001

1. pom.xml
```xml
<dependency>
   <groupId>de.codecentric</groupId>
   <artifactId>spring-boot-admin-starter-client</artifactId>
   <version>1.5.6</version>
</dependency>
```

1. application.properties
```properties
spring.boot.admin.url=http://localhost:8000  
management.security.enabled=false
```

用浏览器访问 http://localhost:8001/health/ 客户端的心跳url

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-server-ui</artifactId>
</dependency>
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-server-ui-login</artifactId>
</dependency>
```



