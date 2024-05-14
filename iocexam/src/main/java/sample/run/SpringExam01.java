package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sample.bean.MyBean;
import sample.config.MyBeanConfig;

public class SpringExam01 {
    public static void main(String[] args) {
        //직접 사용하는 경우!!
        //MyBean bean = new MyBean();
        //bean.setName("kang");
        //
        //System.out.println(bean);

        //스프링  ioc container를 이용해서 사용하는 경우
        //스프링 컨테이너에게 알려줘야하지 않을까요??
        //1. 애노테이션으로 알려줌.   --  컴포넌트 스캔 하도록!!
        //2. 자바파일을 통해서 알려줌

        // BeanFactory  -- 빈을 생성하는데 간단한 기능만 포함하고있어요.   aop 기술은 사용할 수 없어요!!
        System.out.println("ApplicationContext 생성전!!");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class); //공장이 생성될때 어떤 빈을 생성해야할지 알아야함.
        System.out.println("ApplicationContext 생성후!");
        MyBean bean1 = (MyBean)context.getBean("myBean");  //lookup  방식..   id를 알려줌.

        bean1.setName("carami");

        System.out.println(bean1);

        //MyBean bean2 = context.getBean(MyBean.class);  // 타입만 알려줌.  -- 해당 타입의 객체가 하나만 존재할 때는 오류가 없다.
        // 그러나 2 개 이상일 때는...  ㅠㅠ

        MyBean bean2 = context.getBean("myBean2",MyBean.class);

        bean2.setName("kim");
        System.out.println(bean2);
        System.out.println(bean1);

        if(bean2 == bean1)
            System.out.println("같아요.");
        else System.out.println("bean1과 bean2는 다른 인스턴스입니다.");


        MyBean bean3 = context.getBean("myBean", MyBean.class);

        if(bean3 == bean1)
            System.out.println("bean3과 bean1은 같은 인스턴스입니다.");


        MyBean bean4 = context.getBean("myBean", MyBean.class);
        bean4.setName("hong");

        MyBean bean5 = context.getBean("myBean", MyBean.class);
        bean5.setName("lee");


        System.out.println(bean4);
        System.out.println(bean5);

        MyBean bean6 = context.getBean("myBean",MyBean.class);
        System.out.println(bean6);

        // 3. xml을 통해서 알려줌. <-- 현재는 선호하지 않음
        /*
        <!-- applicationContext.xml -->
        <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

        <!-- Bean 정의 -->
        <bean id="myBean" class="sample.bean.MyBean">
            <!-- 프로퍼티 설정 -->
            <property name = "name" value = "hyoseung" />
            <property name = "count" value = "10">
        </beans>
         */
    }
}

/*
    ApplicationContext는 스프링 프레임워크에서 제공하는 인터페이스로, 스프링 애플리케이션의 컨테이너를 나타냅니다. 스프링 애플리케이션의 객체를 생성하고 관리하는데 사용됩니다.
    일반적으로 ApplicationContext는 XML 파일이나 Java 설정 클래스를 기반으로 생성되며, 스프링 컨테이너가 초기화될 때 애플리케이션의 빈(Bean)들을 로드하고 관리합니다.
    이 빈들은 스프링 컨테이너에서 제어되며, 필요할 때 주입(Dependency Injection)됩니다.

    ApplicationContext는 다양한 기능을 제공합니다:
    빈 관리: ApplicationContext는 애플리케이션의 빈을 생성하고 관리합니다. 빈은 일반적으로 스프링에서 관리되는 객체를 나타냅니다.
    의존성 주입(DI): ApplicationContext는 빈들 간의 의존성을 주입합니다. 즉, 한 빈이 다른 빈을 필요로 할 때, ApplicationContext가 이를 해결하여 필요한 의존성을 주입합니다.
    라이프사이클 관리: ApplicationContext는 빈의 라이프사이클을 관리합니다. 빈의 초기화와 소멸을 제어하며, 빈이 생성되고 제거될 때 적절한 라이프사이클 이벤트를 발생시킵니다.
    리소스 로딩: ApplicationContext는 애플리케이션에서 사용하는 리소스를 로딩하고 관리합니다. 이는 클래스 경로 내의 파일, 외부 파일 시스템, 웹 URL 등 다양한 소스에서 리소스를 로드할 수 있습니다.
    국제화 및 로컬화: ApplicationContext는 국제화 및 로컬화를 지원합니다. 메시지 리소스 번들, 포맷팅 및 날짜 형식 설정 등의 기능을 제공합니다.
    이벤트 발행/구독: ApplicationContext는 이벤트 발행 및 구독을 지원합니다. 애플리케이션 내에서 이벤트를 발행하고, 해당 이벤트를 수신하여 처리할 수 있습니다.
    ApplicationContext는 BeanFactory 인터페이스를 확장하여 구현되었기 때문에 모든 BeanFactory의 기능을 포함하고 있습니다.
    또한, ApplicationContext는 BeanFactory보다 더 많은 기능을 제공하므로 일반적으로 스프링 애플리케이션에서는 ApplicationContext를 사용하는 것이 좋습니다.
 */