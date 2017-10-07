package com.jedlab.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.omidbiz.core.axon.Filter;
import org.omidbiz.core.axon.Property;
import org.omidbiz.core.axon.internal.BasicElement;
import org.omidbiz.core.axon.internal.Element;
import org.omidbiz.core.axon.internal.SerializationContext;
import org.omidbiz.core.axon.internal.TypeConverter;

import com.jedlab.model.User;

/**
 * @author omidp only serialize name and comments from user
 */
public class JedlabViewFilter extends AbstractViewFilter
{

    @Override
    public List<String> properties()
    {
        return Arrays.asList("name", "active", "expired", "expiredYesNo");
    }

    /**
     * @author omidp instead of transient / behaviour
     */
    public static class JedlabTypeConverter implements TypeConverter<User>
    {

        public boolean applies(Object instance)
        {
            return instance.getClass().equals(User.class);
        }

        public Element write(User instance, SerializationContext ctx)
        {
            if (instance.getActive() != null && instance.getActive())
                return new BasicElement("Y");
            else
                return new BasicElement("N");
        }

    }

}
