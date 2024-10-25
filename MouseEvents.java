import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEvents extends JFrame implements MouseListener, MouseMotionListener {
    private JTextArea textArea;

    // Constructor
    public MouseEvents() {
        // Create the content pane and text area
        Container contentPane = getContentPane();
        textArea = new JTextArea(20, 40);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Add the text area to the content pane
        contentPane.add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        // Add mouse listener and mouse motion listener to the text area
        textArea.addMouseListener(this);
        textArea.addMouseMotionListener(this);

        // Frame properties
        setTitle("Mouse Events Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    // MouseListener methods
    @Override
    public void mouseClicked(MouseEvent e) {
        display("Mouse Clicked at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        display("Mouse Entered the text area");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        display("Mouse Exited the text area");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        display("Mouse Pressed at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        display("Mouse Released at (" + e.getX() + ", " + e.getY() + ")");
    }

    // MouseMotionListener methods
    @Override
    public void mouseDragged(MouseEvent e) {
        display("Mouse Dragged at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        display("Mouse Moved at (" + e.getX() + ", " + e.getY() + ")");
    }

    // Method to display messages in the text area
    private void display(String message) {
        textArea.append(message + "\n");
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MouseEvents();
            }
        });
    }
}