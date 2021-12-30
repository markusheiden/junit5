/*
 * Copyright 2015-2021 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.api.extension;

/**
 * {@code TestInstanceFactory} defines the API for {@link Extension
 * Extensions} that wish to {@linkplain #loadTestClass(Class) load} test classes.
 *
 * <p>Common use cases include loading test classes with a special {@link ClassLoader}.
 *
 * <p>Extensions that implement {@code TestClassLoader} must be registered
 * at the class level.
 *
 * <h3>Warning</h3>
 *
 * <p>Only one {@code TestClassLoader} is allowed to be registered for any
 * given test class. Registering multiple factories for any single test class
 * will result in an exception being thrown for all tests in that class, in any
 * subclass, and in any nested class. Note that any {@code TestClassLoader}
 * registered in a {@linkplain Class#getSuperclass() superclass} or
 * {@linkplain Class#getEnclosingClass() enclosing} class (i.e., in the case of
 * a {@code @Nested} test class) is <em>inherited</em>. It is therefore the
 * user's responsibility to ensure that only a single {@code TestClassLoader}
 * is registered for any specific test class.
 *
 * <h3>Constructor Requirements</h3>
 *
 * <p>Consult the documentation in {@link Extension} for details on
 * constructor requirements.
 *
 * @since 5.9
 * @see #loadTestClass(Class)
 */
public interface TestClassLoader extends Extension {

	/**
	 * Callback for creating a test class.
	 *
	 * @param testClass the test classes loaded with the default class loader;
	 * never {@code null}
	 * @return the test class; never {@code null}
	 * @throws TestInstantiationException if an error occurs while loading the
	 * test class
	 */
	Class<?> loadTestClass(Class<?> testClass) throws TestInstantiationException;

}
