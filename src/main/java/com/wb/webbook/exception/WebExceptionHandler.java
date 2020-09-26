package com.wb.webbook.exception;

import com.wb.enums.ResultCode;
import com.wb.model.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class WebExceptionHandler {


    /**
     * @apiDefine returnSuccess
     * @apiSuccess {int} code 错误码
     * @apiSuccess {String} massage 信息
     * @apiSuccess {String} [data] 内容
     */

    /**
     * @apiDefine pageParam
     * @apiParam {int} pageSize 每页条数
     * @apiParam {int} pageNum 页数
     * @apiParam {String} [lastId] 该页最后一条的id,首页为空
     */



    /**
     * @apiDefine bindException
     * @apiError bindException bindException.
     * @apiErrorExample Error-Response:
     * {
     *     "code": 10001,
     *     "message": "参数不为空"
     * }
     */
    @ExceptionHandler(value={ParamNotNullException.class})
    @ResponseBody
    public ResultBean nullPointerException(ParamNotNullException e) {
        log.error("nullPointerException", e);
        return ResultBean.error(ResultCode.NOT_NULL,e.getMessage());
    }

    /**
     * @apiDefine illegalArgumentException
     * @apiError illegalArgumentException 参数不合法
     * @apiErrorExample Error-Response:
     * {
     *     "code": 10002,
     *     "message": "参数不合法"
     * }
     */
    @ExceptionHandler(value={IllegalArgumentException.class})
    @ResponseBody
    public ResultBean illegalArgumentException(IllegalArgumentException e) {
        log.error("illegalArgumentException", e);
        return ResultBean.error(ResultCode.PARAM_ILLEGAL,e.getMessage());
    }

    /**
     * @apiDefine unknownError
     * @apiError unknownError 请联系管理员
     * @apiErrorExample Error-Response:
     * {
     *     "code": 500,
     *     "message": "UnknownError"
     * }
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public final ResultBean handleAllExceptions(Exception e) {
        return ResultBean.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

}
