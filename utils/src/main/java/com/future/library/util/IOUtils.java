package com.future.library.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see IOUtils
 * @since 2017/5/19
 */

public class IOUtils {

    public static void close(Closeable... closeables) {
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
