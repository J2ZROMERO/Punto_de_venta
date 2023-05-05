package metodos_personalizados;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class SoloDecimalTextField extends JTextField {

    public SoloDecimalTextField() {
        super();
        this.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '.'))) {
                    e.consume();
                }
                if (c == '.' && getText().contains(".")) {
                    e.consume();
                }
            }
        });
    }
}
