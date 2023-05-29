package com.travis.filesbottle.common.utils;

import cn.hutool.core.lang.Pair;
import com.travis.filesbottle.common.enums.BizCodeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName R
 * @Description 封装通用返回类
 * @Author travis-wei
 * @Version v1.0
 * @Data 2023/4/1
 */
@Data
@Accessors(chain = true)
public class R<T> implements Serializable {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 业务处理结果提示，用户可阅读
     */
    private String message;
    /**
     * 返回数据（常见的为String）
     */
    private T data;

    public static R success() {
        Pair<Integer, String> pair = BizCodeEnum.buildSuccessCode();
        return new R().setCode(pair.getKey()).setMessage(pair.getValue());
    }

    public static R success(String message) {
        return new R().setCode(BizCodeEnum.buildSuccessCode().getKey()).setMessage(message);
    }

    public static <T> R success(T data) {
        return R.success().setData(data);
    }
    public static <T> R success(String message, T data) {
        return new R().setCode(BizCodeEnum.buildSuccessCode().getKey()).setMessage(message).setData(data);
    }

    /**
     * @MethodName checkSuccess
     * @Description 判断是否为正确返回
     * @Author travis-wei
     * @Data 2023/4/2
     * @param r	需要判断的结果封装对象
     * @Return boolean true：200
     **/
    public static boolean checkSuccess(R r) {
        return r.getCode() % 1000 == 200;
    }

    /**
     * @MethodName error
     * @Description 异常返回1
     * @Author travis-wei
     * @Data 2023/4/2
     * @param bizCode	业务处理状态分类码，eg：404
     * @Return com.travis.filesbottle.common.utils.R
     **/
    public static R error(BizCodeEnum bizCode) {
        Pair<Integer, String> pair = BizCodeEnum.buildErrorCode(bizCode);
        return new R().setCode(pair.getKey()).setMessage(pair.getValue());
    }

    /**
     * @MethodName error
     * @Description 异常返回2
     * @Author travis-wei
     * @Data 2023/4/2
     * @param bizCode	业务处理状态分类码，eg：404
     * @param message	自定义异常消息
     * @Return com.travis.filesbottle.common.utils.R
     **/
    public static R error(BizCodeEnum bizCode, String message) {
        return new R().setCode(BizCodeEnum.buildErrorCode(bizCode).getKey()).setMessage(message);
    }

    /**
     * @MethodName error
     * @Description 异常返回3
     * @Author travis-wei
     * @Data 2023/4/2
     * @param bizCode	业务处理状态分类码，eg：404
     * @param data	返回数据
     * @Return com.travis.filesbottle.common.utils.R
     **/
    public static <T> R error(BizCodeEnum bizCode, T data) {
        Pair<Integer, String> pair = BizCodeEnum.buildErrorCode(bizCode);
        return new R().setCode(pair.getKey()).setMessage(pair.getValue()).setData(data);
    }

    /**
     * @MethodName error
     * @Description 异常返回4
     * @Author travis-wei
     * @Data 2023/4/2
     * @param bizCode   业务处理状态分类码，eg：404
     * @param data      返回数据
     * @param message   自定义异常消息
     * @Return com.travis.filesbottle.common.utils.R
     **/
    public static <T> R error(BizCodeEnum bizCode, String message, T data) {
        return new R().setCode(BizCodeEnum.buildErrorCode(bizCode).getKey()).setMessage(message).setData(data);
    }

    /**
     * @MethodName error
     * @Description 异常返回5
     * @Author travis-wei
     * @Data 2023/4/2
     * @param bizCode   业务处理状态分类码，eg：404
     * @param moudleCode	业务模块码，eg：11（网关模块）
     * @Return com.travis.filesbottle.common.utils.R
     **/
    public static R error(BizCodeEnum moudleCode, BizCodeEnum bizCode) {
        Pair<Integer, String> pair = BizCodeEnum.buildErrorCode(moudleCode, bizCode);
        return new R().setCode(pair.getKey()).setMessage(pair.getValue());
    }

    /**
     * @MethodName error
     * @Description 异常返回6
     * @Author travis-wei
     * @Data 2023/4/2
     * @param moudleCode    业务模块码，eg：11（网关模块）
     * @param message       自定义消息异常
     * @param bizCode       业务处理状态分类码，eg：404
     * @Return com.travis.filesbottle.common.utils.R
     **/
    public static R error(BizCodeEnum moudleCode, BizCodeEnum bizCode, String message) {
        return new R()
                .setCode(BizCodeEnum.buildErrorCode(moudleCode, bizCode).getKey())
                .setMessage(message);
    }


    /**
     * @MethodName error
     * @Description 异常返回7
     * @Author travis-wei
     * @Data 2023/4/2
     * @param moudleCode    业务模块码，eg：11（网关模块）
     * @param bizCode       业务处理状态分类码，eg：404
     * @param data          返回数据
     * @Return com.travis.filesbottle.common.utils.R
     **/
    public static <T> R error(BizCodeEnum moudleCode, BizCodeEnum bizCode, T data) {
        Pair<Integer, String> pair = BizCodeEnum.buildErrorCode(moudleCode, bizCode);
        return new R().setCode(pair.getKey()).setMessage(pair.getValue()).setData(data);
    }

    /**
     * @MethodName error
     * @Description 异常返回8
     * @Author travis-wei
     * @Data 2023/4/2
     * @param moudleCode	义务模块码，eg：11（网关模块）
     * @param bizCode	业务处理状态分类码，eg：404
     * @param message	自定义异常消息
     * @param data	    返回数据
     * @Return com.travis.filesbottle.common.utils.R
     **/
    public static <T> R error(BizCodeEnum moudleCode, BizCodeEnum bizCode, String message, T data) {
        return new R()
                .setCode(BizCodeEnum.buildErrorCode(moudleCode, bizCode).getKey())
                .setMessage(message)
                .setData(data);
    }
}
