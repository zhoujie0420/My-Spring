package org.springframework.core;

import cn.hutool.core.lang.Assert;
import org.springframework.utils.ClassUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author jiezhou
 */
public class ClassPathResource implements Resource {

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }


    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new IOException("Could not get InputStream for " + path);
        }
        return is;
    }
}
