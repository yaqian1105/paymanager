package com.qiyu.data;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by liuhui on 2016/4/15.
 */
public class BeanMapper {

    private static MapperFactory mapperFactory ;

    private static DefaultMapperFactory.Builder builder;

    static {
        builder = new DefaultMapperFactory.Builder();
        mapperFactory = builder.mapNulls(false).build();
    }

    private BeanMapper(){}

    public static MapperFacade getMapperFacade() {
        return mapperFactory.getMapperFacade();
    }

    public static DefaultMapperFactory.Builder getBuilder() {
        return builder;
    }

}
