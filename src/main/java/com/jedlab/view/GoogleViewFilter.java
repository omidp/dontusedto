package com.jedlab.view;

import java.util.ArrayList;
import java.util.List;

import org.omidbiz.core.axon.Filter;
import org.omidbiz.core.axon.Property;
import org.omidbiz.core.axon.internal.SerializationContext;

/**
 * @author omidp only serialize name and profile from user
 */
public class GoogleViewFilter extends AbstractViewFilter
{

    static List<String> properties;

    static
    {
        properties = new ArrayList<String>();
        properties.add("name");
        properties.add("profile");
        properties.add("age");
    }

    @Override
    public List<String> properties()
    {
        return properties;
    }

}
