package jinjava;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;

import java.io.IOException;
import java.util.Map;

/**
 * Created by fxd on 2018/9/12.
 */
public class ExampleUsage {

    public static void main(String[] args) {
        Jinjava jinjava = new Jinjava();
        jinjava.getGlobalContext().registerTag(new TimestampTag());
        jinjava.getGlobalContext().registerFilter(new ConcatFilter());
        Map<String, Object> context = Maps.newHashMap();
        context.put("name", "Jared");

        try {
            String[] templates = {Resources.toString(Resources.getResource("test.yaml"), Charsets.UTF_8),
                    "haha {{name}}",
                    "haha {{ name }}",
                    // UnknownTagException
                    "{% timestamp %}",
                    "{{ my_val | concat | split(',') }}"};


            for (int i = 0; i < templates.length; i++) {
                System.out.println(templates[i]);
                String renderedTemplate = jinjava.render(templates[i], context);
                System.out.println(renderedTemplate);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
