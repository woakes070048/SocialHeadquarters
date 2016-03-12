package kostek.socialheadquarters.utills;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Created by Michal Kostewicz on 10.03.16.
 */
public class GeneratedIdFieldCallback implements ReflectionUtils.FieldCallback {
    private static Logger logger = LoggerFactory.getLogger(GeneratedIdFieldCallback.class);

    @Override
    public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
    }
}
