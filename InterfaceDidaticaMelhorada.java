import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class InterfaceDidaticaMelhorada extends JFrame {

    private JTextArea textArea;
    private JButton animarButton;
    private JProgressBar progressBar;
    private JSpinner spinnerVetores, spinnerTamanho, spinnerVelocidade;
    private int[][] vetores;
    private int[] coletados;

    public InterfaceDidaticaMelhorada() {
        setTitle("Visualizador Didático de Vetores Aleatórios");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Área de texto estilo terminal
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.GREEN);
        textArea.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Painel de controle superior
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 3, 10, 5));

        spinnerVetores = new JSpinner(new SpinnerNumberModel(6, 2, 20, 1));
        spinnerTamanho = new JSpinner(new SpinnerNumberModel(6, 2, 20, 1));
        spinnerVelocidade = new JSpinner(new SpinnerNumberModel(800, 100, 3000, 100));

        topPanel.add(new JLabel("Quantidade de Vetores:"));
        topPanel.add(new JLabel("Tamanho de Cada Vetor:"));
        topPanel.add(new JLabel("Velocidade (ms):"));
        topPanel.add(spinnerVetores);
        topPanel.add(spinnerTamanho);
        topPanel.add(spinnerVelocidade);

        // Botão de animação
        animarButton = new JButton("🎬 Iniciar Animação");
        animarButton.setFont(new Font("Arial", Font.BOLD, 16));
        animarButton.setBackground(new Color(70, 130, 180));
        animarButton.setForeground(Color.WHITE);
        animarButton.addActionListener(e -> iniciarAnimacao());

        // Barra de progresso
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(0, 200, 0));
        progressBar.setBackground(Color.DARK_GRAY);

        // Organização geral
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(animarButton, BorderLayout.NORTH);
        bottomPanel.add(progressBar, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void iniciarAnimacao() {
        int quantidadeVetores = (int) spinnerVetores.getValue();
        int tamanhoVetor = (int) spinnerTamanho.getValue();
        int delay = (int) spinnerVelocidade.getValue();

        vetores = new int[quantidadeVetores][tamanhoVetor];
        coletados = new int[quantidadeVetores];
        animarButton.setEnabled(false);
        progressBar.setMaximum(quantidadeVetores + 3); // 3 etapas extras: intro + coleta + ordenação

        SwingWorker<Void, String> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                Random random = new Random();
                StringBuilder sb = new StringBuilder();

                sb.append("🎲 GERANDO VETORES ALEATÓRIOS...\n\n");
                publish(sb.toString());
                Thread.sleep(delay);
                sb.setLength(0);
                progressBar.setValue(1);

                for (int i = 0; i < quantidadeVetores; i++) {
                    sb.append("Vetor ").append(i + 1).append(": ");
                    int pos = tamanhoVetor - 1 - i;

                    for (int j = 0; j < tamanhoVetor; j++) {
                        if (j == pos) {
                            sb.append("[").append(String.format("%02d", vetores[i][j] = random.nextInt(100) + 1)).append("] ");
                        } else {
                            sb.append(String.format("%02d ", vetores[i][j] = random.nextInt(100) + 1));
                        }
                    }

                    coletados[i] = vetores[i][pos];
                    sb.append("← pegou posição ").append(pos).append(" → ").append(vetores[i][pos]);
                    sb.append("\n");

                    publish(sb.toString());
                    sb.setLength(0);
                    progressBar.setValue(i + 2);
                    Thread.sleep(delay);
                }

                Thread.sleep(delay);
                sb.append("\n📥 VALORES COLETADOS:\n");
                for (int val : coletados) {
                    sb.append(val).append(" ");
                }
                sb.append("\n");
                publish(sb.toString());

                Thread.sleep(delay);
                Arrays.sort(coletados);

                sb.setLength(0);
                sb.append("\n📊 VALORES ORDENADOS:\n");
                for (int val : coletados) {
                    sb.append(val).append(" ");
                }
                sb.append("\n\n✅ VETOR ORDENADO!");
                publish(sb.toString());

                progressBar.setValue(quantidadeVetores + 3);
                return null;
            }

            @Override
            protected void process(java.util.List<String> chunks) {
                for (String s : chunks) {
                    textArea.append(s);
                }
            }

            @Override
            protected void done() {
                animarButton.setEnabled(true);
            }
        };

        textArea.setText("");
        progressBar.setValue(0);
        worker.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfaceDidaticaMelhorada app = new InterfaceDidaticaMelhorada();
            app.setVisible(true);
        });
    }
}
