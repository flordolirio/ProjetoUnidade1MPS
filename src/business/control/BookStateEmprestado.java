package business.control;

public class BookStateEmprestado implements BookState{

	@Override
	public BookState pegarEmprestado() {
		System.out.println("Livro j� est� emprestado");
		return this;
	}

	@Override
	public BookState devolver() {
		System.out.println("Livro devolvido");
		return new BookStateDisponivel();
	}

}
