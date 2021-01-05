/*
 * The MIT License
 *
 * Copyright 2021 Vladislav Gorskii.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ru.VladTheMountain.oclide.configurator.ocemu;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import ru.VladTheMountain.oclide.configurator.ocemu.component.Computer;
import ru.VladTheMountain.oclide.configurator.ocemu.component.EEPROM;
import ru.VladTheMountain.oclide.configurator.ocemu.component.Filesystem;
import ru.VladTheMountain.oclide.configurator.ocemu.component.GPU;
import ru.VladTheMountain.oclide.configurator.ocemu.component.Internet;
import ru.VladTheMountain.oclide.configurator.ocemu.component.Keyboard;
import ru.VladTheMountain.oclide.configurator.ocemu.component.Modem;
import ru.VladTheMountain.oclide.configurator.ocemu.component.OCEmu;
import ru.VladTheMountain.oclide.configurator.ocemu.component.OCEmuComponent;
import ru.VladTheMountain.oclide.configurator.ocemu.component.Screen;

/**
 *
 * @author VladTheMountain
 */
public class ConfiguratorForm extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    private OCEmuComponent[] componentsArray = {};

    /**
     * Creates new form ConfiguratorForm
     */
    public ConfiguratorForm() {
        Timer t = new Timer(300, (ActionEvent e) -> {
            this.repaint();
        });
        initComponents();
        addComponent(new GPU(0, 160, 50, 3));
        addComponent(new Modem(1, false));
        addComponent(new EEPROM(9, "lua/bios.lua"));
        addComponent(new Filesystem(7, "loot/OpenOS", true));
        addComponent(new Filesystem(null, "tmpfs", true));
        addComponent(new Filesystem(9, "loot/OpenOS", true));
        addComponent(new Internet());
        addComponent(new Computer());
        addComponent(new OCEmu());
        addComponent(new Screen(null, 80, 25, 3));
        addComponent(new Keyboard());
    }

    private void addComponent(OCEmuComponent c) {
        OCEmuComponent[] tmp = new OCEmuComponent[this.componentsArray.length + 1];
        System.arraycopy(this.componentsArray, 0, tmp, 0, this.componentsArray.length);
        tmp[this.componentsArray.length] = c;
        this.componentsArray = new OCEmuComponent[tmp.length];
        System.arraycopy(tmp, 0, this.componentsArray, 0, tmp.length);
    }

    private void updateComponentList() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (int i = 0; i < componentsArray.length; i++) {
            model.insertElementAt(this.componentsArray[i].getComponentAddress(), i);
        }
        this.componentList.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        configChooser = new javax.swing.JFileChooser();
        javax.swing.JPanel controlPanel = new javax.swing.JPanel();
        javax.swing.JButton launchButton = new javax.swing.JButton();
        javax.swing.JButton cancelButton = new javax.swing.JButton();
        javax.swing.JPanel componentSettingsPanel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        componentAddressField = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        option1Field = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        option2Field = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        option3Field = new javax.swing.JTextField();
        javax.swing.JPanel descriptionPanel = new javax.swing.JPanel();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        componentDescriptionArea = new javax.swing.JTextArea();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        componentTypeComboBox = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        option4Field = new javax.swing.JTextField();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        componentList = new javax.swing.JList<>();
        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem resetConfigItem = new javax.swing.JMenuItem();
        javax.swing.JPopupMenu.Separator jSeparator1 = new javax.swing.JPopupMenu.Separator();
        javax.swing.JMenuItem importConfigItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem saveConfigItem = new javax.swing.JMenuItem();
        javax.swing.JPopupMenu.Separator jSeparator2 = new javax.swing.JPopupMenu.Separator();
        javax.swing.JMenuItem exitItem = new javax.swing.JMenuItem();
        javax.swing.JMenu componentMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem jMenuItem1 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem2 = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();

        configChooser.setDialogTitle("Open config...");
        configChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(java.io.File f){
                if(f.getName().equals("ocemu.cfg")){
                    return true;
                }
                return false;
            }

            @Override
            public String getDescription(){
                return "OCEmu config file ('ocemu.cfg')";
            }
        }
    );
    configChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Configure OCEmu");
    setResizable(false);

    launchButton.setText("Launch");
    launchButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            launchButtonActionPerformed(evt);
        }
    });

    cancelButton.setText("Cancel");
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cancelButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
    controlPanel.setLayout(controlPanelLayout);
    controlPanelLayout.setHorizontalGroup(
        controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(cancelButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(launchButton)
            .addContainerGap())
    );
    controlPanelLayout.setVerticalGroup(
        controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(launchButton)
                .addComponent(cancelButton))
            .addContainerGap())
    );

    jLabel1.setText("Component's address:");

    componentAddressField.setEditable(false);
    componentAddressField.setText("9031cf95-7a59-4ed2-af2c-dbb5834d0317");

    jLabel2.setText("Option 1");

    option1Field.setText("0");

    jLabel3.setText("Option 2");

    option2Field.setText("160");

    jLabel4.setText("Option 3");

    option3Field.setText("50");

    descriptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 10))); // NOI18N

    jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    componentDescriptionArea.setEditable(false);
    componentDescriptionArea.setColumns(20);
    componentDescriptionArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
    componentDescriptionArea.setRows(5);
    componentDescriptionArea.setText("GPU is responsible for screen buffer \nmanupulations and represents the \n'gpu' component library.");
    componentDescriptionArea.setWrapStyleWord(true);
    jScrollPane2.setViewportView(componentDescriptionArea);

    javax.swing.GroupLayout descriptionPanelLayout = new javax.swing.GroupLayout(descriptionPanel);
    descriptionPanel.setLayout(descriptionPanelLayout);
    descriptionPanelLayout.setHorizontalGroup(
        descriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane2)
    );
    descriptionPanelLayout.setVerticalGroup(
        descriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(descriptionPanelLayout.createSequentialGroup()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    jLabel5.setText("Component Type:");

    componentTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "computer", "cpu", "eeprom", "filesystem", "gpu", "internet", "keyboard", "modem", "ocemu", "screen", " " }));
    componentTypeComboBox.setSelectedIndex(4);

    jLabel6.setText("Option 4");

    option4Field.setText("3");

    javax.swing.GroupLayout componentSettingsPanelLayout = new javax.swing.GroupLayout(componentSettingsPanel);
    componentSettingsPanel.setLayout(componentSettingsPanelLayout);
    componentSettingsPanelLayout.setHorizontalGroup(
        componentSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(componentSettingsPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(componentSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(descriptionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, componentSettingsPanelLayout.createSequentialGroup()
                    .addGroup(componentSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(componentSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(option3Field)
                        .addComponent(option2Field)
                        .addComponent(componentTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(option1Field)
                        .addComponent(componentAddressField)
                        .addComponent(option4Field))))
            .addContainerGap())
    );
    componentSettingsPanelLayout.setVerticalGroup(
        componentSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(componentSettingsPanelLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(componentSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(componentTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(componentSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(componentAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(componentSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(option1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(componentSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(option2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(componentSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(option3Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(componentSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(option4Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(descriptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    componentList.setModel(new javax.swing.AbstractListModel<String>() {
        String[] strings = { "gpu", "modem", "eeprom", "filesystem", "filesystem", "filesystem", "internet", "computer", "ocemu", "screen", "keyboard" };
        public int getSize() { return strings.length; }
        public String getElementAt(int i) { return strings[i]; }
    });
    componentList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    componentList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
        public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
            componentListValueChanged(evt);
        }
    });
    jScrollPane1.setViewportView(componentList);

    fileMenu.setText("File");

    resetConfigItem.setText("Reset config");
    fileMenu.add(resetConfigItem);
    fileMenu.add(jSeparator1);

    importConfigItem.setText("Import from file");
    importConfigItem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            importConfigItemActionPerformed(evt);
        }
    });
    fileMenu.add(importConfigItem);

    saveConfigItem.setText("Save to file");
    saveConfigItem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            saveConfigItemActionPerformed(evt);
        }
    });
    fileMenu.add(saveConfigItem);
    fileMenu.add(jSeparator2);

    exitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
    exitItem.setText("Exit");
    exitItem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            exitItemActionPerformed(evt);
        }
    });
    fileMenu.add(exitItem);

    jMenuBar1.add(fileMenu);

    componentMenu.setText("Component");

    jMenuItem1.setText("Add");
    componentMenu.add(jMenuItem1);

    jMenuItem2.setText("Delete selected");
    componentMenu.add(jMenuItem2);

    jMenuBar1.add(componentMenu);

    helpMenu.setText("Help");
    jMenuBar1.add(helpMenu);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(componentSettingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(componentSettingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void componentListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_componentListValueChanged
        this.componentTypeComboBox.setSelectedIndex(componentsArray[this.componentList.getSelectedIndex()].getComponentType());
        this.componentAddressField.setText(componentsArray[this.componentList.getSelectedIndex()].getComponentAddress());
        this.option1Field.setText(componentsArray[this.componentList.getSelectedIndex()].getOptionAt(0));
        this.option2Field.setText(componentsArray[this.componentList.getSelectedIndex()].getOptionAt(1));
        this.option3Field.setText(componentsArray[this.componentList.getSelectedIndex()].getOptionAt(2));
        this.option4Field.setText(componentsArray[this.componentList.getSelectedIndex()].getOptionAt(3));
        switch (componentsArray[this.componentList.getSelectedIndex()].getComponentType()) {
            case 0:
                this.componentDescriptionArea.setText("Computer represents the \n'computer' library.");
                break;
            case 1:
                this.componentDescriptionArea.setText("EEPROM is responsible for \nbooting up the machine.");
                break;
            case 2:
                this.componentDescriptionArea.setText("Filesystem is responsible \nfor file management \nand represents the 'filesystem' \nlibrary.");
                break;
            case 3:
                this.componentDescriptionArea.setText("GPU is responsible for screen \nbuffer manupulations \nand represents the 'gpu' \ncomponent library.");
                break;
            case 4:
                this.componentDescriptionArea.setText("Internet is responsible for \nHTTP-requests and \nrepresents the 'internet' \ncomponent library.");
                break;
            case 5:
                this.componentDescriptionArea.setText("Keyboard is responsible for \nuser's input and \nrepresents the 'keyboard' \ncomponent library.");
                break;
            case 6:
                this.componentDescriptionArea.setText("Modem is responsible for \ncross-machine networking \nand represents the 'modem' \ncomponent library.");
                break;
            case 7:
                this.componentDescriptionArea.setText("OCEmu is responsible for \nintgration of OCEmu's code \nwith original OpenComputers'\n code.");
                break;
            case 8:
                this.componentDescriptionArea.setText("Screen is responsible for \nthe screen block and \nrepresents the 'screen' library.");
                break;
        }
    }//GEN-LAST:event_componentListValueChanged

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void launchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchButtonActionPerformed
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "cd OCEmu && run.bat");
            pb.redirectErrorStream(true);
            Process p = pb.start();
            java.io.BufferedReader r = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
            String outLine;
            java.util.logging.Logger.getLogger(ConfiguratorForm.class.getName()).log(java.util.logging.Level.INFO, "Starting OCEmu...");
            while (true) {
                outLine = r.readLine();
                if (outLine == null) {
                    break;
                }
                System.out.println(outLine);
            }
        } catch (java.io.IOException ex) {
            java.util.logging.Logger.getLogger(ConfiguratorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_launchButtonActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitItemActionPerformed

    private void importConfigItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importConfigItemActionPerformed
        if (this.configChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                new ConfigMaker(this.componentsArray).readConfig(this.configChooser.getSelectedFile());
            } catch (IOException ex) {
                Logger.getLogger(ConfiguratorForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_importConfigItemActionPerformed

    private void saveConfigItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveConfigItemActionPerformed
        try {
            new ConfigMaker(this.componentsArray).createConfig();
        } catch (IOException ex) {
            Logger.getLogger(ConfiguratorForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveConfigItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JTextField componentAddressField;
    javax.swing.JTextArea componentDescriptionArea;
    javax.swing.JList<String> componentList;
    javax.swing.JComboBox<String> componentTypeComboBox;
    javax.swing.JFileChooser configChooser;
    javax.swing.JTextField option1Field;
    javax.swing.JTextField option2Field;
    javax.swing.JTextField option3Field;
    javax.swing.JTextField option4Field;
    // End of variables declaration//GEN-END:variables
}