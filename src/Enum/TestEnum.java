package Enum;

public enum TestEnum implements IBaseEnum<Integer> {

    FAIL(0, "请求失败"),
    SUCCESS(1, "请求成功"),


    /* 服务器常规状态码 */
    HTTP_SUCCESS(200, "请求成功"),
    ;

    TestEnum(int code, String msg) {
        initEnum(code, msg);
    }
}
