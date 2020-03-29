package Su.design.travel.utils.result;


import org.omg.CORBA.PUBLIC_MEMBER;

public enum Code {
    //成功
    SUCCESS(200),

    //失败
    FAIL(400),

    //未认证（签名错误）
    UNAUTHORIZED(401),

    //接口不存在
    NOT_FOUND(404),

    //服务器错误
    INTERNAL_SERVER_ERROR(500);

    public  int code;

    Code(int code){
        this.code =code;
    }

}
