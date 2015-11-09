

package business.model;

import java.io.Serializable;


public class User implements Serializable {

	private static final long serialVersionUID = -3409171233621036055L;

	private String nome, matricula, curso, login, senha;
    
    public User(String nome, String matricula, String curso, String login, String senha) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
		this.login = login;
		this.senha = senha;
	}

    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

  
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
  
    
    public String toString(){
        return nome +"\n" +matricula+ "\n" +curso +"\n" + login +"\n"+senha;
    }

	
    
}
