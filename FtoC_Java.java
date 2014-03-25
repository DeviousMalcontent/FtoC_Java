/**
 * @(#)FtoC_Java.java
 * Purpose: Converts a temperature to Celsius or Fahrenheit.
 *
 * @author Mark Albanese
 * @version 1.00 2013/3/23
 */

    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;
    import java.text.*;
    
public class FtoC_Java extends JFrame implements ActionListener {
        
    /**
     * Creates a new instance of <code>FtoC_Java</code>.
     */
    static String toCelsiusString = "To Celsius";
    static String toFahrenheitString = "To Fahrenheit";
    
    private JTextField txt_temperature;
    private JLabel lbl_temperature;
    
    private JTextField txt_result;
    private JLabel lbl_result;
    
    private JButton btn_exit;
    private JButton btn_clear;
    private JButton btn_convert;
    
    private DecimalFormat pattern;
    
    private JRadioButton toCelsiusButton = new JRadioButton(toCelsiusString);
    private JRadioButton toFahrenheitButton = new JRadioButton(toFahrenheitString);

    public FtoC_Java() {
           super("Fahrenheit to Celsius");
           this.initVars();
           this.setFrame();
    }
    
    private void initVars(){
           pattern = new DecimalFormat("#.#####");
           
           toCelsiusButton.setActionCommand(toCelsiusString);
           toCelsiusButton.setSelected(true);
           
           toFahrenheitButton.setActionCommand(toFahrenheitString);
           
           ButtonGroup group = new ButtonGroup();
           group.add(toCelsiusButton);
           group.add(toFahrenheitButton);
            
           toCelsiusButton.addActionListener(this);
           toFahrenheitButton.addActionListener(this);
           
           lbl_temperature = new JLabel("Temperature:");
           txt_temperature = new JTextField(10);
           
           lbl_result = new JLabel("Result:");
           txt_result = new JTextField(10);
           
           btn_convert = new JButton("Convert");
           btn_convert.addActionListener(new ActionListener()
           {
             public void actionPerformed(ActionEvent e) {
                String txttemperature = txt_temperature.getText();

                try{
                    if (!txttemperature.equals(""))
                    {
                        double temperature = Double.parseDouble(txt_temperature.getText());
                        
                        if (toCelsiusButton.isSelected())
                        {
                            temperature = (temperature - 32) * 5 / 9;
                        }
                        else if(toFahrenheitButton.isSelected())
                        {    
                            temperature = temperature * 9 / 5 + 32;
                        }
                                                            
                        String temperaturestring = pattern.format(temperature);
                        txt_result.setText(pattern.format(temperature));
                     }
                     else
                     {
                           JOptionPane.showMessageDialog(null, 
                           "Please enter a valid temperature in the temperature box.", 
                           "Celsius to Fahrenheit", 
                           JOptionPane.INFORMATION_MESSAGE);
                     }
                     }catch(NumberFormatException ex)
                        {
                          JOptionPane.showMessageDialog(null, 
                          "Please insure the temperature entered is valid.", 
                          "Celsius to Fahrenheit", 
                          JOptionPane.INFORMATION_MESSAGE);
                        }
             }
           }
           );
           
           btn_exit = new JButton("Exit");
           btn_exit.addActionListener(new ActionListener() 
           {
            public void actionPerformed(ActionEvent e) 
                {
                    System.exit(0);
                }
              }
           );
           
           btn_clear = new JButton("Clear");
           btn_clear.addActionListener(new ActionListener()
           {
             public void actionPerformed(ActionEvent e) {
                txt_result.setText("");
                txt_temperature.setText("");
             }
           }
           );
    }
    
    private void setFrame(){
            this.setLayout(new FlowLayout());
            this.add(lbl_temperature);
            this.add(txt_temperature);
            this.add(toCelsiusButton);
            this.add(toFahrenheitButton);
            this.add(lbl_result);
            this.add(txt_result);
            this.add(btn_convert);
            this.add(btn_clear);
            this.add(btn_exit);
            this.setSize(230,160);
            this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setVisible(true);          
    }
    
    public void actionPerformed(ActionEvent e) {
       
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            new FtoC_Java();
    }
}
