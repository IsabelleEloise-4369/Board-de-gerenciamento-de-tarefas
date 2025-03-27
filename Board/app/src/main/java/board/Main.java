package board;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BoardDAO boardDAO = new BoardDAO();
        CardDAO cardDAO = new CardDAO();
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Criar Board");
            System.out.println("2 - Listar Boards");
            System.out.println("3 - Excluir Board");
            System.out.println("4 - Criar Card");
            System.out.println("5 - Bloquear Card");
            System.out.println("6 - Desbloquear Card");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do board: ");
                    String nomeBoard = scanner.nextLine();
                    boardDAO.criarBoard(nomeBoard);
                    break;
                case 2:
                    List<String> boards = boardDAO.listarBoards();
                    boards.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("ID do board para excluir: ");
                    int idBoard = scanner.nextInt();
                    boardDAO.excluirBoard(idBoard);
                    break;
                case 4:
                    System.out.print("Digite o ID da coluna: ");
                    int colunaId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o título do card: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite a descrição do card: ");
                    String descricao = scanner.nextLine();
                    cardDAO.criarCard(colunaId, titulo, descricao);
                    break;
                case 5:
                    System.out.print("ID do card para bloquear: ");
                    int cardId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Motivo do bloqueio: ");
                    String motivo = scanner.nextLine();
                    cardDAO.bloquearCard(cardId, motivo);
                    break;
                case 6:
                    System.out.print("ID do card para desbloquear: ");
                    cardId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Motivo do desbloqueio: ");
                    motivo = scanner.nextLine();
                    cardDAO.desbloquearCard(cardId, motivo);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

