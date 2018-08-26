package resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * Created by fxd on 2018/8/26.
 */
public class PatternResolverTest {

    public static void main(String[] args) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        try {
            Resource[] resources = resolver.getResources("classpath*:resource/**");

            for (Resource resource : resources) {
                System.out.println(resource.getDescription());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
