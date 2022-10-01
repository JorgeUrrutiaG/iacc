package app.ayudantes;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Administracion
 */
public class Componentes {

    private JPanel panel;
    private JFrame ventana;
    private final Icon imgEditar = new ImageIcon(getClass().getResource("/app/img/lapiz20.png"));
    private final Icon imgEditar20 = new ImageIcon(getClass().getResource("/app/img/edit20.png"));
    private final Icon imgQuitar = new ImageIcon(getClass().getResource("/app/img/quitar20.png"));
    private final Icon imgElegir = new ImageIcon(getClass().getResource("/app/img/seleccionar.png"));
    private final JLabel btnEditar = new JLabel(imgEditar);
    private final JLabel btnRemover = new JLabel(imgQuitar);
    private final JLabel btnElegir = new JLabel(imgElegir);
    private final JLabel btnElegir20 = new JLabel(imgEditar20);
    private final JButton btnAsignar = new JButton("Asignar");

    public Componentes() {
    }

    public Componentes(JPanel panel) {
        this.panel = panel;
    }

    public Componentes(JFrame ventana) {
        this.ventana = ventana;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void habilitarText() {

        for (int i = 0; panel.getComponents().length > i; i++) {
            if (panel.getComponents()[i] instanceof JTextField) {

                ((JTextField) panel.getComponents()[i]).setEnabled(true);
            }
        }
    }

    public void inhabilitarText() {
        for (int i = 0; panel.getComponents().length > i; i++) {
            if (panel.getComponents()[i] instanceof JTextField) {
                ((JTextField) panel.getComponents()[i]).setEnabled(false);
            }
        }
    }

    public void habilitarCombos() {
        for (int i = 0; panel.getComponents().length > i; i++) {
            if (panel.getComponents()[i] instanceof JComboBox) {
                ((JComboBox) panel.getComponents()[i]).setEnabled(true);
            }
        }
    }

    public void inhabilitarCombos() {
        for (int i = 0; panel.getComponents().length > i; i++) {
            if (panel.getComponents()[i] instanceof JComboBox) {
                ((JComboBox) panel.getComponents()[i]).setEnabled(false);
            }
        }
    }

    public void limpiarText() {
        for (int i = 0; panel.getComponents().length > i; i++) {
            if (panel.getComponents()[i] instanceof JTextField) {

                ((JTextField) panel.getComponents()[i]).setText("");
            }
        }
    }

    public void limpiarCombos() {
        for (int i = 0; panel.getComponents().length > i; i++) {
            if (panel.getComponents()[i] instanceof JComboBox) {
                ((JComboBox) panel.getComponents()[i]).setSelectedIndex(0);
            }
        }
    }

    public int verificarText() {
        int enBlanco = 0;
        for (int i = 0; panel.getComponents().length > i; i++) {
            if (panel.getComponents()[i] instanceof JTextField) {
                if (((JTextField) panel.getComponents()[i]).getText().equals("")) {
                    enBlanco++;
                }
            }
        }

        return enBlanco;
    }

    public int verificarCombos() {
        int enBlanco = 0;
        for (int i = 0; panel.getComponents().length > i; i++) {
            if (panel.getComponents()[i] instanceof JComboBox) {
                if (((JComboBox) panel.getComponents()[i]).getSelectedIndex() == 0) {
                    enBlanco++;
                }
            }
        }
        return enBlanco;
    }

    public void inhabilitarBotones() {
        for (int i = 0; panel.getComponents().length > i; i++) {
            if (panel.getComponents()[i] instanceof JButton) {
                ((JButton) panel.getComponents()[i]).setEnabled(false);
            }
        }
    }

    public void habilitarBotones() {
        for (int i = 0; panel.getComponents().length > i; i++) {
            if (panel.getComponents()[i] instanceof JButton) {
                ((JButton) panel.getComponents()[i]).setEnabled(true);
            }
        }
    }

    public void llenaLabelGC(String[][] codigo) {
        String mes = null;
        for (int fila = 0; fila < 12; fila++) {
            for (int col = 0; col < 2; col++) {
                switch (col) {
                    case 0:
                        for (int i = 0; panel.getComponents().length > i; i++) {
                            if (panel.getComponents()[i] instanceof JLabel) {
                                if (((JLabel) panel.getComponents()[i]).getText().equals("Codigo" + fila)) {
                                    ((JLabel) panel.getComponents()[i]).setText(codigo[fila][col]);
                                }

                            }
                        }

                        break;
                    case 1:
                        for (int i = 0; panel.getComponents().length > i; i++) {
                            if (panel.getComponents()[i] instanceof JLabel) {
                                if (((JLabel) panel.getComponents()[i]).getText().equals("Detalle" + fila)) {
                                    ((JLabel) panel.getComponents()[i]).setText(codigo[fila][col]);
                                }

                            }
                        }

                        break;
                }
            }
        }
    }

    public String[][] obtieneValorGC(String[][] codigo) {
        for (int fila = 0; fila < 12; fila++) {
            for (int i = 0; panel.getComponents().length > i; i++) {
                if (panel.getComponents()[i] instanceof JTextField) {
                    if (((JTextField) panel.getComponents()[i]).getName().equals("txt" + fila)) {
                        codigo[fila][2] = ((JTextField) panel.getComponents()[i]).getText();
                    }

                }
            }

        }

        return codigo;
    }

    public JLabel getBotonEditar() {
        return btnEditar;
    }

    public JLabel getBotonEditar20() {
        return btnElegir20;
    }

    public JLabel getBotonQuitar() {
        return btnRemover;
    }

    public JLabel getBotonElegir() {
        return btnElegir;
    }

    public JButton getBotonAsignar() {
        return btnAsignar;
    }

    public JButton getBotonEmitir() {
        btnAsignar.setText("Emitir");
        return btnAsignar;
    }
}
