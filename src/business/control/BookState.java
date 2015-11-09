package business.control;

public interface BookState {
	BookState pegarEmprestado();
	BookState devolver();

}
