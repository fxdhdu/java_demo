package jinjava;

import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.filter.Filter;

/**
 *
 * Created by fxd on 2018/9/12.
 */
public class ConcatFilter implements Filter {

    @Override
    public String getName() { return "concat"; }

    @Override
    public Object filter(Object var, JinjavaInterpreter interpreter, String... args)
    {
        String addend = args[0];
        return var.toString() + addend;
    }
}
