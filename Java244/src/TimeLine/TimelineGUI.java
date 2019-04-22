/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeLine;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author noah
 */
public class TimelineGUI extends JPanel{
    
    private TimelineController tlc;
    private TimelineItem tli;
    private final JPanel tlPanel, activeItemPanel, activeTimelinePanel;
    private final JList tliList;
    private final JTextField tliTitleField, tliDescField;
    private final JButton tlSaveBut, tlLoadBut;
    
    
    protected TimelineGUI(TimelineController tlc){
        super(new BorderLayout());
        this.tlc = tlc;
        
        // panels
        tlPanel = new JPanel(new BorderLayout());
        activeItemPanel = new JPanel(new BorderLayout());
        activeTimelinePanel = new JPanel(new BorderLayout());
        
        // activeTimeline Panel
        activeTimelinePanel.add(new JLabel("Timeline Menu"), BorderLayout.NORTH);
        tlSaveBut = new JButton("Save Timeline");
        tlLoadBut = new JButton("Load Timeline");
        activeTimelinePanel.add(tlSaveBut);
        activeTimelinePanel.add(tlLoadBut);
        
        // activeItem Panel
        activeItemPanel.add(new JLabel("Active Item"), BorderLayout.NORTH);
        tliTitleField = new JTextField(tlc.getActiveItem().getTitle());
        activeItemPanel.add(new JLabel("Title: "));
        activeItemPanel.add(tliTitleField, BorderLayout.SOUTH);
        tliDescField = new JTextField(tlc.getActiveItem().getDesc());
        activeItemPanel.add(tliDescField, BorderLayout.CENTER);
        
        // tliList configuration
        tliList = new JList(tlc.getActiveTl().toArray());
        JScrollPane tliScroll = new JScrollPane(tliList);
        tliList.addListSelectionListener(new ListListener());
        tlPanel.add(tliList, BorderLayout.CENTER);
        
        // this adds
        this.add(tlPanel, BorderLayout.WEST);
        this.add(activeItemPanel);
        //this.add(activeTimelinePanel);
        
        
    }
    
    protected void guiMain(){
        JFrame frame = new JFrame("Timeline Manager");
        //this.setSize(1000,1200);
        frame.add(this);
        this.setOpaque(true);
        frame.setSize(10000, 12000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void update(){
        tliTitleField.setText(tlc.getActiveItem().getTitle());
        tliDescField.setText(tlc.getActiveItem().getDesc());
    }

    private class ListListener implements ListSelectionListener {

        public ListListener() {
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting()) return;
            JList list = (JList)e.getSource();
            
            tlc.setActiveItem(tlc.getActiveTl().get(list.getSelectedIndex()));
            
            update();
        }
    }
    
}
