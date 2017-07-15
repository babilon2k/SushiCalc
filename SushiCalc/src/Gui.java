
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Gui extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	private JTextArea mainTxtField;

	public Gui()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					UIManager.setLookAndFeel(
							"javax.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e)
				{
					throw new RuntimeException(e);
				}
				createGui();
			}
		});
	}

	protected void createGui()
	{
		initComponents();
	}

	private void initComponents()
	{
		// Main window
		setTitle("Sushi Calculator");
		setBounds(100, 100, 351, 314);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblRice = new JLabel("How much rice u want to cook?");
		lblRice.setFont(new Font("Tahoma", Font.BOLD, 11));

		textField = new JTextField();
		textField.setToolTipText(
				"Put the amount of rice you want to cook and hit enter.");
		textField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				double rice = 0;
				double water;
				double constRice = 250;
				double constWater = 330;
				double nori;

				rice = Double.parseDouble(textField.getText());
				water = (constWater * rice) / constRice;
				nori = rice / 64.5;
				nori *= 100;
				nori = Math.round(nori);

				nori /= 100;

				mainTxtField.setText("Potrzebujesz " + water + " ml wody."
						+ "\n\nProporcje na sos do ryzu to:\n6 łyżek octu ryżowo\n3 łyżki cukru białego\n2 łyżeczki soli\nStosuj 4 lyzki sosu na kazde 200g ryżu"
						+ "\n\nDo sushi maki zużyjesz ok. " + nori + " nori.");
			}
		});
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane
				.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblRice,
												GroupLayout.PREFERRED_SIZE, 184,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(textField,
												GroupLayout.DEFAULT_SIZE, 117,
												Short.MAX_VALUE))
								.addComponent(scrollPane,
										GroupLayout.DEFAULT_SIZE, 305,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane
				.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(25).addComponent(textField,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(24).addComponent(lblRice,
												GroupLayout.PREFERRED_SIZE, 21,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 251,
								Short.MAX_VALUE)));

		mainTxtField = new JTextArea();
		mainTxtField.setForeground(Color.WHITE);
		mainTxtField.setEditable(false);
		mainTxtField.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(mainTxtField);
		contentPane.setLayout(gl_contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{

	}
}
