package kodlama.io.northwind.core.utilities.results;

public class DataResult<T> extends Result {




    private T data;
    public DataResult(T data, boolean success, String message) {
        super(success, message); //super Ana sınıf için kullanılır.
        this.data = data;
    }

    public DataResult(T data, boolean success) {
        super(success); //super Ana sınıf için kullanılır.
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
