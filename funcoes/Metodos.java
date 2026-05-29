package funcoes;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Metodos {
    public void cadastrar(HashMap<String, ArrayList<String>> listaCarros) {
        JTextField nomeCarroField = new JTextField(15);
        JTextField pecasField = new JTextField(15);
        JTextField descField = new JTextField(15);

        JPanel painel = new JPanel(new GridLayout(3, 2, 0, 5));

        painel.add(new JLabel("Nome do veículo:"));
        painel.add(nomeCarroField);

        painel.add(new JLabel("Peças em manutenção:"));
        painel.add(pecasField);

        painel.add(new JLabel("Descrição do veículo"));
        painel.add(descField);

        int resultado = JOptionPane.showConfirmDialog(
                null,
                painel,
                "Cadastro",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (resultado == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(
                    null,
                    "Veículo: " + nomeCarroField.getText() +
                            "\nPeças: " + pecasField.getText() +
                            "\nDescrição: " + descField.getText());
        }

        ArrayList<String> infoCarro = new ArrayList<>();
        infoCarro.add(pecasField.getText());
        infoCarro.add(descField.getText());
        listaCarros.put(nomeCarroField.getText(), infoCarro);
    }

    public void listar(HashMap<String, ArrayList<String>> listaCarros) {
        JPanel painel = new JPanel(new GridLayout(0, 3, 10, 5));

        for (Map.Entry<String, ArrayList<String>> carros : listaCarros.entrySet()) {
            JLabel labelCarro = new JLabel(carros.getKey());
            labelCarro.setBorder(BorderFactory.createMatteBorder(1,0,1,0,Color.GRAY));
            JLabel labelPecas = new JLabel(carros.getValue().get(0));
            labelPecas.setBorder(BorderFactory.createMatteBorder(1,0,1,0,Color.GRAY));
            JLabel labelDesc = new JLabel(carros.getValue().get(1));
            labelDesc.setBorder(BorderFactory.createMatteBorder(1,0,1,0,Color.GRAY));

            painel.add(new JLabel("Carro"));
            painel.add(new JLabel("Peças"));
            painel.add(new JLabel("Descrição"));
            painel.add(labelCarro);
            painel.add(labelPecas);
            painel.add(labelDesc);
        }

        JOptionPane.showMessageDialog(
                null,
                painel,
                "Carros cadastrados",
                JOptionPane.PLAIN_MESSAGE);
    }

    public void atualizar(HashMap<String, ArrayList<String>> listaCarros) {

        boolean executando = true;
        JTextField carroField = new JTextField(15);
        JTextField pecaField = new JTextField(15);
        JTextField descField = new JTextField(15);
        JButton botaoSair = new JButton("Sair");

        JPanel painel = new JPanel(new GridLayout(3, 2, 0, 5));

        botaoSair.addActionListener(e -> {
            System.exit(0);
        });

        painel.add(new JLabel("Carro: "));
        painel.add(carroField);
        painel.add(new JLabel("Peças: "));
        painel.add(pecaField);
        painel.add(new JLabel("Descrição:"));
        painel.add(descField);
        while (executando) {
            int resposta = JOptionPane.showConfirmDialog(
                    null,
                    painel,
                    "Alterações",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE);

            String carro = carroField.getText();

            if (listaCarros.get(carro) != null) {
                String peca = pecaField.getText();
                String desc = descField.getText();
                if (!peca.isBlank() && !desc.isBlank()) {
                    ArrayList<String> lista = new ArrayList<>();
                    lista.add(peca);
                    lista.add(desc);
                    listaCarros.replace(carro, lista);
                    executando = false;
                    JOptionPane.showMessageDialog(
                            null,
                            "Alterações feitas",
                            "Concluído",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (resposta == JOptionPane.CANCEL_OPTION) {
                executando = false;
            }

        }
    }

    public void deletar(HashMap<String, ArrayList<String>> listaCarros) {
        JTextField carroField = new JTextField(15);

        JPanel painel = new JPanel();

        boolean executando = true;

        painel.add(new JLabel("Carro:"));
        painel.add(carroField);

        while (executando) {
            int resposta = JOptionPane.showConfirmDialog(
                    null,
                    painel,
                    "Deletar",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE);
            if (resposta == 2) {
                executando = false;
            } else {
                String carro = carroField.getText();
                if (!carro.isBlank() || listaCarros.get(carro) != null) {
                    listaCarros.remove(carro);
                    JOptionPane.showMessageDialog(
                            null,
                            "Veículo deletado do sistema",
                            "Deletado",
                            JOptionPane.PLAIN_MESSAGE);
                    executando = false;
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Insira um valor válido",
                            "Erro!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }

}
