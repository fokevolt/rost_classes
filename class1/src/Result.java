public class Result<T> {
    private T data;
    private Throwable error;

    public Result(T data, Throwable error) {
        this.data = data;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public Throwable getError() {
        return error;
    }

    public static<T> Result<T> success(T data){
        return new Result<T>(data, null);
    }

    public static void main(String[] args) {
    }
}


