//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zjg.test.remote.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;


/**
  * @description: BeanDefinitionRegistry的后处理器  用来注册额外的BeanDefinition
 * 经常被用来注册BeanFactoryPostProcessor的BeanDefinition。
  * @author zjg
  * @date 2020/5/2 19:03
  */
    public class RemoteCallScannerConfigurer implements BeanDefinitionRegistryPostProcessor, InitializingBean,
        ApplicationContextAware, BeanNameAware {
    private String beanName;
    private String basePackage;
    private ApplicationContext applicationContext;
    private boolean processPropertyPlaceHolders;

    public RemoteCallScannerConfigurer() {
    }

    @Override
    public void setBeanName(String name) {
        /**
         * RemoteCallPackageRegistrar中generateBaseBeanName生成的beanName
         */
        this.beanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.basePackage, "Property 'basePackage' is required");
    }

    /**
     * 方法会在所有的BeanDefinition已经被加载了，但是所有的Bean还没有被创建前调用
     * @param beanDefinitionRegistry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        if (this.processPropertyPlaceHolders) {
            /**
             * spring启动容器时，执行的顺序是先执行所有的BeanDefinitionRegistryPostProcessor，
             * 再执行BeanFactoryPostProcessor中的postProcessBeanFactory，在里面会有占位符的替换
             * 所以这里在执行扫描接口时，引用的占位符还没有解析替换成相应的properties中的值
             */
            this.processPropertyPlaceHolders();
        }

        ClassPathRemoteCallScanner scanner = new ClassPathRemoteCallScanner(beanDefinitionRegistry);
        scanner.setResourceLoader(this.applicationContext);
        scanner.registerFilters();
        scanner.scan(StringUtils.tokenizeToStringArray(this.basePackage, ",; \t\n"));
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    private void processPropertyPlaceHolders() {
        Map<String, PropertyResourceConfigurer> prcs = this.applicationContext.getBeansOfType(PropertyResourceConfigurer.class);
        if (!prcs.isEmpty() && this.applicationContext instanceof ConfigurableApplicationContext) {
            BeanDefinition mapperScannerBean = ((ConfigurableApplicationContext)this.applicationContext).getBeanFactory()
                    .getBeanDefinition(this.beanName);
            DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
            factory.registerBeanDefinition(this.beanName, mapperScannerBean);
            Iterator var4 = prcs.values().iterator();

            while(var4.hasNext()) {
                PropertyResourceConfigurer prc = (PropertyResourceConfigurer)var4.next();
                prc.postProcessBeanFactory(factory);
            }

            PropertyValues values = mapperScannerBean.getPropertyValues();
            this.basePackage = this.updatePropertyValue("basePackage", values);
        }

        Optional var10001 = Optional.ofNullable(this.basePackage);
        Environment var10002 = this.getEnvironment();
        var10002.getClass();
        this.basePackage = (String)var10001.map(str -> var10002.resolvePlaceholders((String) str)).orElse((Object)null);
    }

    private String updatePropertyValue(String propertyName, PropertyValues values) {
        PropertyValue property = values.getPropertyValue(propertyName);
        if (property == null) {
            return null;
        } else {
            Object value = property.getValue();
            if (value == null) {
                return null;
            } else if (value instanceof String) {
                return value.toString();
            } else {
                return value instanceof TypedStringValue ? ((TypedStringValue)value).getValue() : null;
            }
        }
    }

    private Environment getEnvironment() {
        return this.applicationContext.getEnvironment();
    }

    public String getBasePackage() {
        return this.basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
    public boolean isProcessPropertyPlaceHolders() {
        return this.processPropertyPlaceHolders;
    }

    public void setProcessPropertyPlaceHolders(boolean processPropertyPlaceHolders) {
        this.processPropertyPlaceHolders = processPropertyPlaceHolders;
    }
}
