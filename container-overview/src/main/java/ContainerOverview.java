import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author xiantao.xiang
 */
public class ContainerOverview {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ContainerOverview.class);
        Service ser = annotationConfigApplicationContext.getBean(Service.class);
        System.out.println(ser);
    }

    @Bean
    public Service service() {
        return new Service("simple");
    }

}

class Service {
    private String name;

    public Service(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                '}';
    }
}
