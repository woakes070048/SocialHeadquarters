package kostek.socialheadquarters.utills;

import kostek.socialheadquarters.utills.annotations.GenerateId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * Created by Michal Kostewicz on 10.03.16.
 */
public class GeneratedIdFieldCallback implements ReflectionUtils.FieldCallback {
    private static Logger logger = LoggerFactory.getLogger(GeneratedIdFieldCallback.class);

    private ConfigurableListableBeanFactory configurableBeanFactory;
    private Object bean;

    public GeneratedIdFieldCallback(ConfigurableListableBeanFactory bf, Object bean) {
        configurableBeanFactory = bf;
        this.bean = bean;
    }
    @Override
    public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
        ReflectionUtils.makeAccessible(field);
        Type fieldGenericType = field.getGenericType();
        // In this example, get actual "GenericDAO' type.
        Class<?> generic = field.getType();
        Class<?> classValue = field.getDeclaredAnnotation(GenerateId.class).annotationType();
    }
}
