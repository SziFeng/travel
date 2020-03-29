package Su.design.travel.utils.result;

/**
 * @author Szifeng
 */
public class Result<T> {

    public int code;

    private String msg;

    private T data;

    public Result<T> setCode(Code Code) {
        this.code = Code.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    private final static String SUCCESS = "success";

    public static <T> Result<T> ok() {
        return new Result<T>().setCode(Code.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<T>().setCode(Code.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> Result<T> ok(String message) {
        return new Result<T>().setCode(Code.SUCCESS).setMsg(message);
    }

    public static <T> Result<T> login(String message) {
        return new Result<T>().setCode(Code.SUCCESS).setMsg("登录成功");
    }

    public static <T> Result<T> fail(String message) {
        return new Result<T>().setCode(Code.FAIL).setMsg(message);
    }

    public static <T> Result<T> setInfo(int code, String msg) {
        return new Result<T>().setCode(code).setMsg(msg);
    }

    public static <T> Result<T> setInfo(int code, String msg, T data) {
        return new Result<T>().setCode(code).setMsg(msg).setData(data);
    }
}
