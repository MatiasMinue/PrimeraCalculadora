import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora implements ActionListener {
	JFrame frame;
	JLabel subFrame;
	JTextField textField;
	JButton[] botonesNumeros = new JButton[10];
	JButton[] botonesOperaciones = new JButton[8];
	JButton botonSuma, botonResta, botonDivision, botonMultiplicacion;
	JButton botonDecimal, botonIgual, botonBorrar, botonLimpiar;
	JPanel panel;

	Font fuente = new Font("Libre", Font.BOLD, 30);
	Font fuente2 = new Font("Libre2", Font.ITALIC, 14);

	double num1 = 0, num2 = 0, resultado = 0;
	char operador;

	Calculadora() {
		frame = new JFrame("CALCULADORA");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 600);
		frame.setLayout(null);

		subFrame = new JLabel("by Matias");
		subFrame.setBounds(50, 80, 300, 20);
		subFrame.setFont(fuente2);

		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(fuente);
		textField.setEditable(false);

		botonSuma = new JButton("+");
		botonResta = new JButton("-");
		botonDivision = new JButton("/");
		botonMultiplicacion = new JButton("*");
		botonDecimal = new JButton(".");
		botonIgual = new JButton("=");
		botonBorrar = new JButton("DEL");
		botonLimpiar = new JButton("CLR");

		botonesOperaciones[0] = botonSuma;
		botonesOperaciones[1] = botonResta;
		botonesOperaciones[2] = botonDivision;
		botonesOperaciones[3] = botonMultiplicacion;
		botonesOperaciones[4] = botonDecimal;
		botonesOperaciones[5] = botonIgual;
		botonesOperaciones[6] = botonBorrar;
		botonesOperaciones[7] = botonLimpiar;

		for (int i = 0; i < 8; i++) {
			botonesOperaciones[i].addActionListener(this);
			botonesOperaciones[i].setFont(fuente);
			botonesOperaciones[i].setFocusable(false);
		}

		for (int i = 0; i < 10; i++) {
			botonesNumeros[i] = new JButton(String.valueOf(i));
			botonesNumeros[i].addActionListener(this);
			botonesNumeros[i].setFont(fuente);
			botonesNumeros[i].setFocusable(false);
			botonesNumeros[i].setBackground(Color.ORANGE);
		}

		botonBorrar.setBounds(50, 430, 145, 50);
		botonLimpiar.setBounds(205, 430, 145, 50);

		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(Color.PINK);

		panel.add(botonesNumeros[7]);
		panel.add(botonesNumeros[8]);
		panel.add(botonesNumeros[9]);
		panel.add(botonMultiplicacion);
		panel.add(botonesNumeros[4]);
		panel.add(botonesNumeros[5]);
		panel.add(botonesNumeros[6]);
		panel.add(botonDivision);
		panel.add(botonesNumeros[1]);
		panel.add(botonesNumeros[2]);
		panel.add(botonesNumeros[3]);
		panel.add(botonSuma);
		panel.add(botonDecimal);
		panel.add(botonesNumeros[0]);
		panel.add(botonIgual);
		panel.add(botonResta);
		panel.add(botonBorrar);
		panel.add(botonLimpiar);

		frame.add(panel);
		frame.add(botonBorrar);
		frame.add(botonLimpiar);
		frame.add(textField);
		frame.setVisible(true);
		frame.add(subFrame);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculadora calcu = new Calculadora();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 10; i++) {
			if (e.getSource() == botonesNumeros[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}

		if (e.getSource() == botonDecimal) {
			textField.setText(textField.getText().concat(String.valueOf(".")));
		}

		if (e.getSource() == botonSuma) {
			num1 = Double.parseDouble(textField.getText());
			operador = '+';
			textField.setText("");
		}

		if (e.getSource() == botonResta) {
			num1 = Double.parseDouble(textField.getText());
			operador = '-';
			textField.setText("");
		}

		if (e.getSource() == botonDivision) {
			num1 = Double.parseDouble(textField.getText());
			operador = '/';
			textField.setText("");
		}

		if (e.getSource() == botonMultiplicacion) {
			num1 = Double.parseDouble(textField.getText());
			operador = '*';
			textField.setText("");
		}

		if (e.getSource() == botonIgual) {
			num2 = Double.parseDouble(textField.getText());

			switch (operador) {
			case '+':
				resultado = num1 + num2;
				break;
			case '-':
				resultado = num1 - num2;
				break;
			case '/':
				resultado = num1 / num2;
				break;
			case '*':
				resultado = num1 * num2;
				break;
			}

			textField.setText(String.valueOf(resultado));
			num1 = resultado;
		}

		if (e.getSource() == botonLimpiar) {
			textField.setText(null);
		}

		if (e.getSource() == botonBorrar) {
			String string = textField.getText();
			textField.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				textField.setText(textField.getText() + string.charAt(i));
			}
		}
	}

}