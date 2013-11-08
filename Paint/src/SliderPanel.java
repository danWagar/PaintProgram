import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;
import java.util.Hashtable;
 
/*
 * 
 */
public class SliderPanel extends JPanel// implements ChangeListener
{
	public static SliderPanel inst;
    static final int min = 0;
    static final int max = 255;
    static final int initial = 0;    //initial frames per second
    private static int redValue = 0;
    private static int greenValue = 0;
    private static int blueValue = 0;
    private static int intlStrokeValue = 3;
    private static float strokeValue = (float) intlStrokeValue;
    private static Color newColor;
    //private static boolean first = true;
            
    public SliderPanel() {
        //super(new BoxLayout());
 
        setBackground(Color.black);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        int sliderWidth = 130;
        int sliderHeight =50;
        Dimension d = new Dimension(sliderWidth, sliderHeight);
        
        //Create the slider.
        JSlider redSlider = new JSlider(JSlider.HORIZONTAL, min, max, initial);
        redSlider.setPreferredSize(d);
        redSlider.setMajorTickSpacing(10);
        redSlider.setPaintTicks(true);
        // handle redSlider change events
        redSlider.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent evt) {
            JSlider slider = (JSlider)evt.getSource();
     
            if (!slider.getValueIsAdjusting()) {
              redValue = slider.getValue();
              ButtonPanel.getInstance().repaint();
            }
          }
        }
        );
    	
        JSlider greenSlider = new JSlider(JSlider.HORIZONTAL, min, max, initial);
        greenSlider.setPreferredSize(d);
        greenSlider.setMajorTickSpacing(10);
        greenSlider.setPaintTicks(true);
        // handle greenSlider change events
        greenSlider.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent evt) {
            JSlider slider = (JSlider)evt.getSource();
     
            if (!slider.getValueIsAdjusting()) {
              greenValue = slider.getValue();
              ButtonPanel.getInstance().repaint();
            }
          }
        }
        );
        
        JSlider blueSlider = new JSlider(JSlider.HORIZONTAL, min, max, initial);
        blueSlider.setPreferredSize(d);
        blueSlider.setMajorTickSpacing(10);
        blueSlider.setPaintTicks(true);
        // handle blueSlider change events
        blueSlider.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent evt) {
            JSlider slider = (JSlider)evt.getSource();
     
            if (!slider.getValueIsAdjusting()) {
              blueValue = slider.getValue();
              ButtonPanel.getInstance().repaint();
            }
          }
        }
        );
     
        int strkMin = 1,
            strkMax = 25;
        JSlider strokeSlider = new JSlider(JSlider.HORIZONTAL, strkMin, strkMax, (int) intlStrokeValue);
        strokeSlider.setPreferredSize(new Dimension(165, 48));
        strokeSlider.setMajorTickSpacing(1);
        strokeSlider.setPaintTicks(true);
        
        Hashtable<Integer, JLabel> strokeLabel = new Hashtable<Integer, JLabel>();
        strokeLabel.put(strkMin, new JLabel("1") );
        strokeLabel.put(new Integer( strkMax ), new JLabel("25") );
        strokeSlider.setLabelTable(strokeLabel);
        strokeSlider.setPaintLabels(true);
        strokeSlider.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent evt) {
            JSlider slider = (JSlider)evt.getSource();
            if (!slider.getValueIsAdjusting()) {
              strokeValue = slider.getValue();
              ButtonPanel.getInstance().repaint();
            }
          }
        }
        );
              
        Hashtable<Integer, JLabel> labelTable = 
            new Hashtable<Integer, JLabel>();
        
        labelTable.put(new Integer( 0 ),
                       new JLabel("0") );
                     
        labelTable.put(new Integer( 255 ),
                       new JLabel("255") );
                     
        redSlider.setLabelTable(labelTable);
        greenSlider.setLabelTable(labelTable);
        blueSlider.setLabelTable(labelTable);
        
        redSlider.setPaintLabels(true);
        blueSlider.setPaintLabels(true);
        greenSlider.setPaintLabels(true);
       
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
       
        JButton bigLine = new JButton();
        bigLine.setBackground(Color.black);
        bigLine.setBorder(new LineBorder(Color.black, 2));
        bigLine.setPreferredSize(new Dimension(137,160));
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(bigLine, c);
        add(bigLine);
        
        JButton stroke = new JButton("Stroke Thickness");
        stroke.setPreferredSize(new Dimension(165,25));
        stroke.setForeground(Color.black);
        stroke.setFont(new Font("sansserif", Font.BOLD, 15));
        //stroke.setBorder(new LineBorder(Color.black, 2));
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(stroke, c);
        add(stroke);
        
        JButton thinLine = new JButton();
        thinLine.setBackground(Color.black);
        thinLine.setBorder(new LineBorder(Color.black, 2));
        thinLine.setPreferredSize(new Dimension(137,2));
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(thinLine, c);
        add(thinLine);
        
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(strokeSlider, c);
        add(strokeSlider); 
        
        JButton line = new JButton();
        line.setBackground(Color.black);
        line.setBorder(new LineBorder(Color.black, 2));
        line.setPreferredSize(new Dimension(137,8));
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(line, c);
        add(line);
       
        JButton red = new JButton("R");
        red.setBackground(Color.red);
        red.setForeground(Color.black);
        red.setFont(new Font("sansserif", Font.BOLD, 28));
        red.setBorder(new LineBorder(Color.red, 6));
        c.gridwidth = GridBagConstraints.RELATIVE;
        gridbag.setConstraints(red, c);
        add(red);
        
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(redSlider, c);
        add(redSlider);
        
        JButton green = new JButton("G");
        green.setBackground(Color.green);
        green.setForeground(Color.black);
        green.setFont(new Font("sansserif", Font.BOLD, 28));
        green.setBorder(new LineBorder(Color.green, 6));
        c.gridwidth = GridBagConstraints.RELATIVE;
        gridbag.setConstraints(green, c);
        add(green);
        
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(greenSlider, c);
        add(greenSlider);
        
        JButton blue = new JButton("B");
        blue.setBackground(Color.blue);
        blue.setForeground(Color.black);
        blue.setFont(new Font("sansserif", Font.BOLD, 28));
        blue.setBorder(new LineBorder(Color.blue, 6));
        c.gridwidth = GridBagConstraints.RELATIVE;
        gridbag.setConstraints(blue, c);
        add(blue);
        
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(greenSlider, c);
        add(blueSlider);
    	}
    
    	public void actionPerformed(ActionEvent ae)
    	{
    		System.out.println(ae.getActionCommand());
    	}
    
    	public static SliderPanel getInstance()
    	{
    		if(inst == null){
    			inst =  new SliderPanel();
    		}
    		return inst;
    	}
    	
        public static Color getColor()
        {
        	newColor = new Color(redValue, greenValue, blueValue);
        	return newColor;
        }
        
        public static float getStrokeThickness()
        {
          	return strokeValue;
        }
    }

        
        