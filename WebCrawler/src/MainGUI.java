import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class MainGUI {

	private JFrame frame;
	private JTextField urlTextField;
	private JTextField depthTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterUrl = new JLabel("Enter URL");
		lblEnterUrl.setBounds(92, 71, 48, 14);
		frame.getContentPane().add(lblEnterUrl);
		
		urlTextField = new JTextField();
		urlTextField.setBounds(167, 68, 170, 20);
		frame.getContentPane().add(urlTextField);
		urlTextField.setColumns(10);
		
		JButton crawlButton = new JButton("Crawl!");
		crawlButton.setBounds(167, 171, 89, 23);
		frame.getContentPane().add(crawlButton);
		
		JLabel lblDepthToSearch = new JLabel("Depth to Search");
		lblDepthToSearch.setBounds(62, 106, 78, 14);
		frame.getContentPane().add(lblDepthToSearch);
		
		depthTextField = new JTextField();
		depthTextField.setBounds(167, 106, 48, 20);
		frame.getContentPane().add(depthTextField);
		depthTextField.setColumns(10);
	}
}
