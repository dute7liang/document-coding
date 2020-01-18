package com.duteliang.webbase.imp;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: zl
 * @Date: 2020/1/18 15:51
 */
public class TestImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{TestBean.class.getName()};
    }
}
