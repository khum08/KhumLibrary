package com.khum.lib.global.dagger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Scope;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/9
 *     desc   : fragment使用
 * </pre>
 */
@Scope
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScope {
}
