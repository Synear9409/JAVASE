package Enum;

public class Main {

    public static void main(String[] args) {
//        System.out.println(TestEnum.FAIL.getCode());
//        System.out.println(TestEnum.FAIL.getMessage());
//
//        System.out.println(IBaseEnum.getByCode(TestEnum.class, 1).getMessage());


        System.out.println(IBaseEnum.getByCode(ErrorEnum.class, "400").getMessage());
    }

}
