package view;

public class Display {
	
	public static void loadScreen(int screenCode) {
		
		bufferScreen();
		
		switch(screenCode) {
		case 1:
			mainMenuScreen();
			break;
		case 2:
			itemMenuScreen();
			break;
		default:
			break;
		}
		
	}
	
	private static void bufferScreen() {
		for(int i=0; i < 70 ; i++)
			System.out.println();
	}

	
	private static void mainMenuScreen() {
		for(int i=0; i < 50 ; i++)
		{
			if(i==0||i==48||i==42||i==6)
			{
				for(int x = 0; x < 100; x++)
				{
					System.out.print("=");
				}
				System.out.println();
				
				
			}
			else
			{
				System.out.println(i);
			}
			
		}
			
	}
	
	private static void itemMenuScreen() {
		for(int i=50; i > 0 ; i--)
			System.out.println(i);
	}
}
