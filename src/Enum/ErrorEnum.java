package Enum;

/**
 * @author Synear
 * @version 1.0
 * @date 2021/11/26
 * @description: 异常枚举
 */

public enum ErrorEnum implements IBaseEnum<String>{

    FAIL("0", "请求失败"),
    SUCCESS("1", "请求成功"),


    /* 服务器常规状态码 */
    HTTP_SUCCESS("200", "请求成功"),
    HTTP_CREATED("201", "创建成功"),
    HTTP_NOT_SUPPORT("400", "参数校验出错！"),
    HTTP_NOT_AUTH("401", "没有登录"),
    HTTP_NOT_FOUND("404", "信息不存在"),
    HTTP_NO_PERMISSION("403", "没有权限"),
    HTTP_SERVER_EOR("500", "出错了"),
    EXPORT_DATA_OUT_THRESHOLD("555", "数据量过大, 无法导出!"),
    EXPORT_DATA_IS_EMPTY("554", "数据为空,无法导出!"),
    IMPORT_PARAM_CHECK_FAIL("660", "导入参数校验错误，存在未填字段！"),
    IMPORT_PARAM_ERROR("666", "导入数据格式有误！请核实"),
    EXISTS_KNOWLEDGE_ERROR("669", "知识库名称重复！"),
    WTKRULE_PARAM_ERROR("667", "问题库规则名称重复！"),
    FIRERULE_PARAM_ERROR("668", "异常库规则名称重复！"),
    DB_OPERATE_ERROR("556", "数据库操作异常！"),
    IS_RELATED_TASK("700", "规则已关联任务，请先修改对应任务的关联规则信息！"),
    MONITOR_TASK_IS_RUNNING_ERROR("557", "该规则的监测任务正在执行中，请先停止监测任务！"),
    COMPLIANCE_TASK_IS_RUNNING_ERROR("558", "该规则的合规任务正在执行中，请先停止合规任务！"),
    DATA_BEING_USING("559", "数据正在被使用，无法删除！"),
    AUDIT_NODE_ERROR("701", "审核节点出现异常！"),
    ;

    ErrorEnum(String errCode, String errMsg) {
        initEnum(errCode, errMsg);
    }


    public static String getNameForValue(String v) {
        ErrorEnum[] values = ErrorEnum.values();
        ErrorEnum enumValue = null;

        for (ErrorEnum value :
                values) {
            enumValue = value;
            if (enumValue.getMessage().equals(v)) {
                return value.name();
            }
        }
        return String.valueOf(enumValue);
    }


}
