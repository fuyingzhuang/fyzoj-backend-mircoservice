package com.ambition.fyzojbackendserviceclient.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 付英壮
 * @date 2021/11/16 19:50
 */
public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
