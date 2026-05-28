import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.HashMap;
import funcoes.Metodos;

public class Main {
    public static void main(String[] args) {
        Metodos funcao = new Metodos();
        Object[] opcoes = {
            "Cadastrar carro",
            "Ver carros cadastrados",
            "Alterar informações",
            "Remover Carro",
            "Sair"
        };

        HashMap<String, ArrayList<String>> listaCarros = new HashMap<>();
        
        boolean rodando = true;


        while (rodando) {
            int escolha = JOptionPane.showOptionDialog(
                null,
                "Sistema de Controle de Pátio\nEscolha uma opção:",
                "Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            switch (escolha) {
                case 0:
                    funcao.cadastrar(listaCarros);
                    break;

                case 1:
                    funcao.listar(listaCarros);
                    break;

                case 2:
                    funcao.atualizar(listaCarros);
                    break;
                
                case 3:
                    funcao.deletar(listaCarros);
                    break;

                case 4:
                    rodando = false;
                    break;
                
                default:
                    break;
            }
        }
    }
}