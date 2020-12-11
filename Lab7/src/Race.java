import java.awt.*;
import javax.swing.*;

public class Race
{
	public static void main(String[] args)
	{
		// EventQueue с английского «очередь событий» это функция, которая (содержится в Java) посылает задание текущего
		// Thread-а на очередь к выполнению в главный Thread.
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new RaceFrame(); 
				frame.setTitle("Race");
				//при закрытии окна убиваем процесс
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}





