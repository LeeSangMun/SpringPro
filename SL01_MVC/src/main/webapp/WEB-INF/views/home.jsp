<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  - ${name }
</h1>

<P>  The time on the server is ${serverTime}. ${formattedDate } </P>

<h3><a href="/scott/dept">dept</a></h3>

<!-- 

11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 서버 버전 이름:    Apache Tomcat/8.5.93
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: Server 빌드 시각:  Aug 23 2023 22:43:14 UTC
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: Server 버전 번호:  8.5.93.0
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 운영체제 이름:     Windows 10
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 운영체제 버전:     10.0
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 아키텍처:          amd64
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 자바 홈:           C:\Program Files\Java\jdk-11
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: JVM 버전:          11.0.19+9-LTS-224
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: JVM 벤더:          Oracle Corporation
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: CATALINA_BASE:     E:\Class\Workspace\SpringClass\.metadata\.plugins\org.eclipse.wst.server.core\tmp0
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: CATALINA_HOME:     C:\apache-tomcat-8.5.93
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  -Dcatalina.base=E:\Class\Workspace\SpringClass\.metadata\.plugins\org.eclipse.wst.server.core\tmp0
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  -Dcatalina.home=C:\apache-tomcat-8.5.93
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  -Dwtp.deploy=E:\Class\Workspace\SpringClass\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  --add-opens=java.base/java.lang=ALL-UNNAMED
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  --add-opens=java.base/java.io=ALL-UNNAMED
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  --add-opens=java.base/java.util=ALL-UNNAMED
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  --add-opens=java.base/java.util.concurrent=ALL-UNNAMED
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  --add-opens=java.rmi/sun.rmi.transport=ALL-UNNAMED
11월 22, 2023 4:20:08 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  -Dfile.encoding=UTF-8
11월 22, 2023 4:20:08 오후 org.apache.catalina.core.AprLifecycleListener lifecycleEvent
INFO: 프로덕션 환경들에서 최적의 성능을 제공하는, APR 기반 Apache Tomcat Native 라이브러리가, 다음 java.library.path에서 발견되지 않습니다: [C:\Program Files\Java\jdk-11\bin;C:\WINDOWS\Sun\Java\bin;C:\WINDOWS\system32;C:\WINDOWS;C:/Program Files/Java/jdk-11/bin/server;C:/Program Files/Java/jdk-11/bin;C:\Program Files\Java\jdk-11\bin;C:\oraclexe\app\oracle\product\11.2.0\server\bin;C:\Program Files\Common Files\Oracle\Java\javapath;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\iCLS\;C:\Program Files\Intel\Intel(R) Management Engine Components\iCLS\;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\WINDOWS\System32\OpenSSH\;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files\Bandizip\;C:\Program Files\Git\cmd;C:\apache-tomcat-8.5.93bin;C:\Users\user\AppData\Local\Microsoft\WindowsApps;;C:\Users\user\AppData\Local\Programs\Microsoft VS Code\bin;C:\spring-tool-suite-3.9.18.RELEASE-e4.21.0-win32-x86_64\sts-bundle\sts-3.9.18.RELEASE;;.]
11월 22, 2023 4:20:08 오후 org.apache.coyote.AbstractProtocol init
INFO: 프로토콜 핸들러 ["http-nio-80"]을(를) 초기화합니다.
11월 22, 2023 4:20:09 오후 org.apache.catalina.startup.Catalina load
INFO: Initialization processed in 584 ms
11월 22, 2023 4:20:09 오후 org.apache.catalina.core.StandardService startInternal
INFO: 서비스 [Catalina]을(를) 시작합니다.
11월 22, 2023 4:20:09 오후 org.apache.catalina.core.StandardEngine startInternal
INFO: 서버 엔진을 시작합니다: [Apache Tomcat/8.5.93]
11월 22, 2023 4:20:09 오후 org.apache.jasper.servlet.TldScanner scanJars
INFO: 적어도 하나의 JAR가 TLD들을 찾기 위해 스캔되었으나 아무 것도 찾지 못했습니다. 스캔했으나 TLD가 없는 JAR들의 전체 목록을 보시려면, 로그 레벨을 디버그 레벨로 설정하십시오. 스캔 과정에서 불필요한 JAR들을 건너뛰면, 시스템 시작 시간과 JSP 컴파일 시간을 단축시킬 수 있습니다.
11월 22, 2023 4:20:09 오후 org.apache.catalina.core.ApplicationContext log
INFO: No Spring WebApplicationInitializer types detected on classpath
11월 22, 2023 4:20:10 오후 org.apache.catalina.core.ApplicationContext log
INFO: Initializing Spring root WebApplicationContext
INFO : org.springframework.web.context.ContextLoader - Root WebApplicationContext: initialization started
INFO : org.springframework.web.context.support.XmlWebApplicationContext - Refreshing Root WebApplicationContext: startup date [Wed Nov 22 16:20:10 KST 2023]; root of context hierarchy
INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from ServletContext resource [/WEB-INF/spring/root-context.xml]
INFO : org.springframework.beans.factory.support.DefaultListableBeanFactory - Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2e29dbd1: defining beans []; root of factory hierarchy
INFO : org.springframework.web.context.ContextLoader - Root WebApplicationContext: initialization completed in 679 ms
11월 22, 2023 4:20:10 오후 org.apache.catalina.core.ApplicationContext log
INFO: Initializing Spring FrameworkServlet 'appServlet'
INFO : org.springframework.web.servlet.DispatcherServlet - FrameworkServlet 'appServlet': initialization started
INFO : org.springframework.web.context.support.XmlWebApplicationContext - Refreshing WebApplicationContext for namespace 'appServlet-servlet': startup date [Wed Nov 22 16:20:10 KST 2023]; parent: Root WebApplicationContext
INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from ServletContext resource [/WEB-INF/spring/appServlet/servlet-context.xml]
INFO : org.springframework.context.annotation.ClassPathBeanDefinitionScanner - JSR-250 'javax.annotation.ManagedBean' found and supported for component scanning
INFO : org.springframework.context.annotation.ClassPathBeanDefinitionScanner - JSR-330 'javax.inject.Named' annotation found and supported for component scanning
INFO : org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor - JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
INFO : org.springframework.beans.factory.support.DefaultListableBeanFactory - Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@32370bbd: defining beans [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping#0,org.springframework.format.support.FormattingConversionServiceFactoryBean#0,org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter#0,org.springframework.web.servlet.handler.MappedInterceptor#0,org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver#0,org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver#0,org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver#0,org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping,org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter,org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter,org.springframework.web.servlet.resource.ResourceHttpRequestHandler#0,org.springframework.web.servlet.handler.SimpleUrlHandlerMapping#0,org.springframework.web.servlet.view.InternalResourceViewResolver#0,homeController,org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.annotation.ConfigurationClassPostProcessor$ImportAwareBeanPostProcessor#0]; parent: org.springframework.beans.factory.support.DefaultListableBeanFactory@2e29dbd1
INFO : org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping - Mapped "{[/],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String org.doit.ik.HomeController.home(java.util.Locale,org.springframework.ui.Model)
INFO : org.springframework.web.servlet.handler.SimpleUrlHandlerMapping - Mapped URL path [/resources/**] onto handler 'org.springframework.web.servlet.resource.ResourceHttpRequestHandler#0'
INFO : org.springframework.web.servlet.DispatcherServlet - FrameworkServlet 'appServlet': initialization completed in 816 ms
11월 22, 2023 4:20:11 오후 org.apache.coyote.AbstractProtocol start
INFO: 프로토콜 핸들러 ["http-nio-80"]을(를) 시작합니다.
11월 22, 2023 4:20:11 오후 org.apache.catalina.startup.Catalina start
INFO: Server startup in 2657 ms
INFO : org.doit.ik.HomeController - Welcome home! The client locale is ko_KR.
INFO : org.doit.ik.HomeController - Welcome home! The client locale is ko_KR.


 -->
</body>
</html>
