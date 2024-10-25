import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyNotepad extends JFrame {
    private JTextArea textArea;

    public MyNotepad() {
        // Set up the frame
        setTitle("MyNotepad");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Create the text area
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create "File" menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Add "Open" menu item
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
        fileMenu.add(openItem);

        // Add "Save" menu item
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
        fileMenu.add(saveItem);

        // Add "Exit" menu item
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);

        // Create "Edit" menu
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        // Add "Font" menu item
        JMenuItem fontItem = new JMenuItem("Font");
        fontItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeFont();
            }
        });
        editMenu.add(fontItem);

        // Create "Format" menu
        JMenu formatMenu = new JMenu("Format");
        menuBar.add(formatMenu);

        // Add "Line Wrap" menu item
        JCheckBoxMenuItem lineWrapItem = new JCheckBoxMenuItem("Line Wrap");
        lineWrapItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setLineWrap(lineWrapItem.isSelected());
            }
        });
        formatMenu.add(lineWrapItem);

        // Set the menu bar to the frame
        setJMenuBar(menuBar);
        
        // Make the frame visible
        setVisible(true);
    }

    // Open file dialog
    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);
        
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
                textArea.setText("");
                String line;
                while ((line = br.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error opening file: " + ex.getMessage());
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Save file dialog with overwrite confirmation
    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);
        
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            // Check if file exists and confirm overwrite
            if (file.exists()) {
                int response = JOptionPane.showConfirmDialog(this,
                        "File already exists. Do you want to overwrite it?", "Confirm Overwrite",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (response != JOptionPane.YES_OPTION) {
                    return; // Exit the method if the user does not want to overwrite
                }
            }

            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(file));
                bw.write(textArea.getText());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
            } finally {
                try {
                    if (bw != null) {
                        bw.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Change font dialog with styles
    private void changeFont() {
        Font currentFont = textArea.getFont();
        JFontChooserDialog dialog = new JFontChooserDialog(this, currentFont);
        dialog.setVisible(true);
        Font newFont = dialog.getSelectedFont();
        if (newFont != null) {
            textArea.setFont(newFont);
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MyNotepad();
            }
        });
    }
}

// Font chooser dialog class with styles
class JFontChooserDialog extends JDialog {
    private Font selectedFont;
    private JComboBox<String> fontList;
    private JComboBox<Integer> sizeList;
    private JComboBox<String> styleList;

    public JFontChooserDialog(Component parent, Font initialFont) {
        super((Frame) SwingUtilities.getWindowAncestor(parent), true);
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Font:"));
        fontList = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        add(fontList);

        add(new JLabel("Size:"));
        sizeList = new JComboBox<>(new Integer[]{8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32});
        add(sizeList);

        add(new JLabel("Style:"));
        styleList = new JComboBox<>(new String[]{"Plain", "Bold", "Italic"});
        add(styleList);

        // Set initial values
        fontList.setSelectedItem(initialFont.getName());
        sizeList.setSelectedItem(initialFont.getSize());
        styleList.setSelectedItem(getFontStyleString(initialFont.getStyle()));

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fontName = (String) fontList.getSelectedItem();
                int fontSize = (Integer) sizeList.getSelectedItem();
                String selectedStyle = (String) styleList.getSelectedItem();

                int fontStyle = Font.PLAIN;
                if ("Bold".equals(selectedStyle)) fontStyle = Font.BOLD;
                else if ("Italic".equals(selectedStyle)) fontStyle = Font.ITALIC;

                selectedFont = new Font(fontName, fontStyle, fontSize);
                setVisible(false);
            }
        });
        add(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedFont = null;
                setVisible(false);
            }
        });
        add(cancelButton);

        pack();
        setLocationRelativeTo(parent);
    }

    public Font getSelectedFont() {
        return selectedFont;
    }

    private String getFontStyleString(int style) {
        switch (style) {
            case Font.BOLD: return "Bold";
            case Font.ITALIC: return "Italic";
            default: return "Plain";
        }
    }
}