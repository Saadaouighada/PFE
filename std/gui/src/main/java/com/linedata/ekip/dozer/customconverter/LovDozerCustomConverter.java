
package com.linedata.ekip.dozer.customconverter;

import com.linedata.ekip.core.shared.data.Data;
import org.dozer.ConfigurableCustomConverter;
import org.dozer.MappingException;


/**
 *  @author GSouelmi 
 *  Generated Tue Apr 07 18:45:57 GMT 2020
 * 
 */
public class LovDozerCustomConverter
    implements ConfigurableCustomConverter
{

    private String valueField;

    @Override
    public Object convert(Object destinationFieldValue, Object sourceFieldValue, java.lang.Class<?>destinationClass, java.lang.Class<?>sourceClass) {
        if (sourceFieldValue == null) {
            return null;
        } else {
            if (sourceFieldValue instanceof String) {
                return sourceFieldValue.toString();
            }
            if (sourceFieldValue instanceof Data) {
                return ((Data) sourceFieldValue).get(valueField);
            }
            throw new MappingException(("Converter LovDozerCustomConverter used incorrectly. Arguments passed in were:" +destinationClass+ " and " +sourceClass));
        }
    }

    @Override
    public void setParameter(String parameter) {
        valueField = parameter;
    }

}
