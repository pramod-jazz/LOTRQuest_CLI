package org.game.fantasy;

import java.io.IOException;

public class Console {
	

	public static final int ROWS = 100;
	public static final int COLS = 100;

	private static char[][] screen;
	private static int cursorRow = 0;
	private static int cursorCol = 0;
	
	public Console ()
	{
		screen = new char[ROWS][COLS];
		initScreen();
	}
	
	public void initScreen()
	{
		for (int row=0; row<ROWS; row++)
			for (int col=0; col<COLS; col++)
				screen[row][col] = ' ';
		cursorRow = 0;
		cursorCol = 0;
	}
	
	public void printScreen ()
	{
		String line = "";
		for (int row = 0; row < ROWS; row++) {
			for (int col=0; col<COLS; col++) {
				line += screen[row][col];
			}
		}
		System.out.println(line);
	}
	
	public void clearScreen ()
	{
		initScreen();
		for (int i=0;i<25;i++) System.out.println();
	}
	
	
	public void putCharAt(char c, int row, int col)
	{
		if (row < 0 || row > (ROWS-1)) return;
		if (col < 0 || col > (COLS-1)) return;
		screen[row][col] = c;
		// reset cursor
		cursorCol = ++col;
		cursorRow = row;
		if (cursorCol == COLS) {
			cursorCol = 0;
			cursorRow++;
			if (cursorRow == ROWS) cursorRow = 0;
		}
	}

	public void putChar(char c)
	{
		screen[cursorRow][cursorCol++] = c;
		if (cursorCol == COLS) {
			cursorCol = 0;
			cursorRow++;
			if (cursorRow == ROWS) cursorRow = 0;
		}
	}
	
	public void putStringAt(String s, int row, int col)
	{
		for (int i=0; i<s.length(); i++)
			putCharAt(s.charAt(i), row, col++);
	}
	
	


/**
Sets the screen cursor to locations indicated by <i>x</i> and <i>y</i> parameters.
The <i>x</i> parameter is the column number; the <i>y</i> parameter is the
row number.  Note that the order of these parameters is reversed from the
other screen method calls that specify row first.  This is due to historical
reasons, the gotoXY function is used by a number of different systems and
is provided here for consistancy.  If the x or y parameters are outside
the range of row and column values (0 to 24 and 0 to 79 respectively)
the method does not change the screen cursor position.  Subsequent
calls to put*() methods will not result in correct placement of the char
or string arguments.
*/
	public void gotoXY (int x, int y)
	{
		if (x < 0 || x > (COLS-1)) return;
		if (y < 0 || y > (ROWS-1)) return;
		cursorRow = y;
		cursorCol = x;
	}

	//public char getCharAt(int row, int col)

/**
Prints a prompt message to the console input row (row 25).  To print a
prompt message to some other portion of the screen you will need to
use the putString or putStringAt methods.
*/
   public static void printPrompt(String prompt)
   {  System.out.print(prompt + " ");
      System.out.flush();
   }

/**
Reads a string input from the console input row (row 25) typed by the
user.  This version does not print a preceding prompt message.
*/
   public static String readLine()
   {  int ch;
      String line = "";
      boolean done = false;
      while (!done)
      {  try
         {  ch = System.in.read();
            if (ch < 0 || (char)ch == '\n')
               done = true;
            else if ((char)ch != '\r')
               line = line + (char) ch;
         }
         catch(IOException e)
         {  done = true;
         }
      }
      return line;
   }

/**
Similar to readLine() but prints a prompt message on the input row (row 25)
prior to waiting for user input.
*/
   public static String readLine(String prompt)
   {  printPrompt(prompt);
      return readLine();
   }

/**
Reads an integer value input on the input row (row 25).  If anything
other than an integer is entered, the method notifies the user of the
error and waits for an integer to be entered.
*/
   public static int readInt(String prompt)
   {  while(true)
      {  printPrompt(prompt);
         try
         {  return Integer.valueOf
               (readLine().trim()).intValue();
         } catch(NumberFormatException e)
         {  System.out.println
               ("Not an integer. Please try again!");
         }
      }
   }

/**
Reads a double value input on the input row (row 25).  If anything
other than a double or an integer is entered, the method notifies the
user of the error and waits for a number to be entered.
*/
   public static double readDouble(String prompt)
   {  while(true)
      {  printPrompt(prompt);
         try
         {  return Double.parseDouble(readLine().trim());
         } catch(NumberFormatException e)
         {  System.out.println
         ("Not a floating point number. Please try again!");
         }
      }
   }
   
   public void putString(String s)
	{
		putStringAt(s,cursorRow, cursorCol);
	}
	
	


}
