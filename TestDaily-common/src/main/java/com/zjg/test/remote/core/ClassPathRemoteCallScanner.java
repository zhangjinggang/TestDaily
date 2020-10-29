//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zjg.test.remote.core;

import com.zjg.test.remote.core.annotation.RemoteServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
  * @description: remote接口的路径扫描
  * @author zjg
  * @date 2020/5/2 17:33
  */
@Slf4j
public class ClassPathRemoteCallScanner extends ClassPathBeanDefinitionScanner implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    private Class<? extends RemoteFactoryBean> remoteFactoryBeanClass = RemoteFactoryBean.class;

    /**
     * 对标注SqLiteMapper注解的类生成的BeanDefinition进行修改，转为代理类
     * @param basePackages
     * @return
     */
    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);

        if (beanDefinitions.isEmpty()) {

            log.warn("No RemoteCall interface was found in '{}' package. Please check your configuration.",
                    Arrays.toString(basePackages));
            return beanDefinitions;
        } else {
            Iterator var3 = beanDefinitions.iterator();
            while(var3.hasNext()) {
                BeanDefinitionHolder holder = (BeanDefinitionHolder)var3.next();
                GenericBeanDefinition definition = (GenericBeanDefinition)holder.getBeanDefinition();
                AnnotatedBeanDefinition annotatedBeanDefinition = (AnnotatedBeanDefinition)definition;
                AnnotationMetadata metadata = annotatedBeanDefinition.getMetadata();
                this.processBeanDefinitions(definition, metadata);
                log.debug("Creating RemoteCallFactoryBean with name '{}' and '{}' RemoteCall Interface",
                        holder.getBeanName(), definition.getBeanClassName());
            }
            return beanDefinitions;
        }
    }

    private void processBeanDefinitions(GenericBeanDefinition definition, AnnotationMetadata metadata) {
        String beanClassName = definition.getBeanClassName();
        if (!StringUtils.isEmpty(beanClassName)) {
            definition.setBeanClass(this.remoteFactoryBeanClass);
            //创建FactoryBean需要在构造方法中指定class参数
            definition.getConstructorArgumentValues().addGenericArgumentValue(beanClassName);
            Map<String, Object> attributesMap = metadata.getAnnotationAttributes(RemoteServer.class.getName());
            if (!CollectionUtils.isEmpty(attributesMap) && null != attributesMap.get("serverName")) {
                String remoteServerName = String.valueOf(attributesMap.get("serverName"));
                if (!StringUtils.isEmpty(remoteServerName)) {
                    //指定MapperFactoryBean的remoteServerName属性值
                    definition.getPropertyValues().add("remoteServerName", remoteServerName);
                }

            }
        }
    }

    /**
     * 指定扫描RemoteServer注解的接口
     * @param beanDefinition
     * @return
     */
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        AnnotationMetadata metadata = beanDefinition.getMetadata();
        boolean hasAnnotation = metadata.hasAnnotation(RemoteServer.class.getName());
        //isIndependent()  top level class or nested class (静态内部类)
        //指定是接口
        return hasAnnotation && beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent();
    }

    public ClassPathRemoteCallScanner(BeanDefinitionRegistry registry) {
        super(registry, true);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void registerFilters() {

        this.addIncludeFilter(new AnnotationTypeFilter(RemoteServer.class));

    }

}
