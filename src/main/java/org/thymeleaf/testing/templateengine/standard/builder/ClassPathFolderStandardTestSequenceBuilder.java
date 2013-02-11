/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2012, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.testing.templateengine.standard.builder;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.thymeleaf.util.ClassLoaderUtils;
import org.thymeleaf.util.Validate;





public class ClassPathFolderStandardTestSequenceBuilder extends LocalFolderStandardTestSequenceBuilder {
    
    
    public ClassPathFolderStandardTestSequenceBuilder(final String classPathFolderName, final boolean recursive, final String fileNameSuffix) {
        super(resolveFile(classPathFolderName), recursive, fileNameSuffix);
    }


    private static final File resolveFile(final String classPathFolderName) {
        Validate.notNull(classPathFolderName, "ClassPath folder name cannot be null");
        final ClassLoader cl = ClassLoaderUtils.getClassLoader(ClassPathFolderStandardTestSequenceBuilder.class);
        final URL url = cl.getResource(classPathFolderName);
        try {
            return new File(url.toURI());
        } catch (final URISyntaxException e) {
            throw new IllegalArgumentException(
                    "ClassPath folder name resulted in an unusable URL: \"" + url + "\"", e);
        }
    }
    
    
}