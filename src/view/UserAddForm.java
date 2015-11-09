package view;

import infra.InfraException;

import java.io.IOException;
import java.util.Scanner;

import business.control.UserManager;
import business.model.User;
import business.util.LoginInvalidException;
import business.util.PasswordInvalidException;

public class UserAddForm {

	private Scanner entrada;
	private Scanner opcao;
	public boolean voltar = false;
	UserManager userM;

	public UserAddForm(){
		userM = UserManager.getInstancia();
	}
	public void showMenuCadUsuario(){
		opcao = new Scanner(System.in);
		int opMenu;
		do{
			System.out.println("\nEscolha a opção desejada:\n1- Cadastrar Usuario;\n2- Listar Usuários; \n3- Excluir Usuário;"
					+ "\n4- Alterar Usuário;\n5- Voltar");
			opMenu = opcao.nextInt();
		}while(opMenu<1||opMenu>5);
		opcaoCadUsuario(opMenu);			
	}
	
	public void opcaoCadUsuario(int option){
		entrada = new Scanner(System.in);
		int choice = option;
		boolean checked = true;
		switch (choice) {

		case 1:
			String nome = "";
			String matricula = "";
			String curso = "";
			
			System.out.println("Nome do usuario:");
			nome = entrada.nextLine();
			System.out.println("Matricula do usuario:");
			matricula = entrada.nextLine();
			System.out.println("Curso do usuario:");
			curso = entrada.nextLine();
			
			while (checked) {
				
				String login = "";
				String senha = "";
				
				System.out.println("Login do usuario (deve ter menos de 20 caracteres e não pode ter números):");
				login = entrada.nextLine(); 
				System.out.println("Senha do usuario (entre 8 e 12 caracteres e pelo menos 1 caracter e 2 números):");					
				senha = entrada.nextLine();
				
				try {
					userM.addUser(nome, matricula, curso, login, senha);
					checked = false;
				} catch (LoginInvalidException e) {
					System.out.println(e.getMessage());
				} catch (PasswordInvalidException e) {
					System.out.println(e.getMessage());
				} catch (InfraException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				
			}
			showMenuCadUsuario();
			break;
		
		case 2:
			for (User user : userM.getUsers())
				System.out.println("[ Nome: "+user.getNome()+" || Matricula: "+user.getMatricula()+ " || Curso: " +user.getCurso()+ " || Login: " + user.getLogin() + " || Senha: " + user.getSenha() + " ]");
			
			showMenuCadUsuario();
			break;

		case 3:
			System.out.println("Login do usuario a ser excluido:");
			String deleteLogin = entrada.nextLine();
			
			try {
				userM.deleteUser(deleteLogin);
			} catch (LoginInvalidException e) {
				System.out.println(e.getMessage());
			} catch (InfraException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			showMenuCadUsuario();
			break;
			
		case 4:
			System.out.println("Login do usuario a ser atualizado:");
			String atualizaLogin = entrada.nextLine();
			
			try {
				userM.atualizaUser(atualizaLogin);
			} catch (LoginInvalidException e) {
				System.out.println(e.getMessage());
			} catch (InfraException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			showMenuCadUsuario();
			break;
			
		case 5:
			voltar = true;
		}
	}
}
