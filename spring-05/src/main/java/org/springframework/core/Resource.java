package org.springframework.core;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author jiezhou
 */
public interface Resource {
    /**
     * 获取文件信息
     *
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
