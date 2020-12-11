import java.awt.*;
import javax.swing.*;

public class Race
{
	public static void main(String[] args)
	{
		// EventQueue � ����������� �������� ������� ��� �������, ������� (���������� � Java) �������� ������� ��������
		// Thread-� �� ������� � ���������� � ������� Thread.
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new RaceFrame(); 
				frame.setTitle("Race");
				//��� �������� ���� ������� �������
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}





