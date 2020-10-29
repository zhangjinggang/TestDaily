//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zjg.test.remote.core;

import com.zjg.test.remote.core.annotation.RemoteCallScan;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
  * @description: ImportBeanDefinitionRegistrar在ConfigurationClassPostProcessor
  * 处理Configuration类期间被调用，用来生成该Configuration类所需要的BeanDefinition。
  * 而ConfigurationClassPostProcessor正实现了BeanDefinitionRegistryPostProcessor接口
 *
 * spring启动我们自定义注册的入口
  * @author zjg
  * @date 2020/6/28 19:06
  */
public class RemoteCallPackageRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {
    public RemoteCallPackageRegistrar() {
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
    }

    /**
     * AnnotationMetadata 表示当前被@Import注解给标注的所有注解信息
     * 主要就是向spring中注入了一个RemoteCallScannerConfigurer的beanDefinition，对象名可以自己命名，
     * 在后面RemoteCallScannerConfigurer类执行初始化的时候用到，主要是解析占位符
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annAttrs = AnnotationAttributes.fromMap(importingClassMetadata
                .getAnnotationAttributes(RemoteCallScan.class.getName()));
        if (null != annAttrs) {
            this.registerBeanDefinitions(annAttrs, registry, generateBaseBeanName(importingClassMetadata, 0));
        }
    }

    void registerBeanDefinitions(AnnotationAttributes annAttrs, BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(RemoteCallScannerConfigurer.class);
        builder.addPropertyValue("processPropertyPlaceHolders", true);
        List<String> basePackages = new ArrayList();
        basePackages.addAll((Collection)Arrays.stream(annAttrs.getStringArray("value"))
                .filter(StringUtils::hasText).collect(Collectors.toList()));
        basePackages.addAll((Collection)Arrays.stream(annAttrs.getStringArray("basePackages"))
                .filter(StringUtils::hasText).collect(Collectors.toList()));
        //Comma Delimited逗号分隔
        builder.addPropertyValue("basePackage", StringUtils.collectionToCommaDelimitedString(basePackages));
        registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
    }

    private static String generateBaseBeanName(AnnotationMetadata importingClassMetadata, int index) {
        String str = importingClassMetadata.getClassName() + "#" + RemoteCallScannerConfigurer.class.getSimpleName() + "#" + index;
        return str;
    }

}
