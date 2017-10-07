package com.jedlab.view;

import java.util.List;

import org.omidbiz.core.axon.Filter;
import org.omidbiz.core.axon.Property;
import org.omidbiz.core.axon.internal.SerializationContext;

/**
 * @author omidp
 *
 */
public abstract class AbstractViewFilter implements Filter
{

    public void beforeFilter(SerializationContext ctx)
    {
        
    }

    public boolean exclude(String path, Object target, Property property, Object propertyValue)
    {
        return !properties().contains(property.getName());
    }

    public void afterFilter()
    {
        
    }
    
    public abstract List<String> properties();

}
