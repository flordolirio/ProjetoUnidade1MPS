package business.control;

public class BookStateDisponivel implements BookState{

	@Override
	public BookState pegarEmprestado() {
		System.out.println("Livro foi emprestado");
		return new BookStateEmprestado();
	}

	@Override
	public BookState devolver() {
		System.out.println("Livro já está disponível");
		return this;
	}
	

}
