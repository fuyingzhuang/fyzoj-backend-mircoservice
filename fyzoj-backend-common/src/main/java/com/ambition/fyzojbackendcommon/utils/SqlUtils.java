package com.ambition.fyzojbackendcommon.utils;


import org.apache.commons.lang3.StringUtils;

/**
 * SQL 工具
 *
 * @author ambition
 */
public class SqlUtils {

    /**
     * 校验排序字段是否合法（防止 SQL 注入）
     *
     * @param sortField 排序字段
     * @return true 合法，false 非法
     */
    public static boolean validSortField(String sortField) {
        if (StringUtils.isBlank(sortField)) {
            return false;
        }
        return !StringUtils.containsAny(sortField, "=", "(", ")", " ");
    }
}
