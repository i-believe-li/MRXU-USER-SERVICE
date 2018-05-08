package com.mrxu.cloud.user.comm.uuid;

import java.io.Serializable;

/**
 * @author ifcousing-xujia
 * @since 2017/8/29
 */
public interface IdWorker extends Serializable {

    /**
     * 生成验证码
     * @return 验证码
     */
    String genVerifyCode();

    /**
     * 生成ID
     * @return ID
     */
    Long getNextId();

    /**
     * 当前服务时间戳
     * @return 时间戳
     */
    Long currentTimeMillis();

    /**
     * 生成ID
     * @return ID字符串
     */
    String getNextIdOfString();

}
