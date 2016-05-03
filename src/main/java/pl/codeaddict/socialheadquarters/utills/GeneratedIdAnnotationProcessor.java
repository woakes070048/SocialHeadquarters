package pl.codeaddict.socialheadquarters.utills;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * Created by Michal Kostewicz on 10.03.16.
 */
@Component
public class GeneratedIdAnnotationProcessor implements BeanPostProcessor {
    private ConfigurableListableBeanFactory configurableBeanFactory;

    @Autowired
    public GeneratedIdAnnotationProcessor(ConfigurableListableBeanFactory beanFactory) {
        this.configurableBeanFactory = beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        this.scanGeneratedIdAnnotation(bean, beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }

    protected void scanGeneratedIdAnnotation(Object bean, String beanName) {

    }

    private void configureFieldInjection(Object bean) {
        Class<?> managedBeanClass = bean.getClass();

        ReflectionUtils.FieldCallback fieldCallback =
                new GeneratedIdFieldCallback(configurableBeanFactory, bean);

        ReflectionUtils.doWithFields(managedBeanClass, fieldCallback);

    }
}