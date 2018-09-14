package jinjava;

import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.tag.Tag;
import com.hubspot.jinjava.tree.TagNode;

/**
 * Created by fxd on 2018/9/12.
 */
public class TimestampTag implements Tag
{
    @Override
    public String getName() { return "timestamp"; }

    @Override
    public String getEndTagName() { return null; }

    @Override
    public String interpret(TagNode tagNode, JinjavaInterpreter interpreter)
    {
        return String.valueOf(System.currentTimeMillis());
    }
}