package Enum;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public interface IBaseEnum<T> {

    default void initEnum(T code, String msg) {
        EnumContainer.putEnum(this, code, msg);
    }

    default T getCode() {
        return EnumContainer.getEnum(this).getCode();
    }

    default String getMessage() {
        return EnumContainer.getEnum(this).getText();
    }

    /**
     * 通过code获取枚举实例
     */
    @SuppressWarnings("unchecked")
    static <T, R extends IBaseEnum<T>> R getByCode(Class<? extends IBaseEnum<T>> clazz, T code) {
        IBaseEnum<T>[] enumConstants = clazz.getEnumConstants();
        return Stream.of(clazz.getEnumConstants())
                .filter(f -> f.getCode().equals(code))
                .map(v -> (R) v)
                .findAny()
                .orElse(null);
    }


    class EnumContainer {

        private static final Map<IBaseEnum, EnumBean> ENUM_MAP = new ConcurrentHashMap<>();

        private static <T> void putEnum(IBaseEnum<T> baseEnum, T code, String msg) {
            ENUM_MAP.put(baseEnum, new EnumBean(code, msg));
        }

        static <K extends IBaseEnum<T>, T> EnumBean<T> getEnum(K dict) {
            return ENUM_MAP.get(dict);
        }

    }

    class EnumBean<T> {

        private final T code;

        private final String text;

        public EnumBean(T code, String text) {
            this.code = code;
            this.text = text;
        }

        public T getCode() {
            return code;
        }

        public String getText() {
            return text;
        }
    }
}
