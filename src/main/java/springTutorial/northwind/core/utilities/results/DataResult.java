package springTutorial.northwind.core.utilities.results;

// <T>; we can give any data type.
public class DataResult<T> extends Result {

	private T data;
	
	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;
	}
	
	public DataResult(T data, boolean success, String message) {
		super(success, message);
		this.data = data;
	}
	
	public T getData() {
		return data;
	};
	
}
