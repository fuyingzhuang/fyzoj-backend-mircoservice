package com.ambition.fyzojbackendcommon.utils;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

/**
 * @author Ambition
 * @date 2023/12/4 11:30
 */
@Component
public class GsonUtils {

    //    使用单例模式创建Gson对象
    private static volatile Gson gson;

    /**
     * 私有化构造方法 防止外部创建对象
     */
    private GsonUtils() {
    }

    /**
     * 获取Gson对象
     *
     * @return Gson对象
     * 双层检测锁 保证线程安全
     */
    public static Gson getGson() {
        if (gson == null) {
            synchronized (GsonUtils.class) {
                if (gson == null) {
                    gson = new Gson();
                }
            }
        }
        return gson;
    }

}
